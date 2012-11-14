package uh.ahci.people;

/**
 * This class represents a default person.
 * @author Seppe Magiels
 */
public class Person {

	private int _id = -1;
	private String _lastName = "";
	private String _firstName = "";
	private String _city = "";
	
	/**
	 * Constructor.
	 */
	protected Person() {
	}
	
	/**
	 * Constructor.
	 * @param id The id of the person in the database.
	 * @param lastName The last name of the person.
	 * @param firstName The first name of the person.
	 * @param city The city the person lives in.
	 */
	public Person(int id, String lastName, String firstName, String city) {
		_id = id;
		_lastName = lastName;
		_firstName = firstName;
		_city = city;
	}

	/**
	 * Get the database id of the person.
	 * @return The id of the person.
	 */
	public int getId() {
		return _id;
	}

	/**
	 * Get the last name of the person.
	 * @return The last name of the person.
	 */
	public String getLastName() {
		return _lastName;
	}

	/**
	 * Get the first name of the person.
	 * @return The first name of the person.
	 */
	public String getFirstName() {
		return _firstName;
	}

	/**
	 * Get the city the person lives in.
	 * @return The city the person lives in.
	 */
	public String getCity() {
		return _city;
	}
}
