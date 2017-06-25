package com.dbmi.demos.gameoflife;

import java.awt.*;
import javax.swing.*;

public class GOLView extends JFrame{
   private static final long serialVersionUID = 1L;
   private GOLModel theModel = null;
   // INTERFACE COMPONENTS
   private JPanel             gBoardPanel      = new JPanel();
   private JPanel             buttonPanel      = new JPanel();
   private JPanel             controlPanel     = new JPanel();
   private GBoard             gBoard           = null;
   private JButton            startButton      = new JButton("START");
   private JButton            stepButton       = new JButton("STEP");
   private JButton            stopButton       = new JButton("STOP");
   private JButton            clearButton      = new JButton("CLEAR");
   private JTextField         counterDisplay   = new JTextField("0");
   private JComboBox<String>  boardSizeControl = new JComboBox<String>();
   // MENU COMPONENTS
   private JMenuBar           menuBar          = new JMenuBar();
   private JMenu              fileMenu         = new JMenu("File");
   private JMenu              controlMenu      = new JMenu("Controls");
   private JMenuItem          exitMenuItem     = new JMenuItem("Exit");
   private JMenuItem          stepMenuItem     = new JMenuItem("Step");
   private JMenuItem          clearMenuItem    = new JMenuItem("Clear Board");
   private JMenuItem          initMenuItem     = new JMenuItem("Initialize");

   GOLView(GOLModel aModel) {
      this.theModel = aModel;
      this.buildDisplay();
      theModel.addModelChangeListener(this);
   } // CONSTRUCTOR(20)

   private void buildDisplay() {
      this.setTitle("Game of Life");
      this.setLayout(new BorderLayout());
      gBoard = theModel.getGameBoard();
      // ADD THE GAME BOARD COMPONENTS
      this.add(gBoardPanel, BorderLayout.CENTER);
      gBoardPanel.setLayout(new BorderLayout());
      gBoardPanel.add(gBoard.getPanel(), BorderLayout.CENTER);
      // ADD THE BUTTON PANEL FOR CONTROLS
      buttonPanel.setBackground(Color.GREEN);
      buttonPanel.setSize(400, 050);
      this.add(buttonPanel, BorderLayout.SOUTH);
      buttonPanel.setLayout(new GridLayout(1,4));
      buttonPanel.add(stepButton);
      buttonPanel.add(clearButton);
      buttonPanel.add(startButton);
      buttonPanel.add(stopButton);
      // ADD OTHER DISPLAY COMPONENTS
      boardSizeControl.addItem("70");
      boardSizeControl.addItem("50");
      boardSizeControl.addItem("30");
      boardSizeControl.addItem("25");
      boardSizeControl.addItem("20");
      controlPanel.setLayout(new GridLayout(2,1));
      controlPanel.add(boardSizeControl);
      controlPanel.add(counterDisplay);
      this.add(controlPanel, BorderLayout.EAST);
      // ADD MENUS AND ITEMS
      fileMenu.add(initMenuItem);
      fileMenu.add(exitMenuItem);
      controlMenu.add(stepMenuItem);
      controlMenu.add(clearMenuItem);
      menuBar.add(fileMenu);
      menuBar.add(controlMenu);
      this.setJMenuBar(menuBar);
      // FRAME HOUSEKEEPING
      this.setBounds(new Rectangle(new Point(250,250),new Dimension(500,400)));
      this.setVisible(true);
   } // BUILDDISPLAY()

   void processModelChange(GOLModel aModel){
      this.counterDisplay.setText(Integer.toString(aModel.getGeneration()));
      this.getContentPane().repaint();
   } // PROCESSMODELCHANGE(GOLMODEL)

   // GETTERS AND SETTERS
   public JButton getStartButton() {
      return startButton;
   }

   public JButton getStepButton() {
      return stepButton;
   }

   public JButton getStopButton() {
      return stopButton;
   }

   public JButton getClearButton() {
      return clearButton;
   }

   public JMenuItem getExitMenuItem() {
      return exitMenuItem;
   }

   public JMenuItem getStepMenuItem() {
      return stepMenuItem;
   }

   public JMenuItem getClearMenuItem() {
      return clearMenuItem;
   }

   public JTextField getCounterDisplay() {
      return counterDisplay;
   }

   public JMenuItem getInitMenuItem(){
	   return initMenuItem;
   }

   public JComboBox<String> getBoardSizeControl() {
	return boardSizeControl;
}

public void setCounterDisplay(JTextField counterDisplay) {
      this.counterDisplay = counterDisplay;
   }

} // CLASS
