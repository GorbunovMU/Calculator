package com.luxoft.calculator.utils;

import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.ui.Observer;

public interface Observable {
	void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(CalculatorModel calculatorModel);
}
