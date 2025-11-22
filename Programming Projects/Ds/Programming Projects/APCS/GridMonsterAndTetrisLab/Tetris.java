import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * The Tetris class contains methods for the tetris backdrop, also known as the grid. 
 * It allows for the placing of tetrad objects in the grid and runs the whole tetris game.
 * You can move the tetrads using arrow keys and space bars.
 * 
 *
 * @author Keshav Kotamraju
 * @version March 16, 2023
 */
public class Tetris implements ArrowListener
{
    private MyBoundedGrid<Block> gr;
    private BlockDisplay display;
    private Tetrad tetrad;
    private static boolean gameState = false;
    private static int level = 1;
    private static int rowsCleared = 0;
    private static int score = 0;

    /**
     * Constructs a new tetris grid of 20 rows by 10 columns.  
     * Additionally, creates a tetrad object and a display object.
     */
    public Tetris()
    {
        gr = new MyBoundedGrid<Block>(20,10);
        display = new BlockDisplay(gr);
        display.setTitle("Tetris");
        tetrad = new Tetrad(gr);
        display.showBlocks();
        display.setArrowListener(this);
    }

    /**
     * Rotates the tetrad clockwise when up arrow is pressed.
     * Tetrad cannot go off of grid.
     *
     */
    @Override
    public void upPressed()
    {
        tetrad.rotate();
        display.showBlocks();
    }

    /**
     * Moves the tetrad down one row when down arrow is pressed.
     * Tetrad cannot go off of grid.
     *
     */
    @Override
    public void downPressed()
    {
        tetrad.translate(1,0);
        display.showBlocks();
    }

    /**
     * Moves the tetrad left one column when left arrow is pressed.
     * Tetrad cannot go off of grid.
     *
     */
    @Override
    public void leftPressed()
    {
        tetrad.translate(0,-1); 
        display.showBlocks();
    }

    /**
     * Moves the tetrad right one column when right arrow is pressed.
     * Tetrad cannot go off of grid.
     * 
     */
    @Override
    public void rightPressed()
    {
        tetrad.translate(0,1); 
        display.showBlocks();
    }

    /**
     * Moves the tetrad all the way down when space is pressed.
     * Tetrad cannot go off of grid.
     * 
     */
    @Override
    public void spacePressed()
    {
        while (tetrad.translate(1,0))
        {

        }
        display.showBlocks();
    }
    /**
     * Starts the actual tetris game, the tetrad blocks will fall at 1 square per second.
     * Tetrad will not go off of grid.
     * 
     */
     public void play()
    {

        try
        {
            //Pause for 1000 milliseconds.
            if (level == 1)
                Thread.sleep(1000);
            if (level == 2)
                Thread.sleep(500);
            if (level == 3)
                Thread.sleep(300);
            if (level == 4)
                Thread.sleep(150);
        }
        catch(InterruptedException e)
        {
            //ignore
        }
        if (tetrad.translate(1,0))
        {
            display.showBlocks();
        }

        else
        {
            if (gr.get(new Location(0,gr.getNumCols()/2)) != null)
            {
                System.out.println("Game over");
                gameState = true;
            }
            clearCompletedRows();
            Tetrad newShape = new Tetrad(gr);
            tetrad = newShape;
            display.showBlocks();
        }

    }
    /**
     * Checks if a row is full of blocks.
     * 
     * @param row the given row
     * @return true if row is full; otherwise
     *         false
     */
    private boolean isCompletedRow(int row)
    {
         for (int i = 0; i<gr.getNumCols(); i++)
        {
            Location loc = new Location(row,i);
            if (gr.get(loc) == null)
                return false;
        }
        return true;
    }
    /**
     * Clears a given row of all blocks in that row.
     * 
     * @precondition the row is full
     * @param row the given row
     */
    private void clearRow(int row)
    {
        for (int i = 0; i<gr.getNumCols(); i++)
        {
            Block block = gr.get(new Location(row,i));
            if (block != null)
                block.removeSelfFromGrid();
        }
        for (int r = row - 1; r >= 0; r--)
        {
            for (int col = 0; col < gr.getNumCols(); col++)
            {
                Block block = gr.get(new Location(r,col));
                Location loc = new Location(r+1,col); 
                if (block != null)
                {
                    Block temp = gr.get(loc);
                    if (temp == null)
                    {
                        block.moveTo(loc);
                    }
                }
            }
        }
    }
    /**
     * Checks all rows to see if any must be cleared. Adds score proportional to how many rows cleared
     * and the level of the stage.
     */
    private void clearCompletedRows()
    {
        rowsCleared = 0;
        for (int row = 0; row < gr.getNumRows(); row++)
        {
            if (isCompletedRow(row))
            {
                rowsCleared++;
                clearRow(row);
            }
        }
        if (rowsCleared == 1)
        {
            score += 40*level;
        }
        if (rowsCleared == 2)
        {
            score += 100*level;
        }
        if (rowsCleared == 3)
        {
            score += 300*level;
        }
        if (rowsCleared == 4)
        {
            score += 1200*level;
        }
    }
    
    /**
     * Makes a new Tetris game and runs it till the game is over. The tetrad objects will fall 1 block per second,
     * and the game ends when tetrads reach the top of the screen.
     * 
     * @param args Information from the command line
     */
    public static void main (String[] args)
    {
        Tetris tetr = new Tetris();
        while (!gameState)
        {
            tetr.play();
            if (rowsCleared >= 4)
            {
                rowsCleared = 0;
                if (level < 4)
                    level ++;
            }
            tetr.display.setTitle("Tetris- " + "level: " + level + " score: " + score);
        }
    }
}
