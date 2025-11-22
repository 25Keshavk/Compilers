import java.util.Stack;

/**
 * Write a description of class StringUtil here.
 * 
 * @author Anu Datar
 * @version 10/27/2017
 * 
 * @author Keshav Kotamraju
 * @version 10/25/2023
 */
public class StringUtil
{
    public static String reverseString(String str)
    {
        Stack<String> reverse = new Stack<String>();
        for (int i = 0; i<str.length(); i++)
        {
            reverse.push(str.substring(i,i+1));
        }
        String reversedStr = new String();
        while(!reverse.isEmpty())
        {
            reversedStr += reverse.pop();
        }
        return reversedStr;
    }
    public static boolean isPalindrome(String s)
    {
        if(s.equals(reverseString(s)))
            return true;
        return false;
    }
    public static void main(String[] args)
    {
        String test =  "racecar";
        String test2 = "notapalindrome";

        if ( !("".equalsIgnoreCase(reverseString(""))) )
            System.out.println(" Oops Something went wrong. Check your reverse method ");

        if ( !("a".equalsIgnoreCase(reverseString("a"))) )
            System.out.println(" Oops Something went wrong. Check your reverse method ");

        if (!test.equalsIgnoreCase(reverseString(test)))
            System.out.println(" Oops Something went wrong. Check your reverse method ");
        else
            System.out.println("Success " + test + " matched " + reverseString(test));

        if (test2.equalsIgnoreCase(reverseString(test2)))
            System.out.println(" Oops Something went wrong. Check your reverse method **");

    }
}
