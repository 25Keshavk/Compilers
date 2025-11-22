
/**
 * The Triangle class has a set value for its 3 sides and an object of this
 * class can return the value of its sides. It extends polygon.
 *
 * @author Keshav Kotamraju
 * @version November 2, 2022
 */
public class Triangle extends Polygon
{
    private double sideA,sideB,sideC;
    /**
     * Takes in 3 side lengths and the name for the triangle and creates 
     * an object of the Triangle class.
     * 
     * @param name      The name of the Triangle
     * @param m     the first side
     * @param n     the second side
     * @param p     the third side
     */
    public Triangle(String name, double m, double n, double p)
    {
        super(name, 3);
        orderSides(m, n, p);
    }

    /**
     * Takes the three sides of the triangle and orders them so that
     * a is greatest, b is the median, and c is the smallest of the three.
     *
     * @param  a        Side a of the triangle
     * @param  b        Side b of the triangle
     * @param  c        Side c of the triangle
     * @postcondition   sideA >= sideB >= sideC
     */
    public void orderSides(double a, double b, double c)
    {
        sideA = Math.max(a, Math.max(b,c));
        sideC = Math.min(a, Math.min(b,c));
        sideB = a + b + c - sideA - sideC;
        
        if(sideA >= sideB + sideC || sideC<= 0)
            throw new IllegalArgumentException("Invalid side lengths");//Not a triangle
    }
    /**
     * Gets side A of the triangle
     * 
     * @return      side A of the triangle.
     */
    public double getSideA()
    {
        return sideA;
    }
    /**
     * Gets side B of the triangle
     * 
     * @return      side B of the triangle.
     */
    public double getSideB()
    {
        return sideB;
    }
    /**
     * Gets side C of the triangle
     * 
     * @return      side C of the triangle.
     */
    public double getSideC()
    {
        return sideC;
    }
    /**
     * Changes side A of the triangle to user's input
     * 
     * @param  anotherA    the new value for side A
     * @postcondition   sideA >= sideB >= sideC
     */
    public void setSideA(double anotherA)
    {
        orderSides(anotherA, sideB, sideC);
    }
    /**
     * Changes side B of the triangle to user's input
     * 
     * @param  anotherB    the new value for side B
     * @postcondition   sideA >= sideB >= sideC
     */
    public void setSideB(double anotherB)
    {
        orderSides(sideA, anotherB, sideC);
    }
   /**
     * Changes side C of the triangle to user's input
     * 
     * @param  anotherC    the new value for side C
     * @postcondition   sideA >= sideB >= sideC
     */
    public void setSideC(double anotherC)
    {
        orderSides(sideA, sideB, anotherC);
    }
    /**
     * Calculates the perimeter of the triangle
     * 
     * @return      the perimeter
     */
    @Override
    public double calculatePerimeter()
    {
        return sideA + sideB + sideC;
    }
    /**
     * Calculates the area of the triangle
     * 
     * @return      the area
     */
    @Override
    public double calculateArea()
    {
        double s = calculatePerimeter();//s is the name for the perimeter in the formula
        return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
    }
    /**
     * Checks if two triangles are equal
     * 
     * @param obj       The object being compared
     * @return true if equal;otherwise
     *         false
     */
    public boolean equals(Object obj)
    {
        return this.compareTo(obj) == 0;
    }
    /**
     * Compares two triangles by their side lengths
     * 
     * @param obj       the object to compare to
     * 
     * @return  the difference in sides if obj is a triangle;otherwise
     *          -999
     */
    @Override
    public int compareTo(Object obj)
    {
        if(obj instanceof Triangle)
        {
            Triangle tri = (Triangle) obj;
            if (this.equals(tri))
                return 0;
            int compareSideA = compareToNearly(sideA, tri.sideA);
            if (compareSideA != 0)
                return compareSideA;
            int compareSideB = compareToNearly(sideB, tri.sideB);
            if (compareSideB != 0)
                return compareSideB;
            int compareSideC = compareToNearly(sideC, tri.sideC);
            if (compareSideC != 0)
                return compareSideC;
        }
        return -999;
    }
    /**
     * Checks whether the triangle is regular
     * 
     * @return  true if triangle is regular;otherwise,
     *          false
     */
    @Override
    public boolean isRegular()
    {
        return (isNearlyEqual(sideA,sideB) && isNearlyEqual(sideB,sideC));
    }
    /**
     * Returns true as a triangle is a polygon
     * 
     * @return  true
     */
    @Override
    public boolean isPolygon()
    {
        return true;
    }
    /**
     * Returns info about the triangle. Specifically, its side lengths, 
     * the number of sides, and if its a regular polygon
     * 
     * @return      the information about the triangle
     */
    public String toString()
    {
        String str = "\n\t\t\ta = %8.5f\tb = %8.5f\tc = %8.5f" + 
                     "\n\t\t\tside count = %d\t\tregular : %b";
        return super.toString() +
        String.format (str,
                getSideA(),
                getSideB(),
                getSideC(),
                getNumSides(),
                isRegular());
    }
}
