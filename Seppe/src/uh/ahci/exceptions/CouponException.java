package uh.ahci.exceptions;

/**
 * Exception that is thrown by a coupon.
 *
 * @author Seppe Magiels
 * @see Exception
 */
public class CouponException extends Exception {

    /**
     * Constructor.
     */
    public CouponException() {
        super();
    }

    /**
     * Constructor.
     *
     * @param string The detail message (which is saved for later retrieval by
     * the {@link #getMessage()} method)
     */
    public CouponException(String string) {
        super(string);
    }
}