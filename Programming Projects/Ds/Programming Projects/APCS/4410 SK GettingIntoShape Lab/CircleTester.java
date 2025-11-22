import java.util.ArrayList;

/**
 * Tests the Circle class portion of the GettingIntoShape project.
 * 
 * @author Susan King
 * @author Marina Peregrino
 * @version December 5, 2019
 */
public class CircleTester
{
    /**
     * Tests the GeometricShapes' Circle class.
     * 
     * @param args information past via the command line
     */
    public static void main (String [ ] args) 
    {
        double fourPlus = 4 + Math.pow(10, -5); //close enough to 4 
        double fourTooBig  = 4 + Math.pow(10, -2); // not "close enough" to 4

        /* Check constructors. */
        ArrayList<GeometricShape> circles = new ArrayList<GeometricShape>(); 
        circles.add(new Circle ("A"));
        circles.add(new Circle ("Bee", 1));  //the same as a
        circles.add(new Circle ("four", 4)); //bigger than a
        circles.add(new Circle ("four-ish", fourPlus));  //about the same as four 
        circles.add(new Circle ("four-too-big", fourTooBig)); //too big to be the same as four
        
        /* Check for a bad parameter. */
        try
        {
            System.out.println("\n\nTry creating a negative radius circle." );

            GeometricShape negative = new Circle ("negative", -1);
        }        
        catch (IllegalArgumentException e)
        {
            System.out.println( "\tCorrectly rejects a negative radius: \n\t"+ e );
        }
        
        /* Check toString. */
        System.out.println ("\ntoString:\n");
        for (GeometricShape c : circles)
        {
            System.out.println (c);
        }
        
        /* Check equals. */
        System.out.println ("\nequals: ");
        for (int j=0; j < circles.size(); j++)
        {
            GeometricShape c = circles.get(j);
            for (int i=j; i < circles.size(); i++)
            {
                GeometricShape other = circles.get(i);
                System.out.println ("\t"+ c.getLabel() +" equals " 
                                    + other.getLabel() + "? " 
                                    + c.equals (other)  );
            }
            System.out.println ("");
        }

        /* Check compareTo. */
        System.out.println ("\ncompareTo: ");
        for (int j=0; j < circles.size(); j++)
        {
            GeometricShape c = circles.get(j);
            for (int i=j; i < circles.size(); i++)
            {
                GeometricShape other = circles.get(i);
                System.out.println ("\t"+ c.getLabel() +" compareTo " 
                                    + other.getLabel() + ": " 
                                    + c.compareTo (other)  );
            }
            System.out.println ("");
        }

        /* Check compareAnotherWay. */
        System.out.println ("\ncompareAnotherWay: ");
        for (GeometricShape c : circles)
        {
            for (GeometricShape other : circles)
            {
                System.out.println ("\t"+ c.getLabel() +" compareAnotherWay "
                                    + other.getLabel()+ ": " 
                                    + c.compareAnotherWay(other));
            }
            System.out.println ("");
        }

    }
}
