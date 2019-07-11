package com.luxoft.calculator.model;

import com.luxoft.calculator.utils.Observer;

public interface Observable {
	void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
