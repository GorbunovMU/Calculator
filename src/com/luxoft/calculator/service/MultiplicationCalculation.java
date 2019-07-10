package com.luxoft.calculator.service;

import com.luxoft.calculator.model.CalculatorModel;

public class MultiplicationCalculation implements ICalculate {
	@Override
	public void calculate(CalculatorModel expression) {
		Double res = expression.getNumberOne() * expression.getNumberTwo();
		expression.setResult(res.toString());
	}
}
