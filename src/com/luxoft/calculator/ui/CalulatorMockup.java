package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.*;

public class CalulatorMockup {
	
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
	
	private static final String [] OPERATION_NAMES = {"+", "-", "/", "*"};
	
	Display display;
	Shell shell;
	TabFolder folder;
	
	Text numberOneText;
	Text numberTwoText;
	Combo operationCombo;
	Button calculateButton;
	Button calculateOnFlyCheckBox;
	
	Label resultLabel;
	Text resultText;
	
	public CalulatorMockup() {
		display = new Display();
		
		shell = new Shell(display);
		shell.setText(APPLICATION_NAME);
		shell.setSize(START_WIDTH, START_HEIGHT);
		shell.setLayout(new FillLayout());
		folder = new TabFolder(shell, SWT.NONE);
		
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
		gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gridData.horizontalSpan = 1;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 20;
        gridData.grabExcessHorizontalSpace = true;
        //gridData.grabExcessVerticalSpace = true;
        numberOneText.setLayoutData(gridData);
        
        operationCombo = new Combo(composite, SWT.READ_ONLY | SWT.DROP_DOWN);
		operationCombo.setItems(OPERATION_NAMES);
		operationCombo.select(0);
		operationCombo.setLayoutData(gridData);
        
		numberTwoText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		numberTwoText.setToolTipText(TOOLTIP_TEXT_NUMBER_NAME);
		numberTwoText.setTextLimit(NUMBER_TEXT_LIMIT);
		numberTwoText.setLayoutData(gridData);
		
        calculateOnFlyCheckBox = new Button(composite, SWT.CHECK);
        calculateOnFlyCheckBox.setText(CHECK_BOX_CALCULATE_ON_FLY_NAME);
        gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_END);
        gridData.horizontalSpan = 2;
        gridData.horizontalIndent = 20;
        gridData.verticalIndent = 80;
        gridData.grabExcessHorizontalSpace = true;
        calculateOnFlyCheckBox.setLayoutData(gridData);
		
        calculateButton = new Button(composite, SWT.NONE);
        calculateButton.setText(BUTTON_CALCULATE_NAME);
        calculateButton.setToolTipText(TOOLTIP_BUTTON_CALCULATE_NAME);
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
		
	}
	
	
	public void start() {
		createTabItem1();
		//numberOneText.addListener(SWT., listener)
		createTabItem2();
		
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
