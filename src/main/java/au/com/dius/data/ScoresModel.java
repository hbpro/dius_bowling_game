package au.com.dius.data;

/**
 * <b>ScoreModel</b>
 *
 * Contains the current state of the game and game constants
 */
public class ScoresModel {
    public static final int maxNumOfAttempts = 21;
    public static final int maxNumOfFrames = 10;
    private static ScoresModel scoresModel = null;

    public int attemptsScore[] = null;
    public int currentAttempt;
    public FrameType frameTypes[] = null;

    private ScoresModel(){
        resetGame();
    }

    public static ScoresModel getScoresModel() {
        if(scoresModel == null)
            scoresModel = new ScoresModel();
        return scoresModel;
    }

    /**
     * Resets the state of the game
     */
    public void resetGame(){
        currentAttempt = -1;
        attemptsScore = new int[maxNumOfAttempts];
        frameTypes = new FrameType[maxNumOfFrames];

        for(int i = 0; i < maxNumOfFrames; i++)
            frameTypes[i] = FrameType.NOT_PLAYED;
        for(int i = 0; i < maxNumOfAttempts; i++)
            attemptsScore[i] = 0;
    }
}
