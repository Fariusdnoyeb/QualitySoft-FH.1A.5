/**
 * Each object of this class contains 1 contact
 * information and the methods needed to print those
 * information into a table
 * 
 * @version 3 Mar 21 2017
 * @author Quang Phan
 */

public class Table {
	private static final int LAST_NAME_FIELD = 10,
					  FIRST_NAME_FIELD = 10,
					  ADDRESS_FIELD = 24,
					  EMAIL_FIELD = 25,
					  PHONE_FIELD = 12,
					  NOTES_FIELD = 30,
					  INDEX_FIELD = 3;
	private static final int LINE_LENGTH =
			LAST_NAME_FIELD + FIRST_NAME_FIELD + ADDRESS_FIELD + 
			EMAIL_FIELD + PHONE_FIELD + NOTES_FIELD + INDEX_FIELD + 8;
	private String[] address,
					 lastName,
					 firstName,
					 email,
					 phone,
					 notes,
					 index;
//--------------
// Constructor
//--------------	
	public Table(Person contact, int contactIndex) {
		lastName = convertToArray(contact.getLastName(), LAST_NAME_FIELD);
		firstName = convertToArray(contact.getFirstName(), FIRST_NAME_FIELD);
		email = convertToArray(contact.getEmail(), EMAIL_FIELD);
		phone = convertToArray(contact.getPhone(), PHONE_FIELD);
		notes = convertToArray(contact.getNotes(), NOTES_FIELD);
		address = addressAsString(contact);
		index = convertToArray(Integer.toString(contactIndex + 1), INDEX_FIELD);
	}

//----------------------
//Public Class Methods
//----------------------
	/**
	 * prints out the top of contact list
	 */
	public static void printTop() {
		int left;
		int right;
		final String topMessage = "LIST OF CONTACTS";
		
		//calculates "left" and "right" to fit "topMessage" at the center.
		int emptySpace = LINE_LENGTH - topMessage.length();
		if (emptySpace % 2 == 0) {			//even
			left = right = emptySpace / 2; 
		} else {													//odd
			left = emptySpace / 2;
			right = left + 1;
		}
		//prints
		for (int count = 1; count <= left; count++) {
			System.out.print(" ");
		}
		System.out.print(topMessage);
		for (int count = 1; count <= right; count++) {
			System.out.print(" ");
		}
		System.out.println();
		printBottom();
		printCategories();
		printSeparator();
	}
	

	/**
	 * prints a line separate each contact
	 */
	public static void printSeparator() {
		System.out.print("|");
		System.out.print(categoryLine(INDEX_FIELD));
		System.out.print("|");
		System.out.print(categoryLine(LAST_NAME_FIELD));
		System.out.print("|");
		System.out.print(categoryLine(FIRST_NAME_FIELD));
		System.out.print("|");
		System.out.print(categoryLine(ADDRESS_FIELD));
		System.out.print("|");
		System.out.print(categoryLine(EMAIL_FIELD));
		System.out.print("|");
		System.out.print(categoryLine(PHONE_FIELD));
		System.out.print("|");
		System.out.print(categoryLine(NOTES_FIELD));
		System.out.print("|");
		System.out.println();;
	}
	
	/**
	 * prints the bottom line for the table
	 */
	public static void printBottom() {
		for (int count = 1; count <= LINE_LENGTH; count++) {
			System.out.print("-");
		}
		System.out.println();
	}	
	
//----------------------
//Private Class Methods
//----------------------	
	/**
	 * prints all the category tops
	 */
	private static void printCategories () {
		System.out.print("|");
		System.out.print(printedCategory("#", INDEX_FIELD));
		System.out.print("|");
		System.out.print(printedCategory("Last Name", LAST_NAME_FIELD));
		System.out.print("|");
		System.out.print(printedCategory("First Name", FIRST_NAME_FIELD));
		System.out.print("|");
		System.out.print(printedCategory("Address", ADDRESS_FIELD));
		System.out.print("|");
		System.out.print(printedCategory("Email", EMAIL_FIELD));
		System.out.print("|");
		System.out.print(printedCategory("Phone Number", PHONE_FIELD));
		System.out.print("|");
		System.out.print(printedCategory("Notes", NOTES_FIELD));
		System.out.print("|");
		System.out.println();;
	}
	
	/**
	 * 
	 * @param message : category message
	 * @param field	  : field length of category
	 * @return		  : string containing the category
	 * 					top that fits in the table
	 */
	private static String printedCategory(String message, int field) {
		String whiteSpace = "";
		int spaceLength = field - message.length();
		for (int count = 1; count <= spaceLength; count++) {
			whiteSpace = whiteSpace + " ";
		}
		return message + whiteSpace;
	}

	/**
 	* @param field of the category
 	* @return a line used to separate the top category
 	* 			to the actual contact information
 	*/
	private static String categoryLine(int field) {
		String emptySpace = "";
		for (int count = 1; count <= field; count++) {
			emptySpace = emptySpace + "-";
		}
		return emptySpace;
	}

//--------------------------
// Public Instance Methods
//--------------------------	
	/**
	 * prints this contact into the table
	 */
	public void printContact() {
		int maxLine  = linesToPrint();
		
		for (int line = 0; line < maxLine; line++) {
			System.out.print("|");
			printEach(index, line, INDEX_FIELD);
			printEach(lastName, line, LAST_NAME_FIELD);
			printEach(firstName,line, FIRST_NAME_FIELD);
			printEach(address, line, ADDRESS_FIELD);
			printEach(email, line, EMAIL_FIELD);
			printEach(phone, line, PHONE_FIELD);
			printEach(notes, line, NOTES_FIELD);
			System.out.println();
		}
	}
	
//--------------------------
// Private Instance Methods
//--------------------------
	/**
	 * @param stringToConvert : a string containing contact's information
	 * @param field 		  : field length of contact's information
	 * @return an array of String containing contact's information
	 * 		   as separated lines
	 */
	private String[] convertToArray(String stringToConvert, int field) {
		int numberOfLines;

		numberOfLines = 
					(int)Math.ceil((double)stringToConvert.length() / field);
		//if the string is empty, returns a 1-line string with all whitespaces
		if (numberOfLines == 0) {
			numberOfLines = 1;
		}
		
		String[] array = new String[numberOfLines];

		for (int index = 0; index < numberOfLines - 1; index++) {
			array[index] = 
					stringToConvert.substring(index*field, (index+1)*field);
		}
		array[numberOfLines - 1] = 
				stringToConvert.substring((numberOfLines - 1)*field, 
											stringToConvert.length());
		
		return array;
		
	}
	
	/**
	 * takes a StreetAddress and convert it to String[]
	 * @param contact : contact of this interested address
	 * @return address in the String[] type
	 */
	private String[] addressAsString(Person contact) {
		StreetAddress rawAddress = contact.getAddress();
		//if address was left blank, returns an 1-line empty string
		if(rawAddress.toString().trim().isEmpty()) {
			address = new String[1];
			address[0] = "";
			return address;
		}
		String[] house = convertToArray(rawAddress.getHouse(), ADDRESS_FIELD);

		address = new String[house.length + 3];
		for (int index = 0; index < house.length; index++) {
			address[index] = house[index];
		}
		address[house.length] = rawAddress.getCity();
		address[house.length + 1] = 
						rawAddress.getState() + " " + rawAddress.getZip();
		address[house.length + 2] = rawAddress.getCountry();

		return address;
	}
	
	/**
	 * print a specified line for each of the
	 * contact's information
	 * @param arrayToPrint : one of the data members
	 * @param currentLine : line specified to be printed
	 * @param field		  : field of the string to be printed
	 */
	private void printEach(String[] arrayToPrint, 
						       int currentLine, int field) {	
		if (currentLine <= arrayToPrint.length - 1) {
			String whitespace = "";
			int spaceLength = 
						field - arrayToPrint[currentLine].length();
			for (int count = 1; count <= spaceLength; count++) {
				whitespace = whitespace + " ";
			}
			System.out.print(arrayToPrint[currentLine] + whitespace + "|");
		} else {
			String whitespace = "";
			for (int count = 1; count <= field; count++) {
				whitespace = whitespace + " ";
			}
			System.out.print(whitespace + "|");
		}
	}

	
	/**
	 * @return total number of lines will be printed
	 * for this contact
	 */
	private int linesToPrint() {
		int numberOfLines = address.length; //possibly the longest string
		
		//compare each data member's length
		if (numberOfLines <= notes.length) {
			numberOfLines = notes.length;
		} 
		if (numberOfLines <= phone.length) {
			numberOfLines = phone.length; 
		} 
		if (numberOfLines <= email.length) {
			numberOfLines = email.length;
		}
		if (numberOfLines <= lastName.length) {
			numberOfLines = lastName.length;
		} 
		if (numberOfLines <= firstName.length) {
			numberOfLines = firstName.length;
		}
		return numberOfLines;
	}

	
//--------------------
//     DEBUGGING
//--------------------
	/**
	 * @return a String containing information about
	 * 			all the data members.
	 */
	public String toString() {
		String print;
		print = "Field for one line of each components:\n"
				+ "\tLast Name: " + LAST_NAME_FIELD
				+ "\tFirst Name: "+ FIRST_NAME_FIELD
				+ "\tAddress: " + ADDRESS_FIELD
				+ "\tEmail: " + EMAIL_FIELD
				+ "\tPhone: " + PHONE_FIELD
				+ "\tNotes: " + NOTES_FIELD
				+ "\tIndex: " + INDEX_FIELD;
		
		print = print + "\nTotal number of character per line: "
				+ (LINE_LENGTH) + "\n";
		
		print = print + "Last Name:\n" + printedComponent(lastName);
		print = print + "First Name:\n" + printedComponent(firstName);
		print = print + "Address:\n" + printedComponent(address);
		print = print + "Email:\n" + printedComponent(email);
		print = print + "Phone:\n" + printedComponent(phone);
		print = print + "Notes:\n" + printedComponent(notes);
		print = print + "Index: \n" + printedComponent(index);
		
		print = print + "\nTotal number of line will be "
					+ "printed for this contact: " + linesToPrint();
		return print;
	}
	
	/**
	 * 
	 * @param arrayToPrint : array of String containing contact's information
	 * @return a String represents this contact's information
	 */
	private String printedComponent(String[] arrayToPrint) {
		String print = "";
		for (int index = 0; index < arrayToPrint.length; index++) {
			print = print + arrayToPrint[index] + "\n";
		}
		return print;
	}
	
}