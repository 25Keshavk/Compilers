package scanner;

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
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(  "  $^)(@ { \r\n" + //
                "y = y % 9                       \r\n" + //
                "5 Graratgatgatgatga999 + gat t\r\n" + //
                "//hi" + '\n' + //
                "90210 + Grrrat gat\t \n" + //
                " Babababa * Brrat  \t \n" + //
                " tat da da da da\t \n" + //
                " <= >= <> :=\t \n" + //kjfasdjf
                "/eee\t \n" + //
                "    Rurururuoh     Woo  - 9 - 99       \t\n" + //
                "");
        String tok = "";
        while (!tok.equals("EOF"))
        {
            try
            {
                tok = scan.nextToken();
            }
            catch (ScanErrorException e)
            {
                System.out.println(e);
            }
            System.out.println("Token: " + tok);
        }
        System.out.println("test complete");
    }
}

