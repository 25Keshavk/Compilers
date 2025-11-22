/**
 * The Pig class extends animal. It has a common name and a latin name which
 * can both be changed. Additionally, it can speak and compare itself to other 
 * animals.
 *
 * @author Keshav Kotamraju
 * @version November 13, 2022
 */
public class Pig extends Animal
{
    /**
     * Constructs an object of the class Pig with the common name pig and
     * the latin name of a Pig.
     * 
     * @param chickenType     the common name of the Chicken
     */
    public Pig()
    {
       super("Gallus Gallus Domesticus", "pig"); 
    }
    
    /**
     * The chicken says its given voice line, which is "oink".
     * 
     * @return  the voiceline
     */
    public String speak()
    {
        return "oink";
    }
}
