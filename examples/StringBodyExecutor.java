package com.wormtrader.compile;

// StringBodyExecutor.java
// Andrew Davison, August 2007, ad@fivedots.coe.psu.ac.th

/* Compile and load a string representing a class body, and then
   call it's main() function with a single argument.
   Uses janino's ClassBodyEvaluator which compiles and loads the body 
   of a Java class.
*/


import java.io.*;
import java.lang.reflect.*;
import org.codehaus.janino.*;


public class StringBodyExecutor
{
  public static void main(String[] args) throws Exception
  {
    if (args.length < 1) {
      System.out.println("No argument supplied");
      System.exit(1);
    }

    String codeStr = 
            "public static void main(String[] args){" +
                "System.out.println(\"Hello \" + args[0]);}";

    // Compile the class body, and get the loaded class
    Class<?> cl = new ClassBodyEvaluator(codeStr).getClazz();

    // Invoke the "public static main(String[])" method
    Method mainMeth = cl.getMethod("main", new Class[] { String[].class });
    String[] methArgs = new String[] { args[0] };        // contains one input argument
    mainMeth.invoke(null, new Object[] { methArgs });
  }  // end of main()

} // end of StringBodyExecutor class
