package ast;
import emitter.Emitter;
import environment.Environment;
/**
 * Assignment provides execution and construction for an assignment statement.
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 */
public class Assignment extends Statement {

    private String var;
    private Expression exp;
    /**
     * Assignment constructor
     *
     * @param var the variable
     * @param exp the expression to assign to  variable
     */
    public Assignment(String var, Expression exp)
    {
        this.var = var;
        this.exp = exp;
    }

    /**
     * Evaluates the given class according to the
     * rules of the grammar.
     *
     * @param env
     */
    public void exec(Environment env)
    {
        env.setVariable(var,exp.eval(env));

    }

    /**
     * Converts an assignment into Mips code
     * @param e the emitter used
     */
    public void compile(Emitter e)
    {
        exp.compile(e);
        e.emit("sw $v0 " + var);
    }
}
