import java.util.*;
/**
 * OldMacDonalds Farm has an array list of the farm animals and the farmers name. 
 * It can sing a verse of the farm animals and make a full song using them.
 *
 * @author Keshav Kotamraju
 * @version November 13, 2022
 */
public class OldMacDonaldsFarm
{
    String farmerName;
    ArrayList farmAnimals;
    /**
     * Constructor for objects of class OldMacDonaldsFarm
     */
    public OldMacDonaldsFarm()
    {
        farmerName = "OldMacDonald";
        farmAnimals = new ArrayList<Animal>();
    }
    
    /**
     * Sings a full verse about the farm animals using the 
     * farmAnimals array and the farmerName
     */
    public void singVerse()
    {
        String phrase1 = this.farmerName + "had a farm, ";
        String ei = "E-I-E-I-O";
        for(int i = farmAnimals.size()-1; i >-1; i--)
        {
            Animal anim = (Animal) farmAnimals.get(i);
            String doubleSpeak = anim.speak() + "-" + anim.speak();
            if(i == farmAnimals.size()-1)
            {
                System.out.print(phrase1 + ei + ", and on his farm he had some " + 
                anim.getCommonName() + "s, " + ei + ".\n");
            }
            System.out.print(
            "With a " + doubleSpeak + " here, and a " + doubleSpeak + 
            " there,\nHere a " + anim.speak() + ", there a " + anim.speak() + 
            ", everywhere a " + doubleSpeak + "," + "\n");
            if(i == 0)
            {
                System.out.print(phrase1 + ei + ".\n\n\n");
            }
        }
    }
    
    /**
     * Adds animals to the array and sings a verse each time an animal 
     * is added to create a full song.
     *
     * @param  String [] args   info from the command line
     */
    public static void main(String [] args)
    {
        OldMacDonaldsFarm singer = new OldMacDonaldsFarm( ); 
        singer.farmAnimals.add(new Chicken( ));
        singer.singVerse( );
        singer.farmAnimals.add(new Chick());
        singer.singVerse( ); 
        singer.farmAnimals.add(new Rooster( )); 
        singer.singVerse( ); 
        singer.farmAnimals.add(new Pig( )); 
        singer.singVerse( );
    }
}
