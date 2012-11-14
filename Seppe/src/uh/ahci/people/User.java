package uh.ahci.people;

import uh.ahci.exceptions.UserException;

/**
 * This class represents the costumer that is currently logged in.
 * @author Seppe Magiels
 */
public class User extends Person {

	public static User _instance = null;
	private String _username = ""; 
	private String _password = "";
	
	/**
	 * Constructor.
	 */
	protected User() {
	}

	/**
	 * Get an instance of User.
	 * This is the costumer that is using the application.
	 */
	public static User instance() {
		if(_instance == null)
			_instance = new User();
		return _instance;
	}
	
	/**
	 * Set the login data of the User. 
	 * @param username The name of the 
	 * @throws UserException
	 */
	public void setLogin(String username, String password) throws UserException {
		if(username == null || !username.equals(""))
			throw(new UserException("The username can't be null or empty!"));
		if(password == null || !password.equals(""))
			throw(new UserException("The username can't be null or empty!"));
		_username = username;
		_password = password;
	}
	
	/**
	 * Log in using the specified username and password.
	 * Id, firstName, lastName and city will be set on success. 
	 * @return True if login was successful. False otherwise.
	 */
	public boolean login() {
		return true;
	}
	
	/**
	 * Get the filename of the database file that is used for this user.
	 * @return The unique name for this user.
	 */
	public String getDbName() {
		return "db"+_username+getId()+".sqlite";
	}
}
