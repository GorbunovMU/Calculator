package com.luxoft.calculator.service;

import java.util.EnumMap;

import com.luxoft.calculator.utils.Operations;

public class Calculation {

	private static EnumMap<Operations, ICalculate> methodsOfCalculation; 
	
	static {
		methodsOfCalculation = new EnumMap<>(Operations.class);
		methodsOfCalculation.put(Operations.ADDITION, new AdditionCalculation());
		methodsOfCalculation.put(Operations.DIVISION, new DivisionCalculation());
		methodsOfCalculation.put(Operations.MULTIPLICATION, new MultiplicationCalculation());
		methodsOfCalculation.put(Operations.SUBTRACTION, new SubtractionCalculation());
	}
	
	
	public static ICalculate getCalculationByOperation(Operations operation) {
		return methodsOfCalculation.get(operation);
	}
	
	public static ICalculate getCalculationByOperation(String stringOperation) {
		return methodsOfCalculation.get(Operations.getOperationByString(stringOperation));
	}

}
