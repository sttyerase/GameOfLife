package com.dbmi.demos.gameoflife;

import java.applet.*;
import java.awt.*;

public class GameoflifeApplet extends Applet implements java.awt.event.ActionListener {
	/**
    * 
    */
   private static final long serialVersionUID = 1L;
   private Panel ivjContentsPane = null;
	private GBoard ivjGBoard1 = null;
	private Button ivjstartButton = null;
	private Button ivjstepButton = null;
	private Button ivjstopButton = null;
	private Button ivjclearButton = null;

public GameoflifeApplet() {   // CONSTRUCTOR
	super();
	initialize();
}

public void actionPerformed(java.awt.event.ActionEvent e) {
	if ((e.getSource() == getstepButton()) ) {
		connEtoM1(e);
	}
	if ((e.getSource() == getclearButton()) ) {
		connEtoC3(e);
	}
}

private void connEtoM1(java.awt.event.ActionEvent arg1) {
	try {
		getGBoard1().nexGen();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
}

private void connEtoC3(java.awt.event.ActionEvent arg1) {
	try {
		this.clearButton_ActionPerformed(arg1);
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
}

public void clearButton_ActionPerformed(java.awt.event.ActionEvent actionEvent) {
        ivjGBoard1.clearBoard();
	return;
}

private Panel getContentsPane() {
	if (ivjContentsPane == null) {
		try {
			ivjContentsPane = new java.awt.Panel();
			ivjContentsPane.setName("ContentsPane");
			ivjContentsPane.setLayout(null);
			getContentsPane().add(getstepButton(), getstepButton().getName());
			getContentsPane().add(getclearButton(), getclearButton().getName());
			getContentsPane().add(getGBoard1().getPanel(), getGBoard1().getPanel().getName());
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	};
	return ivjContentsPane;
}

private Button getclearButton() {
	if (ivjclearButton == null) {
		try {
			ivjclearButton = new java.awt.Button();
			ivjclearButton.setName("clearButton");
			ivjclearButton.setBounds(132, 340, 56, 23);
			ivjclearButton.setLabel("Clear");
			ivjclearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	};
	return ivjclearButton;
}

private GBoard getGBoard1() {
	if (ivjGBoard1 == null) {
		try {
			ivjGBoard1 = new GBoard();
			ivjGBoard1.getPanel().setName("GBoard1");
			ivjGBoard1.getPanel().setBounds(48, 19, 318, 299);
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	};
	return ivjGBoard1;
}

@SuppressWarnings("unused")
private Button getstartButton() {
	if (ivjstartButton == null) {
		try {
			ivjstartButton = new java.awt.Button();
			ivjstartButton.setName("startButton");
			ivjstartButton.setBounds(132, 340, 56, 23);
			ivjstartButton.setLabel("Start");
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	};
	return ivjstartButton;
}

private Button getstepButton() {
	if (ivjstepButton == null) {
		try {
			ivjstepButton = new java.awt.Button();
			ivjstepButton.setName("stepButton");
			ivjstepButton.setBackground(java.awt.Color.lightGray);
			ivjstepButton.setBounds(50, 339, 56, 23);
			ivjstepButton.setLabel("Step");
			ivjstepButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	};
	return ivjstepButton;
}

@SuppressWarnings("unused")
private Button getstopButton() {
	if (ivjstopButton == null) {
		try {
			ivjstopButton = new java.awt.Button();
			ivjstopButton.setName("stopButton");
			ivjstopButton.setBounds(226, 340, 56, 23);
			ivjstopButton.setLabel("Stop");
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
	};
	return ivjstopButton;
}

private void handleException(Throwable exception) {

	/* Uncomment the following lines to print uncaught exceptions to stdout */
	// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
	// exception.printStackTrace(System.out);
}

private void initConnections() {
	// user code begin {1}
	// user code end
	getstepButton().addActionListener(this);
	getclearButton().addActionListener(this);
}

private void initialize() {
	// user code begin {1}
	// user code end
	setName("GameoflifeApplet");
	setLayout(new java.awt.BorderLayout());
	setSize(426, 417);
	add(getContentsPane(), "Center");
	initConnections();
	// user code begin {2}
	// user code end
}
/**
 * main entry point - starts the part when it is run as an application
 * 
 */
public void init() {
	try {
		GameoflifeApplet aGameoflife;
		aGameoflife = new GameoflifeApplet();
//		try {
//			Class aCloserClass = Class.forName("com.ibm.uvm.abt.edit.WindowCloser");
//			Class parmTypes[] = { java.awt.Window.class };
//			Object parms[] = { aGameoflife };
//			java.lang.reflect.Constructor aCtor = aCloserClass.getConstructor(parmTypes);
//			aCtor.newInstance(parms);
//		} catch (java.lang.Throwable exc) {};
		aGameoflife.setVisible(true);
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of java.awt.Frame");
		exception.printStackTrace(System.out);
	}
} // main()
} // GameoflifeApplet.class
