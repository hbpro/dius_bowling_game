package au.com.dius;

import au.com.dius.business.*;
import au.com.dius.business.exceptions.EndOfGameException;
import au.com.dius.presentation.GamePresenter;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>Driver</b>
 *
 * This class is the driver of diusBowlingGame simulator
 * It will use the DependencyManager class to retrieve bowlingGame and gamePresenter
 * instances. Then it reads rolls from input and calculates the score
 */
public class Driver {
    private final static Logger logger = Logger.getLogger(Driver.class.getName());
    public static void main(String[] args) {
        logger.setLevel(Level.INFO);
        DependencyManager dependencyManager = new DependencyManager();
        BowlingGame bowlingGame = dependencyManager.getBowlingGame();
        GamePresenter gamePresenter = dependencyManager.getGamePresenter();

        while (true){
            logger.log(Level.INFO, "Roll: ");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            try {
                bowlingGame.roll(num);
                logger.log(Level.INFO, gamePresenter.getGameScoreboard());
            }
            catch (EndOfGameException e){
                logger.log(Level.INFO, e.getMessage());
                break;
            }
            catch (Exception e) {
                logger.log(Level.INFO, e.getMessage());
            }
        }
    }
}
