package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;

import com.luxoft.calculator.listener.ModifyValuesListener;
import com.luxoft.calculator.listener.VerifyEditNumbersLisener;
import com.luxoft.calculator.model.CalculatorModel;
import com.luxoft.calculator.service.Calculation;
import com.luxoft.calculator.utils.Converter;
import com.luxoft.calculator.utils.Operations;
import com.luxoft.exception.EmptyFieldException;

public class CalculatorComposite extends Composite implements IConverter {
	
	private static final String TOOLTIP_TEXT_NUMBER_NAME        = "Numbers only allowed";
	private static final String CHECK_BOX_CALCULATE_ON_FLY_NAME = "Calculate on the fly";
	private static final String BUTTON_CALCULATE_NAME           = "Calculate";
	private static final String TOOLTIP_BUTTON_CALCULATE_NAME   = "Disabled if calculated on a fly";
	private static final String RESULT_LABEL_NAME               = "Result:";
	
	private static final int NUMBER_TEXT_LIMIT = 20;
	
	private Text numberOneText;
	private Text numberTwoText;
	private Combo operationCombo;
	private Button calculateButton;
	private Button calculateOnFlyCheckBox;
	
	private Label resultLabel;
	private Text resultText;
	
	private VerifyEditNumbersLisener verifyEditNumbersLisener;
	private ModifyValuesListener modifyValuesListener;

	
	private IHistoric history;
	private CalculatorModel calculatorMidel;
	
	public CalculatorComposite(Composite parent, int style, IHistoric history) {
		super(parent, style);
		this.history = history;
		this.calculatorMidel = new CalculatorModel();
		init();
		verifyEditNumbersLisener = new VerifyEditNumbersLisener();
		modifyValuesListener = new ModifyValuesListener(this);
		initListeners();
	}
	
	private void init() {
		GridData gridData;
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		//gridLayout.makeColumnsEqualWidth = true;
		setLayout(gridLayout);
		
		numberOneText = new Text(this, SWT.SINGLE|SWT.BORDER);
		numberOneText.setToolTipText(TOOLTIP_TEXT_NUMBER_NAME);
		numberOneText.setTextLimit(NUMBER_TEXT_LIMIT);
		numberOneText.setFocus();
		
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 1;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 20;
        gridData.grabExcessHorizontalSpace = true;
        //gridData.grabExcessVerticalSpace = true;
        numberOneText.setLayoutData(gridData);
        
        operationCombo = new Combo(this, SWT.READ_ONLY | SWT.DROP_DOWN);
        operationCombo.setItems(Operations.getAllStringValues());
		operationCombo.select(0);
		
		operationCombo.setLayoutData(gridData);
        
		numberTwoText = new Text(this, SWT.SINGLE | SWT.BORDER);
		numberTwoText.setToolTipText(TOOLTIP_TEXT_NUMBER_NAME);
		numberTwoText.setTextLimit(NUMBER_TEXT_LIMIT);
		
		numberTwoText.setLayoutData(gridData);
		
        calculateOnFlyCheckBox = new Button(this, SWT.CHECK);
        calculateOnFlyCheckBox.setText(CHECK_BOX_CALCULATE_ON_FLY_NAME);
        
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_END);
        gridData.horizontalSpan = 2;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 80;
        gridData.grabExcessHorizontalSpace = true;
        calculateOnFlyCheckBox.setLayoutData(gridData);
		
        calculateButton = new Button(this, SWT.NONE);
        calculateButton.setText(BUTTON_CALCULATE_NAME);
        calculateButton.setToolTipText(TOOLTIP_BUTTON_CALCULATE_NAME);

        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_END);
        gridData.horizontalSpan = 1;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 80;
        gridData.grabExcessHorizontalSpace = true;
        calculateButton.setLayoutData(gridData);
        
        resultLabel = new Label(this, SWT.NULL);
        resultLabel.setText(RESULT_LABEL_NAME);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_END);
        gridData.horizontalSpan = 1;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 50;
        gridData.grabExcessHorizontalSpace = true;
        resultLabel.setLayoutData(gridData);
        
        resultText = new Text(this, SWT.SINGLE | SWT.BORDER | SWT.RIGHT);
        resultText.setEnabled(false);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 2;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 50;
        gridData.grabExcessHorizontalSpace = true;
        resultText.setLayoutData(gridData);

	}
	
	private void initListeners() {
		numberOneText.addListener(SWT.Verify, verifyEditNumbersLisener);
		numberOneText.addModifyListener(modifyValuesListener);
		
		numberTwoText.addListener(SWT.Verify, verifyEditNumbersLisener);
		numberTwoText.addModifyListener(modifyValuesListener);
		
		operationCombo.addModifyListener(modifyValuesListener);
		
		calculateOnFlyCheckBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn = (Button) e.getSource();
				modifyValuesListener.setCalculateOnFly(btn.getSelection());
//				calculateButton.setEnabled(!btn.getSelection());
            	
				super.widgetSelected(e);
			}
        	
		});
        
        calculateButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				
				calculateResult();
				super.widgetSelected(e);
			}
        	
		});
	}
	
	@Override
	public CalculatorModel convertToModel() {
		
//		ExpressionOfNumbers expressionOfNumbers = new ExpressionOfNumbers();
		
		calculatorMidel.setNumberOne(Converter.toDouble(numberOneText.getText()));
		calculatorMidel.setNumberTwo(Converter.toDouble(numberTwoText.getText()));
		calculatorMidel.setOperation(Operations.getOperationByString(operationCombo.getText()));
		
		return calculatorMidel;
	}
	
	@Override
	public void convertToView(CalculatorModel expressionOfNumbers) {
		resultText.setText(expressionOfNumbers.getResult());
	}
	
	private void validateForEmptyFields() throws EmptyFieldException {
		String msg = "";
		boolean isFieldEmpty = false;
		
		if (numberOneText.getText().isEmpty()) {
			isFieldEmpty = true;
			msg += "Field one is empty\n";
		}
		if (numberTwoText.getText().isEmpty()) {
			isFieldEmpty = true;
			msg += "Field two is empty\n";
		}

		if (operationCombo.getText().isEmpty()) {
			isFieldEmpty = true;
			msg += "Field operation is empty\n";
		}
		
		if (isFieldEmpty) {
			throw new EmptyFieldException(msg); 
		}

	}
	
	private void calculateResult() {
		try {
			validateForEmptyFields();
			CalculatorModel expressionOfNumbers = convertToModel();
			Calculation.getCalculationByOperation(expressionOfNumbers.getOperation()).calculate(expressionOfNumbers);
			convertToView(expressionOfNumbers);
			history.addExpressionToHistory(expressionOfNumbers);
		} catch (Exception exception) {
			MessageBox messageBox = new MessageBox(super.getShell(), SWT.ICON_ERROR | SWT.OK);
			messageBox.setText("Error");
			messageBox.setMessage(exception.getMessage());
			messageBox.open();
		}
	}

}
