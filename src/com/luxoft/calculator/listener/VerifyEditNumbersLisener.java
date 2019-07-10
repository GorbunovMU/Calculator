package com.luxoft.calculator.listener;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.luxoft.calculator.utils.Validator;

public class VerifyEditNumbersLisener implements Listener {
	
	@Override
	public void handleEvent(Event e) {
		Text source = (Text)e.widget;
		
		String oldString = source.getText();
		String newString = oldString.substring(0, e.start) + e.text + oldString.substring(e.end);
		
		e.doit = Validator.isNumberValid(newString);
	}

}
