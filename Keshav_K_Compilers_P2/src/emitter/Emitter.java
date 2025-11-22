package emitter;

import java.io.*;

public class Emitter
{
	private PrintWriter out;
	int label;

	//creates an emitter for writing to a new file with given name
	public Emitter(String outputFileName)
	{
		label = 0;
		try
		{
			out = new PrintWriter(new FileWriter(outputFileName), true);
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	//prints one line of code to file (with non-labels indented)
	public void emit(String code)
	{
		if (!code.endsWith(":"))
			code = "\t" + code;
		out.println(code);
	}

	/**
	 * Generates mips code for storing multiple values using a stack
	 * @param reg the register to store the value from
	 */
	public void emitPush(String reg)
	{
		emit("subu $sp $sp 4\n #push $v0\n"  +
				"sw " + reg + ", ($sp)");
	}

	/**
	 * Generates mips code for getting values from a stack
	 * @param reg the register to store the value in
	 */
	public void emitPop(String reg)
	{
		emit("lw " + reg + ", ($sp)\n" +
		"addu $sp $sp 4");
	}
	/**
	 * Returns the next label to use
	 *
	 * @return the next label to use
	 */
	public int nextLabelID()
	{
		label++;
		return label;
	}

	//closes the file.  should be called after all calls to emit.
	public void close()
	{
		out.close();
	}
}