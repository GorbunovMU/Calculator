package com.luxoft.calculator.app;

import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.ui.CalulatorView;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalculatorModel calculatorModel = new CalculatorModel();
		
		CalulatorView calulatorView = new CalulatorView(calculatorModel);
		calulatorView.start();

	}

}
