package ast;

import environment.Environment;
import java.util.Scanner;

/**
 * Readln provides construction and execution of a "READLN" statement.
 *
 * @author Keshav Kotamraju
 * @version 3/26/24
 *
 */
public class Readln extends Statement
{
    String id;

    /**
     * Constructs a Readln
     *
     * @param id the variable to change
     */
    public Readln(String id)
    {
        this.id = id;
    }

    /**
     * Executes the Readln statement, stores user input
     * in id.
     * @param env the environment to use
     */
    public void exec(Environment env)
    {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        env.setVariable(id, val);
        sc.close(); // ends scanner
    }

}
