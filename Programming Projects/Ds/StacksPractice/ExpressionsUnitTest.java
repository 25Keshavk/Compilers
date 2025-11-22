
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ExpressionsUnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExpressionsUnitTest
{
    /**
     * Default constructor for test class ExpressionsUnitTest
     */
    public ExpressionsUnitTest()
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
    public void TestEvalPostFix()
    {
        // test postfix evaluation 

        assert Expressions.evalPostfix("3  2 +") == 5: "3  2 + " + Expressions.evalPostfix("3  2 +");
        assert Expressions.evalPostfix("3 2 -") == 1: "Check the evalPostfix method";
        assert Expressions.evalPostfix("3 2 *") == 6: "Check the evalPostfix method";
        assert Expressions.evalPostfix("3 2 /") == 1.5: "Check the evalPostfix method";
        assert Expressions.evalPostfix("4 5 %") == 4: "Check the evalPostfix method";
        assert Expressions.evalPostfix("11 5 %") == 1: "Check the evalPostfix method";
        assert Expressions.evalPostfix("3 2 + 1 * 2 2 * +") == 9: "Check the evalPostfix method";
        assert Expressions.evalPostfix("30 2 /") == 15.0: "Check the evalPostfix method";
        assert Expressions.evalPostfix("12 3 4 * +") == 24: "Check the evalPostfix method";

        //("3 2 /", 3.0/2.0); 
    }

    @Test
    public void TestEvalPostFixV2()
    {
        assertTrue( StacksPracticeTester.testEval ("3  2 +", 5), "Check the evalPostfix method");
        assertTrue( StacksPracticeTester.testEval ("3 2 -", 1), "Check the evalPostfix method");
        assertTrue( StacksPracticeTester.testEval ("3 2 *", 6), "Check the evalPostfix method");
        assertTrue( StacksPracticeTester.testEval ("3 2 /", 3.0/2.0), "Check the evalPostfix method"); 
        assertTrue( StacksPracticeTester.testEval ("4 5 %", 4), "Check the evalPostfix method");
        assertTrue( StacksPracticeTester.testEval ("11 5 %", 1), "Check the evalPostfix method");
        assertTrue( StacksPracticeTester.testEval ("3 2 + 1 * 2 2 * +", 9), "Check the evalPostfix method"); 
        assertTrue( StacksPracticeTester.testEval ("30 2 /", 15.0), "Check the evalPostfix method"); 
        assertTrue( StacksPracticeTester.testEval ("12 3 4 * +", 24), "Check the evalPostfix method"); 

    }
    // @Test
    // public void TestEvalInFix()
    // {
        // //
        // //static void     assertEquals(Object expected, Object actual, String message)
        // //Asserts that expected and actual are equal.
        // //

        // String errMsg = "Check your postfix and eval methods **";
        // String exp = "2 + 3 * 4";
        // assertTrue( StacksPracticeTester.test(exp, 14));

        // exp = "12 + 3 * 4";
        // assertTrue( StacksPracticeTester.test(exp, 24));

        // exp = "8 * 12 / 2";
        // assertTrue( StacksPracticeTester.test(exp, 48));

        // exp = "5 % 2 + 3 * 2 - 4 / 2";
        // assertTrue( StacksPracticeTester.test(exp, 5));   

        // exp = "3 % 2 + 5 * 2 - 6 / 3";
        // assertTrue( StacksPracticeTester.test(exp, 9));   

    // }
}

