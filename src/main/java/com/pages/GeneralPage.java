package com.pages;

import org.openqa.selenium.Alert;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

public class GeneralPage extends PageObject{

	public void clickOnOkButtonFromAlertWindow() {
		Alert javascriptAlert = getDriver().switchTo().alert();
	    javascriptAlert.accept();
	}
	
	public void clickButton(String name) {
		getDriver().findElement(By.jquery("button:contains('" + name + "')"));
	}
}
