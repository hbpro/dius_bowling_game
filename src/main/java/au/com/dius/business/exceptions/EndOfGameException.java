package au.com.dius.business.exceptions;

/**
 * <b>EndOfGameException</b>
 *
 * Exception which is raised when the game is finished
 */
public class EndOfGameException extends Exception{
    public EndOfGameException(){
        super("Game finished!");
    }
}
