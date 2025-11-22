package ast;
import emitter.Emitter;
import environment.Environment;

/**
 * While provides execution and construction of while loops.
 * It is constructed with a condition and a statement to execute
 * if the condition is true.
 *
 * @author Keshav Kotamraju
 * @version 3/13/24
 *
 */
public class While extends Statement
{
    Expression con;
    Statement stmt;

    /**
     * Constructs While
     *
     * @param con the condition to evaluate
     * @param stmt the statement to run
     */
    public While(Expression con, Statement stmt)
    {
        this.con = con;
        this.stmt = stmt;
    }

    /**
     * Executes the statement if condition is true
     *
     * @param env the environment given
     */
    public void exec(Environment env)
    {
        while (con.eval(env) == 0)
            stmt.exec(env);
    }
    /**
     * Converts a while statement to Mips
     *
     * @param e the emitter to use
     */
    public void compile(Emitter e)
    {
        String floop = "loop" + String.valueOf(e.nextLabelID());
        String eloop = "eloop" + String.valueOf(e.nextLabelID());
        Condition cond = (Condition) con;
        e.emit(floop + ":");
        cond.compile(e, eloop);
        stmt.compile(e);
        e.emit("j " + floop);
        e.emit(eloop + ":");
    }
}
