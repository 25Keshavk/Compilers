
/**
 * Gets lighter over time, and eventually fully decomposes.
 *
 * @author Keshav Kotamraju
 * @version 10/9/2022
 */
import java.awt.Color;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
public class Sandstone extends Rock
{
    // instance variables - replace the example below with your own
    private int lighteningFactor;
    private static final int COLOR_MAX = 255;
    private static final int DEFAULT_LIGHTENING_FACTOR = 10;
    

    /**
     * Constructs a black sandstone with default lightening factor.
     */
    public Sandstone()
    {
        this(Color.BLACK, DEFAULT_LIGHTENING_FACTOR);
    }
    /**
     * Constructs a sandstone with chosen color and lightening factor
     * 
     * @param color    the initial color of the sandstone
     * @param decompose    the rate at which the rock will lighten (rgb)
     */
    public Sandstone(Color color, int decompose)
    {
        super(color);
        lighteningFactor = decompose;
    }
    /**
     * Constructs a black sandstone with chosen lightening factor
     * 
     * @param decompose    the rate at which the rock will lighten (rgb)
     */
    public Sandstone(int decompose)
    {
        this(Color.BLACK, decompose);
    }
    /**
     * Constructs a sandstone with chosen color and default lightening factor.
     * 
     * @param color    the initial color of the sandstone
     */
    public Sandstone(Color color)
    {
        this(color, DEFAULT_LIGHTENING_FACTOR);
    }

    /**
     * Lightens the sandstone's color by the lightening factor.
     *
     */
    public void lighten()
    {
        Color myColor = getColor();
        
        int red = myColor.getRed() + lighteningFactor;
        int green = myColor.getGreen() + lighteningFactor;
        int blue = myColor.getBlue() + lighteningFactor;
        
        red = Math.min(red, COLOR_MAX);
        blue = Math.min(blue, COLOR_MAX);
        green = Math.min(green, COLOR_MAX);
        
        Color lighterColor = new Color(red, green, blue);
        setColor(lighterColor);
    }
    /**
     * Returns information about the sandstone and the decompose rate.
     */
    @Override
    public String toString()
    {
        return super.toString() + " \ndecomposing factor: " + lighteningFactor;
    }
    /**
     * Gets lighter over time, and once it reaches a fully white color, removes self from grid.
     */
    @Override
    public void act()
    {
        this.lighten();
        if (getColor().equals(Color.WHITE))
            removeSelfFromGrid();
    }
    /**
     * Returns the lightening factor.
     */
    public int getLighteningFactor()
    {
      return lighteningFactor;  
    }
    /**
     * Changes the lightening factor.
     * 
     * @param lighteningFactor the value to change the lightening factor to
     */
    public void setLighteningFactor(int lighteningFactor)
    {
        this.lighteningFactor = lighteningFactor;
    }
}
