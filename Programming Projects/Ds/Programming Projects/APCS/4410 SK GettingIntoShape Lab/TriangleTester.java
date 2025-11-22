import java.util.ArrayList;
/**
 *Tests the Triangle class portion of the GettingIntoShape project. 
 *
 * @author Keshav Kotamraju
 * @version November 2, 2022
 */
public class TriangleTester
{
    /**
     * Tests the GeometricShapes' triangles class.
     * 
     * @param args information past via the command line
     */
    public static void main (String [ ] args) 
    {
        /* Check constructors. */
        ArrayList<GeometricShape> triangles = new ArrayList<GeometricShape>(); 
        triangles.add(new Triangle("a",8,7,9));
        
        /* Check for a bad parameter. */
        try
        {
            System.out.println("\n\nTry creating a negative radius triangles." );

            GeometricShape negative = new Triangle("negative", -1,-2,-3);
        }        
        catch (IllegalArgumentException e)
        {
            System.out.println( "\tCorrectly rejects negative side: \n\t"+ e );
        }
        
        /* Check toString. */
        System.out.println ("\ntoString:\n");
        for (GeometricShape c : triangles)
        {
            System.out.println (c);
        }
        
        /* Check equals. */
        System.out.println ("\nequals: ");
        for (int j=0; j < triangles.size(); j++)
        {
            GeometricShape c = triangles.get(j);
            for (int i=j; i < triangles.size(); i++)
            {
                GeometricShape other = triangles.get(i);
                System.out.println ("\t"+ c.getLabel() +" equals " 
                                    + other.getLabel() + "? " 
                                    + c.equals (other)  );
            }
            System.out.println ("");
        }

        /* Check compareTo. */
        System.out.println ("\ncompareTo: ");
        for (int j=0; j < triangles.size(); j++)
        {
            GeometricShape c = triangles.get(j);
            for (int i=j; i < triangles.size(); i++)
            {
                GeometricShape other = triangles.get(i);
                System.out.println ("\t"+ c.getLabel() +" compareTo " 
                                    + other.getLabel() + ": " 
                                    + c.compareTo (other)  );
            }
            System.out.println ("");
        }

        /* Check compareAnotherWay. */
        System.out.println ("\ncompareAnotherWay: ");
        for (GeometricShape c : triangles)
        {
            for (GeometricShape other : triangles)
            {
                System.out.println ("\t"+ c.getLabel() +" compareAnotherWay "
                                    + other.getLabel()+ ": " 
                                    + c.compareAnotherWay(other));
            }
            System.out.println ("");
        }

    }
}
