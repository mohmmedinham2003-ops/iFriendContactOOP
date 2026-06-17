import java.util.*;
import java.time.LocalDate;
class iFRIENDContact{
	
	public static String[] conatctId = new String[5];
	public static String[] conatctNames = new String[5];
	public static String[] phoneNumbers = new String[5];
	public static int[] contactSalaries = new int[5];
	public static String[] dobs = new String[5];
	
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
	
	
	public static String genarateContactId(int id){
		//String conatctId = String.format("C%04d",id);
		//return conatctId;
		return String.format("C%04d",id);
	}
	
	public static boolean validateSalary(int salary){
		if (salary < 0){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean validatePhoneNO(String phoneNo){
		//10 cha
		//0
		if( phoneNo.startsWith("0") && (phoneNo.length() == 10) ){
			return true;
		}else{
			return false;
		}		
	}
	
	public static boolean validateDOB(String dob){
		
		LocalDate localdate = LocalDate.parse(dob);
		int birthyear = localdate.getYear();
		
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		
		if(birthyear > 1926 && birthyear < currentYear){
			return true;
		}else{
			return false;
		}
	}
	
	public static void addContacts(){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("+--------------------------------------+");
		System.out.println("|       Add Contact to the list        |");
		System.out.println("+--------------------------------------+");
		
		System.out.println('\n');
		
		int id = 1;
		
		//--------------------------------------
		
		char addContactsOption = 'N';
		
		do{
			String contactId = genarateContactId(id);
			
			System.out.println(contactId);
			System.out.println("=======");
			
			conatctId[id-1] = contactId;
			
			System.out.println();
			
			System.out.print("Name     : ");
			String contactName = input.next();
			
			//--SAVE NAME IN ARRAY----
			conatctNames[id-1] = contactName;
			//------------------------
			
			//--------GET CONTACT PHONE NUMBER---------------------
			
			String contactNO;
			
			do{
				System.out.print("Phone NO : ");
				contactNO = input.next();
				
				if(!validatePhoneNO(contactNO)){
					System.out.println("\n\t Invalied Phone number......");
				}
			}while(!validatePhoneNO(contactNO));
			
			//------SAVE CONTACT NO IN ARRAY--
			phoneNumbers[id-1] = contactNO;
			//----------------------------------
			
			int contactSalary = 0;
			//----------------------------------------------------
			while(true){
			System.out.print("Salary   : ");
			contactSalary = input.nextInt();
			
			if(validateSalary(contactSalary)){
				//------SAVE SALARY IN ARRAY--
				contactSalaries[id-1] = contactSalary;
				break;
			}else{
				
					System.out.println("\n\t Invalied salary number......");
					
			}
		}
			//----VALIDATE DATE OF BIRTH--------------------
			
			String dob;
			
			do{
				System.out.print("Birthday : ");
				dob = input.next();
				
				if(!validateDOB(dob)){
					System.out.println("\n\t Invalied Date of Birth......");
				}
			}while(!validateDOB(dob));
			
			//------SAVE DOB IN ARRAY--
			dobs[id-1] = dob;
			//-------------------------
				
			//-----------------------------------------------
			
			System.out.println();
			
			System.out.println("\t\t Contact has been added successfully...");
			
			System.out.print("\nDo you want to add another Contact(Y/N) : ");
			addContactsOption = input.next().charAt(0);
			
			if(addContactsOption == 'Y' || addContactsOption == 'y' ){
				id++;
			}else{
				main(null);
			}
		}while(addContactsOption == 'Y' || addContactsOption == 'y' );
	}
	
	public static int findConatctByname(String name){
		for (int i = 0; i < conatctNames.length; i++){
			if(name.equals(conatctNames[i])){
				return i;
			}
		}
		return -1;
	} 
	
	public static int findContactByPhoneNo(String phoneNo){
		for (int i = 0; i < phoneNumbers.length; i++){
			if(phoneNo.equals(phoneNumbers[i])){
				return i;
			}
		}
		return -1;
	}
	
	public static void searchContacts(){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("+-----------------------------+");
		System.out.println("|        Search Contacts      |");
		System.out.println("+-----------------------------+");
		
		System.out.println('\n');
		
		char searchContactsOption = 'y';
	
		
		do{
			System.out.print("Search Contact by name or Phone Number : ");
			String searchDetails = input.next();
			
			findConatctByname(searchDetails);
			findContactByPhoneNo(searchDetails);
			
			if(findConatctByname(searchDetails) >= 0 ||  findContactByPhoneNo(searchDetails) >= 0){
				
				int index = 0;
				
				if(findConatctByname(searchDetails) > findContactByPhoneNo(searchDetails)){
					index = findConatctByname(searchDetails);
				}else {
					index = findContactByPhoneNo(searchDetails);
				}
				
				System.out.println();
				
				System.out.println("\tContact Id    : " + conatctId[index]);
				System.out.println("\tName          : " + conatctNames[index]);
				System.out.println("\tPhone NO      : " + phoneNumbers[index]);
				System.out.println("\tSalary        : " + contactSalaries[index]);
				System.out.println("\tDate of Birth : " + dobs[index]);
			}else{
				System.out.println("\tNo contact found for " + searchDetails);
			}
			
			System.out.print("\nDo you want to search another Contact(Y/N) : ");
			searchContactsOption = input.next().charAt(0);
			
			if(searchContactsOption == 'N' || searchContactsOption == 'n' ){
				main(null);
			}			
		}while(searchContactsOption == 'Y' || searchContactsOption == 'y');
	}
	
	public static void updateContact(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("+-----------------------------+");
		System.out.println("|        Update Contacts      |");
		System.out.println("+-----------------------------+");
		
		System.out.println();
		
		char updateContactsOption = 'y';
		
		do{
			System.out.print("Search Contact by name or Phone Number : ");
			String searchDetails = input.next();
			
			findConatctByname(searchDetails);
			findContactByPhoneNo(searchDetails);
			
			if(findConatctByname(searchDetails) >= 0 ||  findContactByPhoneNo(searchDetails) >= 0){ 
				
				int index = 0;
				
				if(findConatctByname(searchDetails) > findContactByPhoneNo(searchDetails)){
					index = findConatctByname(searchDetails);
				}else {
					index = findContactByPhoneNo(searchDetails);
				}
				
				System.out.println();
				
				System.out.println("\tContact Id    : " + conatctId[index]);
				System.out.println("\tName          : " + conatctNames[index]);
				System.out.println("\tPhone NO      : " + phoneNumbers[index]);
				System.out.println("\tSalary        : " + contactSalaries[index]);
				System.out.println("\tDate of Birth : " + dobs[index]);
				
				System.out.println();
				
				System.out.println("What do you to uppdate...");
				
				System.out.println();
				
				System.out.println("\t [1]Name");
				System.out.println("\t [2]Phone Number");
				System.out.println("\t [3]Company Name");
				System.out.println("\t [4]Salary");
				
				System.out.print("Enter an option to continue -> ");
				int updateOption = input.nextInt();
				
				switch(updateOption){
					case 1:{
						updateName(index);
					}break;
					case 2:{
						updatePhoneNo(index);
					}break;
					case 3:{
						//updateCompanyName(index);
					}break;
					case 4:{
						updateSalary(index);
					}break;
				}
			}else{
				System.out.println("\tNo contact found for " + searchDetails);
			}
			
			System.out.print("\nDo you want to update another Contact(Y/N) : ");
			updateContactsOption = input.next().charAt(0);
			
			if(updateContactsOption == 'N' || updateContactsOption == 'n' ){
				main(null);
			}			
		}while(updateContactsOption == 'Y');
	}
	
	public static void updateName(int index){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Update Name");
		System.out.println("=============");
		
		System.out.print("\nInput new name : ");
		String newName = input.next();
		
		conatctNames[index] = newName;
		
		System.out.println("\t\n Contact has been update successfully....");
	}
	
	public static void updatePhoneNo(int index){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Update Phone NO");
		System.out.println("==================");
		
		System.out.print("\nInput new phone number : ");
		String newPhoneNo = input.next();
		
		phoneNumbers[index] = newPhoneNo;
		
		System.out.println("\t\n Contact has been update successfully....");
	}
		
	public static void updateSalary(int index){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Update Salary");
		System.out.println("=============");
		
		System.out.print("\nInput new salary : ");
		int newSalary = input.nextInt();
		
		contactSalaries[index] = newSalary;
		
		System.out.println("\t\n Contact has been update successfully....");
	}
	
		//------------List Contact--------------//
	
	public static void listContact(){
		Scanner input = new Scanner(System.in);
		char listOption = 'y';
		while(listOption == 'y'){
		System.out.println("+-----------------------------+");
		System.out.println("|        SORT Contacts      |");
		System.out.println("+-----------------------------+");
		
		System.out.println();
		
		System.out.println("\t[1] Sorting by Name");
		System.out.println("\t[2] Sorting by Salary");
		System.out.println("\t[3] Sorting by Birthday");
		
		System.out.print("Enter an option -> ");
		int sortOption = input.nextInt();
		
		switch(sortOption){
			case 1:{
			sortByName();
			}break;
			case 2:{
				sortBySalary();
			}break;
			case 3:{
			sortByBirthday();
			}break;
		}
		
			System.out.print("\n Do you want to calculate another listContact? (Y/N) : ");
			listOption = input.next().charAt(0);
				if(listOption == 'n'){
							clearConsole();
							main(new String[] {""});
					}
					
				}
				

	}
	
	public static void sortBySalary(){
		String[] tempContactId = new String[conatctId.length];
		String[] tempConatctNames = new String[conatctNames.length];
		String[] tempPhoneNumbers = new String[phoneNumbers.length];
		String[] tempDOBs = new String[dobs.length];
		int[] tempContactSalaries = new int[contactSalaries.length];
		
		tempContactId = conatctId;
		tempConatctNames = conatctNames;
		tempContactSalaries = contactSalaries;
		tempDOBs = dobs;
		tempPhoneNumbers = phoneNumbers;
		
		for (int i = tempContactSalaries.length -1; i > 0 ; i--){
			for (int j = 0; j < i; j++){
				
				if(tempContactSalaries[j] > tempContactSalaries[j+1]){ // 25 000 > 12 000
					
					int tempSalary = tempContactSalaries[j];
					tempContactSalaries[j] = tempContactSalaries[j+1];
					tempContactSalaries[j + 1] = tempSalary;
					
					String tempId = tempContactId[j];
					tempContactId[j] = tempContactId[j+1];
					tempContactId[j +1] = tempId;
					
					String tempConatctName = tempConatctNames[j];
					tempConatctNames[j] = tempConatctNames[j+1];
					tempConatctNames[j +1] = tempConatctName;
					 
					String tempDOB = tempDOBs[j];
					tempDOBs[j] = tempDOBs[j+1];
					tempDOBs[j+1] = tempDOB;
					
					String tempPhoneNumber = tempPhoneNumbers[j];
					tempPhoneNumbers[j] = tempPhoneNumbers[j+1];
					tempPhoneNumbers[j+1] = tempPhoneNumber;
				}
			}
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n","Contact ID","Name","Phone Number","Company","Salary","Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		for (int i = 0; i < tempContactId.length; i++){
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n",tempContactId[i],tempConatctNames[i],tempPhoneNumbers[i],"null",tempContactSalaries[i],tempDOBs[i]);
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		
	}	
	
	
	public static void sortByName(){
		String[] tempContactId = new String[conatctId.length];
		String[] tempConatctNames = new String[conatctNames.length];
		String[] tempPhoneNumbers = new String[phoneNumbers.length];
		String[] tempDOBs = new String[dobs.length];
		int[] tempContactSalaries = new int[contactSalaries.length];
		
		tempContactId = conatctId;
		tempConatctNames = conatctNames;
		tempContactSalaries = contactSalaries;
		tempDOBs = dobs;
		tempPhoneNumbers = phoneNumbers;
		
		for (int i = tempConatctNames.length -1; i > 0 ; i--){
			for (int j = 0; j < i; j++){
				
				if(tempConatctNames[j].compareTo(tempConatctNames[j+1]) > 0){ // 25 000 > 12 000
					
					int tempSalary = tempContactSalaries[j];
					tempContactSalaries[j] = tempContactSalaries[j+1];
					tempContactSalaries[j + 1] = tempSalary;
					
					String tempId = tempContactId[j];
					tempContactId[j] = tempContactId[j+1];
					tempContactId[j +1] = tempId;
					
					String tempConatctName = tempConatctNames[j];
					tempConatctNames[j] = tempConatctNames[j+1];
					tempConatctNames[j +1] = tempConatctName;
					 
					String tempDOB = tempDOBs[j];
					tempDOBs[j] = tempDOBs[j+1];
					tempDOBs[j+1] = tempDOB;
					
					String tempPhoneNumber = tempPhoneNumbers[j];
					tempPhoneNumbers[j] = tempPhoneNumbers[j+1];
					tempPhoneNumbers[j+1] = tempPhoneNumber;
				}
			}
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n","Contact ID","Name","Phone Number","Company","Salary","Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		for (int i = 0; i < tempContactId.length; i++){
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n",tempContactId[i],tempConatctNames[i],tempPhoneNumbers[i],"null",tempContactSalaries[i],tempDOBs[i]);
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		
	}	
	
	public static void sortByBirthday(){
		String[] tempContactId = new String[conatctId.length];
		String[] tempConatctNames = new String[conatctNames.length];
		String[] tempPhoneNumbers = new String[phoneNumbers.length];
		String[] tempDOBs = new String[dobs.length];
		int[] tempContactSalaries = new int[contactSalaries.length];
		
		tempContactId = conatctId;
		tempConatctNames = conatctNames;
		tempContactSalaries = contactSalaries;
		tempDOBs = dobs;
		tempPhoneNumbers = phoneNumbers;
		
		for (int i = tempConatctNames.length -1; i > 0 ; i--){
			for (int j = 0; j < i; j++){
				
				if(LocalDate.parse(tempDOBs[j]).isAfter(LocalDate.parse(tempDOBs[j+1]))){ // 25 000 > 12 000
					
					int tempSalary = tempContactSalaries[j];
					tempContactSalaries[j] = tempContactSalaries[j+1];
					tempContactSalaries[j + 1] = tempSalary;
					
					String tempId = tempContactId[j];
					tempContactId[j] = tempContactId[j+1];
					tempContactId[j +1] = tempId;
					
					String tempConatctName = tempConatctNames[j];
					tempConatctNames[j] = tempConatctNames[j+1];
					tempConatctNames[j +1] = tempConatctName;
					 
					String tempDOB = tempDOBs[j];
					tempDOBs[j] = tempDOBs[j+1];
					tempDOBs[j+1] = tempDOB;
					
					String tempPhoneNumber = tempPhoneNumbers[j];
					tempPhoneNumbers[j] = tempPhoneNumbers[j+1];
					tempPhoneNumbers[j+1] = tempPhoneNumber;
				}
			}
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n","Contact ID","Name","Phone Number","Company","Salary","Birthday");
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		for (int i = 0; i < tempContactId.length; i++){
			System.out.printf("| %-13s | %-12s | %-15s | %-11s | %-8s  | %-15s |%n",tempContactId[i],tempConatctNames[i],tempPhoneNumbers[i],"null",tempContactSalaries[i],tempDOBs[i]);
		}
		
		System.out.println("+--------------------------------------------------------------------------------------------+");
		
		
	}	
	
	public static void deleteContact() {

    Scanner input = new Scanner(System.in);
    char deleteContactOption = 'y';
    
    while(deleteContactOption == 'y'){

    System.out.println("+--------------------------------------+");
    System.out.println("|         DELETE CONTACT              |");
    System.out.println("+--------------------------------------+");

			System.out.print("Search Contact by name or Phone Number : ");
			String searchDetails = input.next();
			
			findConatctByname(searchDetails);
			findContactByPhoneNo(searchDetails);
			
			if(findConatctByname(searchDetails) >= 0 ||  findContactByPhoneNo(searchDetails) >= 0){
				
				int index = 0;
				
				if(findConatctByname(searchDetails) > findContactByPhoneNo(searchDetails)){
					index = findConatctByname(searchDetails);
				}else {
					index = findContactByPhoneNo(searchDetails);
				}
				
				System.out.println();
				
				System.out.println("\tContact Id    : " + conatctId[index]);
				System.out.println("\tName          : " + conatctNames[index]);
				System.out.println("\tPhone NO      : " + phoneNumbers[index]);
				System.out.println("\tSalary        : " + contactSalaries[index]);
				System.out.println("\tDate of Birth : " + dobs[index]);
		
			// Confirmation
			System.out.print("\nDo you want to delete this contact? (Y/N) : ");
			char confirm = input.next().charAt(0);

			if(confirm == 'Y' || confirm == 'y') {
				// Shift arrays left
				for(int i = index; i < conatctId.length - 1; i++) {

					conatctId[i] = conatctId[i + 1];
					conatctNames[i] = conatctNames[i + 1];
					phoneNumbers[i] = phoneNumbers[i + 1];
					dobs[i] = dobs[i + 1];
					contactSalaries[i] = contactSalaries[i + 1];
				}

				// Clear last position
				conatctId[conatctId.length - 1] = null;
				conatctNames[conatctNames.length - 1] = null;
				phoneNumbers[phoneNumbers.length - 1] = null;
				dobs[dobs.length - 1] = null;
				contactSalaries[contactSalaries.length - 1] = 0;

				System.out.println("\nContact deleted successfully...");
			} else {
				System.out.println("\nDeletion cancelled...");
				
			}
				}else{
				System.out.println("\tNo contact found for " + searchDetails);
			}
				 
				System.out.print("Do you want to delete anorther contacty(y or n) : ");
				deleteContactOption = input.next().charAt(0);
				
				input.nextLine();
				
				if(deleteContactOption == 'n'){
				clearConsole();	
				main(new String[] {""});
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
