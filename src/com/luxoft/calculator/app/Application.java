package com.luxoft.calculator.app;

import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.service.Calculation;
import com.luxoft.calculator.ui.CalulatorView;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calculation calculation = new Calculation();
		CalculatorModel expressionOfNumbers = new CalculatorModel();
		
		CalulatorView calulatorView = new CalulatorView(calculation, expressionOfNumbers);
		calulatorView.start();

	}

}
