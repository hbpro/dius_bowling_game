package au.com.dius.business.exceptions;


/**
 * <b>MoreThanTenPinsException</b>
 *
 * Exception which is raised when the no.pins is greater than 10
 */
public class MoreThanTenPinsException extends Exception{
    public MoreThanTenPinsException(){
        super("Invalid pins number! (Pins number cannot be more than 10)");
    }
}
