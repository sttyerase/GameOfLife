package com.dbmi.demos.gameoflife;

import java.util.ArrayList;

public class GOLModel {
   private int bsize         =  20;
   private int generation    =  0 ;
   private GBoard gameBoard  =  null;
   private boolean yesRun    =  false;
   private ArrayList<GOLView> modelChangeListeners = new ArrayList<GOLView>();

   GOLModel(){
      this(25);
   }

   GOLModel(int boardsize){
      bsize = boardsize;
      gameBoard = newBoard(bsize);
   } // CONSTRUCTOR(INT)

   // UTILITY METHODS
   public void nextGen(){
      gameBoard.nexGen();
      generation++;
      this.fireModelChangedEvent();
   } // NEXTGEN

   public void clearBoard(){
      gameBoard.clearBoard();
      generation = 0;
      this.fireModelChangedEvent();
   } // CLEARBOARD()

   protected GBoard  newBoard(int boardsize){
	   return new GBoard(boardsize);
   }

   protected void initBoard(){
      gameBoard.initBoard();
      this.fireModelChangedEvent();
   } // INITBOARD()

   public void addModelChangeListener(GOLView view) {
      modelChangeListeners.add(view);
    }  // ADDMODELCHANGELISTENERS(GOLVIEW)

   private void fireModelChangedEvent() {
      GOLView v;
      for (int i=0; i<modelChangeListeners.size(); i++) {
        v = modelChangeListeners.get(i);
        v.processModelChange(this);
      }
    } // FIREMODELCHANGEEVENT(OBJECT)

   public synchronized void runBoard(){
      int temp = 0;  // FOR TESTING PURPOSES...REMOVE
      while(yesRun){
         this.nextGen();
         fireModelChangedEvent();
         try{
            Thread.sleep(200);
         } catch (InterruptedException ie) {
            System.out.println("Interruption caught: " + ie);
         } // TRY-CATCH
         if(temp > 21) yesRun = false; // TESTING
         temp++; // TESTING
      } // WHILE
   } // RUNBOARD()

   // GETTERS AND SETTERS
   public int getGeneration() {
      return generation;
   } // GETGENERATION()

   public void setGeneration(int generation) {
      this.generation = generation;
   } // SETGENERATION(INT)

   public GBoard getGameBoard(){
      return gameBoard;
   } // GETGAMEBOARD()

   public void setGameBoard(GBoard aBoard){
      gameBoard = aBoard;
      fireModelChangedEvent();
   }

   public int getBsize() {
	return bsize;
   }

   public boolean shouldRun() {
		return yesRun;
   } // SHOULDRUN()

   public void setYesRun(boolean yesRun) {
      this.yesRun = yesRun;
   } // SETYESRUN(BOOLEAN)

} // CLASS
