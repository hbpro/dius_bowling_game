package au.com.dius.business;

import au.com.dius.data.ScoresModel;
import au.com.dius.presentation.DiusGamePresenter;
import au.com.dius.presentation.GamePresenter;

/**
 * <b>DependencyManager</b>
 *
 * A Dependency Injection simulation that builds and manages required classes and
 * links them to their corresponding interfaces
 */
public class DependencyManager {
    private ScoresModel scoresModel;
    private ScoreCalculator scoreCalculator;
    private BowlingGame bowlingGame;
    private DiusGamePresenter gamePresenter;
    
    public DependencyManager(){
        scoresModel = ScoresModel.getScoresModel();
        scoreCalculator = new DiusScoreCalculator(scoresModel);
        bowlingGame = new DiusBowlingGame(scoresModel, scoreCalculator);
        gamePresenter = new DiusGamePresenter(scoresModel, bowlingGame);
    }

    /**
     *
     * @return scoreModel instance
     */
    public ScoresModel getScoreModel(){
        return scoresModel;
    }

    /**
     *
     * @return scoreCalculator instance
     */
    public ScoreCalculator getScoreCalculator(){
        return scoreCalculator;
    }

    /**
     *
     * @return bowlingGame instance
     */
    public BowlingGame getBowlingGame(){
        return bowlingGame;
    }

    /**
     *
     * @return gamePresenter instance
     */
    public GamePresenter getGamePresenter(){
        return gamePresenter;
    }
}
