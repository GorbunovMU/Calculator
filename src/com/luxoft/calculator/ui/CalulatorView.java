package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

import com.luxoft.calculator.manager.CalculatorTabViewUIMgr;
import com.luxoft.calculator.model.CalculatorModel;

public class CalulatorView {
	
	private static final String APPLICATION_NAME = "SWT Calculator";
	private static final int START_WIDTH  = 500;
	private static final int START_HEIGHT = 500;

	
	private static final String ITEM_CALCULATOR_NAME = "Calculator";
	private static final String ITEM_HISTORY_NAME = "History";
	
	
	private Display display;
	private Shell shell;
	private TabFolder folder;
	private CalculatorComposite calculatorComposite;
	private HistoryComposite historyComposite;
	
	private CalculatorModel calculatorModel;
	
//	private CalculatorTabViewUIMgr mgr;
	
	public CalulatorView(CalculatorModel calculatorModel) {
		this.calculatorModel  = calculatorModel; 
		
		display = new Display();
		
		shell = new Shell(display);
		shell.setText(APPLICATION_NAME);
		shell.setSize(START_WIDTH, START_HEIGHT);
		shell.setLayout(new FillLayout());
		folder = new TabFolder(shell, SWT.NONE);
		
		
		historyComposite = new HistoryComposite(folder, SWT.NONE);
		calculatorModel.registerObserver(historyComposite);
		
		calculatorComposite = new CalculatorComposite(folder, SWT.NONE);
		
		calculatorModel.registerObserver(calculatorComposite);
		
	}
	
//	private void initUIManager() {
//		mgr = new CalculatorTabViewUIMgr();
//		mgr.createView(folder);
//	}

	
	private void createCalculatorTabItem() {
		TabItem tabItem = new TabItem(folder, SWT.NONE);
		tabItem.setText(ITEM_CALCULATOR_NAME);
		tabItem.setControl(calculatorComposite);
	}
	
	private void createHisoryTabItem() {
		TabItem tabItem = new TabItem(folder, SWT.NONE);
		tabItem.setText(ITEM_HISTORY_NAME);
		tabItem.setControl(historyComposite);
	}
	
	
	public void start() {
		createCalculatorTabItem();
		createHisoryTabItem();
		
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
