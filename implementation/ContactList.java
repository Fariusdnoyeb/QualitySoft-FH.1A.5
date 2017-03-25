/**
 * Definition for Class ContactList
 * Each object of this class stores a
 * contact list
 * 
 * @version 3 Mar 21 2017
 * @author Quang Phan
 */

import java.util.Arrays;
import java.util.Scanner;

public class ContactList {
//data members
	private Person[] contactList;
	private int contactCounter;
	
//--------------
// Constructor
//--------------
	/**
	 * Creates & allocates contactList
	 * @param size = size of contactList
	 */
	public ContactList(int size) {
		contactList = new Person[size];
		contactCounter = 0;
	}
	
//--------------------------
// Public Instance Methods
//--------------------------
	/**
	 * @return "counter": the number of contacts existing
	 */
	public int getContactCounter() {
		return contactCounter;
	}
	
	/**
	 * adds a new "Person" object into "contactList"
	 * and add 1 to "counter"
	 */
	public void addContact() {
		if (contactCounter == contactList.length) {
			System.err.println("Maximum contacts reached. "
								+ "No more contact can be added");
		return;
		}
		
		readContactInfo();	
	}
	
	/**
	 * reads in contact's information from user
	 */
	private void readContactInfo() {
		Scanner console = new Scanner(System.in);
		Person tempPerson = new Person();
		String stringInput;
		
		System.out.println("Please press enter after each input, or "
							+ "input only 'c' to cancel.");
		System.out.print("Last name: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else if (stringInput.isEmpty()) { //terminates if last name is blank
			System.err.println("Last name is required. No contact added!");
			return;
		} else {
			tempPerson.setLastName(stringInput);
		}
		
		System.out.print("First name: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else if (stringInput.isEmpty()) { //terminates if first name is blank
			System.err.println("First name is required. No contact added!");
			return;
		} else {
			tempPerson.setFirstName(stringInput);
		}
		
		
		StreetAddress address = new StreetAddress();
		System.out.println("Address: ");
		System.out.print("\tHouse/Apartment: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else {
			address.setHouse(stringInput);
		}
		
		System.out.print("\tCity: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else {
			address.setCity(stringInput);
		}
		
		System.out.print("\tState: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else {
			address.setState(stringInput);
		}
		
		System.out.print("\tZip code: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else {
			address.setZip(stringInput);
		}
		
		System.out.print("\tCountry: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else {
			address.setCountry(stringInput);
			tempPerson.setAddress(address);
		}
			
		System.out.print("Email address: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else {
			tempPerson.setEmail(stringInput);
		}
		
		System.out.print("Phone number(XXX XXX XXXX): ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else {
			tempPerson.setPhone(stringInput);
		}
	
		System.out.print("Notes: ");
		stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return;
		} else {
			tempPerson.setNotes(stringInput);
		}
		
		contactList[contactCounter] = tempPerson;
		System.out.println("New contact added!");
		contactCounter++;
	}
	
	private boolean isCancelled(String stringInput) {
		if (stringInput.equalsIgnoreCase("c")) {
			return true;
		} else {
			return false;
		}
	}
	
	/** HG
	 * @param last name of a person being searched
	 * searches and prints the information from
	 * the person(s) with the matched last name
	 */
	public void search(String lastName) {
		//If no one is found, display a message
		//If more than one is found, print all
		//code needed for Use Case 3
		int contactCounter = 0;
		if (contactList.length == 0) {
			System.out.println("*** Contact List is empty, nothing to search for ***" + "\n");
		} else {
			Scanner console = new Scanner(System.in);
			System.out.println("Please enter a Contact's last name to search for: ");
			String getLastName = console.nextLine();
			for (Person person : contactList) {
			if (lastName.equals(person.getLastName())) {
				System.out.println(person);
				contactCounter++;
				}
			}
			if (contactCounter == 0) {
				System.out.println("***No contacts found***");
			}
		}
	}
	
	
	/**
	 * sorts the contact list in ascending alphabetical order
	 * with respects to last name
	 * 2 contacts with the same last name will be ordered by
	 * first name 
	 */
	public void sort() {
		Arrays.sort(contactList, 0, contactCounter);
	}
	
	/**
	 * 
	 * @param index of the contact of interest
	 * @return the contact as a "Person" type
	 */
	public Person getContact(int index) {
		return contactList[index];
	}
	
	/**
	 * @return a String containing the number of contacts
	 * in the list and all the contacts' information.
	 */
	public String toString() {
		String allInformation = "";
		for (int index = 0; index < contactCounter; index++) {
			allInformation = allInformation + contactList[index].toString() 
					+ "\n----------------------------\n";
		}
		
		allInformation = allInformation
					+ "Number of contacts: " + contactCounter;
		return allInformation 
				+ "\n===============================\n";
	}	
}
