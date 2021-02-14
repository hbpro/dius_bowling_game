package au.com.dius.business.exceptions;

/**
 * <b>NegativePinException</b>
 *
 * Exception which is raised when the no.pins is negative
 */
public class NegativePinException extends Exception{
    public NegativePinException(){
        super("Invalid pins number! (Pins number cannot be negative)");
    }
}
