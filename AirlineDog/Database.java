package AirlineDog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.apache.derby.drda.NetworkServerControl;


public class Database {

	private static String dbURL = "jdbc:derby://localhost:1527/myDB;create=true;user=me;password=mine";
	
	private static Connection conn = null;
    private static Statement stmt = null;
    private static NetworkServerControl server = null;
    



    public static void createTable(String tableName) {
		 try {
			 stmt = conn.createStatement();
			 stmt.execute("CREATE TABLE " + tableName + " (id INT NOT NULL,Name VARCHAR(255),cityName VARCHAR(255),PRIMARY KEY ( id) )");
			 stmt.close();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
    
    public static void deleteTable(String tableName) {
    	try {
    		stmt = conn.createStatement();
    		stmt.execute("DROP TABLE " + tableName);
    		stmt.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public static void insertIntoTable(int id,String tableName, String Name, String cityName) {
	        try {
	            stmt = conn.createStatement();
	            stmt.execute("INSERT INTO " + tableName + " values (" +
	                    id + ",'" + Name + "','" + cityName +"')");
	            stmt.close();
	        } catch (SQLException sqlExcept) {
	            sqlExcept.printStackTrace();
	        }
	    }
	 
    public static void printTable(String tableName) {
	        try {
	            stmt = conn.createStatement();
	            ResultSet results = stmt.executeQuery("select * from " + tableName);
	            ResultSetMetaData rsmd = results.getMetaData();
	            int numberCols = rsmd.getColumnCount();
	            for (int i=1; i<=numberCols; i++)
	            {
	                //print Column Names
	                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
	            }

	            System.out.println("\n-------------------------------------------------");

	            while(results.next())
	            {
	                int id = results.getInt(1);
	                String Name = results.getString(2);
	                String cityName = results.getString(3);
	                System.out.println(id + "\t\t" + Name + "\t\t" + cityName);
	            }
	            results.close();
	            stmt.close();
	        }
	        catch (SQLException sqlExcept)
	        {
	            sqlExcept.printStackTrace();
	        }
	    }

    public static void createConnection() {
			try {
				server = new NetworkServerControl();
				server.start (null);
				Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
	            //Get a connection
	            conn = DriverManager.getConnection(dbURL); 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
    public static void shutdownConnection() {
		        try {
		            if (stmt != null) {
		                stmt.close();
		            }
		            if (conn != null) {
		                conn.close();
		            }     
		            server.shutdown();
		        }catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
}