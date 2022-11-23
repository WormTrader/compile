package com.wormtrader.compile;
// Comparison.java Fig. 2.17: 

import javax.swing.JOptionPane;

public class Comparison {
   public static void main( String args[] )
   {
      String firstNumber,   // first string entered by user
             secondNumber,  // second string entered by user
             result;        // a string containing the output
      int number1,          // first number to compare
          number2;          // second number to compare

      // read first number from user as a string
      firstNumber =
         JOptionPane.showInputDialog( "Enter first integer:" );

      // read second number from user as a string
      secondNumber =
         JOptionPane.showInputDialog( "Enter second integer:" );          

      // convert numbers from type String to type int
      number1 = Integer.parseInt( firstNumber );
      number2 = Integer.parseInt( secondNumber );

      // initialize result to the empty string
      result = "";

      if ( number1 == number2 )
         result = number1 + " == " + number2;

      if ( number1 != number2 )
         result = number1 + " != " + number2;

      if ( number1 < number2 )
         result = result + "\n" + number1 + " < " + number2;

      if ( number1 > number2 )
         result = result + "\n" + number1 + " > " + number2;

      if ( number1 <= number2 )
         result = result + "\n" + number1 + " <= " + number2;

      if ( number1 >= number2 )
         result = result + "\n" + number1 + " >= " + number2;

      // Display results
      JOptionPane.showMessageDialog(
         null, result, "Comparison Results",
         JOptionPane.INFORMATION_MESSAGE );

      System.exit( 0 );
   }
}
