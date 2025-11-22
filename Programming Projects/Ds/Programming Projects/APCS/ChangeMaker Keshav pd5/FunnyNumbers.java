
/**
 * Write a description of class FunnyNumbers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FunnyNumbers
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class FunnyNumbers
     */
    public FunnyNumbers()
    {
        // initialise instance variables
    }


    public static void main(String args[])
    {
        int count = 0;
        for (int x=0; x<1000000; x++)
        {
            double xIdentity = x *(2.0/3.0)/(2.0/3.0);
            System.out.println(xIdentity);
            if (x != xIdentity)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
