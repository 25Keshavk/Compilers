
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import org.junit.Assert;
//import static org.junit.Assert.*;

/**
 * The test class StringUnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StringUnitTest
{
    String [] pals;
    String [] notPals;
    /**
     * Default constructor for test class StringUnitTest
     */
    public StringUnitTest()
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
        //pals = new String [] {"a", "", "racecar", "wasitacatisaw", "neveroddoreven"};
        pals = new String [] {"a", "", "racecar", "wasitacatisaw", "neveroddoreven"};
        notPals = new String [] {"ab", "aaabcaaa", "notapalindrome"};

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

    @Test
    public void testpalindrome()
    {

        for (String a : pals){
            String msg = "\"" + a + "\" -> \"" + StringUtil.reverseString(a) +"\"" ;
            String errMsg = "Expected palindrome " + msg ;
            System.out.println(msg);
            assertTrue(StringUtil.isPalindrome(a), errMsg );
        }

        for (String b : notPals){
            String msg = "\"" + b + "\" -> \"" + StringUtil.reverseString(b) +"\"" ;
            String errMsg =  msg ;
            System.out.println(msg);
            assertFalse(StringUtil.isPalindrome(b), errMsg);
        }
    }

    @Test
    public void testReverseString()
    {
        for (String a : pals){
            String errMsg = "Expected equal strings \"" + a + "\" -> \"" + StringUtil.reverseString(a) +"\"" ;
            assertTrue( a .equals(StringUtil.reverseString(a) ), errMsg);
        }
    }
}

