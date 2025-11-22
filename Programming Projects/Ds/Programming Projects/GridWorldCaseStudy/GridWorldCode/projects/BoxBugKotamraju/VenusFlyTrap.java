
/**
 *Venus Fly Trap eats the bugs in front and behind it. If it cannot eat any bugs, it will behave like a regular bug.
 *
 * @author Keshav Kotamraju
 * @version 10/6/2022
 */
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;
public class VenusFlyTrap extends Flower
{
    private boolean hasEaten;
    /**
     * Constructs a green venus fly trap that has not eaten.
     */
    public VenusFlyTrap()
    {
        super(Color.GREEN);
        this.hasEaten = hasEaten;
    }

    /**
     * Checks for a bug at a given location and eats it if one is there. If it eats a bug, turns green.
     *
     * @param  loc  the location to check for a bug
     * @return    true if there is a bug at the location; otherwise
     *            false
     */
    public boolean eatBug(Location loc)
    {
        Grid<Actor> gr = getGrid();
        if (gr.isValid(loc) && gr != null)
        {
            Actor neighbour = gr.get(loc);
            if (neighbour instanceof Bug)
            {
                neighbour.removeSelfFromGrid();
                setColor(Color.GREEN);
                hasEaten = true; 
                return true;
            }
        }
        return false;
    }
    /**
     * Checks front and back for a bug, and if one is there, will eat it.
     */
    public void eat()
    {
        Location trapsLoc = this.getLocation();
        int trapsDir = this.getDirection();
        int myDir = this.getDirection();
        int frontDir = myDir + Location.AHEAD;
        int behindDir = myDir + Location.HALF_CIRCLE;
        Location aheadTrap = trapsLoc.getAdjacentLocation(frontDir);
        Location behindTrap = trapsLoc.getAdjacentLocation(behindDir);
        
        eatBug(aheadTrap);
        eatBug(behindTrap);
    }
    /**
     * Eats the bugs in front and behind it. If it cannot eat any bugs, 
     * it will behave like a regular bug.
     */
    @Override
    public void act()
    {
        hasEaten = false;
        eat();
        if (!hasEaten)
        {
            super.act();
        }
    }
}
