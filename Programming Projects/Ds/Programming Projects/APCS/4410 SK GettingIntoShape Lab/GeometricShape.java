
/**
 * Abstract class GeometricShape focuses on the shape's
 * name, perimeter, and area. Comparable methods allow
 * shapes to be compared.
 *
 * @author Keshav Kotamraju
 * @version October 26, 2022
 */
public abstract class GeometricShape implements Comparable,
                                                AnotherComparable,
                                                Nearable
{
    /**
     * The acceptable epsilon (aka delta) constant
     */
    public final static double EPSILON = 1.0e-5;
    private String label;
    /**
     * Initializes the instance variable label for a Geometric Shape.
     * 
     * @param label     the name given to a particular geometric shape
     */
    public GeometricShape(String label)
    {
        super();
        this.label = label;
    }
    /**
     * Gets the name of the Shape
     */
    public String getLabel()
    {
        return label;
    }
    /**
     * Sets the name of the Shape
     */
    public void setLabel(String label)
    {
        this.label = label;
    }
    /**
     * Computes the area of a geometric shape.
     * 
     * @return      the area of the geometric object
     */
    public abstract double calculateArea( );
    /**
     * Computes the perimeter of a geometric shape
     * 
     * @return      the perimeter of the geometric object
     */
    public abstract double calculatePerimeter( );
    /** Compares current geometric shape with the Object obj.
     * The comparison depends upon the geometric shape.
     * For example, circles are compared by their radii
     * 
     * @param obj       GeometricShape object with which to compare
     * @return   0      if the two geometric sha0pes are basically the 
     *                  same within an EPSILON tolerance
     *         > 0      if "this" object > than obj's object
     *         < 0      if "this" object < than obj's object
     */
    @Override
    public abstract int compareTo(Object obj);
    /**
     * Compares two geometric shapes based upon the areas 
     * of the geometric shapes.
     * 
     * @param obj   the geometric shape being compared
     * 
     * @return   0 if the two shapes have the same area within an EPSILON tolerance,
     *         > 0      if "this" object > than obj's object
     *         < 0      if "this" object < than obj's object
     *
     *@throws IllegalArgumentException if obj is not a GeometricShape object
     */
    @Override
    public int compareAnotherWay(Object obj)
    {
        if (obj instanceof GeometricShape)
        {
            double thisArea = this.calculateArea();
            double objArea = ((GeometricShape)obj).calculateArea();
            return compareToNearly(thisArea, objArea);
        }
        else
            throw new IllegalArgumentException("Needs to be a GeometricShape");
    }
    /**
     * Determines if two objects' quantities are within an epsilon difference
     *
     * @param  x    Double object to be tested as close to another Double object
     * @param  y    Double object to be tested as close to another Double object
     * 
     * @return  true   if the quantities are close to each other; otherwise,
     *          false
     *          
     * @throws IllegalArgumentException if x or y is not Double object
     */
    @Override
    public boolean isNearlyEqual(Object x, Object y)
    {
        if (x instanceof Double && y instanceof Double)
        {
            double xD = (Double)x;
            double yD = (Double)y;
            double absDiff = Math.abs(xD - yD);
            return absDiff <= EPSILON * Math.max(Math.abs(xD), Math.abs(yD));
        }
        else
            throw new IllegalArgumentException("Needs to be a Double");
    }
    /**
     * Compares two numbers with the consideration of an epsilon difference.
     * 
     * @param  x    Double object to be tested as close to another Double object
     * @param  y    Double object to be tested as close to another Double object
     * 
     * @return   0 if the two shapes have the same area within an EPSILON tolerance,
     *         > 0      if "this" object > than obj's object
     *         < 0      if "this" object < than obj's object
     *  
     * @throws IllegalArgumentException if x or y is not a Double object
     */
    @Override
    public int compareToNearly(Object x, Object y)
    {
        if (x instanceof Double && y instanceof Double)
        {
            double xD = (Double)x;
            double yD = (Double)y;
            double diff = xD - yD;
            double absDiff = Math.abs(diff);
            double acceptableEpsilon = EPSILON * Math.max(Math.abs(xD),Math.abs(yD));
            
            if (absDiff <= acceptableEpsilon)
                return 0;
            else if (-1.0 < diff && diff < 0.0)
                return -1;
            else if (0.0 < diff && diff < 1.0)
                return 1;
            else
                return (int)diff;
        }
        else
            throw new IllegalArgumentException("Needs to be a Double");
    }
    /** 
     *Determines if a geometric shape is a polygon.
     *
     *@return true if the geometric shape is a polygon; otherwise,
     *        false
     */
    public abstract boolean isPolygon();
    /** Formats the geometric object's class name, the object's 
     * label, its area, and its perimeter.
     * 
     * @return a formatted line about the geometric object
     */ 
    @Override
    public String toString()
    {
        String className = this.getClass().getName();
        if (className.equals("IsoscelesRightTriangle"))
            className = "IsoRtTri";
        else if (className.equals("EquilateralTriangle"))
            className = "EquilTri";
        return String.format("%s\t %s\n\t\t\tarea = %8.5f\tperimeter = %8.5f ",
                            className,
                            getLabel( ),
                            calculateArea( ),
                            calculatePerimeter());
    }
}
