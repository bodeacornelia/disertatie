package com.steps;

import net.thucydides.core.annotations.Step;

public class GeneralSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@Step
	public void clickOnOkButtonFromAlertWindow() {
		getGeneralPage().clickOnOkButtonFromAlertWindow();
	}

}
