
/**
 * A word and its frequency in a book.
 * 
 * Note to students:  you need to add code as well methods to the
 *                    class to complete the project.
 * @author Keshav Kotamraju
 * @author  Susan King
 * @version March 4, 2016
 * @version February 27, 2023
 */
public class Word implements Comparable
{
    // instance variables 
    private String word;  
    private int frequency;  // how often word appears in a text file

    /**
     * Constructor for objects of class Word.
     * 
     * @param text the string of characters of the word
     */
    public Word(String text)
    {
        // initialise frequency to 1 because the text has
        // appeared the first time in the file
        frequency = 1;
        word = text;
    }

    /**
     * The "word" has already appeared in the file, so 1 is 
     * added to frequence since it as appeared again.
     */
    public void addOne( )
    {
        frequency++;
    }
    /**
     * Retrieve the text string word.
     * 
     * @return the text of the current Word object
     */
    public int getFrequency( )
    {
        return frequency;
    }

    
    /**
     * Retrieve the text string word.
     * 
     * @return the text of the current Word object
     */
    public String getWord( )
    {
        return word;
    }
    
    /**
     * Compare lexicalgraphically this current Word object and 
     * the Word obj.  
     * 
     * @param obj  the object to compare the current Word object to
     * 
     * @return   0 if this current Word object's word has equal to obj's word;
     *         < 0 if this current Word object's word comes earlier
     *             in the alphabet than obj's word;
     *         > 0 if this current Word object's word comes later 
     *             in the alphabet that obj's word
     * @throw Illegal Argument Exception    the parameter does not belong to the Word class
     */
    public int compareTo(Object obj)
    {
        if (obj instanceof Word)
        {
            Word w = (Word)obj;
            return word.compareTo(w.getWord());
        }
        else
        {
            throw new IllegalArgumentException("Need a Word Object");
        }
    }
    
    /**
     * Compare the frequencies of this current Word object and 
     * the Word obj.  
     * 
     * @param obj  the object to compare the current Word object to
     * 
     * @return   0 if this current Word object's frequency is equal to obj's frequency;
     *         < 0 if this current Word object's frequency is greater than obj's frequency;
     *         > 0 if this current Word object's frequency is greater than obj's frequency;
     * @throw Illegal Argument Exception    the parameter does not belong to the Word class
     */
    public int compareFrequencies(Object obj)
    {
        if (obj instanceof Word)
        {
            Word w = (Word)obj;
            return this.getFrequency() - w.getFrequency();
        }
        else
        {
            throw new IllegalArgumentException("Need a Word Object");
        }
    }
    
    /**
     * Return the text of the word and its frequency as a String.
     * 
     * @return text and frequency
     */
    public String toString( )
    {
        return String.format("%-15s %6d", word, frequency);
    }
    
}
