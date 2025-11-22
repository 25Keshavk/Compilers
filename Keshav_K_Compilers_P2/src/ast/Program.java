package ast;
import emitter.Emitter;


import java.util.List;

import environment.Environment;

/**
 * Program provides construction and execution
 * of a program statement.
 *
 * @author Keshav Kotamraju
 * @version 4/10/24
 */
public class Program
{
    List<Statement> procedures;
    Statement main;
    List<String> var;

    /**
     * Constructs a program
     *
     * @param prod the procedures in the program
     * @param main the statement to execute later
     */
    public Program(List<Statement> prod, Statement main, List<String> var)
    {
        this.procedures = procedures;
        this.main = main;
        this.var = var;
    }

    /**
     * Executes the program's procedures and statement
     *
     * @param env the environment provided
     */
    public void exec(Environment env)
    {
        for (int i = 0; i < procedures.size(); i++)
            procedures.get(i).exec(env);
        main.exec(env);
    }

    /**
     *Generates mips code for a given program and writes
     * it to a file
     */
    public void compile(String fn)
    {

        Emitter e = new Emitter(fn + ".txt");
        e.emit(".data\n" );
        for (int i = 0; i < var.size(); i++)
            e.emit( var.get(i) + ": .word 0");
        e.emit(".text\n" +
                ".globl main\n" +
                "main: #QTSPIM will automatically look for main\n");
                main.compile(e);
        e.emit("# future code will go here\n" +
                "li $v0 10\n" +
                "syscall # halt");
        e.close();
    }
}
