package com.luxoft.calculator.utils;

public enum Operations {
	ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, UNKNOWN;
	
	public static Operations getOperationByString(String operationString) {
		operationString = operationString.trim();
		if (operationString.equals("+")) {
			return ADDITION;
		} else if (operationString.equals("-")) {
			return SUBTRACTION;
		} else {
			return UNKNOWN;
		}
	}
	
}
