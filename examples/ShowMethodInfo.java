package com.wormtrader.compile;

// ShowMethodInfo.java
// Andrew Davison, August 2007, ad@fivedots.coe.psu.ac.th

/* Subclass janino's Traverser class to print
   class, method, and method call information about the
   supplied Java file.
*/


import java.io.*;
import org.codehaus.janino.*;
import org.codehaus.janino.util.*;


public class ShowMethodInfo extends Traverser
{
  public ShowMethodInfo(String fnm)
  {
    Java.CompilationUnit cu = null;
    try {
      // parse the file
      FileReader fr = new FileReader(fnm);
      Parser p = new Parser( new Scanner(fnm, fr) );
      cu = p.parseCompilationUnit();
      fr.close();
    } 
    catch(Exception e)
    {  System.err.println(e);  
       System.exit(1);
    }

    // traverse the parse tree
    traverseCompilationUnit(cu);
  }  // end of ShowMethodInfo()

  
  // ----------------- traversal methods ---------------------------

  public void traverseNamedClassDeclaration(Java.NamedClassDeclaration ncd)
  // print class names
  { System.out.println("\n" + ncd);
    super.traverseNamedClassDeclaration(ncd);
  }

  public void traverseConstructorDeclarator(Java.ConstructorDeclarator cd)
  // print constructor prototypes
  { System.out.println("  " + cd);
    super.traverseConstructorDeclarator(cd);
  }

  public void traverseMethodDeclarator(Java.MethodDeclarator md)
  // print method prototypes
  { System.out.println("  " + md);
    super.traverseMethodDeclarator(md);
  }

  public void traverseMethodInvocation(Java.MethodInvocation mi)
  // print method calls
  { System.out.println("   -> " + mi);
    super.traverseMethodInvocation(mi);
  }

  // ----------------------------------------------------------

  public static void main(String[] args) 
  {
    if (args.length != 1)
      System.out.println("Usage: ShowMethodInfo <java file>");
    else
      new ShowMethodInfo(args[0]);
  } // end of main()


} // end of ShowMethodInfo class
