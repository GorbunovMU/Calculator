package com.luxoft.calculator.service;

import com.luxoft.calculator.model.ExpressionOfNumbers;

public class SubtractionCalculation implements ICalculate {
	
	@Override
	public void calculate(ExpressionOfNumbers expression) {
		Double res = expression.getNumberOne() - expression.getNumberTwo();
		expression.setResult(res.toString());
		
	}

}
