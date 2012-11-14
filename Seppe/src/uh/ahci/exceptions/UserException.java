package uh.ahci.exceptions;

/**
 * Exception that is thrown by a user.
 *
 * @author Seppe Magiels
 * @see Exception
 */
public class UserException extends Exception {

    /**
     * Constructor.
     */
    public UserException() {
        super();
    }

    /**
     * Constructor.
     *
     * @param string The detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method)
     */
    public UserException(String string) {
        super(string);
    }
}