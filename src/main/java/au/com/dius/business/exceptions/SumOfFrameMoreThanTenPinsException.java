package au.com.dius.business.exceptions;

/**
 * <b>SumOfFrameMoreThanTenPinsException</b>
 *
 * Exception which is raised when sum of no.pins in a frame is more than 10
 */
public class SumOfFrameMoreThanTenPinsException extends Exception{
    public SumOfFrameMoreThanTenPinsException(){
        super("Invalid pins number! (Sum of two frames cannot be more than 10)");
    }
}
