package com.luxoft.calculator.utils;

import java.util.ArrayList;
import java.util.List;

import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.ui.Observer;

public class CalculatorObserver implements Observable {
	private static CalculatorObserver instance = null;
	private List<Observer> observers;
	private boolean needSaveToHistory;
	
	private CalculatorObserver() {
		observers = new ArrayList<>();
		needSaveToHistory = false;
	}
	
	public static CalculatorObserver getInstance() {
		
		if (instance == null) {
			instance = new CalculatorObserver();
		}
		
		return instance;
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers(CalculatorModel calculatorModel) {
		
		for (Observer observer : observers) {
			observer.update(calculatorModel);
		}
		
		needSaveToHistory = false;
	}

	public boolean isNeedSaveToHistory() {
		return needSaveToHistory;
	}

	public void setNeedSaveToHistory(boolean needSaveToHistory) {
		this.needSaveToHistory = needSaveToHistory;
	}

	
}
