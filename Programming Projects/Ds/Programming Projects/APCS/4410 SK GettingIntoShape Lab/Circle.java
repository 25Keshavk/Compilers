
/**
 * The circle class has a set radius and an object of this class can return its radius and change its radius. Circles can be compared by their 
 * radius. It is not a polygon, and extends Geometric Shape.
 *
 * @author Keshav Kotamraju
 * @version October 31, 2022
 */
public class Circle extends GeometricShape
{
    private double radius;
    /**
     * Constructor for objects of class Circle
     * 
     * @param label     The shape's name
     * @param r     The radius of the circle
     */
    public Circle(String label, double r)
    {
        super(label);
        setRadius(r);
    }
    /**
     * Constructor for objects of class Circle
     * 
     * @param label     The shape's name
     */
    public Circle(String label)
    {
        this(label,1.0);
    }
    /**
     * Changes the radius of the circle
     *
     * @param r     The new radius
     */
    public void setRadius(double r)
    {
        if (r<=0.0)
        {
            throw new IllegalArgumentException("Radius needs to be positive");
        }
        radius = r;
    }
    /**
     * Returns the radius of the circle
     * 
     * @return      The radius of the circle
     */
    public double getRadius()
    {
        return radius;
    }
    /**
     * Calculates the circumphrence of the circle.
     * 
     * @return      The circumphrence of the circle
     */
    @Override
    public double calculatePerimeter()
    {
        return 2.0 * Math.PI * radius;
    }
    /**
     * Calculates the area of the circle.
     * 
     * @return      The area of the circle
     */
    public double calculateArea()
    {
        return radius * radius * Math.PI;
    }
    /**
     * Compares two circles by their radii
     * 
     * @param obj       the object to compare to
     * 
     * @return  the difference in radii if obj is a circle;otherwise
     *          -999
     */
    @Override
    public int compareTo(Object obj)
    {
        if (obj instanceof Circle)
        {
            Circle circ = (Circle) obj;
            int compareRadii = compareToNearly(radius, circ.radius);
            return compareRadii;
        }
        else
            return -999;
    }
    /**
     * Checks if two circles are equal
     * 
     * @return true if equal;otherwise
     *         false
     */
    @Override
    public boolean equals(Object obj)
    {
        return this.compareTo(obj) == 0;
    }
    /**
     * Returns whether a circle is a polygon
     * 
     * @return  false in all cases
     */
    @Override
    public boolean isPolygon()
    {
        return false;
    }
    /**
     * Returns info about the circle.
     * 
     * @return      info about the circle
     */
    @Override
    public String toString()
    {
        return super.toString() +
               String.format("\n\t\t\tradius = %10.5f",this.getRadius());
    }
}
