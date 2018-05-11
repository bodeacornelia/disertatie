package com.steps;

import com.pages.HeaderPage;
import com.pages.LoginPage;
import com.pages.MyAccountPage;
import com.pages.UploadPage;

import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	public void navigateTo(String URL) {
		getDriver().get(URL);
	}

	public HeaderPage getHeaderPage() {
		return getPages().currentPageAt(HeaderPage.class);
	}
	
	public LoginPage getLoginPage() {
		return getPages().currentPageAt(LoginPage.class);
	}
	
	public MyAccountPage getMyAccountPage() {
		return getPages().currentPageAt( MyAccountPage.class);
	}
	
	public UploadPage getUploadPage() {
		return getPages().currentPageAt( UploadPage.class);
	}

}
