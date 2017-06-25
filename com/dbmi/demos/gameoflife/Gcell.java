package com.dbmi.demos.gameoflife;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gcell extends JButton implements ActionListener {
   private static final long serialVersionUID = 0312315235512L;
   private int               deadOrAlive;
   final int                 dead             = 0;
   final int                 alive            = 1;
   int                       xcoord, ycoord;
   Gcell                     cArray[];

   Gcell() {
      deadOrAlive = dead;
      this.setSize(5, 5);
      this.addActionListener(this);
   } // DEFAULT CONSTRUCTOR

   public int getNextState(GBoard aBoard) {
      int i, j;
      int newstate = deadOrAlive;
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
               sumnb = sumnb + aBoard.sendCellState(xn, yn);
         } // for j
      } // for i

      // TRANSITION RULES
      if (deadOrAlive == dead && sumnb == 3)
         newstate = alive;
      else if (deadOrAlive == alive && (sumnb == 2 || sumnb == 3))
         newstate = alive;
      else
         newstate = dead;

      return (newstate);

   } // getNextState()

   public int getState() {
      return (deadOrAlive);
   } // getState()

   public int setCoords(int x, int y) {
      xcoord = x;
      ycoord = y;
      return 0;
   }

   public int setState(int cs) {
      deadOrAlive = cs;
      if (deadOrAlive == alive)
         setBackground(Color.yellow);
      else
         setBackground(Color.red);
      return (deadOrAlive);
   } // SETSTATE(INT)

   public void actionPerformed(ActionEvent e) {
      if (deadOrAlive == dead)
         setState(alive);
      else
         setState(dead);
   } // ACTIONPERFORMED(ACTIONEVENT)

} // CLASS
