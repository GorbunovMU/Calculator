package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class CalulatorView {
	
	private static final String APPLICATION_NAME     = "SWT Calculator";
	private static final int START_WIDTH  = 500;
	private static final int START_HEIGHT = 500;

	private static final String ITEM_CALCULATOR_NAME = "Calculator";
	private static final String ITEM_HISTORY_NAME    = "History";
	
	private Display display;
	private Shell shell;
	private TabFolder folder;
	private CalculatorComposite calculatorComposite;
	private HistoryComposite historyComposite;
	
	public CalulatorView() {
		createComponents();	
	}

	private void createComponents() {
		
		display = new Display();
		
		shell = new Shell(display);
		shell.setText(APPLICATION_NAME);
		shell.setSize(START_WIDTH, START_HEIGHT);
		shell.setLayout(new FillLayout());
		
		folder = new TabFolder(shell, SWT.NONE);
		
		calculatorComposite = new CalculatorComposite(folder, SWT.NONE);
		TabItem calcTabItem = new TabItem(folder, SWT.NONE);
		calcTabItem.setText(ITEM_CALCULATOR_NAME);
		calcTabItem.setControl(calculatorComposite);

		historyComposite = new HistoryComposite(folder, SWT.NONE);
		TabItem historyTabItem = new TabItem(folder, SWT.NONE);
		historyTabItem.setText(ITEM_HISTORY_NAME);
		historyTabItem.setControl(historyComposite);
	}
	
	
	public void open() {
		
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
