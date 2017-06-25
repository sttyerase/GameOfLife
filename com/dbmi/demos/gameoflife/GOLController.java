package com.dbmi.demos.gameoflife;

import java.awt.event.*;

public class GOLController implements ActionListener{
   private GOLModel theModel = null;
   private GOLView  theView  = null;

   GOLController(GOLModel aModel, GOLView aView){
      this.theModel = aModel;
      this.theView  = aView;
      theView.getStepButton().addActionListener(this);
      theView.getStepMenuItem().addActionListener(this);
      theView.getClearButton().addActionListener(this);
      theView.getClearMenuItem().addActionListener(this);
      theView.getExitMenuItem().addActionListener(this);
      theView.getStartButton().addActionListener(this);
      theView.getBoardSizeControl().addActionListener(this);
   } // CONSTRUCTOR(GOLMODEL,GOLVIEW)

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == theView.getStepButton() || e.getSource() == theView.getStepMenuItem()) {
         theModel.nextGen();
      }
      else if (e.getSource() == theView.getClearButton() || e.getSource() == theView.getClearMenuItem()) {
         theModel.clearBoard();
      }
      else if (e.getSource() == theView.getStartButton()){
         theModel.setYesRun(true);
         theModel.runBoard();
      }
      else if (e.getSource() == theView.getInitMenuItem()){
    	  theModel.initBoard();
       }
      else if (e.getSource() == theView.getBoardSizeControl()){
         theModel.setGameBoard(theModel.newBoard(Integer.parseInt(theView.getBoardSizeControl().getSelectedItem().toString())));
        }
      else if (e.getSource() == theView.getExitMenuItem()) {
         theView.dispose();
         System.exit(0);
      } // IF-ELSE-IF
   } // ACTIONPERFORMED(ACTIONEVENT)

} // CLASS
