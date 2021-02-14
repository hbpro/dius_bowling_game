package au.com.dius.business;

import au.com.dius.data.FrameType;
import au.com.dius.data.ScoresModel;

/**
 * <b>DiusScoreCalculator Class</b>
 *
 * implements the prototype of required methods to calculate score based on the
 * current frame status
 */
public class DiusScoreCalculator implements ScoreCalculator{
    private ScoresModel scoresModel;
    public DiusScoreCalculator(ScoresModel scoresModel){
        this.scoresModel = scoresModel;
    }

    /**
     * Calculates the score of a strike frame
     * @param currentFrame int
     * @return int value
     */
    @Override
    public int getScoreForStrikeFrame(int currentFrame){
        int score = 0;
        if(currentFrame < ScoresModel.maxNumOfFrames - 2){
            if(scoresModel.frameTypes[currentFrame + 1] == FrameType.NOT_PLAYED ||
                    scoresModel.frameTypes[currentFrame + 2] == FrameType.NOT_PLAYED ||
                    scoresModel.frameTypes[currentFrame + 1] == FrameType.FIRST_ATTEMPT ||
                    scoresModel.frameTypes[currentFrame + 2] == FrameType.FIRST_ATTEMPT)
                score = -1;
            else if(scoresModel.frameTypes[currentFrame + 1] == FrameType.STRIKE) {
                score = scoresModel.attemptsScore[2 * currentFrame] +
                        scoresModel.attemptsScore[2 * currentFrame + 2] +
                        scoresModel.attemptsScore[2 * currentFrame + 4];
            }
            else {
                score = scoresModel.attemptsScore[2 * currentFrame] +
                        scoresModel.attemptsScore[2 * currentFrame + 2] +
                        scoresModel.attemptsScore[2 * currentFrame + 3];
            }
        }
        else if(currentFrame >= ScoresModel.maxNumOfFrames - 2) {
            if (scoresModel.frameTypes[currentFrame + 1] == FrameType.NOT_PLAYED ||
                    scoresModel.frameTypes[currentFrame + 1] == FrameType.FIRST_ATTEMPT) {
                score = -1;
            } else {
                score = scoresModel.attemptsScore[2 * currentFrame] +
                        scoresModel.attemptsScore[2 * currentFrame + 2] +
                        scoresModel.attemptsScore[2 * currentFrame + 3];
            }
        }
        else {
            score = scoresModel.attemptsScore[2 * currentFrame];
        }
        return score;
    }

    /**
     * Calculates the score of a spare frame
     * @param currentFrame int
     * @return int value
     */
    @Override
    public int getScoreForSpareFrame(int currentFrame){
        int score = 0;
        if(currentFrame < ScoresModel.maxNumOfFrames - 1){
            if(scoresModel.frameTypes[currentFrame + 1] == FrameType.NOT_PLAYED ||
                    scoresModel.frameTypes[currentFrame + 1] == FrameType.FIRST_ATTEMPT) {
                score = -1;
            }
            else {
                score = scoresModel.attemptsScore[2 * currentFrame] +
                        scoresModel.attemptsScore[2 * currentFrame + 1] +
                        scoresModel.attemptsScore[2 * currentFrame + 2];
            }
        }
        else {
            score = scoresModel.attemptsScore[2 * currentFrame] +
                    scoresModel.attemptsScore[2 * currentFrame + 1] +
                    scoresModel.attemptsScore[2 * currentFrame + 2];
        }
        return score;
    }

    /**
     * Calculates the score of a regular frame
     * @param currentFrame int
     * @return int value
     */
    @Override
    public int getScoreForRegularFrame(int currentFrame){
        int score = scoresModel.attemptsScore[2 * currentFrame] +
                scoresModel.attemptsScore[2 * currentFrame + 1];
        return score;
    }

    /**
     * Calculates the score of a first attempted frame
     * @param currentFrame int
     * @return int value
     */
    @Override
    public int getScoreForFirstAttemptFrame(int currentFrame){
        int score = scoresModel.attemptsScore[2 * currentFrame];
        return score;
    }
}
