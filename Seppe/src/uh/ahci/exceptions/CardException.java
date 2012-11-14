package uh.ahci.exceptions;

/**
 * Exception that is thrown by a loyalty card.
 *
 * @author Seppe Magiels
 * @see Exception
 */
public class CardException extends Exception {

    /**
     * Constructor.
     */
    public CardException() {
        super();
    }

    /**
     * Constructor.
     *
     * @param string The detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method)
     */
    public CardException(String string) {
        super(string);
    }
}