import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

class Contacts{
private String contactId;
private String name;
private String phoneNumber;
private double salary;
private String companyName;
private String birthday;

		Contacts(){
	
		}
	
		Contacts(String contactId,String name,String phoneNumber,double salary,String companyName,String birthday){
			this.contactId = contactId;
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.salary = salary;
			this.companyName = companyName;
			this.birthday = birthday;
			
		}
		public void setContactId(String contactId){
		this.contactId = contactId;	
		}
		public void setName(String name){
		this.name = name;	
		}
		public void setPhoneNumber(String pNO){
			this.phoneNumber = pNO;
		}
		public void setSalary(double salary){
			this.salary = salary;
		}
		public void setCompanyName(String companyName){
			this.companyName = companyName;
		}
		public void setBirthDay(String dob){
			this.birthday = dob;
		
		public String getContactId(){
		return this.contactId;	
		}
		public String getname(){{
		return this.name;	
		}
		public String getPhoneNumber(){
		return this.phoneNumber;	
		}
		public double getSalary(){
		return this.salary;
	}
	public String getCompanyName(){
		return this.companyName;
	}
	public String getBirthday(){
		return this.birthday;
	}
		
	public String toString(){
		return contactId+"\t"+name+"\t"+phoneNumber+"\t"+salary+"\t"+companyName+"\t"+birthday;
	}

}
class iFRIENDContact{
	public stativ Contacts[] contacts = new Contacts[0];
	
	public final static void clearConsole(){
		try {   
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
			}else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String generateContactID(int ID){
		String contact_ID = String.Format("C%04d",ID);
	return contact_ID;	
	}
	
	public static boolean checkPhoneNumber(String p_No){
		
	if(p_No.length() == 10 && p_No.charAt(0) == '0'){
	return true;	
	}	
	return false
	}
	
	
	public static void addContacts(){
			Scanner input=new Scanner(System.in);
			int contact_ID = 1;
			
			do{
				System.out.println("+-----------------------------------------------+");
				System.out.println("|\t   Add Contact to the list  \t\t|");
				System.out.println("+-----------------------------------------------+");
				System.out.println('\n');
				
				String ID = generateContactID(contact_ID);
				System.out.println(ID);
				System.out.println("=======");
				System.out.println();
				
				System.out.print("Name              : ");
				String name=input.next();

				System.out.print("Phone Number      : ");
				String p_NO=input.next();
				
				L1: do{
					if(!checkPhoneNumber(p_NO)){

					System.out.println();
					System.out.println("\tInvalid phone number...");
					System.out.println();
					
					System.out.print("Do you want to add phone number again (Y/N): ");
					char subADD = input.nextchartAt(0);
					System.out.println();

					subADD = Character.toLowerCase(subAdd);
					
					if(subADD == 'y'){
						System.out.print("\033[6A");
						System.out.print("\033[0J");
						
						System.out.print("Phone Number      : ");
						p_NO=input.next();	
						}else{
						System.out.print("\033[6A");
						System.out.print("\033[0J");
						System.out.println("Phone Number      : Not insert...");
						p_NO="";
						break L1;
					}
										
					}while (!checkPhoneNumber(p_NO));
					
					System.out.print("Company Name      : ");
					String company_Name=input.next();
						
					System.out.print("Salary            : ");
					double Salary=input.nextDouble();
					
					L2: do{
								
						
						
						
								}
					
					
					
					
					
					
					
					
					
					
					}
				
			}
					

		
		
	}
	
	
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("	                      /$$ / $$$$$$$$/$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$    ");
		System.out.println("	                      |__/  $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$| $$__  $$  ");
		System.out.println("	                       /$$  $$      | $$  \\ $$  | $$  | $$      | $$$$| $$| $$  \\ $$  ");
		System.out.println("	                      | $$| $$$$$   | $$$$$$$/  | $$  | $$$$$   | $$ $$ $$| $$  | $$  ");
		System.out.println("	                      | $$| $$__/   | $$__  $$  | $$  | $$__/   | $$  $$$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  \\ $$  | $$  | $$      | $$\\  $$$| $$  | $$  ");
		System.out.println("	                      | $$| $$      | $$  | $$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/  ");
		System.out.println("	                      |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/   ");
		
		System.out.println('\n');
		
		System.out.println("   _____             _             _              ____                         _                   ");
		System.out.println("  / ____|           | |           | |            / __ \\                       (_)                 ");
		System.out.println(" | |      ___  _ __ | |_ __ _  ___| |_ ___      | |  | |_ __ __ _       _ __  _ ____ __ _ __     ");
		System.out.println(" | |     / _ \\| '_ \\| __/ _` |/ __| __/ __|     | |  | | `_/  _` |/ _` | '_ \\| |_  / _ \\ `__|    ");
		System.out.println(" | |____| (_) | | | | || |_| | |__| |_\\__ \\     | |__| | | | |_| | |_| | | | | |/ /  __/| |      ");
		System.out.println("  \\_____ \\___/|_| |_|\\__\\__,_|\\___|\\__|___/      \\____/|_|  \\__, |\\__,_|_| |_|_/___\\___||_|      ");
		System.out.println("                                                             __/ |                               ");
		System.out.println("                                                            |___/                                ");
		
		System.out.println();
		System.out.println("========================================================================================================");
		System.out.println('\n');
		
		System.out.println("\t[1] Add Contacts");
		System.out.println("\t[2] Update Contacts");
		System.out.println("\t[3] Delete Contacts");
		System.out.println("\t[4] Search Contacts");
		System.out.println("\t[5] List Contacts");
		System.out.println("\t[6] Exit");
		
		System.out.print("\nEnter an option to continue -> ");
		int mainOption = input.nextInt();
		
		switch(mainOption){
			case 1: {
				addContacts();
			}break;
			case 2:{
				updateContact();
			}break;
			case 3: {
				deleteContact();
			}break;
			case 4:{
				searchContacts();
			}break;
			case 5:{
				listContact();
			}break;
			case 6: System.exit(0);break;
		}
	}
}
