package com.luxoft.calculator.app;

import com.luxoft.calculator.model.ExpressionOfNumbers;
import com.luxoft.calculator.service.Calculation;
import com.luxoft.calculator.ui.CalulatorView;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculation calculation = new Calculation();
		ExpressionOfNumbers expressionOfNumbers = new ExpressionOfNumbers();
		
		CalulatorView calulatorView = new CalulatorView(calculation, expressionOfNumbers);
		calulatorView.start();

	}

}
