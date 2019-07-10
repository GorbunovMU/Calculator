package com.luxoft.calculator.ui;

import com.luxoft.calculator.model.CalculatorModel;

public interface IConverter {
	CalculatorModel convertToModel();
	void convertToView(CalculatorModel expressionOfNumbers);
}
