/* */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/* */

/* * /
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/* */ 

/**
 * The test class MyALJUnitBasicTests.
 *
 * @author  Marina Peregrino
 * @version Oct 2022  created basic tests for MyArrayList 
 */
public class MyALJUnitBasicTests
{

    MyArrayList<String> empty ;
    MyArrayList<Integer> five ;
    /**
     * Default constructor for test class MyALJUnit
     */
    public MyALJUnitBasicTests()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        empty = new MyArrayList();
        five = new MyArrayList();
        for (int i=0; i < 5; i++)
        {
            five.add(5*i); 
        }
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * testingPreamble - student instructions
     */
    public void testingPreamble()
    {
        System.out.println("\nRunning a series of tests.");
        System.out.println("Test will stop on first failure, and show a red bar if it does fail.  ");
        System.out.println("Find Test Results window and click ");
        System.out.println("on the failed test in the top window ");
        System.out.println("Lower window will then show detail to help debug why it failed\n");
        System.out.println("click [Show Source] to see the test that failed."); 
    }

    @Test
    /**
     * Tests size for empty, and size 5, lists
     * and adds one element at a time and tests that capacity doubles only as needed.  
     */
    public void testSize()
    {
        testingPreamble();
        System.out.println("Testing size, and capacity:");
        assertEquals(0 , empty.size(), "size for empty list should be 0" );
        assertEquals(5 , five.size(), "size expected 5 " );
        assert empty.getCapacity() == 1: "Empty list should have capacity of 1"; 
        assert five.getCapacity() == 8: "capacity should double as needed "; 

        MyArrayList<Integer> list = new MyArrayList() ;
        // list = five;  // this would show test failures 
        /* */ 
        list.add(1); 
        assert list.getCapacity() == 1: 
        "capacity should only double when needed, size: " 
        + list.size() + ", capacity: " + list.getCapacity(); 

        list.add(2); 
        assert list.getCapacity() == 2: "capacity should only double when needed, "
        + list.size() + ", capacity: " + list.getCapacity(); 

        list.add(3); 
        assert list.getCapacity() == 4: "capacity should double when needed, "
        + list.size() + ", capacity: " + list.getCapacity(); 

        list.add(4); 
        assert list.getCapacity() == 4: "capacity should only double when needed, "
        + list.size() + ", capacity: " + list.getCapacity(); 
        /* */

    }

    @Test
    /**
     * Tests index out of bounds 
     * Tests: an empty list, at index 0: get, set and remove 
     * Tests add on an empty list at index 1
     * 
     * Similar tests for a size 5 list.  
     * 
     * Tests add after the last index for both lists, should not throw an error.  
     */
    public void testIndexOutOfBounds()
    {
        final int errorIndex0 = 0; 
        String info = "size: " + empty.size() + ", index: " + errorIndex0; 
        Exception exception;

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                empty.remove(errorIndex0);
            }, "Expect to catch an exception here: remove" + info  );        
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                empty.get(errorIndex0);
            }, "Expect to catch an exception here: get" + info  );        
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                empty.set(errorIndex0,"one");
            }, "Expect to catch an exception here: set" + info  );

        final int errorIndex1 = 1; 
        info = "size: " + empty.size() + ", index: " + errorIndex1; 
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                empty.add(errorIndex1,"one");
            }, "Expect to catch an exception here: add" + info  );

        final int errorIndex6 = 6; 
        info = "size: " + five.size() + ", index: " + errorIndex6; 

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                five.add(errorIndex6,1);
            }, "Expect to catch an exception here: add" + info  );

        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                five.remove(errorIndex6);
            }, "Expect to catch an exception here: remove" + info  );        
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                five.get(errorIndex6);
            }, "Expect to catch an exception here: get" + info  );        
        exception = assertThrows(IndexOutOfBoundsException.class, () -> {
                five.set(errorIndex6,1);
            }, "Expect to catch an exception here: set" + info  );

        // This test should generate a fail
        // exception = assertThrows(IndexOutOfBoundsException.class, () -> {
        // five.add(5,555);
        // }, "This test should fail, since no exception should be thrown here"); 

        // Should be able to add at the last index.  
        empty.add(0,"a");
        five.add(5, 555);
        //Should be able to get, set and remove at a valid index
        empty.get(0);
        empty.set(0,"one");
        empty.remove(0);

        five.get(0);
        five.set(0,1);
        five.remove(0);

        //these should cause test to generate a fail
        //empty.add(5,"a");
        //five.add(555, 555);

    }

    @Test
    /**
     * Basic tests for both add methods, get, set, remove
     */
    public void basicAddGetSetRemove()
    {
        MyArrayList<Integer> nums = new MyArrayList();
        java.util.ArrayList<Integer> javaNums = new java.util.ArrayList<Integer>();

        //Add, append,  to both MyArrayList and to java's list and compare.  
        for (int i =0; i < 15; i++)
        {
            int rand =(int) (Math.random() * 100);
            nums.add(rand); 
            javaNums.add(rand);
            String nStr = nums.toString();
            String jStr = javaNums.toString(); 
            assert nStr.equals(jStr) 
            : "ArrayList should behave as Java's does \n" +" add (" +rand +")" 
            + "\n" + nStr + "\n" + jStr; 
        }
        System.out.println ("After add, list contains:\n" + nums); 

        // add at index and compare to java's list
        for (int i = nums.size(); i>= 0; i/= 2, i--){
            int x = -1 * i - 1_000_000;
            nums.add(i, x); 
            javaNums.add(i, x);
            String nStr = nums.toString();
            String jStr = javaNums.toString(); 
            assert nStr.equals(jStr) 
            : "ArrayList should behave as Java's does \n" +" add ("+ i +", "+ x +")" 
            + "\n" + nStr + "\n" + jStr; 
            //System.out.println ( nStr + "\n" + jStr);
        }
        System.out.println ("\nAfter add at index, list contains:\n" + nums); 

        java.util.ArrayList<Integer> getList = new java.util.ArrayList<Integer>();
        // compare get 
        for (int num : nums) {
            getList.add(num); 
        }

        assert getList.toString().equals(javaNums.toString()) == true:
        "Testing get fails. \nFound: \n" + getList + "\nexpected:\n" + javaNums;

        java.util.ArrayList<Integer> listSetReturns = new java.util.ArrayList<Integer>();
        // set and compare the return from set to previous values 
        for (int i=0; i < nums.size(); i++) {
            listSetReturns.add(nums.set(i, 2*i)); 
            //System.out.println ( nums );
        }
        System.out.println ("\nAfter set, list contains:\n" + nums); 

        assert listSetReturns.toString().equals(javaNums.toString()) == true:
        "Testing set fails. \nFound: \n" + listSetReturns + "\nexpected:\n" + javaNums;

        java.util.ArrayList<Integer> listRemoveReturns = new java.util.ArrayList<Integer>();
        javaNums = new java.util.ArrayList<Integer>();
        // set and compare the return from remove to expected values 
        for (int i=nums.size()-1; i >=0 ; i--) {
            javaNums.add(2*i);  //same as set above
            int remo = nums.remove(i);
            listRemoveReturns.add(remo); 
        }
        System.out.println ("\nAfter remove, list contains:\n" + nums); 

        assert listRemoveReturns.toString().equals(javaNums.toString()) == true:
        "Testing remove fails. Expected to retrieve previous elements:\n" + javaNums;

        System.out.println(nums + "\n removed values: \n"+ listRemoveReturns);
        assert nums.size() == 0 : "Expect list to be empty after removing all elements, found " + nums; 
    }

}
