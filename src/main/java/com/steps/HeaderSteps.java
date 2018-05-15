package com.steps;

import net.thucydides.core.annotations.Step;

public class HeaderSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@Step
	public void navigateToLoginPage() {
		getHeaderPage().selectHoveredDropdownValue("Login");
	}
	
	@Step
	public void navigateToYourProfilePage() {
		getHeaderPage().selectHoveredDropdownValue("Your Profile");
	}

}
