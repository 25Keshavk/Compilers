package ast;
import emitter.Emitter;
import environment.Environment;
/**
 * Number provides execution and construction
 * of a number expression.
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 *
 */
public class Number extends Expression {
    private int val;
    /**
     * Constructs a Number Expression
     *
     * @param val value of the number
     */
    public Number(int val)
    {
        this.val = val;
    }

    /**
     * Returns the value of the number expression
     *
     * @param env the environment given
     * @return value of the number
     */
    public int eval(Environment env)
    {
        return val;

    }
    /**
     * Converts a number to mips code,
     * storing it in v0
     *
     * @param e the Emitter to write to the file with
     */
    public void compile(Emitter e)
    {
        e.emit("li $v0, " +  val);
    }
}
