
import kareltherobot.*;
import java.awt.Color;

/**
 * Checks the installation of Karel and BlueJ
 * 
 * @author  Martin Baynes 
 *
 * @version June 9, 2014 11:30am
 */
public class CheckInstallation implements Directions 
{
    /**
     * Creates and positions a robot to test code.
     *
     * @param args arguments from the command line
     */
    public static void main(String [] args)
    {    
        /* Sets up the GUI for the Karel world. */
        WorldBuilder myBuilder = new WorldBuilder(false); 
        World.reset();
        //World.showSpeedControl(true); // use setDelay method
        String pathPc = "C:/ProgramData/HarkerCS/worldFilesDOS/";  //Path for worlds on PC 
        String pathMac = "/Users/Shared/HarkerCS/worldFilesDOS/"; //Path for worlds on Mac  

        /* Read a world from a file in the given directory path. */

        //Edit to open the desired world 
        World.readWorld(pathPc, "fig2-3.kwld");   // Use for PC 
        World.readWorld(pathMac, "fig2-3.kwld");   // Use for Mac 

        World.setDelay(20);
        World.setSize(10, 10);

        World.setVisible(true);

        /* Creates a Robot karel at (1,1), facing East, with no beepers. */
        UrRobot karel = new UrRobot(1, 2, East, 0);

        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        karel.move();
        karel.move();
        karel.turnLeft();
        karel.move();
        karel.pickBeeper();
        karel.move();
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        karel.move();
        karel.move();
        karel.putBeeper();
        karel.turnLeft();
        karel.move();

    }
}