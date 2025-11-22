package ast;

import emitter.Emitter;
import environment.Environment;

import java.util.List;
/**
 * Block provides execution and construction for a
 * block statement
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 *
 */
public class Block extends Statement{
    private List<Statement> smts;
    /**
     * Constructs a Block given a list of statements
     *
     * @param smts the statements to run in order
     */
    public Block(List<Statement> smts)
    {
        this.smts = smts;
    }

    /**
     * Executes given statements in order provided
     *
     * @param env the environment to use
     */
    public void exec(Environment env)
    {
        for (int i =0; i < smts.size(); i++)
        {
            smts.get(i).exec(env);
        }
    }
    /**
     * Converts a Block statement to mips code,
     * giving mips code that simulates a java execution
     * of the Block's exec method
     *
     * @param e the Emitter to write to the file with
     */
    public void compile(Emitter e)
    {
        for (int i = 0; i < smts.size(); i++)
            smts.get(i).compile(e);

    }
}
