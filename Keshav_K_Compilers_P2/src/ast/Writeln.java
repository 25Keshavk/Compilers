package ast;

import emitter.Emitter;
import environment.Environment;
/**
 * Writeln provides execution and construction of a
 * Writeln statement
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 *
 */
public class Writeln extends Statement
{
    private Expression exp;
    /**
     * Constructs a Writeln statement
     *
     * @param exp the expression to print
     */
    public Writeln(Expression exp)
    {
        this.exp = exp;
    }

    /**
     * Prints the given expression
     *
     * @param env the environment given
     */
    public void exec(Environment env)
    {
        System.out.println(exp.eval(env));
    }

    /**
     * Converts a Writeln statement to mips code,
     * giving mips code that prints a expression
     *
     * @param e the Emitter to write to the file with
     */
    public void compile(Emitter e)
    {
        exp.compile(e);
        e.emit("\n" +
                "move $a0 $v0\n" +
                "li $v0 1\n" +
                "syscall,\n " +
                 "li $v0 11 \n" +
                         "li $a0 10  \n" +
                         "syscall");
    }
}