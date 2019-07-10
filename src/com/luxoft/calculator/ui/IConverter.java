package com.luxoft.calculator.ui;

import com.luxoft.calculator.model.ExpressionOfNumbers;

public interface IConverter {
	ExpressionOfNumbers convertToModel();
	void convertToView(ExpressionOfNumbers expressionOfNumbers);
}
