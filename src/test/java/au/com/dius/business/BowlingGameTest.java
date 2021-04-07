package au.com.dius.business;

import au.com.dius.business.exceptions.MoreThanTenPinsException;
import au.com.dius.data.ScoresModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * <b>BowlingGameTest</b>
 *
 * Tests the BowlingGame class
 */
public class BowlingGameTest {

    DependencyManager dependencyManager = new DependencyManager();
    BowlingGame bowlingGame = dependencyManager.getBowlingGame();
    ScoresModel scoresModel = dependencyManager.getScoreModel();

    /**
     *  Tests whether the roll function throws more MoreThanTenPinsException
     *  when the no. pins in more than 10
     */
    @Test
    public void testMoreThanTenPinsException(){
        scoresModel.resetGame();
        try {
            assertThrows(MoreThanTenPinsException.class, () -> {
                bowlingGame.roll(11);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks whether the actual value and the value passed to roll function equal
     */
    @Test
    public void testRoll(){
        scoresModel.resetGame();
        try {
            bowlingGame.roll(1);
            bowlingGame.roll(5);
            bowlingGame.roll(10);
            bowlingGame.roll(0);
            bowlingGame.roll(9);

            assertEquals(scoresModel.attemptsScore[0], 1);
            assertEquals(scoresModel.attemptsScore[1], 5);
            assertEquals(scoresModel.attemptsScore[2], 10);
            assertEquals(scoresModel.attemptsScore[3], 0);
            assertEquals(scoresModel.attemptsScore[4], 0);
            assertEquals(scoresModel.attemptsScore[5], 9);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks whether the overall score equals to the actual one
     */
    @Test
    public void testScore(){
        scoresModel.resetGame();
        try {
            bowlingGame.roll(1);
            bowlingGame.roll(5);
            bowlingGame.roll(10);
            bowlingGame.roll(0);
            bowlingGame.roll(9);
            bowlingGame.roll(1);
            bowlingGame.roll(1);

            assertEquals(bowlingGame.score(), 36);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
