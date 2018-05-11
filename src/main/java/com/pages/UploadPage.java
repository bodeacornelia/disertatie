package com.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

public class UploadPage extends PageObject{

	public void addPhoto(String imagePath) {
		getDriver().findElement(By.cssSelector("input[type=file]")).sendKeys(imagePath);
	}
	
	public void enterLocationValue(String location) {
		getDriver().findElement(By.cssSelector("input[id*='location']")).sendKeys(location);
	}
	
	public void selectPublishCheckbox() {
		getDriver().findElement(By.cssSelector("label.upload-submit__check input")).click();
	}
	
	public void clickOnPublishButton() {
		WebElement button = getDriver().findElement(By.cssSelector("input[value='Publish']"));
		element(button).waitUntilEnabled().click();
	}
}
