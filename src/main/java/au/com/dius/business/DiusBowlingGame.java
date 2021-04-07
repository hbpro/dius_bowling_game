package au.com.dius.business;

import au.com.dius.business.exceptions.EndOfGameException;
import au.com.dius.business.exceptions.MoreThanTenPinsException;
import au.com.dius.business.exceptions.NegativePinException;
import au.com.dius.business.exceptions.SumOfFrameMoreThanTenPinsException;
import au.com.dius.data.FrameType;
import au.com.dius.data.ScoresModel;

/**
 * <b>DiusBowlingGame Class</b>
 *
 * Implements the Bowling interface
 */

public class DiusBowlingGame implements BowlingGame{

    private ScoresModel scoresModel;
    private ScoreCalculator scoreCalculator;

    public DiusBowlingGame(ScoresModel scoresModel, ScoreCalculator scoreCalculator){
        this.scoresModel = scoresModel;
        this.scoreCalculator = scoreCalculator;
    }

    /**
     * Implements BowlingGame roll function
     *
     * Changes the status of the game regarding the current attempt
     * @param noOfPins which is the number of pins that are hit during this attempt
     * @throws Exception
     */
    @Override
    public void roll(int noOfPins) throws Exception {
        scoresModel.currentAttempt++;
        if(scoresModel.currentAttempt > ScoresModel.maxNumOfAttempts - 1){
            throw new EndOfGameException();
        }
        if(noOfPins > 10) {
            scoresModel.currentAttempt--;
            throw new MoreThanTenPinsException();
        }
        if(noOfPins < 0) {
            scoresModel.currentAttempt--;
            throw new NegativePinException();
        }
        else if(scoresModel.currentAttempt < ScoresModel.maxNumOfAttempts - 2 &&
                scoresModel.currentAttempt % 2 == 1 &&
                scoresModel.attemptsScore[scoresModel.currentAttempt - 1] + noOfPins > 10){
            scoresModel.currentAttempt--;
            throw new SumOfFrameMoreThanTenPinsException();
        }
        if(scoresModel.currentAttempt % 2 == 0 &&
                scoresModel.currentAttempt < ScoresModel.maxNumOfAttempts - 3
                && noOfPins == 10) {
            scoresModel.frameTypes[scoresModel.currentAttempt/2] = FrameType.STRIKE;
        }
        else if(scoresModel.currentAttempt == ScoresModel.maxNumOfAttempts - 1 &&
                (scoresModel.frameTypes[scoresModel.currentAttempt/2 - 1] == FrameType.STRIKE ||
                scoresModel.frameTypes[scoresModel.currentAttempt/2 - 1] == FrameType.SPARE)) {
            scoresModel.attemptsScore[scoresModel.currentAttempt] = noOfPins;
        }
        else if(scoresModel.currentAttempt % 2 == 1 && noOfPins == 10 &&
                scoresModel.currentAttempt < ScoresModel.maxNumOfAttempts - 2){
            scoresModel.frameTypes[scoresModel.currentAttempt/2] = FrameType.SPARE;
        }
        else if(scoresModel.currentAttempt % 2 == 1 &&
                (noOfPins + scoresModel.attemptsScore[scoresModel.currentAttempt- 1] == 10)){
            scoresModel.frameTypes[scoresModel.currentAttempt/2] = FrameType.SPARE;
        }
        else if(scoresModel.currentAttempt % 2 == 0 &&
                scoresModel.currentAttempt < ScoresModel.maxNumOfAttempts - 1){
            scoresModel.frameTypes[scoresModel.currentAttempt/2] = FrameType.FIRST_ATTEMPT;
        }
        else if(scoresModel.currentAttempt % 2 == 1){
            scoresModel.frameTypes[scoresModel.currentAttempt/2] = FrameType.REGULAR;
        }

        scoresModel.attemptsScore[scoresModel.currentAttempt] = noOfPins;

        if(scoresModel.currentAttempt % 2 == 0 &&
                scoresModel.currentAttempt < ScoresModel.maxNumOfAttempts - 3
                && noOfPins == 10) {
            scoresModel.currentAttempt++;
        }
        if(scoresModel.currentAttempt == ScoresModel.maxNumOfAttempts - 2 &&
                (scoresModel.attemptsScore[scoresModel.currentAttempt] +
                        scoresModel.attemptsScore[scoresModel.currentAttempt - 1] < 10) &&
                noOfPins != 10){
            scoresModel.currentAttempt = ScoresModel.maxNumOfAttempts;
        }
    }

    /**
     * Implements BowlingGame score function
     *
     * Calculates the score of the current state of the game
     * @return score
     */
    @Override
    public int score() {
        int score = 0;
        for(int i = 0; i < ScoresModel.maxNumOfFrames - 1; i++){
            if(scoresModel.frameTypes[i] == FrameType.STRIKE){
                int frameScore = scoreCalculator.getScoreForStrikeFrame(i);
                if(frameScore == -1) {
                    score = frameScore;
                    break;
                }
                score += frameScore;
            }
            if(scoresModel.frameTypes[i] == FrameType.SPARE){
                int frameScore = scoreCalculator.getScoreForSpareFrame(i);
                if(frameScore == -1) {
                    score = frameScore;
                    break;
                }
                score += frameScore;
            }
            if(scoresModel.frameTypes[i] == FrameType.REGULAR) {
                score += scoreCalculator.getScoreForRegularFrame(i);
            }
            if(scoresModel.frameTypes[i] == FrameType.FIRST_ATTEMPT) {
                score += scoreCalculator.getScoreForFirstAttemptFrame(i);
            }
            if(scoresModel.frameTypes[i] == FrameType.NOT_PLAYED){
                break;
            }
        }
        if(score != -1 &&
                scoresModel.currentAttempt >= ScoresModel.maxNumOfAttempts - 3){
            for(int i = ScoresModel.maxNumOfAttempts - 3; i < ScoresModel.maxNumOfAttempts; i++) {
                score += scoresModel.attemptsScore[i];
            }
        }
        return score;
    }

}
