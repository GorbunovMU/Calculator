package com.luxoft.calculator.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.luxoft.calculator.model.CalculatorModel;

public class SubtractionCalculationTest {

	private CalculatorModel expressionOfNumbers;
	private SubtractionCalculation calculation;
	
	@Before
	public void setUp() {
		calculation = new SubtractionCalculation();
		expressionOfNumbers = new CalculatorModel();
		expressionOfNumbers.setNumberOne(1.0);
		expressionOfNumbers.setNumberTwo(2.0);
		expressionOfNumbers.setResult(Double.toString(-1.0));
	}


	@Test
	public void testCalculateSubtraction() {
		CalculatorModel expected = expressionOfNumbers;
		CalculatorModel actual = new CalculatorModel();
		actual.setNumberOne(expressionOfNumbers.getNumberOne());
		actual.setNumberTwo(expressionOfNumbers.getNumberTwo());
		calculation.calculate(actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateSubtractionFaulty() {
		CalculatorModel expected = expressionOfNumbers;
		CalculatorModel actual = new CalculatorModel();
		actual.setNumberOne(expressionOfNumbers.getNumberOne() + 1.0);
		actual.setNumberTwo(expressionOfNumbers.getNumberTwo());
		calculation.calculate(actual);
		
		assertFalse(actual.equals(expected));
	}

}
