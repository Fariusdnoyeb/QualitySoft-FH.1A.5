/**
 * Definition for Class ContactList
 * Each object of this class stores a
 * contact list
 * 
 * @version  4.2 Mar 24 2017
 * @author Quang Phan
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactList {
//data members
	private Person[] contactList; //list of all contacts
	private int contactCounter; //number of contacts in the list
	
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
	 * 
	 * @param index of the contact of interest
	 * @return the contact as a "Person" type
	 */
	public Person getContact(int index) {
		return contactList[index];
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
		System.out.println("Please press enter after each input, or "
				+ "input only 'c' to cancel.");
		readContactInfo();	
	}
	
	/**
	 * searches and prints the information from
	 * the person(s) with the matched last name
	 * @param last name of a person being searched
	 */
	public void search(String lastName) {
		//If no one is found, display a message
		//If more than one is found, print all
		//code needed for Use Case 3
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
//---------------------------
// Private Instance Methods
//---------------------------
	/**
	 * reads in new contact's information from user
	 * terminates if the user input 'c'/'C'
	 */
	private void readContactInfo() {
		Scanner console = new Scanner(System.in);
		Person tempPerson = new Person();
		
		if (!readLastName(console, tempPerson)) {
			return;
		} else if (!readFirstName(console, tempPerson)) {
			return;
		} else if (!readAddress(console, tempPerson)) {
			return;
		} else if (!readEmail(console, tempPerson)) {
			return;
		} else if (!readPhone(console, tempPerson)) {
			return;
		} else if (!readNotes(console, tempPerson)) {
			return;
		} else { //only after all info are valid will the person be added
			contactList[contactCounter] = tempPerson;
			System.out.println("New contact added!");
			contactCounter++;
		}
	}
	
	/**
	 * reads in last name for new contact
	 * @param console : Scanner for user input
	 * @param tempPerson : new contact to be add
	 * @return true if last name is successfully added
	 * 		   false if last name is blank or user input 'c'/'C'
	 */
	private boolean readLastName(Scanner console, Person tempPerson) {
		System.out.print("Last name: ");
		String stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return false;
		} else if (stringInput.isEmpty()) { //terminates if last name is blank
			System.err.println("Last name is required. No contact added!");
			return false;
		} else {
			tempPerson.setLastName(stringInput);
			return true;
		}
	}
	
	/**
	 * reads in first name for new contact
	 * @param console : Scanner for user input
	 * @param tempPerson : new contact to be add
	 * @return true if first name is successfully added
	 * 		   false if first name is blank or user input 'c'/'C'
	 */
	private boolean readFirstName(Scanner console, Person tempPerson) {
		System.out.print("First name: ");
		String stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return false;
		} else if (stringInput.isEmpty()) { //terminates if first name is blank
			System.err.println("First name is required. No contact added!");
			return false;
		} else {
			tempPerson.setFirstName(stringInput);
			return true;
		}
	}

	/**
	 * reads in full address for new contact
	 * @param console : Scanner for user input
	 * @param tempPerson : new contact to be added
	 * @return true if address is successfully added
	 * 		   false if user inputs 'c'/'C'
	 */
	private boolean readAddress(Scanner console, Person tempPerson) {
		StreetAddress tempAddress = new StreetAddress();
		System.out.println("Address: ");
		if (!readHouse(console, tempAddress)) {
			return false;
		} else if (!readCity(console, tempAddress)) {
			return false;
		} else if (!readState(console, tempAddress)) {
			return false;
		} else if (!readZip(console, tempAddress)) {
			return false;
		} else if (!readCountry(console, tempAddress)) {
			return false;
		} else {
			tempPerson.setAddress(tempAddress);
			return true;
		}
	}

	/**
	 * reads in house/apartment/street for new contact's address
	 * @param console : Scanner for user input
	 * @param tempAddress : address to be added
	 * @return true if house address is successfully added
	 * 		   false if user inputs 'c'/'C'
	 */
	private boolean readHouse(Scanner console, StreetAddress tempAddress) {
		System.out.print("\tHouse/Apartment: ");
		String stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return false;
		} else {
			tempAddress.setHouse(stringInput);
			return true;
		}
	}

	/**
	 * reads in city for new contact's address
	 * @param console : Scanner for user input
	 * @param tempAddress : address to be added
	 * @return true if city is successfully added
	 * 		   false if user inputs 'c'/'C'
	 */
	private boolean readCity(Scanner console, StreetAddress tempAddress) {
		System.out.print("\tCity: ");
		String stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return false;
		} else {
			tempAddress.setCity(stringInput);
			return true;
		}
	}
	
	/**
	 * reads in state for new contact's address
	 * @param console : Scanner for user input
	 * @param tempAddress : address to be added
	 * @return true if state is successfully added
	 * 		   false if user inputs 'c'/'C'
	 */
	private boolean readState(Scanner console, StreetAddress tempAddress) {
		System.out.print("\tState: ");
		String stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return false;
		} else {
			tempAddress.setState(stringInput);
			return true;
		}
	}

	/**
	 * reads in zip code for new contact's address
	 * @param console : Scanner for user input
	 * @param tempAddress : address to be added
	 * @return true if zip code is successfully added
	 * 		   false if user inputs 'c'/'C'
	 */
	private boolean readZip(Scanner console, StreetAddress tempAddress) {
		System.out.print("\tZip code: ");
		String stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return false;
		} else {
			tempAddress.setZip(stringInput);
			return true;
		}
	}

	/**
	 * reads in country for new contact's address
	 * @param console : Scanner for user input
	 * @param tempAddress : address to be added
	 * @return true if country is successfully added
	 * 		   false if user inputs 'c'/'C'
	 */
	private boolean readCountry(Scanner console, StreetAddress tempAddress) {
		System.out.print("\tCountry: ");
		String stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return false;
		} else {
			tempAddress.setCountry(stringInput);
			return true;
		}
	}
	
	/**
	 * reads in email for new contact
	 * @param console : Scanner for user input
	 * @param tempPerson : new contact to be added
	 * @return true if email is successfully added
	 * 		   false if email input is in wrong syntax
	 * 				or user input 'c'/'C'
	 */
	private boolean readEmail(Scanner console, Person tempPerson) {
		final Pattern VALID_EMAIL_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		boolean isValidEmail;
		String stringInput;
		do {
			System.out.print("Email address: ");
			stringInput = console.nextLine().trim();
			isValidEmail = validateEmail(stringInput, VALID_EMAIL_REGEX);
			if (isCancelled(stringInput)) { //terminates if user enters "c"
				System.out.println("No contact added.");
				return false;
			} else if (isValidEmail) {
				tempPerson.setEmail(stringInput);
			} else {
				System.err.println("Invalid syntax. Please try again.");
			}
		} while(!isValidEmail);
		return true;
	}

	/**
	 * reads in phone number for new contact
	 * @param console : Scanner for user input
	 * @param tempPerson : new contact to be added
	 * @return true if phone number is successfully added
	 * 		   false if phone input is in wrong syntax
	 * 				or user input 'c'/'C'
	 */
	private boolean readPhone(Scanner console, Person tempPerson) {
		boolean isValidPhone;
		String stringInput;
		do {
			System.out.print("Phone number(XXX-XXX-XXXX): ");
			stringInput = console.nextLine().trim();
			isValidPhone = validatePhone(stringInput);
			if (isCancelled(stringInput)) { //terminates if user enters "c"
				System.out.println("No contact added.");
				return false;
			} else if (isValidPhone) {
				tempPerson.setPhone(stringInput);
			} else {
				System.err.println("Invalid syntax. Please try again.");
			}
		} while (!isValidPhone);
		return true;
	}

	/**
	 * reads in notes for new contact
	 * @param console : Scanner for user input
	 * @param tempPerson : new contact to be added
	 * @return true if notes is successfully added
	 * 		   false if user input 'c'/'C'
	 */
	private boolean readNotes(Scanner console, Person tempPerson) {
		System.out.print("Notes: ");
		String stringInput = console.nextLine().trim();
		if (isCancelled(stringInput)) { //terminates if user enters "c"
			System.out.println("No contact added.");
			return false;
		} else {
			tempPerson.setNotes(stringInput);
			return true;
		}
		
	}
<<<<<<< HEAD

=======
	
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
	
	
>>>>>>> ee1b459307925b00403b971be86c382d8de4a5e6
	/**
	 * validates if user inputs email in the correct syntax
	 * @param emailInput : email input by user
	 * @param emailRegex : the correct email syntax
	 * @return true only if email input matches the correct syntax
	 */
	private boolean validateEmail (String emailInput, Pattern emailRegex) {
		Matcher matcher = emailRegex.matcher(emailInput);
		return matcher.matches();
	}

	/**
	 * validates if user inputs phone
	 * in the correct syntax: XXX-XXX-XXXX
	 * @param phoneInput : phone input by user
	 * @return true only if email is in correct syntax
	 */
	private boolean validatePhone(String phoneInput) {
		final String PHONE_PATTERN = "[0-9]{3}-[0-9]{3}-[0-9]{4}";
		if (phoneInput.matches(PHONE_PATTERN)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * checks if user wants to cancel the contact-adding process
	 * @param stringInput : a String input by user
	 * @return true if user type in 'C'/'c'
	 */
	private boolean isCancelled(String stringInput) {
		if (stringInput.equalsIgnoreCase("c")) {
			return true;
		} else {
			return false;
		}
	}

}

