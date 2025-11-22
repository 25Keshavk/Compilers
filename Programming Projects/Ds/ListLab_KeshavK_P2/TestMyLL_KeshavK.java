
/**
 * Demonstrates execution of each and every method within MyLinkedList.  
 * 
 * @author Marina Peregrino  
 * @version 12 19, 2019     
 *          Created Skeleton to outline some basic tests for students to create.  
 * 
 * @author Keshav Kotamraju
 * @version October 9, 2023
 *          Filled in skeleton.
 */

public class TestMyLL_KeshavK
{

    /**
     * Tests each of the methods for the MyLinkedList: 
     * 
     * toString
     * size()
     * add(n)
     * add(i, n)
     * 
     * remove
     * set
     * get
     * 
     * @param args information from the command line
     */
    public static void main (String [] args)
    { 
        /*
         * Things to consider:
         * What would be different for a Linked List?  
         */

        String studentName = "Keshav Kotamraju"; //Insert your name here.  
        System.out.println("Tests MyLL for "+ studentName); 

        // Test that MyLinkedList implements the interface
        MyLinkedList<Integer> nums1 = new MyLinkedList<Integer>();

        /**
         * test1:  Tests for each of the following: 
         * add(i, n) to an empty list,
         * add(i, n) to an existing list,
         * size,
         * toString 
         */
        boolean test1 = true; 
        if (!test1)
        {
            System.out.println ("Skipping Test #1"); 
        }
        else
        {
            System.out.println ("#1 Testing: add at last index");
            for (int i=0; i < 5; i++)
            {
                nums1.add(i, i);
                System.out.println ("" + nums1 + ", size: " + nums1.size());

            }
        }
        nums1= null;   //release unused data 
        //////////////////////////////////////////////////////////////////////

        /**
         * test2:  Tests for each of the following: 
         * add(n) to an empty list,
         * add(n) to an existing list,
         * size,
         * toString 
         */
        MyLinkedList<Integer> nums2 = new MyLinkedList<Integer>();
        boolean test2 = true; 
        if (!test2)
        {
            System.out.println ("Skipping Test #2"); 
        }
        else
        {
            System.out.println ("#2 Testing: add (appending)");
            for (int i = 0; i < 5; i++)
            {
                nums2.add(i);
                System.out.println ("" + nums2 + ", size: " );
            }
        }

        /**
         * test3:  Tests for each of the following: 
         * iterator,
         * hasNext,
         * next,
         */
        boolean test3 = true; 
        if (!test3)
        {
            System.out.println ("Skipping Test #3"); 
        }
        else
        {
            /* */
            System.out.println ("List:\n" + nums2);
            System.out.println ("#3 Testing: iterator:  ");
            String s ="";
            MyLinkedList<String> myAl = new MyLinkedList<String>();

            System.out.println(myAl.toString());
            MyIterator iter = nums2.iterator();

            while(iter.hasNext())
            {
                int val = (int) iter.next();
                s += val + ", ";
            }

            System.out.println(" yields:");
            System.out.println(s);

        }

        nums2= null;  //release unused data 
        //////////////////////////////////////////////////////////////////////

        /**
         * Previous tests were Integer list subsequent tests are String list
         * 
         * Add tests for the methods 
         * append,              
         * insert, 
         * remove, 
         * set, 
         * get
         * 
         * from begin, middle and end of list
         * 
         * test index out of bounds
         */
        MyLinkedList<String> list = new MyLinkedList<String>();

        /**
         * test4:  Tests for each of the following: 
         * 
         * 
         * 
         * 
         */
        boolean test4 = true; 
        if (!test4)
        {
            System.out.println ("Skipping Test #4"); 
        }
        else
        {
            list.add("B");
            list.add("D");
            list.add("E");
            list.add("F");
            list.add(2, "C");
            list.add(0, "A");
            list.add(6, "G");

            String strs = "";
            for (int i = 0; i < list.size(); i++)
            {
                strs += list.get(i);
            }

            System.out.println("Test 4: " + strs);
        }

        /**
         * test5:  Tests for each of the following: 
         * 
         * 
         * 
         */
        boolean test5 = true; 
        MyLinkedList<String> listy = new MyLinkedList<String>();
        if (!test5)
        {
            System.out.println ("Skipping Test #5"); 
        }
        else
        {
            listy.add("A");
            listy.add("B");
            listy.add("C");
            listy.add("D");
            for (int i = 0; i < listy.size(); i++)
            {
                listy.set(i, "E");
            }
            String strings = "";
            for (int i = 0; i < listy.size(); i++)
            {
                strings += listy.get(i);
            }
            System.out.println("Test 5.1: " + strings);
            for(int i = 0; i < listy.size(); i++)
            {
                list.remove(i);
            }
            String stri = "";
            for (int i = 0; i < listy.size(); i++)
            {
                stri += listy.get(i);
            }
            System.out.println("Test 5.2: " + stri);
        }

        /**
         * test6:  Tests exception for index out of bounds 
         * tests each of the methods that use index, 
         * add, remove, set, get
         * Tests when underlying list does have such and index and when it does not.   
         */
        boolean test6 = true; 
        if (!test6)
        {
            System.out.println ("Skipping Test #9"); 
        }
        else
        {
            MyLinkedList<String> list3 = new MyLinkedList<String>();
            System.out.println("\n Test index out of bounds exception:");
            list3.add("A");
            list3.add("B");
            list3.add("C");
            list3.add("D");
            String strings = "";
            try 
            {
                list3.get(1000);
            } catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                list3.add(-3, "E");
            } catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                list3.set(-3, "E");
            } catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            try 
            {
                list3.remove(-3);
            } catch (IndexOutOfBoundsException e) 
            {
                System.out.println("" +  e );
                System.out.println("");
            }
            /**/
        }
    }
}
