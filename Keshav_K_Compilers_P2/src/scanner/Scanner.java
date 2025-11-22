package scanner;
import java.io.*;
/**
 * Scanner is a simple scanner for Compilers and Interpreters (2014-2015) lab exercise 1
 * A scanner.Scanner is instantiated with a user inputted string and contains
 * three instance variables: eof for end of file, in for the input stream,
 * and currentChar for the value one character ahead of the token. The input scanner
 * is responsible for reading the input string and producing a string of tokens. Using
 * the next token method, scanner can provide tokens one by one until it reaches
 * the end of the file.
 * @author Keshav Kotamraju
 * @version 23 January 2024
 *
 * Notebook entry:
 * scanner.Scanner Lab Hints
 * The parameter that you would pass to eat would
 * be the char that you expect to get.
 * Using eat like this is useful as now we
 * do not have to use another try-catch function to
 * check for the possibility of an IOException when using in.read();
 *
 *
 * scanner.Scanner Lab notebook:
 * If the next character is an open parenthesis or a new line,
 * we can conclude that we have found the keyword “IF” since
 * an if statement begins with "if (condition)" and can have
 * whitespace (a new line) between it.
 *
 *
 * Usage:
 * scanner.Scanner scan = new scanner.Scanner("hello, type string here");
 *
 */
public class Scanner
{
    private BufferedReader in;
    private char currentChar;
    private boolean eof;
    /**
     * scanner.Scanner constructor for construction of a scanner that
     * uses an InputStream object for input.
     * Usage:
     * FileInputStream inStream = new FileInputStream(new File(<file name>);
     * scanner.Scanner lex = new scanner.Scanner(inStream);
     * @param inStream the input stream to use
     */
    public Scanner(InputStream inStream)
    {
        in = new BufferedReader(new InputStreamReader(inStream));
        eof = false;
        getNextChar();
    }
    /**
     * scanner.Scanner constructor for constructing a scanner that
     * scans a given input string.  It sets the end-of-file flag an then reads
     * the first character of the input string into the instance field currentChar.
     * Usage: scanner.Scanner lex = new scanner.Scanner(input_string);
     * @param inString the string to scan
     */
    public Scanner(String inString)
    {
        in = new BufferedReader(new StringReader(inString));
        eof = false;
        getNextChar();
    }
    /**
     * getNextChar sets the instance variable currentChar
     * to whatever value obtained from the input stream using
     * the read method. The method will also catch IOexceptions
     * and end execution if one arises.
     */
    private void getNextChar()
    {
        try
        {
            int next = in.read();
            if (next == -1)
                eof = true;
            else
                currentChar = (char) next;
        }
        catch(IOException e)
        {
            return;
        }

    }
    /**
     * eat is provided an expected char and if the expected is the same char then
     * eat will move on to the next char. Otherwise, eat will throw an error
     * since the expected and current char are not the same.
     *
     * @param expected the expected char
     */

    private void eat(char expected) throws ScanErrorException
    {

        if (expected == currentChar)
            getNextChar();
        else
            throw new ScanErrorException("Illegal character - expected" +
                    currentChar + "and found" + expected);
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
        return !eof;
    }
    /**
     * nextToken skips any beginning whitespace and then stores the value of currentChar,
     * looping through the currentChar until it either reaches the
     * end of the file or there is a whitespace. After, if the next char is
     * not a digit, letter, or operator, it will print unidentified character;
     * The method also returns the value "EOF" if the input stream is at the
     * end of the file. The method also skips comments.
     *
     * @return a String representing the lexeme found.
     */
    public String nextToken() throws ScanErrorException
    {
        if (!hasNext())
            return "EOF";
        while (hasNext() && isWhiteSpace(currentChar))
        {
            eat(currentChar);
        }
        if (currentChar == '/')
        {
            char temp = currentChar;
            eat(currentChar);
            if (currentChar == '/' && hasNext())
            {
                scanComment();
            }
            else
                return temp + "";

        }
        while (hasNext() && isWhiteSpace(currentChar))
        {
            eat(currentChar);
        }
        if (!hasNext())
            return "EOF";
        if(isDigit(currentChar))
            return scanNumber();
        if(isLetter(currentChar))
            return scanIdentifier();
        if(isOperand(currentChar))
            return scanOperand();
        if (!hasNext())
            return "EOF";
        char err = currentChar;
        if (err == '.')
        {
            eof = true;
            return "EOF";
        }
        else
        {
            eat(currentChar);
            throw new ScanErrorException("Unidentified character:" + err);
        }
    }
    /**
     * Checks if the char is a digit
     *
     * @param c the character being tested
     * @return true if c is a digit; otherwise,
     *         false
     */
    public static boolean isDigit(char c)
    {
        return (c >= '0' && c <= '9');
    }
    /**
     * Checks if the char is a letter
     *
     * @param c the character being tested
     * @return true if c is a letter; otherwise,
     *         false
     */
    public static boolean isLetter(char c)
    {
        return (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z');
    }
    /**
     * Checks if the char is a whitespace (//)
     *
     * @param c the character being tested
     * @return true if c is a whitespace; otherwise,
     *         false
     */
    public static boolean isWhiteSpace(char c)
    {
        return (c == ' ' || c == '\r'
                || c == '\n' || c == '\t' );
    }

    /**
     * Checks if the char is an operator
     *
     * @param c the character being tested
     * @return true if c is an operator; otherwise,
     *         false
     */
    public static boolean isOperand(char c)
    {
        return (c == '=' || c == '+' || c == '-' || c == '*'
                || c == '/' || c == '%' || c == '(' || c == ')'
                || c == '<' || c == '>' || c == ':' || c == ';'|| c == ',');
    }
    /**
     * scanComment loops through a comment till it reaches a new line.
     *
     */
    public void scanComment() throws ScanErrorException
    {
        while (currentChar != '\n')
        {
            eat(currentChar);
        }
    }

    /**
     * scanNumber creates and returns a String consisting of
     * digits, stopping when the next char is not a digit.
     *
     * @return String representation of scanned number
     */
    public String scanNumber() throws ScanErrorException
    {
        String tot = "";
        while (isDigit(currentChar))
        {
            tot += currentChar;
            eat(currentChar);
        }
        return tot;
    }
    /**
     * scanNumber creates and returns a String consisting of
     * identifiers, stopping when the next char is not an identifier.
     *
     * @return String representation of scanned number
     */
    public String scanIdentifier() throws ScanErrorException
    {
        String tot = "";
        if (isLetter(currentChar))
        {
            while (isLetter(currentChar) || isDigit(currentChar))
            {
                tot += currentChar;
                eat(currentChar);
            }

        }
        return tot;
    }

    /**
     * scanNumber creates and returns a String consisting of
     * operands, stopping when the next char is not an operand.
     *
     * @return String representation of scanned number
     */
    public String scanOperand() throws ScanErrorException
    {
        String val = "";
        val += currentChar;
        eat(currentChar);
        try
        {
            in.mark(2);
        }
        catch (IOException e)
        {

        }
        if ((val + currentChar).equals("<=") || (val + currentChar).equals(">=") ||
                (val + currentChar).equals(":=") || (val + currentChar).equals("<>"))
        {
            val += currentChar;
            eat(currentChar);
            return val;
        }
        try
        {
            in.reset();
        }
        catch (IOException e)
        {

        }
        return val;
    }

}
