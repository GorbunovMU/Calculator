package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.utils.CalculatorObserver;

public class HistoryComposite extends Composite implements Observer {
	
	private List historyList;

	public HistoryComposite(Composite parent, int style) {
		super(parent, style);
		CalculatorObserver.getInstance().registerObserver(this);
		init();
	}
	
	private void init() {
		setLayout(new FillLayout());
		historyList = new List(this, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
	}


	@Override
	public void update(CalculatorModel calculatorModel) {
		if (CalculatorObserver.getInstance().isNeedSaveToHistory()) {
			historyList.add(calculatorModel.toString());
		}
	}
	
	
}
