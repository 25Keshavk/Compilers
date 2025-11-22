package parser;
import ast.*;
import environment.Environment;
import scanner.Scanner;
import scanner.ScanErrorException;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * The Parser class executes Pascal-like statements as it checks their syntactical accuracy
 * by utilizing the current token, a map of all String identifiers with their Integer values,
 * and a Scanner, which provides the Parser with a list of the tokens to parse.
 * Parser follows a grammar
 * defined as follows:
 * stmt → WRITELN ( expr ) ; | BEGIN stmts END ; | id := expr ;
 * stmts → stmts stmt | ε
 * expr → expr + term | expr - term | term
 * term → term * factor | term / factor | factor
 * factor → ( expr ) | - factor | num | id
 *
 * @author Keshav Kotamraju
 * @version March 11, 2024
 */

public class Parser {
    Scanner scanny;

    String currentToken;

    public Parser(Scanner scant) throws ScanErrorException
    {
        scanny = scant;
        currentToken = scanny.nextToken();
    }

    /**
     * eat is provided an expected char and if the expected is the same char then
     * eat will move on to the next char. Otherwise, eat will throw an error
     * since the expected and current char are not the same.
     *
     * @param expected the expected char
     * @throws ScanErrorException
     * @throws IllegalArgumentException
     */

    private void eat(String expected) throws ScanErrorException, IllegalArgumentException {

        if (expected.equals(currentToken))
            currentToken = scanny.nextToken();
        else
            throw new ScanErrorException("Illegal token - expected" +
                    expected + "and found" + currentToken);
    }

    /**
     * parseNumber is called when the current token is a String of a digit.
     * The method uses parseInt to convert the String to an Integer and then
     * calls eat to change current Token. Then it creates a Number holding
     * the value.
     * <p>
     * precondition: current token is a digit
     * postcondition: number token has been eaten
     *
     * @return a Number containing the value
     * @throws ScanErrorException
     */
    private Expression parseNumber() throws ScanErrorException {
        ast.Number num = new ast.Number(parseInt(currentToken));
        eat(currentToken);
        return num;
    }

    /**
     * parseStatement parses all lines inside a WRITELN() or between a
     * BEGIN and END statement by calling parseExpression after eating
     * the tokens containing the to be parsed statements. If the
     * expression is within WRITELN() then it is printed when execution
     * is called.
     * @return a Statement that can be evaluated
     *
     * @throws ScanErrorException
     */
    public Statement parseStatement() throws ScanErrorException
    {
        if (currentToken.equals("WRITELN"))
            {
                eat("WRITELN");
                eat("(");
                Expression exp = parseExpression();
                eat(")");
                eat(";");
                return new Writeln(exp);
            }
        if (currentToken.equals("BEGIN"))
        {
            List<Statement> smts = new ArrayList<Statement>();
            eat("BEGIN");
            while(!currentToken.equals("END"))
            {
                smts.add(parseStatement());

            }
            eat("END");
            eat(";");
            return new Block(smts);
        }
        else if (currentToken.equals("IF"))
        {
            eat("IF");
            Expression con = parseConditional();
            eat("THEN");
            Statement stmt1 = parseStatement();
            if (currentToken.equals("ELSE"))
            {
                eat("ELSE");
                Statement stmt2 = parseStatement();
                return new If(con, stmt1, stmt2);
            }
            return new If(con, stmt1);
        }
        else if (currentToken.equals("WHILE"))
        {
            eat("WHILE");
            Expression con = parseConditional();
            eat("DO");
            Statement stmt = parseStatement();
            return new While(con, stmt);
        }
        else if (currentToken.equals("FOR"))
        {
            eat("FOR");
            String ind = currentToken;
            eat(currentToken);
            eat(":=");
            Expression lowb  = parseExpression();
            eat("TO");
            Expression upperb = parseExpression();
            eat("DO");
            Statement statm = parseStatement();
            return new For(ind, lowb, upperb, statm);
        }
        else if (currentToken.equals("READLN"))
        {
            eat("READLN");
            eat("(");
            String id = currentToken;
            eat(currentToken);
            eat(")");
            eat(";");
            return new Readln(id);
        }
        else if (currentToken.equals("PROCEDURE"))
        {
            eat("PROCEDURE");
            String id = currentToken;
            eat(currentToken);
            eat("(");
            List<String> parids = new ArrayList<String>();
            while (!currentToken.equals(")"))
            {
                parids.add(currentToken);
                eat(currentToken);
                if (currentToken.equals(","))
                    eat(",");
            }
            eat(")");
            eat(";");
            Statement stmt = parseStatement();
            return new ProcedureDeclaration(id, parids, stmt);
        }
        else
        {
            String id = currentToken;
            eat(currentToken);
            if (currentToken.equals("("))
            {
                eat("(");
                List<Expression> params = new ArrayList<Expression>();
                while (!currentToken.equals(")"))
                {
                    params.add(parseExpression());
                    if (currentToken.equals(","))
                        eat(",");
                }
                eat(")");
                return new Assignment("", new ProcedureCall(id, params));
            }
            else
            {
                eat(":=");
                Expression exp = parseExpression();
                eat(";");
                return new Assignment(id, exp);
            }
        }


    }

    /**
     * parseFactor parses an Integer using parseNumber after determining its value as
     * negative or positive by checking the current Token.
     *
     * @return the value of the parsed factor
     * @throws ScanErrorException
     */
    private Expression parseFactor() throws ScanErrorException
    {

        if (currentToken.equals("-"))
        {
            eat("-");
            return new BinOp("*", new ast.Number(-1), parseFactor());
        }
        else if (currentToken.equals("("))
        {
            eat("(");
            Expression val = parseExpression();
            eat(")");
            return val;
        }
        try
        {
            return parseNumber();
        }
        catch (NumberFormatException e)
        {
            String id = currentToken;
            eat(currentToken);
            if (currentToken.equals("("))
            {
                eat("(");
                List<Expression> pars = new ArrayList<Expression>();
                while (!currentToken.equals(")"))
                {
                    pars.add(parseExpression());
                    if (currentToken.equals(","))
                        eat(",");
                }
                eat(")");
                return new ProcedureCall(id, pars);
            }
            return new Variable(id);
        }

    }

    /**
     * parseTerm calculates a term by parsing any multiplication or division and
     * then calling parseFactor on any Factors.
     *
     * @return the parsedTerm
     * @throws ScanErrorException
     */
    private Expression parseTerm() throws ScanErrorException
    {
        Expression exp = parseFactor();
        while (currentToken.equals("*") || currentToken.equals("/"))
        {

            if (currentToken.equals("/"))
            {
                eat("/");
                exp = new BinOp("/", exp, parseFactor());
            }
            else
            {
                eat("*");
                exp = new BinOp("*", exp, parseFactor());
            }

        }

        return exp;
    }

    /**
     * parseExpression calculates an expression by evaluating subtraction
     * and addition after calling parseTerm to evaluate all Terms.
     *
     * @return the evaluated expression
     * @throws ScanErrorException
     */
    public Expression parseExpression() throws ScanErrorException
    {

        Expression exp = parseTerm();
        while (currentToken.equals("+") || currentToken.equals("-")) {

            if (currentToken.equals("+")) {
                eat("+");
                exp = new BinOp("+", exp, parseTerm());
            }
            else {
                eat("-");
                exp = new BinOp("-", exp, parseTerm());
            }

        }
        return exp;
    }
    /**
     * hasNext returns whether there is a next char based off of the instance
     * variable eof.
     *
     * @return true if scanner.Scanner has a next char; otherwise,
     *         false
     */
    public boolean hasNext()
    {
        return scanny.hasNext();
    }
    /**
     * parses a Conditional
     *
     * @return an Expression containing condition
     */
    private Expression parseConditional() throws ScanErrorException {
        Expression exp1 = parseExpression();
        String op = currentToken;
        eat(currentToken);
        Expression exp2 = parseExpression();
        return new Condition(op, exp1, exp2);
    }
    /**
     * Parses a whole program
     *
     * @return a list of Statements as the parse of the
     * full file/text
     */
    public Program parseProgram() throws ScanErrorException {
        List<Statement> procedures = new ArrayList<Statement>();
        List<String> var = new ArrayList<String>();
        while (currentToken.equals("VAR"))
            if (currentToken.equals("VAR"))
            {
                eat(currentToken);
                while (!currentToken.equals(";"))
                {
                    var.add(currentToken);
                    eat(currentToken);
                    if (currentToken.equals(","))
                        eat(",");
                }
                eat(currentToken);
            }
        while(currentToken.equals("PROCEDURE"))
            procedures.add(parseStatement());
        Statement main = parseStatement();
        return new Program(procedures, main, var);
    }

}



