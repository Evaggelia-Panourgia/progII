package gr.aueb.StopSpread;

public class Profile {


	/**Creates new user */
	public static void newEntry() {
		Database.createConnection();		
				
				System.out.println("�������� �������� �� ����� ������:");
				String user_name = Inputs.stringScanner();
				while (Database.usernameCheck(user_name)) {
					System.out.println("�� ����� ������ ��������������� ���.");
					System.out.println("�������� �������� ����������� ����� ������:");
					user_name = Inputs.stringScanner();
				}
				

				String pass, pass2;
				do {
					System.out.println("�������� �������� ������ ������:");
					pass = Inputs.stringScanner();
					System.out.println("�������� ������������ ��� ������ ������ ���:");
					pass2 = Inputs.stringScanner();
					if(!pass.equals(pass2)) {
						System.out.println("�� ������� ��� ��� ����������. \n��������� ����");
					}
				}while(!pass.equals(pass2));
				
				
				Database.insertIntoUserTable(user_name, pass);
				
				
				System.out.println("� ����������� ��� ������������� �� ��������!");
				System.out.println("���������� ��� �� ����������� ��� �����������!");

				Database.shutdownConnection();
	}
	
	
		/** Authenticates user's credentials and returns the user_id 
		 * for later use in the program */
		public static int authenticate() {
			Database.createConnection();		
			int user_id;
			
			System.out.println("�������� �������� �� ����� ������ ���:");
			String name = Inputs.stringScanner();
			
			user_id = Database.findUsersId(name);
			while (user_id == -1) {
				System.out.println("�������� ��������.\n�� ����� ������ ��� �������.\n�������� ����������� ����: ");
				name = Inputs.stringScanner();
				user_id = Database.findUsersId(name);
			}
			
			
			System.out.println("�������� �������� ��� ������ ���:");
			String pass = Inputs.stringScanner();
			
			String existingPass = Database.findUsersPass(user_id);
			
			while(!existingPass.equals(pass)) {
				System.out.println("�������� ��������.\n�� ����� ������ ��� � ������� ��� ����������.\n��������� ����.");
				System.out.println("�������� �������� ��� ������ ���:");
				pass = Inputs.stringScanner();
			}

			
			System.out.println("�������� ��������!");

			Database.shutdownConnection();
			return user_id;
		}
		
}
