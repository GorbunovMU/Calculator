package com.luxoft.calculator.utils;

public class Converter {
	public static double toDouble(String numberString) throws NumberFormatException {
		
		return Double.valueOf(numberString.trim()).doubleValue();
		
	}
}
