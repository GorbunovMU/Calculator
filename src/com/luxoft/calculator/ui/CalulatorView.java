package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

import com.luxoft.calculator.model.ExpressionOfNumbers;
import com.luxoft.calculator.model.ListOfExpressions;
import com.luxoft.calculator.service.Calculation;
import com.luxoft.calculator.utils.Converter;
import com.luxoft.calculator.utils.Operations;
import com.luxoft.calculator.utils.Validator;

public class CalulatorView {
	
	private static final String APPLICATION_NAME = "SWT Calculator";
	private static final int START_WIDTH = 500;
	private static final int START_HEIGHT = 500;

	private static final String ITEM_1_NAME = "Calculator";
	private static final String ITEM_2_NAME = "History";
	
	private static final String TOOLTIP_TEXT_NUMBER_NAME = "Numbers only allowed";
	private static final int NUMBER_TEXT_LIMIT = 20;
	
	private static final String CHECK_BOX_CALCULATE_ON_FLY_NAME = "Calculate on the fly";
	private static final String BUTTON_CALCULATE_NAME = "Calculate";
	private static final String TOOLTIP_BUTTON_CALCULATE_NAME = "Disabled if calculated on a fly";
	
	private static final String RESULT_LABEL_NAME = "Result:";
	
//	private static final String [] OPERATION_NAMES = {"+", "-", "/", "*"};
	
	private ListOfExpressions listOfExpressions;
	private Calculation calculation;
	
	private Display display;
	private Shell shell;
	private TabFolder folder;
	
	private Text numberOneText;
	private Text numberTwoText;
	private Combo operationCombo;
	private Button calculateButton;
	private Button calculateOnFlyCheckBox;
	
	private Label resultLabel;
	private Text resultText;
	
	private List historyList;
	
	public CalulatorView() {
		display = new Display();
		
		shell = new Shell(display);
		shell.setText(APPLICATION_NAME);
		shell.setSize(START_WIDTH, START_HEIGHT);
		shell.setLayout(new FillLayout());
		folder = new TabFolder(shell, SWT.NONE);
		
		listOfExpressions = new ListOfExpressions();
		calculation = new Calculation();
		
	}

	
	private void recalculate(ExpressionOfNumbers expressionOfNumbers) {
		calculation.getCalculationByOperation(expressionOfNumbers.getOperation()).calculate(expressionOfNumbers);
		resultText.setText(expressionOfNumbers.getResult());
	}
	
	private void calculateButtonPressed() {
		ExpressionOfNumbers expressionOfNumbers;
		
		expressionOfNumbers = Converter.convert(numberOneText, numberTwoText, operationCombo);
		recalculate(expressionOfNumbers);
		listOfExpressions.addToList(expressionOfNumbers);
		historyList.add(expressionOfNumbers.toString());
	}
	
	private void validateNumberOneText(Event e) {
		
		String oldString = numberOneText.getText();
		String newString = oldString.substring(0, e.start) + e.text + oldString.substring(e.end);
		
		if (Validator.isNumberValid(newString)) {
			if (calculateOnFlyCheckBox.getSelection()) {
				ExpressionOfNumbers expressionOfNumbers = Converter.convert(numberOneText, numberTwoText, operationCombo); 
				expressionOfNumbers.setNumberOne(Converter.toDouble(newString));
				recalculate(expressionOfNumbers);
			}
			
		} else {
			e.doit = false;
		}
	}
	

	private void validateNumberTwoText(Event e) {
		String oldString = numberTwoText.getText();
		String newString = oldString.substring(0, e.start) + e.text + oldString.substring(e.end);
		
		if (Validator.isNumberValid(newString)) {
			if (calculateOnFlyCheckBox.getSelection()) {
				ExpressionOfNumbers expressionOfNumbers = Converter.convert(numberOneText, numberTwoText, operationCombo); 
				expressionOfNumbers.setNumberTwo(Converter.toDouble(newString));
				recalculate(expressionOfNumbers);
			}
			
		} else {
			e.doit = false;
		}

	}
	
	
	private void operationComboChanged(SelectionEvent e) {
		
		if (calculateOnFlyCheckBox.getSelection()) {
				ExpressionOfNumbers expressionOfNumbers = Converter.convert(numberOneText, numberTwoText, operationCombo);
				expressionOfNumbers.setOperation(Operations.getOperationByString(operationCombo.getText()));
				recalculate(expressionOfNumbers);
		} else {
			e.doit = false;
		}
		
	}
	
	private void createTabItem1() {
		GridData gridData;
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;

		//gridLayout.makeColumnsEqualWidth = true;
		
		Composite composite = new Composite(folder, SWT.NONE);
		composite.setLayout(gridLayout);
		
		TabItem tabItem = new TabItem(folder, SWT.NONE);
		tabItem.setText(ITEM_1_NAME);
		
		numberOneText = new Text(composite, SWT.SINGLE|SWT.BORDER);
		numberOneText.setToolTipText(TOOLTIP_TEXT_NUMBER_NAME);
		numberOneText.setTextLimit(NUMBER_TEXT_LIMIT);
		numberOneText.setFocus();

		numberOneText.addListener(SWT.Verify, new Listener() {
			
			@Override
			public void handleEvent(Event e) {
				validateNumberOneText(e);
			}
		});
		
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 1;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 20;
        gridData.grabExcessHorizontalSpace = true;
        //gridData.grabExcessVerticalSpace = true;
        numberOneText.setLayoutData(gridData);
        
        operationCombo = new Combo(composite, SWT.READ_ONLY | SWT.DROP_DOWN);
        operationCombo.setItems(Operations.getAllStringValues());
		operationCombo.select(0);
		operationCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				operationComboChanged(e);
				super.widgetSelected(e);
			}
		});
		
		
		operationCombo.setLayoutData(gridData);
        
		numberTwoText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		numberTwoText.setToolTipText(TOOLTIP_TEXT_NUMBER_NAME);
		numberTwoText.setTextLimit(NUMBER_TEXT_LIMIT);
		
		numberTwoText.addListener(SWT.Verify, new Listener() {
			
			@Override
			public void handleEvent(Event e) {
				validateNumberTwoText(e);
			}
		});

		numberTwoText.setLayoutData(gridData);
		
        calculateOnFlyCheckBox = new Button(composite, SWT.CHECK);
        calculateOnFlyCheckBox.setText(CHECK_BOX_CALCULATE_ON_FLY_NAME);
        calculateOnFlyCheckBox.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				if (!btn.getSelection()) {
					calculateButton.setEnabled(true);
				} else {
					recalculate(Converter.convert(numberOneText, numberTwoText, operationCombo));
					calculateButton.setEnabled(false);
				}
            	
				super.widgetSelected(e);
			}
        	
		});
        
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_END);
        gridData.horizontalSpan = 2;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 80;
        gridData.grabExcessHorizontalSpace = true;
        calculateOnFlyCheckBox.setLayoutData(gridData);
		
        calculateButton = new Button(composite, SWT.NONE);
        calculateButton.setText(BUTTON_CALCULATE_NAME);
        calculateButton.setToolTipText(TOOLTIP_BUTTON_CALCULATE_NAME);
//        calculateButton.addSelectionListener(new ButtonCalculateListener());
        calculateButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				calculateButtonPressed();
				super.widgetSelected(e);
			}
        	
		});
        
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_END);
        gridData.horizontalSpan = 1;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 80;
        gridData.grabExcessHorizontalSpace = true;
        calculateButton.setLayoutData(gridData);
        
        resultLabel = new Label(composite, SWT.NULL);
        resultLabel.setText(RESULT_LABEL_NAME);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
        gridData.horizontalSpan = 1;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 50;
        gridData.grabExcessHorizontalSpace = true;
        resultLabel.setLayoutData(gridData);
        
        resultText = new Text(composite, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
        resultText.setEnabled(false);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 2;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 50;
        gridData.grabExcessHorizontalSpace = true;
        resultText.setLayoutData(gridData);
        
		tabItem.setControl(composite);
	}
	
	private void createTabItem2() {
		TabItem tabItem = new TabItem(folder, SWT.NONE);
		tabItem.setText(ITEM_2_NAME);
		
		Composite composite = new Composite(folder, SWT.NONE);
		composite.setLayout(new FillLayout());
		historyList = new List(composite, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
//		historyList.set
		
		tabItem.setControl(composite);
		
	}
	
	
	public void start() {
		createTabItem1();
		createTabItem2();
//		calculateButtonPressed();
		
		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}		
		display.dispose();

	}
	
}
