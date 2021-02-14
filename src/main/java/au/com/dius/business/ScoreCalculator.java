package au.com.dius.business;

/**
 * <b>ScoreCalculator Interface</b>
 *
 * Defines the prototype of required methods to calculate score based on the
 * current frame status
 */

public interface ScoreCalculator {
    int getScoreForStrikeFrame(int currentFrame);
    int getScoreForSpareFrame(int currentFrame);
    int getScoreForRegularFrame(int currentFrame);
    int getScoreForFirstAttemptFrame(int currentFrame);
}
