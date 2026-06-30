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
		}
		public String getContactId(){
		return this.contactId;
	}
	public String getName(){
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
	public static Contacts[] contacts = new Contacts[0];
	
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
		String contact_ID = String.format("C%04d",ID);
	return contact_ID;	
	}
	
	public static boolean checkPhoneNumber(String p_No){
		
	if(p_No.length() == 10 && p_No.charAt(0) == '0'){
	return true;	
	}	
	return false;
	}
	
	public static boolean checkSalary(double salary){
		if(salary > 0){
		return true;
		}
		return false;
	}


public static boolean checkBirthDay(String bDay){
		try{
			LocalDate birthday=LocalDate.parse(bDay);
			LocalDate currentDate=LocalDate.now();
			
			int birthYear=birthday.getYear();
			int currentYear=currentDate.getYear();
			
			if(birthYear < 1900 || birthYear > currentYear){
				return false;
			}
			
			return true;
			
		}catch(DateTimeParseException e){
			return false;
		}
			
	}
	
	public static void extendArrays(String ID,String Name,String p_NO,String company_Name,double Salary,String bDay){
	Contacts[] tempContacts = new Contacts[contacts.length +1];
	
	for(int i =0;i < contacts.length;i++){
	tempContacts[i] = contacts[i];	
	}
		contacts = tempContacts;
		
		contacts[contacts.length-1] = new Contacts(ID, Name, p_NO, Salary, company_Name, bDay);
		
		
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
					char subADD = input.next().charAt(0);
					System.out.println();

					subADD = Character.toLowerCase(subADD);
					
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
				}
										
					}while (!checkPhoneNumber(p_NO));
					
					System.out.print("Company Name      : ");
					String company_Name=input.next();
						
					System.out.print("Salary            : ");
					double Salary=input.nextDouble();
					
					L2: do{
							if(!checkSalary(Salary)){
							System.out.println();
							System.out.println("\tInvalid Input...");
							System.out.println();	
							
							System.out.print("Do you want to add salary again (Y/N): ");
							char subSalary = input.next().charAt(0);
							subSalary = Character.toLowerCase(subSalary);		
							
							if(subSalary=='y'){
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						
						System.out.print("Salary            : ");
						Salary=input.nextDouble();
					}else{
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						System.out.println("Salary            : Not insert...");
						Salary=0;
						break L2;
					}
							
								
					}
								
					}while(!checkSalary(Salary));
					
					System.out.print("B'Day(YYYY-MM-DD) : ");
			String bDay=input.next();
			
		//////////CHECK BIRTHDAY//////////
		L3:	do{
				if(checkBirthDay(bDay)){
					break L3;
				}else{
					System.out.println();
					System.out.println("\tInvalid Birthday...");
					System.out.println();
					
					System.out.print("Do you want to input birthday again (Y/N): ");
					char subBDay=input.next().charAt(0);
					subBDay=Character.toLowerCase(subBDay);
					
					if(subBDay=='y'){
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						
						System.out.print("B'Day(YYYY-MM-DD) : ");
						bDay=input.next();
					}else{
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						System.out.print("B'Day(YYYY-MM-DD) : Not insert");
						bDay="";
						break L3;
					}
				}
					
			}while(!checkBirthDay(bDay));	
			
			extendArrays(ID,name,p_NO,company_Name,Salary,bDay);	
			contact_ID++;
			
			System.out.println();
			System.out.println("\tContact has been added successfully...");
			System.out.println('\n');
			System.out.print("Do you want add another contact: ");
			char optionADD = input.next().charAt(0);
			optionADD = Character.toLowerCase(optionADD);
			System.out.println('\n');
			
			if(optionADD == 'y'){
			clearConsole();
			continue;	
				
			}else{
			clearConsole();
			main(null);
			}
			
				
			}while(true);
	}

	public static int searchContacts(String search){
	for(int i = 0;i < contacts.length;i++){
	if(search.equals(contacts[i].getName())|| search.equals(contacts[i].getPhoneNumber())){
	return i;	
		
	}

	}	
		return -1;

	}
	
	public static void displayContact(int i){
		if(i != -1){
			System.out.println("\tContact ID        : "+contacts[i].getContactId());
			System.out.println("\tName              : "+contacts[i].getName());
			System.out.println("\tPhone Number      : "+contacts[i].getPhoneNumber());
			System.out.println("\tCompany Name      : "+contacts[i].getCompanyName());
			System.out.println("\tSalary            : "+contacts[i].getSalary());
			System.out.println("\tB,Day(YYYY-MM-DD) : "+contacts[i].getBirthday());			
		}
		
	}

	
	public static void searchContacts(){
			Scanner input=new Scanner(System.in);

		do{		
			System.out.println("+-----------------------------------------------+");
			System.out.println("|\t\t SEARCH Contact \t\t|");
			System.out.println("+-----------------------------------------------+");
			System.out.println('\n');
			
			System.out.print("Search Contact by Name or Phone Number - ");
			String search  = input.next();
			System.out.println();
		
		
			int index = searchContacts(search);
			
		if(index == -1){
				System.out.println("\tNo contact found for "+search);
				System.out.println('\n');
				
				try{Thread.sleep(600);}catch(Exception e){}
				
				System.out.print("Do you want to try a new search (Y/N): ");
				char subSearch=input.next().charAt(0);
				subSearch=Character.toLowerCase(subSearch);
				
				if(subSearch=='y'){
					System.out.print("\033[6A");
					System.out.print("\033[0J");
					clearConsole();
					continue;
					
				}else{
					clearConsole();
					main(null);
					break;
				}
			}else{
			displayContact(index);	
			try{Thread.sleep(600);}catch(Exception e){}
	
			}
		System.out.println('\n');
			System.out.print("Do you want to search another contact(Y/N): " );
			char optionSearch=input.next().charAt(0);
			optionSearch=Character.toLowerCase(optionSearch);
			System.out.println('\n');
			
			if(optionSearch=='y'){
				clearConsole();
				continue;
			}else{
				clearConsole();
				main(null);
				break;
			}
		}while(true);

}
	
	public static void deleteContact(){
		Scanner input=new Scanner(System.in);
		
	L6:	do{
			System.out.println("+-----------------------------------------------+");
			System.out.println("|\t\t DELETE Contact \t\t|");
			System.out.println("+-----------------------------------------------+");
			System.out.println('\n');
	
			System.out.print("Search Contact by  Name or Phone Number - ");
			String search=input.next();
			System.out.println('\n');
			
			int index=searchContacts(search);

			displayContact(index);
	//		System.out.println('\n');
			
			if(index==-1){
				System.out.println("\t No results found...");
				System.out.println('\n');
				
				try{Thread.sleep(500);}catch(Exception e){}
				
				System.out.print("Do you want to search contact again (Y/N): ");
				char subUpdate=input.next().charAt(0);
				subUpdate=Character.toLowerCase(subUpdate);
				if(subUpdate=='y'){
					clearConsole();
					continue;
				}else {
					clearConsole();			
					main(null);
				}
			}
			
			System.out.println('\n');
			System.out.print("Do you want to delete this Contact (Y/N): ");
			char subDelete=input.next().charAt(0);
			subDelete=Character.toLowerCase(subDelete);
			System.out.println();
			
			if(subDelete=='y'){
				reduceArrays(index);
				
				try{Thread.sleep(100);}catch(Exception e){}
				
				System.out.println("\tContact has been deleted successfuly...");
				System.out.println('\n');
				
				try{Thread.sleep(200);}catch(Exception e){}
				
			}else {
				System.out.println("\tNot deleted...");
				System.out.println('\n');
				
				try{Thread.sleep(200);}catch(Exception e){}
			}
			
			System.out.print("Do you want to delete another Contact(Y/N): ");	
			char optionDelete=input.next().charAt(0);
			System.out.println();
			optionDelete=Character.toLowerCase(optionDelete);
			if(optionDelete=='y'){
				clearConsole();
				continue;
			}else{
				clearConsole();
				main(null);
				break L6;
			}		
			
		}while(true);
	}
	
	public static void reduceArrays(int index){
		Contacts[] tempContacts = new Contacts[contacts.length-1];
		 for(int i = index;i<contacts.length-1;i++){
		contacts[i] = contacts[i+1];	 
		}
		for(int j = 0;j < tempContacts.length;j++){
		tempContacts[j] = contacts[j];
		}
		contacts = tempContacts;
			
	}
	
	public static void updateContacts(){
		Scanner input=new Scanner(System.in);
		
		do{
			System.out.println("+-----------------------------------------------+");
			System.out.println("|\t\t UPDATE Contact \t\t|");
			System.out.println("+-----------------------------------------------+");
			System.out.println('\n');
		
			System.out.print("Search Contact by  Name or Phone Number - ");
			String search=input.next();
			System.out.println('\n');
			
			int index=searchContacts(search);
		//	int temp=searchContacts(search);

			displayContact(index);
			
			try{Thread.sleep(500);}catch(Exception e){}
			
			if(index==-1){
				System.out.println("\tNo results found...");
				System.out.println('\n');
				
				try{Thread.sleep(800);}catch(Exception e){}
				
				System.out.print("Do you want to search contact again(Y/N): ");
				char subUpdate=input.next().charAt(0);
				subUpdate=Character.toLowerCase(subUpdate);
				if(subUpdate=='y'){
					clearConsole();
					continue;
				}else{
					clearConsole();
					main(null);
				}
			}
			
			System.out.println('\n');
			System.out.println("what do you want to update...");
			System.out.println();
			System.out.println("\t[01]Name");
			System.out.println("\t[02]Phone Number");
			System.out.println("\t[03]Company Name");
			System.out.println("\t[04]Salary");
			System.out.println('\n');
			System.out.print("Enter an option to continue -> ");
			int optionUpdate=input.nextInt();
			System.out.println('\n');
		
			System.out.print("\033[11A");
			System.out.print("\033[0J");
			
		switch (optionUpdate){
				//////////UPDATE NAME//////////
				case 1: 
				System.out.println("Update Name");
				System.out.println("============");
				System.out.println();
				
				System.out.print("Input new name - ");
				//String updateName = input.next();
				//contacts.setName(updateName);
				
				contacts[index].setName(input.next());
				System.out.println('\n');
				
				System.out.println("\tContact has been update succesfully...");
				System.out.println('\n');
				break;
				//////////UPDATE PHONE NUMBER//////////
				case 2: 
				System.out.println("Update Phone Number");
				System.out.println("====================");
				System.out.println();
				
				System.out.print("Input new Phone Number - ");
				String p_NO=input.next();
					//////////CHECK PHONE NUMBER IN UPDATE//////////
			L4 :do{
					if(!checkPhoneNumber(p_NO)){
					System.out.println('\n');
					System.out.println("\tInvalid phone number...");
					System.out.println('\n');
					
					System.out.print("Do you want to add phone number again (Y/N): ");
					char subUpdateP_NO=input.next().charAt(0);
					subUpdateP_NO=Character.toLowerCase(subUpdateP_NO);
					if(subUpdateP_NO=='y'){
						System.out.print("\033[7A");
						System.out.print("\033[0J");
						
						System.out.print("Input Phone Number - ");
						p_NO=input.next();

					}else{
						System.out.print("\033[5A");
						System.out.print("\033[0J");
						System.out.println("Input Phone Number - not update...");
						
						break L4;
					}
					}
				}while(!checkPhoneNumber(p_NO));
				
				if(checkPhoneNumber(p_NO)){
					contacts[index].setPhoneNumber(p_NO);
				}else{
				//	contacts[index].getPhoneNumber()=contacts[index].getPhoneNumber();
				}
				
				System.out.println('\n');
				System.out.println("\tContact has been update succesfully...");
				System.out.println('\n');
				break;
				
				//////////UPDATE COMPANY NAME//////////
				case 3: 
				System.out.println("Update Company Name");
				System.out.println("=====================");
				System.out.println();
				
				System.out.print("Input new company name - ");
				contacts[index].setCompanyName(input.next());
				System.out.println('\n');
				
				System.out.println("\tContact has been update succesfully...");
				System.out.println('\n');
				break;
				
				//////////UPDATE SALARY//////////
				case 4: 
				System.out.println("Update Salary");
				System.out.println("==============");
				System.out.println();
				
				System.out.print("Input new salary - ");
				double Salary=input.nextDouble();
					//////////CHECK SALARY IN UPDATE//////////
			L5:	do{
					if(!checkSalary(Salary)){
						System.out.println();
						System.out.println("\tInvalid Salary...");
						System.out.println();
						
						System.out.print("Do you want to input Salary again (Y/N): ");
						char subUpdateSalary=input.next().charAt(0);
						subUpdateSalary=Character.toLowerCase(subUpdateSalary);
						if(subUpdateSalary=='y'){
							System.out.print("\033[5A");
							System.out.print("\033[0J");
							
							System.out.print("Input new salary - ");
							Salary=input.nextDouble();
						}else{
							System.out.print("\033[5A");
							System.out.print("\033[0J");
							System.out.println("Input Salary - not update...");
							break L5;
						}
					}
				}while(!checkSalary(Salary));	
				
				contacts[index].setSalary(Salary);
				System.out.println('\n');
				
				System.out.println("\tContact has been update succesfully...");
				System.out.println('\n');
				break;
				
				default:System.out.println("\tInvalid option...");
			}
			
			System.out.print("Do you want to update another Contact (Y/N) : ");
			char subUpdate=input.next().charAt(0);
			if(subUpdate=='y'){
				clearConsole();
				continue;
			}else{
				clearConsole();
				main(null);
				return ;
			}
		}while(true);
	}
		
	public static void sortName(){
		Scanner input=new Scanner(System.in);
		for(int j = contacts.length-1;j>0;j--){
			for(int i = 0;i < j;i++){
			if(contacts[i].getName().charAt(0) > contacts[i+1].getName().charAt(0){
			Contacts temp = contacts[i];
			contacts[i] = contacts[i+1];
			contacts[i+1] = temp;	
				
			}	
				
			}
			
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n","Contact ID","Name","Phone Number","Company","Salary","Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		for(int i = 0;i<contacts.length;i++){
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8f  | %-15s | \n",contacts[i].getContactId(),contacts[i].getName(),contacts[i].getPhoneNumber(),contacts[i].getCompanyName(),contacts[i].getSalary(),contacts[i].getBirthday());
			
		}
			System.out.println("+--------------------------------------------------------------------------------------------+");

		
	}	
	
	
	
	public static void sortContacts(){
		Scanner input=new Scanner(System.in);
		
		System.out.println("+------------------------------------+");
		System.out.println("|            SORT Contact            |");
		System.out.println("+------------------------------------+");
		System.out.println('\n');
		
		System.out.println("	[1] Sorting by Name\n");
		System.out.println("	[2] Sorting by Slary\n");
		System.out.println("	[3] Sorting by Birthday\n");
		System.out.println();
		
		System.out.print("Enter an option to continue -> ");
		int  optionSort=input.nextInt();
		System.out.println();
		
		switch (optionSort){
			case 1 :sortName();break;
			case 2 :sortSalary();break;
			case 3 :sortBirthDay();break;
			default:
			System.out.println("\tInvalid Input...");
			try{Thread.sleep(200);}catch(Exception e){}
			clearConsole();
			main(null);
			break;
		}
			
	}
	
	public static void exit(){
		System.exit(0);
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
				//updateContact();
			}break;
			case 3: {
				deleteContact();
			}break;
			case 4:{
				searchContacts();
			}break;
			case 5:{
				//listContact();
			}break;
			case 6: System.exit(0);break;
		}
	}
}
