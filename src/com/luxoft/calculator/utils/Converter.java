package com.luxoft.calculator.utils;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import com.luxoft.calculator.model.ExpressionOfNumbers;

public class Converter {
	public static double toDouble(String numberString) throws NumberFormatException {
		if (numberString.isEmpty()) {
			return 0.0;
		} else {
		return Double.valueOf(numberString.trim()).doubleValue();
		}
		
	}
	
	
	public static ExpressionOfNumbers convert(Text numberOneText, Text numberTwoText, Combo operationCombo) {
		
		ExpressionOfNumbers expressionOfNumbers = new ExpressionOfNumbers();
		
		expressionOfNumbers.setNumberOne(Converter.toDouble(numberOneText.getText()));
		expressionOfNumbers.setNumberTwo(Converter.toDouble(numberTwoText.getText()));
		expressionOfNumbers.setOperation(Operations.getOperationByString(operationCombo.getText()));
		
		
		return expressionOfNumbers;
	}
}
