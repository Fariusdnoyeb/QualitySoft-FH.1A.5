/**
 * manages the contact list
 * @version final Mar 29 2017
 * @author Jason Martinez
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class ContactManager implements Serializable {
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
	
	
	/**JM
	 * reads the saved file into "contactList"
	 * and display a message
	 */
	public static void read() {
		try  {
		    	  ObjectInputStream in = new ObjectInputStream(new FileInputStream("ContactList.ser"));
		    	  contactList = (ContactList)in.readObject();
		    	  in.close();    
		      } catch(IOException ioe)  {
		      } catch (ClassNotFoundException cnfe)  {
		         System.out.println ("Error in casting to Array: " + cnfe);
		      } 
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
					break;
				case "4":
					save();
					System.out.println("Goodbye!");
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
		contactList.searchContacts();
	}
	
	/**JM
	 * Saves "contactList" to disk and sets
	 */
	public static void save() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
				    new FileOutputStream("ContactList.ser")
				);
				out.writeObject(contactList);
				out.flush();
				out.close();
				System.out.println("Contact list saved.");
		} catch (IOException ioe)  {
	         System.out.println ("Error writing objects to the file: "+ ioe.getMessage());
	         
	      }
	}
	
}



/*RUN 1
Greetings!
0 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
1
===============================
Please press enter after each input. Input only 'c' to cancel.
Last name: 
Last name is required. No contact added!
Greetings!
0 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
1
===============================
Please press enter after each input. Input only 'c' to cancel.
Last name: Smith
First name: 
First name is required. No contact added!
Greetings!
0 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
1
===============================
Please press enter after each input. Input only 'c' to cancel.
Last name: Smith
First name: John
Address: 
	House/Apartment: 
	City: 
	State: 
	Zip code: 
	Country: 
Email address: john@com
Invalid syntax. Please try again.
Email address: johnsmithgmail.com
Invalid syntax. Please try again.
Email address: john.smith@gmail.com
Phone number(XXX-XXX-XXXX): no phones
Invalid syntax. Please try again.
Phone number(XXX-XXX-XXXX): 309-111-21551
Invalid syntax. Please try again.
Phone number(XXX-XXX-XXXX): 
Notes: c
No contact added.
Greetings!
0 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
1
===============================
Please press enter after each input. Input only 'c' to cancel.
Last name: Smith
First name: John
Address: 
	House/Apartment: 123 Main St.
	City: San Jose
	State: CA
	Zip code: 12345
	Country: USA
Email address: john.smith@gmail.com
Phone number(XXX-XXX-XXXX): 012-345-6789
Notes: Test Test Test
New contact added!
Greetings!
1 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
1
===============================
Please press enter after each input. Input only 'c' to cancel.
Last name: Smith
First name: Jane
Address: 
	House/Apartment: 
	City: 
	State: 
	Zip code: 
	Country: 
Email address: 
Phone number(XXX-XXX-XXXX): 
Notes: 
New contact added!
Greetings!
2 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
1
===============================
Please press enter after each input. Input only 'c' to cancel.
Last name: Doe
First name: John
Address: 
	House/Apartment: 456 Main St.
	City: Santa Clara
	State: CA
	Zip code: 12345
	Country: USA
Email address: john.doe@gmail.com
Phone number(XXX-XXX-XXXX): 987-654-3210
Notes: 
New contact added!
Greetings!
3 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
2
                                                     LIST OF CONTACTS                                                     
--------------------------------------------------------------------------------------------------------------------------
|#  |Last Name |First Name|Address                 |Email                    |Phone Number|Notes                         |
|---|----------|----------|------------------------|-------------------------|------------|------------------------------|
|1  |Doe       |John      |456 Main St.            |john.doe@gmail.com       |987-654-3210|                              |
|   |          |          |Santa Clara             |                         |            |                              |
|   |          |          |CA 12345                |                         |            |                              |
|   |          |          |USA                     |                         |            |                              |
|---|----------|----------|------------------------|-------------------------|------------|------------------------------|
|2  |Smith     |Jane      |                        |                         |            |                              |
|---|----------|----------|------------------------|-------------------------|------------|------------------------------|
|3  |Smith     |John      |123 Main St.            |john.smith@gmail.com     |012-345-6789|Test Test Test                |
|   |          |          |San Jose                |                         |            |                              |
|   |          |          |CA 12345                |                         |            |                              |
|   |          |          |USA                     |                         |            |                              |
--------------------------------------------------------------------------------------------------------------------------
Greetings!
3 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
3
Please enter a Contact's last name to search for: smith
Smith, Jane
    



Smith, John
123 Main St. San Jose CA 12345 USA
john.smith@gmail.com
012-345-6789
Test Test Test
Greetings!
3 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
3
Please enter a Contact's last name to search for: Martinez
***No contacts found***
Greetings!
3 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
4
Contact list saved.
Goodbye!

*/

/*RUN 2
Greetings!
3 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
2
                                                     LIST OF CONTACTS                                                     
--------------------------------------------------------------------------------------------------------------------------
|#  |Last Name |First Name|Address                 |Email                    |Phone Number|Notes                         |
|---|----------|----------|------------------------|-------------------------|------------|------------------------------|
|1  |Doe       |John      |456 Main St.            |john.doe@gmail.com       |987-654-3210|                              |
|   |          |          |Santa Clara             |                         |            |                              |
|   |          |          |CA 12345                |                         |            |                              |
|   |          |          |USA                     |                         |            |                              |
|---|----------|----------|------------------------|-------------------------|------------|------------------------------|
|2  |Smith     |Jane      |                        |                         |            |                              |
|---|----------|----------|------------------------|-------------------------|------------|------------------------------|
|3  |Smith     |John      |123 Main St.            |john.smith@gmail.com     |012-345-6789|Test Test Test                |
|   |          |          |San Jose                |                         |            |                              |
|   |          |          |CA 12345                |                         |            |                              |
|   |          |          |USA                     |                         |            |                              |
--------------------------------------------------------------------------------------------------------------------------
Greetings!
3 contact(s) found.
What would you like to do?
[1] Add a contact
[2] Print contacts
[3] Search by last name
[4] Quit
4
Contact list saved.
Goodbye!

*/
