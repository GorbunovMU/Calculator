package com.luxoft.calculator.utils;

public enum Operations {
	ADDITION("+"), 
	SUBTRACTION("-"), 
	MULTIPLICATION("*"), 
	DIVISION("/"), 
	UNKNOWN("");
	
	
	private String stringValue;
	
	private Operations(String stringValue) {
		this.stringValue = stringValue;
	}
	
	public String getStringValue() {
		return stringValue;
	}
	
	
	public static String[] getAllStringValues() {
		StringBuilder res = new StringBuilder();
		
		for (Operations operation : Operations.values()) {
			if (operation != UNKNOWN) {
				res.append(operation.stringValue).append(";"); 
			}
		}
		return res.toString().split(";");
	}
	
	public static Operations getOperationByString(String stringOperation) {
		for (Operations operation : Operations.values()) {
			if (operation.stringValue.equals(stringOperation.trim())) {
				return operation;
			}
		}
		
		return Operations.UNKNOWN;
	}
}
