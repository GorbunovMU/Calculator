package com.luxoft.calculator.utils;

import java.util.ArrayList;
import java.util.List;

import com.luxoft.calculator.listener.CalculationChangeListener;
import com.luxoft.calculator.model.CalculatorModel;

public class CalculatorObserver {
	private static CalculatorObserver instance = null;
	private List<CalculationChangeListener> observers;
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

	public void registerObserver(CalculationChangeListener o) {
		observers.add(o);
		
	}

	public void removeObserver(CalculationChangeListener o) {
		observers.remove(o);
		
	}

	public void notifyObservers(CalculatorModel calculatorModel) {
		
		for (CalculationChangeListener observer : observers) {
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
