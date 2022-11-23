package com.wormtrader.compile;
// Painter.java

/* This program draws black dots into a panel.

   The coding is okay so long as the window is not hidden by
   another, and then redisplayed. In that case, the
   drawing area may become 'scrambled'.

   The solution is a more complicated data structure in the
   program that 'remembers' the old dots so they can all be
   redrawn correctly when necessary.

   We will do that in the 'Graphics' part of the notes.
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Painter extends JFrame 
{
   public Painter()
   {
      super( "A simple paint program" );

	  Container c = getContentPane();

	  c.add( new PaintPanel(), "Center");
	  c.add( new Label( "Drag the mouse to draw" ),
								BorderLayout.SOUTH );

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize( 300, 150 );  
      show();   
   }

   public static void main( String args[] )
   {  new Painter();  }
} // end of Painter


class PaintPanel extends JPanel 
{
  private int xCoord = -1;
  private int yCoord = -1;

  public PaintPanel()
  {
	addMouseMotionListener( new MouseMotionAdapter() {
	  public void mouseDragged( MouseEvent e)
	  {  xCoord = e.getX(); yCoord = e.getY();
//	     System.out.println( xCoord + ", " + yCoord ); 
		 repaint();
	  }
	} );
  } // end of PaintPanel()

  public void paintComponent(Graphics g)
  {
    g.fillOval( xCoord, yCoord, 4, 4 );
  }

} // end of PaintPanel
