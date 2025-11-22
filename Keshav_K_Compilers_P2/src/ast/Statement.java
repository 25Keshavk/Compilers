package ast;

import emitter.Emitter;
import environment.Environment;
/**
 * Statement is an abstract class for different statements
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 */
public abstract class Statement
{
    /**
     * Executes the statement
     *
     * @param env the environment given
     */
    public abstract void exec(Environment env);
    public void compile(Emitter e)
    {
        throw new RuntimeException("Implement me!!!!!");
    }
}