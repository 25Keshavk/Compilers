
import java.util.Iterator;
import java.util.ListIterator;
/**
 * The MyLinkedList provides the user with a Linked List
 * that makes use of the first as well as the last node in the list
 * to provide regular array methods, such as remove, with a 
 * lower time complexity. It also provides new methods, such as
 * the removeLast method.
 * 
 * @author Keshav Kotamraju
 * 
 * @version October 16, 2023
 */

public class MyLinkedList<E> implements MyList<E>
{

    private DoubleNode first;
    private DoubleNode last;
    private int size;

    /**
     * Instantiates a MyLinkedList object, setting its nodes
     * to null and its size to 0.
     */
    public MyLinkedList()
    {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Formats the LinkedList, and then returns it.
     * 
     * @return the formatted LinkedList
     */

    public String toString()
    {
        DoubleNode node = first;
        if (node == null)
            return "[]";
        String s = "[";
        while (node.getNext() != null)
        {
            s += node.getValue() + ", ";
            node = node.getNext();
        }
        return s + node.getValue() + "]";
    }

    /** 
     * Gets the node at the given index by starting from the first
     * node.
     * 
     * @precondition  0 <= index <= size / 2
     * @postcondition starting from first,  the node
     *               with given index (where index 0
     *               returns first) is returned
     * @param index the index of the node
     * @return the node at the given index
     */
    private DoubleNode getNodeFromFirst(int index)
    {
        DoubleNode node = this.first;
        for (int i = 0; i<index; i++)
        {
            node = node.getNext(); 
        }
        return node;
    }

    /** 
     * Gets the node at the given index by starting from the last
     * node.
     * 
     * @precondition  size / 2 <= index < size
     * @postcondition starting from last, returns the node
     *               with given index (where index size-1
     *               returns last)
     * @param index the index of the node
     * @return the node at the given index
     */
    private DoubleNode getNodeFromLast(int index)
    {
        DoubleNode node = last;
        for (int i = size-1; i > index; i--)
        {
            node = node.getPrevious();
        }
        return node;
    }

    /** 
     * Gets the node at a given index
     * 
     * @precondition  0 <= index < size
     * @postcondition starting from first or last (whichever
     *               is closer), returns the node with given
     *               index
     * @param index the index of the wanted node
     * @return the node at the given index
     */
    private DoubleNode getNode(int index)
    {
        if (index <= size/2)
            return getNodeFromFirst(index);
        return getNodeFromLast(index);
    }

    /**
     * Finds the size of the LinkedList
     * 
     * @return the size of the LinkedList
     */
    public int size()
    {
        return size;
    }

    /**
     * Gets the value of a node at a given index
     * 
     * @param index the index of the node
     * 
     * @return the value of the node at the given index
     */
    public E get(int index)
    {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index is out of bounds");

        return (E)getNode(index).getValue();
    }

    /** 
     * Sets the value of a node at a given index to the new specified value.
     * 
     * @postcondition replaces the element at position index with obj
     *  returns the element formerly at the specified position
     * @param index the index of the node
     * @param obj the new value of the node
     * @return the previous value of the node
     */
    public E set(int index, E obj)
    {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        DoubleNode prev = getNode(index);
        E value = (E)prev.getValue();
        prev.setValue(obj);
        return value;
    }

    /**
     * Adds a node containing a given object to the end of the list.
     * 
     * @param obj the object to be added
     * @postcondition appends obj to end of list; returns true
     * @return true
     */
    public boolean add(E obj)
    {
        addLast(obj);
        return true;
    }

    /** 
     * Removes the node at a given index.
     * 
     * @param index the index of the node
     * @postcondition removes element from position index, moving elements
     *               at position index + 1 and higher to the left
     *               (subtracts 1 from their indices) and adjusts size
     * @return the element of the node removed
     */
    public E remove(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        DoubleNode curr = getNode(index);
        if(index == size - 1)
        {
            return removeLast();
        }
        else if(index == 0)
        {
            return removeFirst();
        }
        DoubleNode next = curr.getNext();
        DoubleNode prev = curr.getPrevious();
        if (prev == null)
            first = next;
        else
            prev.setNext(next);
        curr.setPrevious(null);
        if (next == null)
            last = prev;
        else
            next.setPrevious(prev);
        size--;
        curr.setNext(null);
        return (E)curr.getValue();
    }

    /** 
     * Adds obj to the specified index
     * 
     * @param index the index of the node
     * @param obj the object to be added
     * @precondition  0 <= index <= size
     * @postcondition inserts obj at position index,
     *                moving elements at position index and higher
     *                to the right (adds 1 to their indices) and adjusts size
     */
    public void add(int index, E obj)
    {   
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        if (index == size)
        {
            addLast(obj);
        }
        else
        {
            DoubleNode curr = getNode(index);
            DoubleNode prev = curr.getPrevious();
            DoubleNode nextObj = new DoubleNode(obj);
            nextObj.setPrevious(prev);
            nextObj.setNext(curr);
            curr.setPrevious(nextObj);
            if (prev == null)
                first = nextObj;
            else
                prev.setNext(nextObj);
            size++;
        }    
    }

    /**
     * Adds a given object to the beginning of the list.
     * 
     * @param obj the object to be added
     */
    public void addFirst(E obj)
    {
        DoubleNode newObj = new DoubleNode(obj);
        DoubleNode prev = first;
        newObj.setNext(prev);
        if (first == null)
        {
            last = newObj;
        }
        else
        {
            prev.setPrevious(newObj);
        }
        first = newObj;
        size++;
    }

    /**
     * Adds a given object to the end of the list
     * 
     * @param obj the object to be added
     */
    public void addLast(E obj)
    {
        DoubleNode newObj = new DoubleNode(obj);
        DoubleNode prev = last;
        newObj.setPrevious(prev);
        if (prev == null)
        {
            first = newObj;
        }
        else
        {
            prev.setNext(newObj);
        }
        last = newObj;
        size++;
    }

    /**
     * Gets the first node of the list
     * 
     * @return the first node
     */
    public E getFirst()
    {
        return (E)first.getValue();
    }

    /**
     * Gets the last node of the list
     * 
     * @return the last node
     */
    public E getLast()
    {
        return (E)last.getValue();
    }

    /**
     * Removes the first node in the list
     * 
     * @return the node that was removed
     */
    public E removeFirst()
    {
        DoubleNode prevFir = first;
        DoubleNode next = first.getNext();
        first.setNext(null);
        first = next;
        if (next == null)
        {
            last = null;
        }
        else
        {
            next.setPrevious(null);
        }
        size--;
        return (E)prevFir;
    }

    /**
     * Removes the last node in the list
     * 
     * @return the node that was previously there
     */
    public E removeLast()
    {
        DoubleNode prevLast = last;
        DoubleNode prev = last.getPrevious();
        last.setPrevious(null);
        last = prev;
        if (prev == null)
        {
            first = null;
        }
        else
        {
            prev.setNext(null);
        }
        size--;
        return (E)prevLast;
    }

    /**
     * Creates a new iterator of the list
     * 
     * @return the new iterator
     */
    public MyIterator<E> iterator()
    {
        return new MyLinkedListIterator();
    }
    /**
     * Creates a new Listiterator of the list
     * 
     * @return the new iterator
     */
    public MyListIterator<E> listIterator()
    {
        return new MyLinkedList_ListIterator();
    }

    /**
     * Iterator for the MyLinkedList class
     */
    private class MyLinkedListIterator implements MyIterator<E>
    {   
        private DoubleNode nextNode;
        private int lastIndex;
        /**
         * Constructor for the iterator of the MyLinkedList class.
         */
        public MyLinkedListIterator()
        {
            nextNode = first;
            lastIndex = 0;
        }

        /**
         * Determins whether there is another node.
         * 
         * @return true if there is another node; otherwise, false
         */
        public boolean hasNext()
        {
            return lastIndex < size;
        }

        /**
         * Updates the next node, and returns that node.
         * 
         * @return the next node in the iteration
         */
        public E next()
        {
            DoubleNode temp = nextNode;
            nextNode = nextNode.getNext();
            lastIndex++;
            return (E)temp.getValue();
        }

        /**
         * Removes the last element that was returned by next.
         * 
         * @postcondition removes the last element that was returned by next
         */
        public void remove()
        {
            lastIndex--;
            MyLinkedList.this.remove(lastIndex);
        }
    }
    /**
     * A helper iterator class for the MyLinkedList class.
     */
    public class MyLinkedList_ListIterator extends MyLinkedListIterator 
        implements MyListIterator<E>
    {
        /**
         * Has no functional use
         */
        public MyLinkedList_ListIterator()
        {
            super();
        }

        /**
         * Has no functional use
         * 
         * @param obj the object
         */
        public void set(E obj)
        {
            MyLinkedList.this.set(super.lastIndex - 1, obj);
        }

        /**
         * Has no functional use
         * 
         * @param obj the object
         */
        public void add(E obj)
        {
            MyLinkedList.this.add(super.lastIndex, obj);
            super.lastIndex++;
        }

    }
}
