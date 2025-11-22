
/**
 * The Equilateral Triangle class extends Triangle, and an object
 * of this class has all equal sides.
 *
 * @author Keshav Kotamraju
 * @version November 2, 2022
 */
public class EquilateralTriangle extends Triangle
{
    /**
     * Constructs an Equilateral triangle, a triangle with all equal sides
     * 
     * @param label     The name of the triangle
     * @param side      The length of a side
     */
    public EquilateralTriangle(String label,double side)
    {
        super(label,side,side,side);
    }
    /**
     * Changes the length of the sides of the equilateral triangle
     *
     * @param  anotherA  the new length of each side of the triangle
     */
    @Override
    public void setSideA(double anotherA)
    {
        orderSides(anotherA,anotherA,anotherA);
    }
    /**
     * Changes the length of the sides of the equilateral triangle
     *
     * @param  anotherB  the new length of each side of the triangle
     */
    @Override
    public void setSideB(double anotherB)
    {
        setSideA(anotherB);
    }
    /**
     * Changes the length of the sides of the equilateral triangle
     *
     * @param  anotherC  the new length of each side of the triangle
     */
    @Override
    public void setSideC(double anotherC)
    {
        setSideB(anotherC);
    }
}
