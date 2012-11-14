package uh.ahci.exceptions;

/**
 * Exception that is thrown by a store or store chain.
 *
 * @author Seppe Magiels
 * @see Exception
 */
public class StoreException extends Exception {

    /**
     * Constructor.
     */
    public StoreException() {
        super();
    }

    /**
     * Constructor.
     *
     * @param string The detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method)
     */
    public StoreException(String string) {
        super(string);
    }
}