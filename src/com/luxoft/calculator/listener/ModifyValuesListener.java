package com.luxoft.calculator.listener;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.service.Calculation;
import com.luxoft.calculator.utils.IConverter;


public class ModifyValuesListener implements ModifyListener {
	private boolean calculateOnFly;
	private IConverter converter;
	
	public ModifyValuesListener(IConverter converter) {
		calculateOnFly = false;
		this.converter = converter;
	}
	
	public void setCalculateOnFly(boolean calculateOnFly) {
		this.calculateOnFly = calculateOnFly;
		if (calculateOnFly) {
			recalculate();
		}
	}
	
	
	private void recalculate() {
		if (calculateOnFly) {
			CalculatorModel calculatorModel = converter.convertToModel(); 
			Calculation.getCalculationByOperation(calculatorModel.getOperation()).calculate(calculatorModel);
//			converter.convertToView(calculatorModel);
			
		}
		
	}
	
	@Override
	public void modifyText(ModifyEvent e) {
		recalculate();
	}
}
