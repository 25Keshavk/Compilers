import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The tetrad class contains a constructor to create new tetrads of random color 
 * and shape as well as methods to modify the location of the object.
 * A tetrad object consists of four blocks, given as an instance array of blocks.
 * The tetrad class also contains an instance grid to allow for modifying of locations.
 * @author Keshav Kotamraju
 * @version March 16, 2023
 */
public class Tetrad
{
    private Block[] blocks;
    private MyBoundedGrid<Block> gri;
    private int rand;
    private static final Color RED = Color.RED;
    private static final Color GRAY = Color.GRAY;
    private static final Color CYAN = Color.CYAN;
    private static final Color YELLOW = Color.YELLOW;
    private static final Color MAGENTA = Color.MAGENTA;
    private static final Color BLUE = Color.BLUE;
    private static final Color GREEN = Color.GREEN;

    /**
     * Constructs a Tetrad object of random color and shape, 
     * and adds each square of the object to the grid. 
     * 
     * @param gr    the grid which the method adds the tetrad to
     */
    public Tetrad(MyBoundedGrid<Block> gr)
    {
        gri = gr;
        blocks = new Block[4];
        Color col;
        Location[] locs = new Location[4];
        rand = 1;//(int)(Math.random()* 7 + 1); 
        int mid = gri.getNumCols()/2;
        if (rand == 1)
        {
            col = RED;
            locs[0] = new Location(0,mid-1);
            locs[1] = new Location(1,mid-1);
            locs[2] = new Location(2,mid-1);
            locs[3] = new Location(3,mid-1);
        }
        else if (rand == 2)
        {
            col = GRAY;
            locs[0] = new Location(0,mid-2);
            locs[1] = new Location(0,mid-1);
            locs[2] = new Location(0,mid);
            locs[3] = new Location(1,mid-1);
        }

        else if (rand == 3)
        {
            col = CYAN;
            locs[0] = new Location(0,mid-1);
            locs[1] = new Location(0,mid);
            locs[2] = new Location(1,mid-1);
            locs[3] = new Location(1,mid);
        }    
        else if (rand == mid-1)
        {
            col = YELLOW;
            locs[0] = new Location(0,mid-1);
            locs[1] = new Location(1,mid-1);
            locs[2] = new Location(2,mid-1);
            locs[3] = new Location(2,mid);
        }
        else if (rand == mid)
        {
            col = MAGENTA;
            locs[0] = new Location(0,mid);
            locs[1] = new Location(1,mid);
            locs[2] = new Location(2,mid);
            locs[3] = new Location(2,mid-1);
        }

        else if (rand == 6)
        {
            col = BLUE;
            locs[0] = new Location(0,mid);
            locs[1] = new Location(0,mid-1);
            locs[2] = new Location(1,mid-1);
            locs[3] = new Location(1,mid-2);
        }

        else
        {
            col = GREEN; 
            locs[0] = new Location(0,mid-2);
            locs[1] = new Location(0,mid-1);
            locs[2] = new Location(1,mid);
            locs[3] = new Location(1,mid-1);
        }
        for (int index = 0; index < blocks.length; index++)
        {
            blocks[index] = new Block();
            blocks[index].setColor(col);
        }
        addToLocations(gri, locs);
    }

    /**
     * Adds blocks to multiple given locations.
     *
     * @param  grid the grid where the block will be added
     * @param  locs the location to add the block to
     */
    private void addToLocations(MyBoundedGrid<Block> grid,
    Location[] locs)
    {
        for (int i = 0;  i < blocks.length; i++)
            blocks[i].putSelfInGrid(grid,locs[i]);
    }

    /**
     * Removes the blocks for the tetrad and returns the locations of the blocks.
     *
     * @return  locs the locations of the blocks
     */
    private Location[] removeBlocks()
    {
        Location [] locs = new Location[4];
        for(int i = 0; i < blocks.length; i++)
        {
            locs[i] = blocks[i].getLocation();
            blocks[i].removeSelfFromGrid();
        }
        return locs;
    }

    /**
     * Checks if the given locations are valid and if they are empty.
     *
     * @param  grid the grid where the locations will be checked
     * @param locs the locations to check
     * 
     * @return true if locations are valid and empty; otherwise,
     *         false
     */
    private boolean areEmpty(MyBoundedGrid<Block> grid,
    Location[] locs)
    {
        for (Location loc : locs)
        {
            if (!(grid.isValid(loc)) || grid.get(loc) != null)
            {
                return false;
            }
            else if (grid.get(loc) != null)
                return false;  
        }
        return true;
    }

    /**
     * Moves the tetrad a certain number of rows and columns. A positive deltaRow
     * means it moves right, and a negative means it moves left.
     * Similarly, a positive deltaCol means it moves up, 
     * negative means move down.
     *
     * @param  deltaRow the amount of rows to move
     * @param  deltaCol the amount of columns to move
     * @return true if tetrad can be moved; otherwise
     *         false
     */
    public boolean translate(int deltaRow, int deltaCol)
    {
        Location[] locs = removeBlocks() ;
        Location[] newLocs = new Location[locs.length];
        for (int i = 0; i < locs.length; i++)
        {
            int row = locs[i].getRow();
            int col = locs[i].getCol();
            newLocs[i] = new Location(row + deltaRow,col + deltaCol);
        } 
        if (areEmpty(gri,newLocs))
        {
            addToLocations(gri,newLocs);
            return true;
        }
        addToLocations(gri,locs);
        return false;

    }

    /**
     * Rotates the tetrad object clockwise along a point p'.
     *
     * @return true if tetrad successfully rotates; otherwise,
     *         false
     */
    public boolean rotate()
    {
        if(rand != 3)
        {
            Location loc = blocks[1].getLocation();
            Location[] oldLocs = removeBlocks();
            Location[] newLocs = new Location[4];
            for (int i = 0; i < 4; i++)
            {
                int row = oldLocs[i].getRow();
                int col = oldLocs[i].getCol();
                newLocs[i] = new Location(loc.getRow()-loc.getCol()+col,
                     loc.getRow()+loc.getCol()-row);
            }
            if (areEmpty(gri,newLocs))
            {
                addToLocations(gri,newLocs);
                return true;
            }
            addToLocations(gri,oldLocs);
            return false;
        }
        return false;
    }

}
