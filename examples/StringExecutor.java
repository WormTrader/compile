package com.wormtrader.compile;

// StringExecutor.java
// Andrew Davison, August 2007, ad@fivedots.coe.psu.ac.th

/* Compile and load a string representing a class, and then
   call it's main() function with a single argument.
   Uses janino's SimpleCompiler which compiles a single 
   "compilation unit" (i.e. the equivalent of the contents
   of a ".java" file).
*/
import java.io.*;
import java.lang.reflect.*;
import org.codehaus.janino.*;

public class StringExecutor
	{
	private static final String CLASS_NAME = "Foo";

	public static void compileRun(String aProgram)
		throws Exception
		{
		String codeStr = ""
			+ "import com.shanebow.ui.SBDialog;"
			+ "import com.wormtrader.bars.Bar;"
			+ "import com.wormtrader.history.Tape;"
			+ "public class " + CLASS_NAME + " {"
			+ "public static void someMethod(String arg){"
			+ "System.out.println(\"Hello Rick\");"
			+ "SBDialog.confirm(arg);"
			+ aProgram
			+ "}}";

		SimpleCompiler compiler = new SimpleCompiler();
		compiler.cook( new StringReader(codeStr) );

		// get the loaded class
		Class<?> cl = compiler.getClassLoader().loadClass(CLASS_NAME);

		// Invoke the "public static main(String[])" method
//		Method meth = cl.getMethod("main", new Class[] { String[].class });
//		String[] methArgs = new String[] { aProgram };  // contains one input argument
//		meth.invoke(null, new Object[] { methArgs });
		Method meth = cl.getMethod("someMethod", new Class[] { String.class });
		meth.invoke(null, new Object[] { "an arg to someMethod" });
		}
	}
