package com.luxoft.calculator.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.luxoft.calculator.model.ExpressionOfNumbers;

public class MultiplicationCalculationTest {

	private ExpressionOfNumbers expressionOfNumbers;
	private MultiplicationCalculation calculation;
	
	@Before
	public void setUp() {
		calculation = new MultiplicationCalculation();
		expressionOfNumbers = new ExpressionOfNumbers();
		expressionOfNumbers.setNumberOne(1.0);
		expressionOfNumbers.setNumberTwo(2.0);
		expressionOfNumbers.setResult(Double.toString(2.0));
	}


	@Test
	public void testCalculateMultiplication() {
		ExpressionOfNumbers expected = expressionOfNumbers;
		ExpressionOfNumbers actual = new ExpressionOfNumbers();
		actual.setNumberOne(expressionOfNumbers.getNumberOne());
		actual.setNumberTwo(expressionOfNumbers.getNumberTwo());
		calculation.calculate(actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateMultiplicationFaulty() {
		ExpressionOfNumbers expected = expressionOfNumbers;
		ExpressionOfNumbers actual = new ExpressionOfNumbers();
		actual.setNumberOne(expressionOfNumbers.getNumberOne() + 1.0);
		actual.setNumberTwo(expressionOfNumbers.getNumberTwo());
		calculation.calculate(actual);
		
		assertFalse(actual.equals(expected));
	}

}
