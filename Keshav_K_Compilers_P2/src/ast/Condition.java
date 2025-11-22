package ast;

import emitter.Emitter;
import environment.Environment;

/**
 * Condition provides execution and construction of
 * conditionals.
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 *
 */
public class Condition extends Expression
{
    String op;
    Expression exp1;
    Expression exp2;

    /**
     * Constructs a condition
     *
     * @param op the condition 
     * @param exp1 the left expression
     * @param exp2 the right expression
     */
    public Condition(String op, Expression exp1, Expression exp2)
    {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    /**
     * Evaluates the condition, returning 0 and 1 for 
     * true and false respectively
     * @param env the environment given
     * @return 0 if true;otherwise
     *         1
     */
    public int eval(Environment env)
    {
        int state = 1;
        if (op.equals("=") && exp1.eval(env) == exp2.eval(env))
            state = 0;
        else if (op.equals("<=") && exp1.eval(env) <= exp2.eval(env))
            state = 0;
        else if (op.equals(">=") && exp1.eval(env) >= exp2.eval(env))
            state = 0;
        else if (op.equals("<") && exp1.eval(env) < exp2.eval(env))
            state = 0;
        else if (op.equals(">") && exp1.eval(env) > exp2.eval(env))
            state = 0;
        else if (op.equals("<>") && exp1.eval(env) != exp2.eval(env))
            state = 0;
        return state;
    }
    /**
     * Converts a condition evaluation to Mips code
     *
     * @param e the emitter object to use
     * @param label the label to jump to in mips
     */
    public void compile(Emitter e, String label)
    {
        exp1.compile(e);
        e.emitPush("$v0");
        exp2.compile(e);
        e.emitPop("$t0");
        if (op.equals("="))
            e.emit("bne $t0 $v0 " + label);
        else if (op.equals(">"))
            e.emit("ble $t0 $v0 " + label);
        else if (op.equals("<"))
            e.emit("bge $t0 $v0 " + label);
        else if (op.equals(">="))
            e.emit("blt $t0 $v0 " + label);
        else if (op.equals("<="))
            e.emit("bgt $t0 $v0 " + label);
        else if (op.equals("<>"))
            e.emit("beq $t0 $v0 " + label);
    }
}
