package ast;
import emitter.Emitter;
import environment.Environment;
/**
 * Variable provides execution and construction
 * for a variable
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 */
public class Variable extends Expression  {
    private String name;
    /**
     * Constructs a variable
     *
     * @param name the name of the variable
     */
    public Variable(String name)
    {
        this.name = name;
    }

    /**
     * Gets the value of the variable
     *
     * @param env the environment given
     * @return the value
     */
    public int eval(Environment env)
    {
        return env.getVariable(name);
    }
    /**
     * Converts a variable's evaluation to mips code,
     *
     * @param e the Emitter to write to the file with
     */
    public void compile(Emitter e)
    {
        e.emit("la $t0 " + name + "\n" +
                "lw $v0 ($t0)");

    }
}
