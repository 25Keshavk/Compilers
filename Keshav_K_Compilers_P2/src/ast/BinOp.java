package ast;

import emitter.Emitter;
import environment.Environment;
/**
 * BinOp provides execution and construction for a
 * Binary operation (+,-,/,*) Expression
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 *
 */
public class BinOp extends Expression{
    private String op;
    private Expression exp1;
    private Expression exp2;
    /**
     * Constructs a BinOp
     *
     * @param op the operator
     * @param exp1 the left side exp
     * @param exp2 the right side exp
     */
    public BinOp(String op, Expression exp1, Expression exp2)
    {
        this.op = op;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    /**
     * evaluates the given class according to the
     * rules of the grammar.
     *
     * @param env
     * @return
     */
    public int eval(Environment env)
    {
        if (op.equals("-"))
        {
            return exp1.eval(env) - exp2.eval(env);
        }
        else if (op.equals("+"))
        {
            return exp1.eval(env) + exp2.eval(env);
        }
        else if (op.equals("*"))
        {
            return exp1.eval(env) * exp2.eval(env);
        }
        else
        {
            return exp1.eval(env) / exp2.eval(env);
        }



    }
    /**
     * Converts a BinOp statement to mips code,
     * giving mips code that evaluates and
     * prints the result
     *
     * @param e the Emitter to write to the file with
     */
    public void compile(Emitter e)
    {
        exp1.compile(e);
        e.emitPush("$v0");
        exp2.compile(e);
        e.emitPop("$t0");
        if (op.equals("+"))
            e.emit("addu $v0 $t0 $v0");
        else if (op.equals("-"))
            e.emit("subu $v0 $t0 $v0");
        else if (op.equals("/")) {
            e.emit("div $v0 $t0 $v0");
        }
        else {
            e.emit("mult $t0 $v0");
            e.emit("mflo $v0");
        }

    }
}
