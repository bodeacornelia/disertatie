package com.tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.AbstractSteps;
import com.steps.HeaderSteps;
import com.steps.LoginSteps;
import com.steps.MyAccountSteps;
import com.steps.PhotoDetailsSteps;
import com.tools.constants.EnvironmentConstants;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class Test_UploadPhoto {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public AbstractSteps abstractSteps;
	@Steps
	public HeaderSteps headerSteps;
	@Steps
	public LoginSteps loginSteps;
	@Steps
	public MyAccountSteps myAccountSteps;
	@Steps
	public PhotoDetailsSteps photoDetailsSteps;

	@Test
	public void test_UploadPhoto() {
		abstractSteps.navigateTo(EnvironmentConstants.BASE_URL);
		headerSteps.navigateToLoginPage();
		loginSteps.login(EnvironmentConstants.USERNAME, EnvironmentConstants.PASSWORD);
		myAccountSteps.uploadPhoto();
		myAccountSteps.verifyInfoMessageForUploadedPhoto();
	}
	
	@After
	public void deleteUploadedPhoto() {
		myAccountSteps.openLastUploadedPhotoDetails();
		photoDetailsSteps.deletPhoto();
	}
}
