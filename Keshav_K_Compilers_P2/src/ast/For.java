package ast;

import environment.Environment;

/**
 * For provides the execution and construction of a
 * for loop.
 *
 * @author Keshav Kotamraju 
 * @version 3/14/24
 */
public class For extends Statement
{
    String ind;
    Expression lowb;
    Expression upperb;
    Statement stmt;

    /**
     * Constructs a For
     *
     * @param ind the ind of the counter
     * @param lowb the initial value
     * @param upperb the end bound
     * @param stmt the statement to execute
     */
    public For(String ind, Expression lowb, Expression upperb, Statement stmt)
    {
        this.ind = ind;
        this.lowb = lowb;
        this.upperb = upperb;
        this.stmt = stmt;
    }

    /**
     * Executes the statement through the loop
     *
     * @param env the environment given
     */
    public void exec(Environment env)
    {
        int i = lowb.eval(env);
        env.setVariable(ind, i);
        while( env.getVariable(ind) <= upperb.eval(env))
        {
            stmt.exec(env);
            env.setVariable(ind, env.getVariable(ind) + 1);
        }
    }
}
