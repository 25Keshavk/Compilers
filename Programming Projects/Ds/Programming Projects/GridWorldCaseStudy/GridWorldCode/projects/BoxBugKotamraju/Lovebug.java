
/**
 * Love bug acts like a regular bug and will clone a bug into the 
 * bottom left, bottom right, or both locations if there is either 
 * nothing or a flower. The cloning is based on random values and the 
 * probability of breeding.
 * 
 * @author Keshav Kotamraju
 * @version 10/10/2022
 */
import java.awt.Color;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.lang.Math.*;
public class Lovebug extends Bug
{
    private int probBreed;
    private static final int DEFAULT_PROBABILITY_OF_BREEDING = 50;
    /**
     * Constructs a pink lovebug with default probability of breeding.
     */
    public Lovebug()
    {
        this(Color.PINK, DEFAULT_PROBABILITY_OF_BREEDING);
    }
    /**
     * Constructs a lovebug with chosen color and probability of breeding.
     * 
     * @param color         determines color of the lovebug
     * @param probBreed     the probability for the bug to clone
     */
    public Lovebug(Color color, int probBreed)
    {
        super(color);
        this.probBreed = probBreed;
    }
    /**
     * Constructs a pink lovebug with chosen probability of breeding.
     * 
     * @param probBreed     the probability for the bug to clone
     */
    public Lovebug(int probBreed)
    {
        this(Color.PINK, probBreed);
    }
    /**
     * Constructs a lovebug with chosen color and default probability of breeding.
     * 
     * @param color     determines color of the lovebug
     */
    public Lovebug(Color color)
    {
        this(color, DEFAULT_PROBABILITY_OF_BREEDING);
    }
    /**
     * Given a location, checks if the lovebug can clone at that location. 
     * If there is nothing or a flower, it can clone
     * at that location.
     *
     * @param  loc  the location to check for if the bug can clone
     * @return    true if bug can clone; otherwise
     *            false
     */
    public boolean canClone(Location loc)
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        if (!gr.isValid(loc))
            return false;
        Actor checkSpace = gr.get(loc);
        return (checkSpace instanceof Flower || checkSpace == null);
    }
    /**
     * If the random number is less than or equal to the probability 
     * of breeding and you can clone at location,
     * it will clone the lovebug.
     *
     * @param  loc  the location to clone at
     */
    public void clone(Location loc)
    {
        Grid<Actor> gr = getGrid();
        int randNum = (int)(Math.random() * 101);
        if (randNum <= probBreed && probBreed > 0 && gr.isValid(loc))
        {
            Lovebug baby = new Lovebug(getColor(),probBreed);
            baby.putSelfInGrid(gr,loc);
            baby.setDirection(getDirection());
        } 
    }
    /**
     * Returns bug's info and probability of breeding.
     * 
     * @return the bug's info and probBreed
     */
    @Override
    public String toString()
    {
      return super.toString() + " \nprobability of breeding is: " + probBreed;  
    }
    /**
     * Acts like a regular bug, then checks if it can clone 
     * below to the right and below to the left, 
     * and will clone at either or both locations if there 
     * is nothing or a flower.
     */
    @Override
    public void act()
    {
        super.act();
        
        int dir = getDirection();
        int lowerRightDir = dir + Location.RIGHT + Location.HALF_RIGHT;
        int lowerLeftDir = dir + Location.LEFT + Location.HALF_LEFT;
        Location loc = getLocation();
        Location lowerRight = loc.getAdjacentLocation(lowerRightDir);
        Location lowerLeft = loc.getAdjacentLocation(lowerLeftDir);
        
        if (canClone(lowerRight))
            clone(lowerRight);
        if (canClone(lowerLeft))
            clone(lowerLeft);
    }
    /**
     * Returns the probability of breeding.
     * 
     * @return the probability of breeding
     */
    public int getProbBreed()
    {
      return probBreed;  
    }
    /**
     * Changes the probability of breeding.
     * 
     * @param lighteningFactor the value to change the probability of breeding to
     */
    public void setProbBreed(int probBreed)
    {
        this.probBreed = probBreed;
    }
}
