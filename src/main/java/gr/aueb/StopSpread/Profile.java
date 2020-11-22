package gr.aueb.StopSpread;

public class Profile {


	/**Creates new user */
	public static void newEntry() {
		Database.createConnection();		
				
				System.out.println("Παρακαλώ εισάγετε Όνομα Χρήστη:");
				String user_name = Inputs.stringScanner();
				while (Database.usernameCheck(user_name)) {
					System.out.println("Το Όνομα Χρήστη χρησιμοποιείται ήδη.");
					System.out.println("Παρακαλώ διαλέξτε διαφορετικό Όνομα Χρήστη:");
					user_name = Inputs.stringScanner();
				}
				

				String pass, pass2;
				do {
					System.out.println("Παρακαλώ εισάγετε Κωδικό Χρήστη:");
					pass = Inputs.stringScanner();
					System.out.println("Παρακαλώ επιβεβαιώστε τον Κωδικό Χρήστη σας:");
					pass2 = Inputs.stringScanner();
					if(!pass.equals(pass2)) {
						System.out.println("Οι Κωδικοί Χρήστη σας δεν ταιριάζουν.\nΔοκιμάστε Ξανά.");
					}
				}while(!pass.equals(pass2));
				
				
				Database.insertIntoUserTable(user_name, pass);
				
				
				System.out.println("Ο Λογαριασμός σας δημιουργήθηκε με επιτυχία!");
				System.out.println("Συνδεθείτε για να ανακαλύψετε τις δυνατότητες!");

				Database.shutdownConnection();
	}
	
	
		/** Authenticates user's credentials  
		 * @return user_id 
		 * for later use in the program*/
		public static int authenticate() {
			Database.createConnection();		
			int user_id;
			
			System.out.println("Παρακαλώ εισάγετε το Όνομα Χρήστη σας:");
			String name = Inputs.stringScanner();
			
			user_id = Database.findUsersId(name);
			while (user_id == -1) {
				System.out.println("Αποτυχία Σύνδεσης.\nΤο Όνομα Χρήστη δεν υπάρχει.\nΠαρακαλώ προσπαθήστε ξανά : ");
				name = Inputs.stringScanner();
				user_id = Database.findUsersId(name);
			}
			
			
			System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας:");
			String pass = Inputs.stringScanner();
			
			String existingPass = Database.findUsersPass(user_id);
			
			while(!existingPass.equals(pass)) {
				System.out.println("Αποτυχία Συνδεσης.\nΤο Όνομα Χρήστη και ο Κωδικός δεν ταιριάζουν.\nΔοκιμάστε ξανά.");
				System.out.println("Παρακαλώ εισάγετε τον Κωδικό σας:");
				pass = Inputs.stringScanner();
			}

			
			System.out.println("Επιτυχία Συνδεσης! ");

			Database.shutdownConnection();
			return user_id;
		}
		
}
