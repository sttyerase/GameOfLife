package com.dbmi.demos.gameoflife;

import java.awt.*;

import javax.swing.*;

class GBoard {

   private JPanel myPanel = new JPanel();
   @SuppressWarnings("unused")
   private static final long serialVersionUID = 0312315235511L;
   public static int vgap   = 0;
   public static int hgap   = 0;
   public static int on     = 1;
   public static int off    = 0;

   private int       boardSize = 20;
   Gcell             gc[][];
   GridLayout        ggrid;

   public GBoard(){
      this(20);
   } // CONSTRUCTOR(DEFAULT)

   public GBoard(int asize){
      boardSize = asize;
      gc = new Gcell[boardSize][boardSize];
      ggrid = new GridLayout(boardSize, boardSize, vgap, hgap);
      myPanel.setLayout(ggrid);
      myPanel.setBackground(Color.lightGray);
      for (int i = 0; i < boardSize; i++) {
         for (int j = 0; j < boardSize; j++) {
            gc[i][j] = new Gcell();
            gc[i][j].setCoords(i, j);
            myPanel.add(gc[i][j]);
            gc[i][j].setState(off); // INITIALIZE CELLS TO OFF
         } // j
      } // i
      this.initBoard();
      myPanel.repaint();
   }

   public int getBsize() {
      return (boardSize);
   } // getBsize

   // INITIALIZE THE BOARD WITH A GLIDER AND A BLINKER
   public void initBoard() {
      clearBoard();
      gc[2][4].setState(on);
      gc[2][5].setState(on);
      gc[2][6].setState(on);
      gc[7][5].setState(on);
      gc[7][6].setState(on);
      gc[7][7].setState(on);
      gc[8][7].setState(on);
      gc[9][6].setState(on);
   } // iBoard()

   public void newBoard() {  // TODO: Create new board.
      ;
   }

   // CALCULATE AND SET THE NEXT GENERATION
   // USE A NEW  BOARD TO STORE THE RESULTS OF THE CALCULATION, THEN
   // RESET THE POSITIONS ON THE GAME BOARD USING THE NEW BOARD POSITIONS
   public void nexGen() {
      int i, j;
      int[][] newboard = new int[boardSize][boardSize];
      for (i = 0; i < boardSize; i++) {
         for (j = 0; j < boardSize; j++) {
            newboard[i][j] = gc[i][j].getNextState(this);
         } // j
      } // i
      for (i = 0; i < boardSize; i++) {
         for (j = 0; j < boardSize; j++) {
            gc[i][j].setState(newboard[i][j]);
         } // j
      } // i
   } // nexGen()

   public int sendCellState(int x, int y) {
      return (gc[x][y].getState());
   } // sendCellState

   public void clearBoard() {
      for (int i = 0; i < boardSize; i++) {
         for (int j = 0; j < boardSize; j++) {
            gc[i][j].setState(off);
         } // j
      } // i
   } // CLEARBOARD()

   public int getBoardSize(){
      return boardSize;
   } // GETBOARDSIZE()

   public JPanel getPanel(){
      return myPanel;
   }

} // CLASS