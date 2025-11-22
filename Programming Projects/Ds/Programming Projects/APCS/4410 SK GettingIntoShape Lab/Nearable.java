
/**
 * This interface has two purposes that may be used to compare two objects that 
 * might be considered close enough to each other to be considered equal.
 * 
 * One method isNearlyEqual determines if two objects' quantifiable properties are
 * close enough to each other to be considered equal. This method echoes similarity 
 * to Object's equal with the addition concept of two objects being "close enough"
 * or within an epsilon tolerance of each other to be "equal."
 * 
 * The other method compareNearlyTo is similar to the Comparable method compareTo 
 * with the additional considereation that two objects can be "close enough" to
 * be considered equal. Just as with compareTo, this method can be used to 
 * impose an order to objects of each class that impements this interface.
 *
 * @author Keshav Kotamraju
 * @version (Obtober 26, 2022
 */
public interface Nearable
{
    /**
     * Determines if two objects' quantities are within an
     * epsilon difference of each other
     *
     * @param  obj1    an object to be tested as close to another object
     * @param  obj2    an object to be tested as close to another object
     * 
     * @return  true   if the quantities are close to each other; otherwise,
     *          false
     */
    boolean isNearlyEqual(Object obj1, Object obj2);
    /**
     * Compares two objects' quantities.
     * 
     * @param obj1      an object to be tested as close to another object
     * @param obj2      an object to be tested as close to another object
     * 
     * @return   0 if the two objects are basically the same within an EpSILON tolerance
     *          >0 if obj 1 > than obj 2
     *          <0 if obj 1 < than obj 2
     *          
     *          
     */
    int compareToNearly(Object obj1, Object obj2);
}

