package au.com.dius.data;

import au.com.dius.business.DependencyManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <b>ScoreModelTest</b>
 *
 * Tests ScoreModel class
 */
public class ScoreModelTest {

    DependencyManager dependencyManager = new DependencyManager();
    ScoresModel scoresModel = dependencyManager.getScoreModel();

    /**
     * Tests resetGame function and the corresponded values to be zero
     */
    @Test
    public void testResetGame(){
        scoresModel.resetGame();
        try {
            scoresModel.resetGame();
            for(int i = 0; i < ScoresModel.maxNumOfAttempts; i++) {
                assertEquals(scoresModel.attemptsScore[i], 0);
            }
            for(int i = 0; i < ScoresModel.maxNumOfFrames; i++){
                assertEquals(scoresModel.frameTypes[i], FrameType.NOT_PLAYED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
