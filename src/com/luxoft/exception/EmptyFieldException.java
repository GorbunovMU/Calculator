package com.luxoft.exception;

public class EmptyFieldException extends Exception {
	
	public EmptyFieldException(String msg) {
		super(msg);
	}
	
	public EmptyFieldException() {
		super("The field is empty");
	}
}
