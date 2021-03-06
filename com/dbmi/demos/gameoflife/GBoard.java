package com.dbmi.demos.gameoflife;

import java.awt.*;

import javax.swing.*;

class GBoard {

   private final JPanel myPanel = new JPanel();
   private static final long serialVersionUID = 312315235511L;
   private final boolean     alive            = true;
   public static int         vgap             = 0;
   public static int         hgap             = 0;

   private int       boardSize = 20;
   Gcell[][]         gc;
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
            gc[i][j].setCellProperties(!alive); // INITIALIZE ALL CELLS TO DEAD (!ALIVE)
            myPanel.add(gc[i][j]);
         } // j
      } // i
      this.initBoard(); // INITIALIZE THE BOARD WITH A STANDARD SET
      myPanel.repaint();
   }

   public int getBsize() {
      return (boardSize);
   } // getBsize

   // INITIALIZE THE BOARD WITH A GLIDER AND A BLINKER
   public void initBoard() {
      clearBoard();
      gc[2][4].setCellProperties(alive);
      gc[2][5].setCellProperties(alive);
      gc[2][6].setCellProperties(alive);
      gc[7][5].setCellProperties(alive);
      gc[7][6].setCellProperties(alive);
      gc[7][7].setCellProperties(alive);
      gc[8][7].setCellProperties(alive);
      gc[9][6].setCellProperties(alive);
   } // iBoard()

   public void newBoard() {  // TODO: Create new board.
      ;
   }

   // CALCULATE AND SET THE NEXT GENERATION
   // USE A NEW  BOARD TO STORE THE RESULTS OF THE CALCULATION, THEN
   // RESET THE POSITIONS ON THE GAME BOARD USING THE NEW BOARD POSITIONS
   public void nexGen() {
      int i, j;
      boolean[][] newboard = new boolean[boardSize][boardSize];
      for (i = 0; i < boardSize; i++) {
         for (j = 0; j < boardSize; j++) {
            newboard[i][j] = gc[i][j].getNextState(this);
         } // j
      } // i
      for (i = 0; i < boardSize; i++) {
         for (j = 0; j < boardSize; j++) {
            gc[i][j].setCellProperties(newboard[i][j]);
         } // j
      } // i
   } // nexGen()

   public boolean getCellState(int x, int y) {
      return (gc[x][y].getState());
   } // sendCellState

   public void clearBoard() {
      for (int i = 0; i < boardSize; i++) {
         for (int j = 0; j < boardSize; j++) {
            gc[i][j].setCellProperties(!alive);
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
