
/**
 * The Rooster class extends Chicken. It has a common name and a latin name which
 * can both be changed. Additionally, it can speak and compare itself to other 
 * animals.
 *
 * @author Keshav Kotamraju
 * @version November 13, 2022
 */
public class Rooster extends Chicken
{
    /**
     * Constructs an object of the class Rooster with the given name rooster and
     * the latin name of a Chicken.
     */
    public Rooster()
    {
        super("rooster");
    }
    
    /**
     * The rooster says its given voice line, which is "cock-a-doodle-do".
     * 
     * @return  the voiceline
     */
    public String speak()
    {
        return "cock-a-doodle-do";
    }
}
