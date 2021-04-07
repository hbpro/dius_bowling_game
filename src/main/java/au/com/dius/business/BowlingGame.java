package au.com.dius.business;

/**
 * <b>BowlingGame Interface</b>
 *
 * The interface defines roll and score methods to be implemented
 */
public interface BowlingGame {
    /**
     * Changes the status of the game regarding the current attempt
     *
     * @param noOfPins which is the number of pins that are hit during this attempt
     * @throws Exception
     */
    void roll(int noOfPins) throws Exception;

    /**
     * Calculates the score of the current state of the game
     * @return score
     */
    int score();
}
