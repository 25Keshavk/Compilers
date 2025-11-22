package parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import ast.Program;
import environment.Environment;
import scanner.ScanErrorException;
import scanner.Scanner;

/**
 * Tests the Parser Class
 * @author Keshav Kotamraju
 * @version 3/21/24
 */

public class ParserTester {
    public static void main(String[] args) throws ScanErrorException, FileNotFoundException {
        try
        {
            Parser paras = new Parser(new Scanner(new FileInputStream("parserTest8.txt")));
            paras.parseProgram().compile("mipsfile.asm");
           /** Environment env = new Environment();
            while (paras.hasNext())
                paras.parseStatement().exec(env);
            */
        }
        catch (FileNotFoundException  | ScanErrorException e2)
        {
            e2.printStackTrace();
        }

    }
}
