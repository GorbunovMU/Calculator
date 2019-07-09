package com.luxoft.calculator.service;

import java.util.EnumMap;

import com.luxoft.calculator.utils.Operations;

public class Calculation {

	private EnumMap<Operations, ICalculate> methodsOfCalculation; 
	
	public Calculation() {
		methodsOfCalculation = new EnumMap<>(Operations.class);
		methodsOfCalculation.put(Operations.ADDITION, new AdditionCalculation());
		methodsOfCalculation.put(Operations.DIVISION, new DivisionCalculation());
		methodsOfCalculation.put(Operations.MULTIPLICATION, new MultiplicationCalculation());
		methodsOfCalculation.put(Operations.SUBTRACTION, new SubtractionCalculation());
	}
	
	
	public ICalculate getCalculationByOperation(Operations operation) {
		return methodsOfCalculation.get(operation);
	}
	
	public ICalculate getCalculationByOperation(String stringOperation) {
		return methodsOfCalculation.get(Operations.getOperationByString(stringOperation));
	}

}
