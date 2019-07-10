package com.luxoft.calculator.listener;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;

import com.luxoft.calculator.model.ExpressionOfNumbers;
import com.luxoft.calculator.service.Calculation;
import com.luxoft.calculator.ui.IConverter;

public class ModifyValuesListener implements ModifyListener {
	private boolean calculateOnFly;
	private IConverter converter;
	private Calculation calculation;
	
	public ModifyValuesListener(IConverter converter, Calculation calculation) {
		calculateOnFly = false;
		this.converter = converter;
		this.calculation = calculation;
	}
	
	public void setCalculateOnFly(boolean calculateOnFly) {
		this.calculateOnFly = calculateOnFly;
		if (calculateOnFly) {
			recalculate();
		}
	}
	
	
	private void recalculate() {
		if (calculateOnFly) {
			ExpressionOfNumbers expressionOfNumbers = converter.convertToModel(); 
//			System.out.println(expressionOfNumbers);
			calculation.getCalculationByOperation(expressionOfNumbers.getOperation()).calculate(expressionOfNumbers);
			converter.convertToView(expressionOfNumbers);
			
		}
		
	}
	
	@Override
	public void modifyText(ModifyEvent e) {
//		System.out.println("ModifyEvent, calculateOnFly = " + calculateOnFly);
		recalculate();
		
	}
}
