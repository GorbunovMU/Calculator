package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import com.luxoft.calculator.model.CalculatorModel;

public class HistoryComposite extends Composite implements IHistoric {
	
	private List historyList;

	public HistoryComposite(Composite parent, int style) {
		super(parent, style);
		init();
	}
	
	private void init() {
		setLayout(new FillLayout());
		historyList = new List(this, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
	}

	@Override
	public void addExpressionToHistory(CalculatorModel expressionOfNumbers) {
		historyList.add(expressionOfNumbers.toString());
		
	}
	
}
