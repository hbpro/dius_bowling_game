package au.com.dius.business;

import au.com.dius.data.ScoresModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <b>ScoreCalculatorTest</b>
 *
 * Tests the ScoreCalculator class
 */
public class ScoreCalculatorTest {
    DependencyManager dependencyManager = new DependencyManager();
    BowlingGame bowlingGame = dependencyManager.getBowlingGame();
    ScoreCalculator scoreCalculator = dependencyManager.getScoreCalculator();
    ScoresModel scoresModel = dependencyManager.getScoreModel();

    /**
     * Tests different frame types score
     */
    @Test
    public void testDifferentFrameTypes(){
        scoresModel.resetGame();
        try {
            bowlingGame.roll(1);
            bowlingGame.roll(5);
            bowlingGame.roll(10);
            bowlingGame.roll(6);
            bowlingGame.roll(3);
            bowlingGame.roll(9);
            bowlingGame.roll(1);
            bowlingGame.roll(1);
            bowlingGame.roll(1);
            bowlingGame.roll(1);

            assertEquals(scoreCalculator.getScoreForRegularFrame(0), 6);
            assertEquals(scoreCalculator.getScoreForStrikeFrame(1), 19);
            assertEquals(scoreCalculator.getScoreForRegularFrame(2), 9);
            assertEquals(scoreCalculator.getScoreForSpareFrame(3), 11);
            assertEquals(scoreCalculator.getScoreForRegularFrame(4), 2);
            assertEquals(scoreCalculator.getScoreForFirstAttemptFrame(5), 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
