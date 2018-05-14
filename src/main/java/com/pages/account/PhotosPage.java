package com.pages.account;

import org.openqa.selenium.By;
import net.thucydides.core.pages.PageObject;

public class PhotosPage extends PageObject{

	public void clickOnUploadYourPhotosButton() {
		getDriver().findElement(By.cssSelector("div.show-if-signed-in a")).click();
	}
	
	public void clickOnBrowseButton() {
		getDriver().findElement(By.cssSelector(".upload-form button")).click();
	}
	
	public String getInfoMessageForUploadedPhoto() {
		return getDriver().findElement(By.cssSelector("div.flash--success")).getText();
	}
}
