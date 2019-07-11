package com.luxoft.calculator.manager;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;

import com.luxoft.calculator.listener.ModifyValuesListener;
import com.luxoft.calculator.listener.VerifyEditNumbersLisener;
import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.ui.CalculatorComposite;
import com.luxoft.calculator.ui.HistoryComposite;
import com.luxoft.calculator.utils.IConverter;
import com.luxoft.calculator.utils.Observer;

public class CalculatorTabViewUIMgr implements Observer {
	
	private IConverter converter;
	
	private CalculatorComposite calculatorComposite;
	private HistoryComposite historyComposite;
	
	private VerifyEditNumbersLisener verifyEditNumbersLisener;
	private ModifyValuesListener modifyValuesListener;

	private static CalculatorTabViewUIMgr calculatorUIManager;
	
	private static final Map<String, Composite> map = new HashMap<>();
	
	private CalculatorTabViewUIMgr() {
		// TODO Auto-generated constructor stub
		CalculatorModel model = CalculatorModel.getInstance();
		model.registerObserver(this);
	}
	
	public void createView(TabFolder folder, String name) {
		
		map.put("CalculatorView", calculatorComposite);
//		map.put("HistoryView", historyComposite);
		
	}
	
	public void setConverter(IConverter converter) {
		this.converter = converter;
	}
	
	public VerifyEditNumbersLisener getVerifyEditNumbersLisener() {
		return verifyEditNumbersLisener;
	}
	public ModifyValuesListener getModifyValuesListener() {
		return modifyValuesListener;
	}

	@Override
	public void update(Map param) {
		// TODO Auto-generated method stub
		updateCalcResult(result);
		updateHistory();
	}
	
	private void updateCalcResult(String result) {
		
	}
	
    private void updateHistory() {
		
	}
	
	
	
	

}
