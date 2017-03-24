/**
 * manages the contact list
 * @version 3 Mar 21 2017
 * @author Quang Phan
 */

import java.util.Scanner;

public class ContactManager {
	private static boolean restart = true;
	private static final int MAX_CONTACT = 100;	
	private static ContactList contactList = new ContactList(MAX_CONTACT);
	
	public static void main(String[] args) {		
		read();
		
		do {
			printMenu();
			executeAction();
		} while (restart);
	}
	
	
	/**
	 * reads the saved file into "contactList"
	 * and display a message
	 */
	public static void read() {
		//more code needed for reading file.
	}
	
	/**
	 * prints the menu
	 */
	public static void printMenu() {
		System.out.println("Greetings!");
		System.out.println(contactList.getContactCounter() 
							+ " contact(s) found.");
		System.out.println("What would you like to do?");
		System.out.println("[1] Add a contact");
		System.out.println("[2] Print contacts");
		System.out.println("[3] Search by last name");
		System.out.println("[4] Quit");
	}
	
	/**
	 * executes user's choice of action
	 * @param user's choice
	 */
	public static void executeAction() {
		boolean inputAgain;
		Scanner console = new Scanner(System.in);
		String choice;
		do {
			choice = console.nextLine();
			inputAgain = false;
			switch (choice) {
				case "1": 
					addContact();
					break;
				case "2": 
					printContacts();					
					break;	
				case "3":
					searchContacts();
				case "4":
					save();
					restart = false; //terminates program
					break;
				default: 
					inputAgain = true;
					System.err.println("Wrong input. "
									+ "Please input only 1 to 4");
			}
		} while (inputAgain);
	}
	
	/**
	 * adds a contact
	 */
	public static void addContact() {
		System.out.println("===============================");
		contactList.addContact();
	}
	
	/**
	 * prints all the contacts in "contactList"
	 */
	public static void printContacts() {
		contactList.sort();
		
		Table.printTop();
		
		int numberOfContacts = contactList.getContactCounter();
		
		for (int index = 0; index < numberOfContacts; index++) {
			Table contactToPrint = new Table(contactList.getContact(index), index);
			contactToPrint.printContact();
			if (index < numberOfContacts - 1) {
				Table.printSeparator();
			} else {
				Table.printBottom();
			}
		}
		
	}
	
	/**
	 * searches contacts in "contactList" by lastName
	 */
	public static void searchContacts() {
		//Use Case 3
		//code needed for searching
	}
	
	/**
	 * saves "contactList" to disk and sets
	 */
	public static void save() {
		//Use Case 4
		//code needed for saving file
	}
	
}



/*RUN

*/
