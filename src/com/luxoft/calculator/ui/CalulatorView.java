package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.service.Calculation;


public class CalulatorView {
	
	private static final String APPLICATION_NAME = "SWT Calculator";
	private static final int START_WIDTH = 500;
	private static final int START_HEIGHT = 500;

	
	private static final String ITEM_1_NAME = "Calculator";
	private static final String ITEM_2_NAME = "History";
	
	
//	private ListOfExpressions listOfExpressions;
	
	
	private Display display;
	private Shell shell;
	private TabFolder folder;
	private CalculatorComposite calculatorComposite;
	private HistoryComposite historyComposite;
	
	public CalulatorView(Calculation calculation, CalculatorModel expressionOfNumbers) {
		display = new Display();
		
		shell = new Shell(display);
		shell.setText(APPLICATION_NAME);
		shell.setSize(START_WIDTH, START_HEIGHT);
		shell.setLayout(new FillLayout());
		folder = new TabFolder(shell, SWT.NONE);
		
		
		historyComposite = new HistoryComposite(folder, SWT.NONE);
		calculatorComposite = new CalculatorComposite(folder, SWT.NONE, calculation,
				historyComposite, expressionOfNumbers);
		
	}

	
	private void createTabItem1() {
		TabItem tabItem = new TabItem(folder, SWT.NONE);
		tabItem.setText(ITEM_1_NAME);
		tabItem.setControl(calculatorComposite);
	}
	
	private void createTabItem2() {
		TabItem tabItem = new TabItem(folder, SWT.NONE);
		tabItem.setText(ITEM_2_NAME);
		tabItem.setControl(historyComposite);
	}
	
	
	public void start() {
		createTabItem1();
		createTabItem2();
		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}		
		display.dispose();

	}
	
}
