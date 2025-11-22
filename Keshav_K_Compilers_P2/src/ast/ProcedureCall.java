package ast;

import java.util.List;

import environment.Environment;

/**
 * ProcedureCall provides the execution and construction of
 * Procedure Calls.
 *
 * @author Keshav Kotamraju
 * @version 4/9/24
 *
 */
public class ProcedureCall extends Expression
{
    String id;
    List<Expression> pars;

    /**
     * Constructs a ProcedureCall
     *
     * @param id the identifier
     * @param pars the parameters to pass in
     */
    public ProcedureCall(String id, List <Expression> pars)
    {
        this.id = id;
        this.pars = pars;
    }

    /**
     * Evaluates a ProcedureCall
     *
     * @param env the environment provided
     * @return the return value of the procedure if there is one;otherwise
     *         0
     */
    public int eval(Environment env)
    {
        ProcedureDeclaration proced = env.getProcedure(id);
        Environment secenv = new Environment(env);
        List<String> pids = proced.getPIDs();

        secenv.declareVariable(id, 0);

        for (int i = 0; i < pars.size(); i++)
            secenv.declareVariable(pids.get(i), pars.get(i).eval(env));

        proced.getStatement().exec(secenv);

        return secenv.getVariable(id);
    }
}
