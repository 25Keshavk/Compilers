package environment;

import ast.Expression;
import ast.ProcedureDeclaration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Environment provides the storing of values for the laterevaluation
 * of programs, allowing parsing to be seperate
 * from execution.
 *
 * @author Keshav Kotamraju
 * @version 3/21/24
 */
public class Environment {

    Map<String ,Integer> mappy;
    Map<String, ProcedureDeclaration> procedures;
    Environment parenv;
    /**
     * Constructs an Environment
     */
    public Environment()
    {
        mappy = new HashMap<String, Integer>();
        procedures = new HashMap<String, ProcedureDeclaration>();
    }
    /**
     * Constructor for procedures, overloaded.
     *
     * @param parenv the "parent" environment provided
     */
    public Environment(Environment parenv)
    {
        mappy = new HashMap<String, Integer>();
        procedures = new HashMap<String, ProcedureDeclaration>();
        this.parenv = parenv;
    }


    /**
     * gets the Parent environment
     *
     * @return the parent environment
     */
    public Environment getParenv()
    {
        return parenv;
    }
    /**
     * Gets all the variables in the environment
     *
     * @return a Set containing all variables
     */
    public Set<String> getVariables()
    {
        return mappy.keySet();
    }

    /**
     * Sets the variable to a given value
     *
     * @param var the variable
     * @param val the value to set the variable to
     */
    public void setVariable(String var, int val)
    {
        Environment env = this;
        while (env != null)
        {
            if (env.getVariables().contains(var))
            {
                env.declareVariable(var, val);
                return;
            }
            env = env.getParenv();
        }
        mappy.put(var, val);
    }

    /**
     * Sets the variable to a given value
     *
     * @param var the variable
     * @param val the value to set the variable to
     */
    public void declareVariable(String var, int val)
    {
        mappy.put(var, val);
    }

    /**
     * Returns the value of a given variable
     *
     * @param var the variable
     * @return the value of the variable
     */
    public int getVariable(String var)
    {
        if (getVariables().contains(var))
            return mappy.get(var);
        if (parenv != null)
            return parenv.getVariable(var);
        return 0;
    }

    /**
     * Sets a given procedure
     *
     * @param id the id of the procedure
     * @param prod a ProcedureDeclaration with commands
     */
    public void setProcedure(String id, ProcedureDeclaration prod)
    {
        if (parenv == null)
            procedures.put(id, prod);
        else
            parenv.setProcedure(id, prod);
    }

    /**
     * Gets a given procedure from the environment
     *
     * @param id the id of the procedure
     * @return the procedure for the id
     */
    public ProcedureDeclaration getProcedure(String id)
    {
        if (parenv == null)
            return procedures.get(id);
        else
            return parenv.getProcedure(id);
    }
}
