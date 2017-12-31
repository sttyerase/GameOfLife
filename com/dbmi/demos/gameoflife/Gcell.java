package com.dbmi.demos.gameoflife;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gcell extends JButton implements ActionListener {
   private static final long serialVersionUID = 0312315235512L;
   private final boolean     alive              = true;
   private boolean           deadOrAlive        = false;
   int                       xcoord = 0, ycoord = 0;
   Gcell                     cArray[];

   Gcell() {
      this.setSize(5, 5);
      this.addActionListener(this);
   } // DEFAULT CONSTRUCTOR

   public boolean getNextState(GBoard aBoard) {
      int i, j;
      boolean newstate = deadOrAlive;
      int bsize = aBoard.getBsize();
      int xn = 0, yn = 0;
      int sumnb = 0;
      // get the sum of active state (live) neighbors
      for (i = xcoord - 1; i <= xcoord + 1; i++) {
         for (j = ycoord - 1; j <= ycoord + 1; j++) {
            if (i < 0 || i >= bsize) {
               if (i >= bsize)
                  xn = 0;
               else
                  xn = bsize - 1;
            } else
               xn = i;
            if (j < 0 || j >= bsize) {
               if (j >= bsize)
                  yn = 0;
               else
                  yn = bsize - 1;
            } else
               yn = j;
            // sum the neighbors (either 1 or 0)
            if (i == xcoord && j == ycoord)
               ; // do nothing - don't want self
            else
            	   if (aBoard.getCellState(xn, yn)) sumnb++;
               // sumnb = sumnb + aBoard.getCellState(xn, yn);
         } // for j
      } // for i

      // TRANSITION RULES
      if (deadOrAlive == !alive && sumnb == 3)
         newstate = alive;
      else if (deadOrAlive == alive && (sumnb == 2 || sumnb == 3))
         newstate = alive;
      else
         newstate = !alive;

      return (newstate);

   } // getNextState()

   public boolean getState() {
      return (deadOrAlive);
   } // getState()

   public int setCoords(int x, int y) {
      xcoord = x;
      ycoord = y;
      return 0;
   }

   public void setCellProperties(boolean cellState) {
	   deadOrAlive = cellState;
      if (deadOrAlive)
         setBackground(Color.yellow);
      else
         setBackground(Color.red);
      this.setVisible(true);
      this.setOpaque(true);
      if(System.getProperty("os.name").compareTo("Mac OS X") == 0)  this.setBorderPainted(false);
      // this.setBorderPainted(false);
   } // SETSTATE(INT)

   public void actionPerformed(ActionEvent e) {
      if (deadOrAlive == !alive) setCellProperties(alive);
      else setCellProperties(!alive);
   } // ACTIONPERFORMED(ACTIONEVENT)

} // CLASS
