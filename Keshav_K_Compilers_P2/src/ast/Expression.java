package ast;

import emitter.Emitter;
import environment.Environment;
/**
 * Expression is an abstract class for different statements
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 */
public abstract class Expression {
    /**
     * evaluates the given class according to the
     * rules of the grammar.
     * @param env
     * @return the evaluation of the expression
     */
    public abstract int eval(Environment env);
    public void compile(Emitter e)
    {
        throw new RuntimeException("Implement me!!!!!");
    }

}
