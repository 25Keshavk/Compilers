/**
 * Isosceles Right Triangle is a triangle with 2 equal legs.
 * It extends Triangle.
 *
 * @author Keshav Kotamraju
 * @version November 2, 2022
 */
public class IsoscelesRightTriangle extends Triangle
{
    /**
     * Constructs an Isosceles Right Triangle with 2 equal legs and
     * a side root(2) times longer
     * 
     * @param label     The name of the triangle
     * @param leg       the length of one of the legs
     */
    public IsoscelesRightTriangle(String label,double leg)
    {
        super(label,leg*Math.sqrt(2),leg,leg);
    }
    /**
     * Changes side A of the triangle to user's input
     * 
     * @param  anotherA    the new value for side A
     * @postcondition   sideA >= sideB = sideC
     */
    @Override
    public void setSideA(double anotherA)
    {
        orderSides(anotherA,anotherA/Math.sqrt(2),anotherA/Math.sqrt(2));
        //need to order both legs to be equal
    }
    /**
     * Changes side B of the triangle to user's input
     * Also changes side C to be equal to B
     * 
     * @param  anotherB    the new value for side B
     * @postcondition   sideA >= sideB = sideC
     */
    @Override
    public void setSideB(double anotherB)
    {
        orderSides(anotherB * Math.sqrt(2), anotherB, anotherB);
        //need to order both legs to be equal
    }
    /**
     * Changes side C of the triangle to user's input
     * Also changes side B to be equal to C
     * 
     * @param  anotherC    the new value for side C
     * @postcondition   sideA >= sideB = sideC
     */
    @Override
    public void setSideC(double anotherC)
    {
        setSideB(anotherC);
    }
}
