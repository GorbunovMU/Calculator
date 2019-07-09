package com.luxoft.calculator.model;

import java.util.ArrayList;
import java.util.List;

public class ListOfExpressions {
	private List<ExpressionOfNumbers> expressionOfNumbersList;
	
	public ListOfExpressions() {
		expressionOfNumbersList = new ArrayList<ExpressionOfNumbers>();
	}
	
	
	public boolean addToList (ExpressionOfNumbers expressionOfNumbers) {
		return expressionOfNumbersList.add(expressionOfNumbers);
	}


	public List<ExpressionOfNumbers> getExpressionOfNumbersList() {
		return expressionOfNumbersList;
	}


	public void setExpressionOfNumbersList(List<ExpressionOfNumbers> expressionOfNumbersList) {
		this.expressionOfNumbersList = expressionOfNumbersList;
	}
	

	public ExpressionOfNumbers getCurrent() {
		return expressionOfNumbersList.get(expressionOfNumbersList.size() - 1);
	}
	
}
