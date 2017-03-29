/**
 * Definition for Class StreetAddres.
 * Each object of this class 
 * stores a contact address
 * 
 * @version  final Mar 29 2017
 * @author Hitesh Govani
 */
import java.io.Serializable;

public class StreetAddress implements Serializable{
//data member:
	private String house;
	private String city;
	private String state;
	private String zip;
	private String country;

//--------------------------
// Public Instance Methods
//--------------------------
	/**														
	 * sets the value for house to "newHouse"
	 */
	public void setHouse(String newHouse) {	
		house = newHouse;
	}
	
	/**
	 * sets the value for city to "newCity"
	 */
	public void setCity(String newCity) {
		city = newCity;
	}
	
	/**
	 * sets the value for state to "newState"
	 */
	public void setState(String newState) {
		state = newState;
	}
	
	/**
	 * sets the value for zip to "newZip"
	 */
	public void setZip(String newZip) {
		zip = newZip;
	}
	
	/**
	 * sets the value for country to "newCountry
	 */
	public void setCountry(String newCountry) {
		country = newCountry;
	}
	
	/**
	 * @return house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @return country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * returns a String containing all the address info.
	 */
	public String toString() {							
		return house + " " + city + " " + state
				+ " " + zip + " " + country;
	}
}
