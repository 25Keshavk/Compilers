
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MatchParensUnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatchParensUnitTest
{
    /**
     * Default constructor for test class MatchParensUnitTest
     */
    public MatchParensUnitTest()
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
    public void testMatchParens()
    {

        String [] matchedParens = { 
                "{ 2 + 3 } * ( 4 + 3 )",
                "( ( ( ) ) )",
                "( [ { } ] )",
        };
            String [] unMatchedParens = { 
                "(", 
                ")", 
                "} 4 + 4 { * ( 4 + 3 )", 
                "[ [ [ ] ]",
                "{ ( } )",
            }   ;     

        for (String match : matchedParens){
            String msg = " \"" + match + "\" " ;
            String errMsg = msg; 
            System.out.println(msg + " should match "+ Expressions.matchParenthesis(match));
            assertTrue( Expressions.matchParenthesis(match) , errMsg);
        }
        
        
        for (String differ : unMatchedParens){
            String msg = " \"" + differ + "\" " ;
            String errMsg = msg; 
            System.out.println(msg + " mismatch, not match "+ Expressions.matchParenthesis(differ));
            assertFalse( Expressions.matchParenthesis(differ) , errMsg);
        }
    }
}
