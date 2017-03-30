/**
 * Definition for Class Person
 * An object of this class stores
 * contact information for 1 individual
 * 
 * @version final Mar 29 2017
 * @author Hitesh Govani
 */
import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable {
//Data Members
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private String notes;
	private StreetAddress address;
//--------------------------
// Public Instance Methods
//--------------------------

	/**
	 * sets first name for contact
	 */
	public void setFirstName(String newName) {
		firstName = newName;
	}
	
	/**
	 * sets last name for contact
	 */
	public void setLastName(String newName) {
		lastName = newName;
	}
	
	/**
	 * calls methods from address of type StreetAddress
	 * to reads in address information for contact
	 */
	public void setAddress(StreetAddress newAddress) {
		address = new StreetAddress();
		address = newAddress;
	}	
	
	/**
	 * sets email for contact
	 */
	public void setEmail(String newEmail) {		
		emailAddress = newEmail;
	}
	
	/**
	 * sets phone number for contact
	 */
	public void setPhone(String newPhone) {
		phoneNumber = newPhone;
	}	
	
	/**
	 * sets notes for contact
	 */
	public void setNotes(String newNotes) {
		notes = newNotes;
	}
	
	/**
	 * @return contact's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @return contact's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	

	/**
	 * @return contact's address as StreetAddress object
	 */
	public StreetAddress getAddress() {
		return address;
	}
	/**
	 * @return contact's email
	 */
	public String getEmail() {
		return emailAddress;
	}
	
	/**
	 * @return contact's phone
	 */
	public String getPhone() {
		return phoneNumber;
	}
	
	/**
	 * @return contact's notes
	 */
	public String getNotes() {
		return notes;
	}
	
	/**
	 * compares two Person object by comparing
	 * their name alphabetically
	 * @param Person object to compare
	 * @return  a positive integer if this >  other
	 * 		   	a negative integer if this <  other
	 * 			0 if this == other
	 */
	public int compareTo(Person other) {
		if (this.lastName.compareToIgnoreCase(other.lastName) == 0) {
			return this.firstName.compareToIgnoreCase(other.firstName);
		} else {
			return this.lastName.compareToIgnoreCase(other.lastName);
		}
	}

	/**
	 * @return a string containing all 
	 * 		   the contact's information
	 */
	public String toString() {
		return 	lastName + ", " + firstName
				+ "\n" + address
				+ "\n" + emailAddress
				+ "\n" + phoneNumber
				+ "\n" + notes;
	}
	
}
