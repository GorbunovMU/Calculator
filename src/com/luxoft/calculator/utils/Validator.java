package com.luxoft.calculator.utils;

public class Validator {
	public static boolean isNumberValid(String numberText) {
		
		if (numberText.isEmpty()) {
			return true;
		}
		
		try {
			Double.valueOf(numberText.trim());
		} catch (NumberFormatException e) {
			return false;
		}
		
		return true;
	}
	
}
