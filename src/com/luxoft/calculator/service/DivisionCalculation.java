package com.luxoft.calculator.service;

import com.luxoft.calculator.model.CalculatorModel;

public class DivisionCalculation implements ICalculate{
	@Override
	public void calculate(CalculatorModel expression) {
		if (expression.getNumberTwo() == 0.0) {
			expression.setResult("Error");
		} else {
		Double res = expression.getNumberOne() / expression.getNumberTwo();
		expression.setResult(res.toString());
		}
	}
}
