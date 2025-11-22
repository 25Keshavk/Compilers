import java.util.Scanner;

/** 
 * This program generates a random number between 1 and 100 for the user to guess
 * and then tells the user whether their guess is higher, lower, or correct
 * 
 * @author Keshav Kotamraju 
 * @version September 2 2022
 */
public class GuessingGame
{
    // Only one instance variable is permitted in this class.
    private int rand;  // random number

    /**
     * Constructs an object to the class.
     */
    public GuessingGame()//Constructor for Guessing Game class(no return type)
    {
        // initialize instance variables
        rand = 0;
    }

    /**
     * Assigns a value to the random number variable.
     * 
     * @return      the random number
     */
    public int generateRandomNumber( )
    {
        rand = (int)(Math.random()*100+1);//Turns the random number with range [0,1) to [1,100]
        return rand;
    }

    /**
     * Asks the user for a guess and returns it.
     * 
     * @return      the user's guess
     */
    public int askForUserGuess( )
    {
        System.out.println("Guess a number from 1 to 100: ");
        Scanner in = new Scanner (System.in);
        int guess = in.nextInt( );
        return guess;
    }

    /**
     * Tells user how their guess was relative to the number.
     * 
     * @param guess      user's guess
     */
    public void giveUserFeedback(int guess)
    {
        if (rand == guess)
        {
            System.out.println("Congratulations, you won!");
        }
        if (rand < guess)
        {
            System.out.println("Your guess is too high!");
        }
        if (rand > guess)
        {
            System.out.println("Your guess is too low!");
        }
    }
        

    /**
     * Determines if the user has guessed correctly.
     * 
     * @param userGuess     the user's number/guess
     * 
     * @return true     if the user is correct; otherwise, false
     */
    public boolean isWinner(int userGuess)
    {
        if (rand == userGuess)
        {
            return true;
        }
        else
        {
           return false; 
        }
    }

    /**
     * Runs the guessing game.
     *
     * @param args       information from the command line
     */
    public static void main(String [ ] args)
    {
        GuessingGame bob = new GuessingGame( );
        bob.generateRandomNumber( );
        int est = bob.askForUserGuess( );
        bob.giveUserFeedback(est);
        while ( ! bob.isWinner(est) )
        {
            est = bob.askForUserGuess( );
            bob.giveUserFeedback(est);

        }
    }

}
