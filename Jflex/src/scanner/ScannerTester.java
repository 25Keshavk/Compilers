package scanner;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * A tester for the Scanner class. Tests include unidentified characters,
 * single line comments, numbers, operators, identifiers, and
 * whitespaces.
 *
 * @author Keshav Kotamraju
 * @version 27 January 2024
 */
public class ScannerTester
{
    /**
     * Method: main
     *
     * @param args information from the command line
     */
    public static void main(String[] args) throws IOException {
        Reader reader1 = new FileReader("out.txt");
        Scanner sc = new Scanner(reader1);
        while (!sc.yyatEOF()) {
            System.out.println(sc.nextToken());
        }
    }}

