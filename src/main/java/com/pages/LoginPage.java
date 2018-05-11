package com.pages;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;

public class LoginPage extends PageObject{
	
	private void enterInputValue(String input, String value) {
		getDriver().findElement(By.cssSelector("input[name='"+ input +"']")).sendKeys(value);
	}
	
	private void clickOnLoginButton() {
		getDriver().findElement(By.cssSelector("input[name='commit']")).click();
	}

	public void login(String username, String password) {
		enterInputValue("user[email]", username);
		enterInputValue("user[password]", password);
		clickOnLoginButton();
	}
}
