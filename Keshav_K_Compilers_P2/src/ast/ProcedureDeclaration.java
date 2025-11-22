package ast;

import java.util.List;

import environment.Environment;

/**
 * ProcedureDeclaration provides the execution and construction of
 * Procedure Declarations
 *
 * @author Keshav Kotamraju
 * @version 4/9/24
 *
 */
public class ProcedureDeclaration extends Statement
{
    String id;
    List <String> parids;
    Statement stmt;

    /**
     * ProcedureDeclaration constructor
     *
     * @param id the identifier of the function
     * @param parids the identifiers of the parameters
     * @param stmt the statement to be run
     */
    public ProcedureDeclaration(String id, List <String> parids, Statement stmt)
    {
        this.id = id;
        this.parids = parids;
        this.stmt = stmt;
    }

    /**
     * Adds a given function to the environment
     *
     * @param env the environment provided
     */
    public void exec(Environment env)
    {
        env.setProcedure(id, this);
    }

    /**
     * Gets the statement
     *
     * @return the statement to run
     */
    public Statement getStatement()
    {
        return stmt;
    }

    /**
     * Gets the parameter ids
     *
     * @return the ids of the parameters the function uses, if any
     */
    public List<String> getPIDs()
    {
        return parids;
    }
}
