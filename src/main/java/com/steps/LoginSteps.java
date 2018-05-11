package com.steps;

import net.thucydides.core.annotations.Step;

public class LoginSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@Step
	public void login(String username, String password) {
		getLoginPage().login(username, password);
	}

}
