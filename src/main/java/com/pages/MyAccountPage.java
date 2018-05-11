package com.pages;

import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;

public class MyAccountPage extends PageObject{

	public void clickOnUploadYourPhotosButton() {
		getDriver().findElement(By.cssSelector("div.show-if-signed-in a")).click();
	}
	
	public void clickOnBrowseButton() {
		getDriver().findElement(By.cssSelector(".upload-form button")).click();
	}
}
