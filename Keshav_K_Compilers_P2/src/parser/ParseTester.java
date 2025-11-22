package parser;

import scanner.ScanErrorException;
import scanner.Scanner;

public class ParseTester {

    /**
     * Tests the Parser using given statements by calling
     * the Parser method parseStatement.
     *
     * @param args info from the command line
     */
    public static void main(String[] args) throws ScanErrorException
    {
        Scanner scanny = new Scanner("BEGIN\n" +
                "x := 2;\n" +
                "y := x + 1;\n" +
                "x := y*(-y);\n" +
                "WRITELN(x * y);\n" +
                "END;");
        Parser paras = new Parser(scanny);
        while(scanny.hasNext())
        {
            paras.parseStatement();
            System.out.println();
        }
    }
}
