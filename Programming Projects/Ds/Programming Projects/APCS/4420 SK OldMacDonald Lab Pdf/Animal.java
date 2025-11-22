/**
 * The Abstract class animal has getters and setters for its latin and 
 * common Names. It also contain the header for a speak method,
 * which will return a specific animal's voiceline, and a compare to 
 * method, which will compare two animals.
 *
 * @author Keshav Kotamraju
 * @version November 13, 2022
 */
public abstract class Animal implements Comparable
{
    private String commonName;
    private String latinName;
    /**
     * 
     */
    public Animal(String latinName, String commonName)
    {
        this.latinName = latinName;
        this.commonName = commonName;
    }
    
    /**
     * Gets the latin name.
     * 
     * @return  the latin name
     */
    public String getLatinName()
    {
        return latinName;
    }
    
    /**
     * Gets the common name.
     * 
     * @return  the common name
     */
     public String getCommonName()
    {
        return commonName;
    }
    
    /**
     * Sets the latin name to a new one.
     * 
     * @param newName   the new name
     */
    public void setLatinName(String newName)
    {
        latinName = newName;
    }
    
    /**
     * Sets the common name to a new one.
     * 
     * @param newName   the new name
     */
    public void setCommonName(String newName)
    {
        commonName = newName;
    }
    
    /**
     * Returns a string, for example, if animal were a dog,
     * it would return "woof"
     * 
     * @return  the animal's voiceline
     */
    public abstract String speak();
    
    /**
     * Compares two objects by First checking to see if object is an animal.
     * If the object is an animal, it uses the String class's compareTo method
     * to check if the common names are the same and returns the output;if they are
     * equal,return 0.
     * 
     * @param obj  the object to be compared to
     * @return  0 if equal, -999 if obj is not an Animal, -1 if they are not 
     * @throws IllegalArgumentException if obj is not an Animal
     */
    @Override
    public int compareTo(Object obj)
    {
        if(obj instanceof Animal)
        {
            Animal anim = (Animal) obj;
            return anim.compareTo(commonName);
        }
        else
            throw new IllegalArgumentException("Needs to be an Animal");
    }
}
