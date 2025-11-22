/**
 * The Chick class extends Chicken. It has a common name and a latin name which
 * can both be changed. Additionally, it can speak and compare itself to other 
 * animals.
 *
 * @author Keshav Kotamraju
 * @version November 13, 2022
 */
public class Chick extends Chicken
{
    /**
     * Constructs an object of the class Chick with the given name chick and
     * the latin name of a Chicken.
     */
    public Chick()
    {
        super("chick");
    }
    
    /**
     * The rooster says its given voice line, which is "peep".
     * 
     * @return  the voiceline
     */
    public String speak()
    {
        return "peep";
    }
}
