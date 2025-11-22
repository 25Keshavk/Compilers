package ast;
import emitter.Emitter;
import environment.Environment;

/**
 * If provides the execution and construction of If statements.
 * If can be constructed with one or two statements.
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 *
 */
public class If extends Statement
{
    Expression con;
    Statement stmt1;
    Statement stmt2;

    /**
     * Constructs IF
     *
     * @param con the condition of the if statement
     * @param stmt1 the statement to be executed if con is true
     */
    public If(Expression con, Statement stmt1)
    {
        this.con = con;
        this.stmt1 = stmt1;
        this.stmt2 = null;
    }

    /**
     * constructs If for 2 statements
     *
     * @param con   the condition to be evaluated
     * @param stmt1 statement to execute if con is true
     * @param stmt2 statement to execute if con is false
     */
    public If(Expression con, Statement stmt1, Statement stmt2)
    {
        this.con = con;
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }

    /**
     * Executes stmt1 if cond is true;
     * otherwise executes stmt2
     *
     * @param env the environment given
     */
    public void exec(Environment env)
    {
        if (con.eval(env) == 0)
            stmt1.exec(env);
        else if (stmt2 != null)
            stmt2.exec(env);
    }
    /**
     * Converts an if statement to Mips code
     *
     * @param e the emitter to use
     */
    public void compile(Emitter e)
    {
        String lbl = "endif" + String.valueOf(e.nextLabelID());
        Condition cond = (Condition) con;
        cond.compile(e, lbl);
        stmt1.compile(e);
        e.emit(lbl + ":");
    }
}
