/**
 * The Chicken class extends animal. It has a common name and a latin name which
 * can both be changed. Additionally, it can speak and compare itself to other 
 * animals.
 *
 * @author Keshav Kotamraju
 * @version November 13, 2022
 */
public class Chicken extends Animal
{
    /**
     * Constructs an object of the class Chicken with the given name chicken and
     * the latin name of a Chicken.
     */
    public Chicken()
    {
        this("chicken");
    }
    
    /**
     * Constructs an object of the class Chicken with a chosen common name and
     * the latin name of a Chicken.
     * 
     * @param chickenType     the common name of the Chicken
     */
    public Chicken(String chickenType)
    {
       super("Gallus Gallus Domesticus", chickenType); 
    }
    
    /**
     * The chicken says its given voice line, which is "bawk".
     * 
     * @return  the voiceline
     */
    public String speak()
    {
        return "bawk";
    }
}
