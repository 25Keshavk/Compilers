
/**
 * Compares two objects in a different way than comparable. 
 * Specifically, returns 0 when two objects are 0, and 
 * returns a value greater or less 
 * than zero depending on the difference between two objects.
 *
 * @author Keshav Kotamraju
 * @version October 31, 2022
 */
public interface AnotherComparable
{
    /**
     * Compares two objects in a different way than compareTo does.
     *
     * @param  obj      the other object
     * 
     * @return   0 if two objects are sufficiently equal,
     *         > 0 if "this" object is determined to be greater than obj, or
     *         < 0 if "this" object is determined to be less than obj
     */
    public abstract int compareAnotherWay(Object obj);
}
