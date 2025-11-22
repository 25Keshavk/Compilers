
/**
 * Polygon, an abstract class, gives the outline for the name of a shape. 
 * It also provides
 * the number of sides, the fact that it's a polygon, and its regularity.
 *
 * @author Keshav Kotamraju
 * @version    11/1/22
 */
public abstract class Polygon extends GeometricShape
{
    private int numSides;

    /**
     * Creates a polygon with given name and sides.
     * 
     * @param label     the name of polygon
     * @param numSides  the number of sides
     */
    public Polygon(String label, int numSides)
    {
        super(label);
        this.numSides = numSides;
    }

    /**
     * Returns true as object is a polygon
     *
     * @return   true 
     */
    public boolean isPolygon(int y)
    {
        return true;
    }
    /**
     * Returns whether polygon is regular.
     * 
     * @return true if polygon is regular;otherwise,
     *         false
     */
    public abstract boolean isRegular();
    /**
     * Returns the number of sides
     * 
     * @return      the sides
     */
    public int getNumSides()
    {
        return numSides;
    }
    /**
     * Changes the number of sides of the polygon
     * 
     * @param newSides      the new number of sides
     */
    public void setNumSides(int newNumSides)
    {
        numSides = newNumSides;
    }

}
