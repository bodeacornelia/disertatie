package com.pages;

import org.openqa.selenium.Alert;

import net.thucydides.core.pages.PageObject;

public class GeneralPage extends PageObject{

	public void clickOnOkButtonFromAlertWindow() {
		Alert javascriptAlert = getDriver().switchTo().alert();
	    javascriptAlert.accept();
	}
}
