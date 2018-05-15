package com.pages.account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	public void openLastUploadedPhotoDetails() {
		List<WebElement> photoList = getDriver().findElements(By.cssSelector("div.photos article a img"));
		photoList.get(photoList.size()-1).click();
	}
}
