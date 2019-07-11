package com.luxoft.calculator.model;

import com.luxoft.calculator.service.Operations;

public class CalculatorModel {
	
	private double numberOne;
	private double numberTwo;
	private String result;
	private Operations operation;

	public CalculatorModel() {
		numberOne = 0;
		numberTwo = 0;
		result = "";
		operation = Operations.UNKNOWN;
	}

	public CalculatorModel(double numberOne, double numberTwo, String result, Operations operation) {
		super();
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
		this.result = result;
		this.operation = operation;
	}

	public double getNumberOne() {
		return numberOne;
	}

	public void setNumberOne(double numberOne) {
		this.numberOne = numberOne;
	}

	public double getNumberTwo() {
		return numberTwo;
	}

	public void setNumberTwo(double numberTwo) {
		this.numberTwo = numberTwo;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Operations getOperation() {
		return operation;
	}

	public void setOperation(Operations operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return numberOne + " " + operation.getStringValue() + " " + numberTwo + " = " + result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(numberOne);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(numberTwo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalculatorModel other = (CalculatorModel) obj;
		if (Double.doubleToLongBits(numberOne) != Double.doubleToLongBits(other.numberOne))
			return false;
		if (Double.doubleToLongBits(numberTwo) != Double.doubleToLongBits(other.numberTwo))
			return false;
		if (operation != other.operation)
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
			return false;
		return true;
	}

	
}
