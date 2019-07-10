package com.luxoft.calculator.utils;

public class Converter {
	public static double toDouble(String numberString) throws NumberFormatException {
		if (numberString.isEmpty()) {
			return 0.0;
		} else {
		return Double.valueOf(numberString.trim()).doubleValue();
		}
		
	}
		
}
