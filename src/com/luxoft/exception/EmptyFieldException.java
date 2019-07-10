package com.luxoft.exception;

public class EmptyFieldException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7357241076516198461L;

	public EmptyFieldException(String msg) {
		super(msg);
	}
	
	public EmptyFieldException() {
		super("The field is empty");
	}
}
