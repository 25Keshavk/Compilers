
/*
 * Some things to consider for this lab:
 * 
 * Use the updated checkstyle.  
 * 
 * Java doesn't let us instantiate an array of type E so some casting will be needed
 * 
 * Some new tags and annotations you may like to use:
 * @param  <E> describes the specific type of data stored in the list.  
 * 
 * When casting carefully, you may not need Java's warning regarding unsafe or unchecked operations 
 * you may like to use the annotation @SuppressWarnings("unchecked")
 * Use this judiciously.  
 * 
 * In Javadocs use the tags either {@code text} or {@literal}.
 * to avoid html interpretations for example {@code 0 <= index <= size}
 * or use {@literal 0 <= index <= size}
 */
import java.util.Iterator;
import java.util.ListIterator;
import java.util.*;

/**
 * MyArrayList is an array that can be freely manipulated by allowing the user to add and remove 
 * elements at any given index. It also has a mutable size which allows for as many elements as needed.
 * 
 * @author Marina Peregrino
 * @author Keshav Kotamraju
 * @version December 19, 2019
 * @version2 October 6, 2023
 */
public class MyArrayList<E> implements MyList<E>, Iterable<E>
{
    private int size;
    private Object[] array;
    /**
     * Constructs a MyArrayList object which has an array with the size of 1. The size is asisigned to 0
     * because there are no elements in the array.
     */
    public MyArrayList()
    {
        size = 0;
        array = new Object[1];
    }

    /**
     * Gets the size of the ArrayList
     * 
     * @return the size of the ArrayList
     */
    public int size()
    {
        return size;
    }

    /**
     * Appends a given object to the end of the ArrayList. If the ArrayList is full, doubles the size
     * and then adds the object.
     * 
     * @param obj the object being added
     * @return true 
     */
    public boolean add(E obj)
    {
        if (size == array.length)
            doubleCapacity();
        array[size] = obj;
        size++;
        return true;
    }

    /**
     * Adds a given object to a given index, shifting all upcoming elements to the right.
     * 
     * @param index the index to add the object at
     * @param obj the object being added
     * @precondition 0 <= index <= size
     */
    public void add(int index, E obj)
    {
        if (index == size)
        {
            add(obj);
            return;
        }
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index Not In Bounds");
        if (array[index] == null)
            array[index] = (Object)obj;
        else 
        {     
            int len = array.length;
            if (size == array.length)
                len *= 2;
            Object[] array2 = new Object[len];
            for(int i = 0; i < index; i++)
            {
                array2[i] = array[i];
            }
            array2[index] = (Object)obj;
            for(int j = index ; j < size; j++)
            {
                array2[j+1] = array[j];
            }
            array = array2;
        }
        size++;
    }

    /**
     * Doubles the capacity of the ArrayList 
     * by creating a new array and copying the values.
     * 
     * @postcondition the new array has the same elements with two times the capacity
     */
    private void doubleCapacity()
    {
        Object[] array2 = new Object[array.length*2];
        for (int i = 0; i < size; i++)
            array2[i] = array[i];
        array = array2;
    }

    /**
     * Gets a value at a given index. Throws an error if ArrayList has no objects.
     * @param index  The index of the object wanted
     * @return the object at the given index
     * @precondition 0 <= index < size
     */
    public E get(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(
                "Your index should be between 0 and " + (size-1) );
        if (size==0)
            throw new IndexOutOfBoundsException("Index: 0, Size: 0");
        return (E)array[index];

    }

    /**
     * Gets the maximum capacity of the array. This is only
     * the same value as size when the array is full.
     * @return the length of the array
     */
    public int getCapacity()
    {
        return array.length;
    }

    /**
     * Removes the object at the given index, shifts all the remaining elements down by 1 index,
     * and returns the removed object.
     * 
     * @param  index the location of the object to be removed.
     * @return the object that was removed from the list
     */
    public E remove(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(
                "Your index should be between 0 and " + (size-1) );
        Object removed = array[index];
        size--;
        for (int i = index; i < size; i++)
            array[i] = array[i+1];
        array[size]=null;
        return (E) removed;
    }

    /**
     * Replaces the object at a given index with a new given object.
     * @param the location at which to place the new object
     * @param obj the new object replacing the old one at the index
     * @return  the previous object that was replaced
     */
    public E set(int index, E obj)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(
                "Your index should be between 0 and " + (size-1) );
        Object oldObj = array[index];
        array[index] = obj;
        return (E) oldObj;
    }

    /**
     * Constructs an iterator of this ArrayList.
     * @return an iterator of this ArrayList
     */
    public MyIterator<E> iterator()
    {
        return new MyArrayListIterator();
    }

    /**
     * Constructs a ListIterator of this ArrayList.
     * @return null
     */
    public MyListIterator<E> listIterator()
    {
        return new MyArrayListIterator();
    }

    public String toString()
    {
        if (size == 0)
            return "[]";

        String s = "[";
        for (int i = 0; i < size - 1; i++)
            s += array[i] + ", ";
        return s + array[size - 1] + "]";

    }
    /**
     *  MyArrayListIterator is an iterator for the MyArrayList class, which uses methods
     *  modeled by the MyIterator interface. MyArrayListIterator objects can 
     *  check for a next element, remove the element most recently returned by the
     *  next() method, and return the next element in the list. However, it cannot
     *  go backwards or add to the list.
     * 
     * @author Keshav Kotamraju
     * @version October 9, 2023
     */
    private class MyArrayListIterator implements MyIterator<E>, MyListIterator<E>
    {
        // the index of the value that will be returned by next() 
        private int nextIndex;
        // index of the last returned object
        private int lastReturned;
        /**
         * Constructs a MyArrayListIterator object, instantiating nextIndex to 0 
         * and lastReturned to -1.
         */
        public MyArrayListIterator()
        {
            nextIndex = 0;
            lastReturned = -1;
        }

        public void add(E obj)
        {
            MyArrayList.this.add(nextIndex, obj);
            nextIndex++;
        }

        public void set(E obj)
        {
            MyArrayList.this.set(nextIndex-1, obj);
        }

        /**
         * Determines if there is a next element in the ArrayList
         * @return true if there is a next element; otherwise
         *         false
         */
        public boolean hasNext()
        {
            return nextIndex != size;
        }

        /**
         * Returns the next element in the list, and increments nextIndex by 1
         * throws a NoSuchElementException if there is no next element
         * 
         * @return next element in the list
         */
        public E next()
        {    
            if (nextIndex == size)
                throw new NoSuchElementException();
            return (E) get(nextIndex++);
        }
        // public E next()
        // {    
        // lastReturned = nextIndex;
        // nextIndex++;
        // if (lastReturned==size)
        // throw new NoSuchElementException();
        // return (E) get(lastReturned);
        // }
        /**
         * Removes the last element returned by next() from the arraylist. 
         * This method cannot be called twice in a row, next() must be called in between.
         */
        public void remove()
        {        
            MyArrayList.this.remove(--nextIndex);
        }
    }

}
