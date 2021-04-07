package au.com.dius.presentation;

import au.com.dius.business.BowlingGame;
import au.com.dius.data.ScoresModel;

/**
 * <b>DiusGamePresenter</b>
 *
 * This class implements GamePresenter interface to stringify the current state of the game
 */
public class DiusGamePresenter implements GamePresenter{
    private ScoresModel scoresModel;
    private BowlingGame bowlingGame;
    public DiusGamePresenter(ScoresModel scoresModel, BowlingGame bowlingGame){
        this.bowlingGame = bowlingGame;
        this.scoresModel = scoresModel;
    }

    /**
     * generates gameScoreboard string which represents the current state of the game
     * @return String value
     */
    @Override
    public String getGameScoreboard(){
        String gameScoreboard = "";
        for(int i = 0; i < ScoresModel.maxNumOfAttempts; i++)
            gameScoreboard += scoresModel.attemptsScore[i] + ", ";
        gameScoreboard += "\n";
        for(int i = 0; i < ScoresModel.maxNumOfFrames; i++)
            gameScoreboard += scoresModel.frameTypes[i] + ", ";
        int score = bowlingGame.score();
        gameScoreboard += "\nScore: " +
                (score == -1 ? "Waiting for the next roll...": score);

        return gameScoreboard;
    }
}
