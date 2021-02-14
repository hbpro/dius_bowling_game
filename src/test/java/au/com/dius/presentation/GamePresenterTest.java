package au.com.dius.presentation;

import au.com.dius.business.BowlingGame;
import au.com.dius.business.DependencyManager;
import au.com.dius.data.ScoresModel;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * <b>GamePresenterTest</b>
 *
 * Tests GamePresenter test
 */
public class GamePresenterTest {

    DependencyManager dependencyManager = new DependencyManager();
    BowlingGame bowlingGame = dependencyManager.getBowlingGame();
    GamePresenter gamePresenter = dependencyManager.getGamePresenter();
    ScoresModel scoresModel = dependencyManager.getScoreModel();

    /**
     * Tests the au.com.dius.presentation of the current state of the game
     */
    @Test
    public void testScoreboardString(){
        scoresModel.resetGame();
        try {
            bowlingGame.roll(1);
            bowlingGame.roll(5);
            bowlingGame.roll(10);
            bowlingGame.roll(0);
            bowlingGame.roll(9);
            bowlingGame.roll(1);
            bowlingGame.roll(1);
            String output = "1, 5, 10, 0, 0, 9, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, \n" +
                    "REGULAR, STRIKE, REGULAR, REGULAR, NOT_PLAYED, NOT_PLAYED, NOT_PLAYED, NOT_PLAYED, NOT_PLAYED, NOT_PLAYED, \n" +
                    "Score: 36";
            assertEquals(gamePresenter.getGameScoreboard(), output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
