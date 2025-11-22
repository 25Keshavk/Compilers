import java.util.Stack;

/**
 * Write a description of class StringUtil here.
 * 
 * @author Anu Datar
 * @version 10/27/2017
 * 
 * @author Keshav Kotmaraju
 * @version 10/23/2023
 */

public class Expressions
{
    // parenthesis matching : An expression is said to be balanced if
    // every opener has a corresponding closer, in the right order
    // {, [ or ( are the only types of brackets allowed
    // @param   expression containing operands operators 
    //          and any of the 3 supportedbrackets
    // @return  true is the parenthesis are balanced         
    //          false otherwise
    public static boolean matchParenthesis(String expression)
    {
        Stack<String> stk = new Stack<String>();

        String[] string = expression.split("");
        for (int i = 0; i<string.length; i++)
        {
            switch(string[i])
            {
                case "(":
                case "[":
                case "{":
                case "<":
                    stk.push(string[i]);
                    break;
                case ")":
                    if (stk.isEmpty() || !stk.pop().equals("("))
                        return false;
                    break;
                case "]":
                    if (stk.isEmpty() || !stk.pop().equals("["))
                        return false;
                    break;
                case "}":
                    if (stk.isEmpty() || !stk.pop().equals("{"))
                        return false;
                    break;
                case ">":
                    if (stk.isEmpty() || !stk.pop().equals("<"))
                        return false;
                    break;
            }
        }
        return stk.isEmpty();
    }
    // returns a string in postfix form 
    // if given an expression in infix form as a parameter
    // does this conversion using a Stack
    // @param expr valid expression in infix form
    // // @return equivalent expression in postfix form
    // public static String infixToPostfix(String expr)
    // {
    // Stack<Integer> postFix = new Stack<Integer>();
    // String strPostfix = "";

    // // Write code here
    // return strPostfix;
    // // }

    // // returns the value of an expression in postfix form
    // does this computation using a Stack
    // @param expr valid expression in postfix form
    // @return value of the expression
    // @precondition postfix expression  
    //               contains numbers and operators + - * / and %
    //               and that operands and operators are separated by spaces
    public static double evalPostfix(String expr)
    {
        Stack<Double> operands = new Stack<Double>();
        String[] splitArr = expr.split(" +");
        Stack<String> chars = new Stack<String>();
        // for (String str : splitArr) 
        // {
        // if (!str.equals("*") && !str.equals("+") && !str.equals("-") &&
        // !str.equals("%") && !str.equals("/"))
        // operands.push(Double.valueOf(str));
        // else
        // {
        // chars.push(str);
        // }
        // }
        // for (int i = splitArr.length-1; i>= 0; i--) {
        //switch (splitArr[i]) {
        for(String str : splitArr)
            switch(str){
                case "+":
                    double second = operands.pop();
                    double first = operands.pop();
                    double sum = first + second;
                    operands.push(sum);
                    break;
                case "-":
                    second = operands.pop();
                    first = operands.pop();
                    double difference = first - second;
                    operands.push(difference);
                    break;
                case "*":
                    second = operands.pop();
                    first = operands.pop();
                    double product = first * second;
                    operands.push(product);
                    break;
                case "/":
                    second = operands.pop();
                    first = operands.pop();
                    double quotient = first/second;
                    operands.push(quotient);
                    break;
                case "%":
                    second = operands.pop();
                    first = operands.pop();

                    double mod = first % second;
                    System.out.print(" mod " + mod);
                    operands.push(mod);
                    break;
                default:
                    operands.push(Double.parseDouble(str));

            }

        return operands.peek();
    }

    // Tester to check if infix to postfix and evaluate postfix work well
    public static void main(String[] args)
    {
        /* *
        String exp = "2 + 3 * 4";
        test(exp, 14);

        exp = "8 * 12 / 2";
        test(exp, 48);

        exp = "5 % 2 + 3 * 2 - 4 / 2";
        test(exp, 1);   
        //number changes due to post fix ignoring order of operations. 
        /* */

        // test balanced expressions
        testBalanced("{ 2 + 3 } * ( 4 + 3 )", true);
        testBalanced("} 4 + 4 { * ( 4 + 3 )", false);
        testBalanced("[ [ [ ] ]", false);
        testBalanced("{ ( } )", false);
        testBalanced("( ( ( ) ) )", true);
    }

    /**
     * Test for the infix and evalPostfix methods
     * 
     * @param expr the expression
     * 
     * @param expect the expected value
     */
    public static void test(String expr, double expect)
    {      
        double val = evalPostfix(expr);
        System.out.println("Postfix: " + expr);
        System.out.println("Value: " + val);
        if (val == expect)
        {
            System.out.print("** Success! Great Job **");
        }
        else
        {
            System.out.print("** Oops! Something went wrong. ");
            System.out.println("Check your postfix and eval methods **");
        }
    }

    /**
     * Tests the matchParenthesis method, sees if it matches the expected result
     * 
     * @param ex the given string
     * 
     * @param expected whether or not the parenthesis should match
     */
    public static void testBalanced(String ex, boolean expected)
    {
        boolean act = matchParenthesis(ex);
        if (act == expected)
            System.out.println("** Success!: matchParenthesis(" + ex + ") returned " + act);
        else
        {
            System.out.print("** Oops! Something went wrong check : matchParen(" + ex + ")");
            System.out.println(" returned " + act + " but should have returned " + expected);
        }
    }
}
