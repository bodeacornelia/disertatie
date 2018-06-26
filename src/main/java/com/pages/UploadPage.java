package com.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class UploadPage extends PageObject {
	
	@FindBy(css = "input[id*='location']")
	private WebElementFacade locationInput;

	public void addPhoto(String imagePath) {
		getDriver().findElement(By.cssSelector("input[type=file]")).sendKeys(imagePath);
	}

	public void enterLocationValue(String location) {
		locationInput.sendKeys(location);
	}

	public void enterTagValue(String tag) {
		changeAddTagInputCss(tag);
	}

	public void selectPublishCheckbox() {
		getDriver().findElement(By.cssSelector("label.upload-submit__check input")).click();
	}

	public void clickOnPublishButton() {
		WebElement button = getDriver().findElement(By.cssSelector("input[value='Publish']"));
		element(button).waitUntilEnabled().click();
	}

	private void changeAddTagInputCss(String tag) {
		String command = "document.querySelector('textarea[id*=tag-input]').classList.remove('tag-editor-hidden-src')";
		evaluateJavascript(command);
		command = "document.querySelector('textarea[id*=tag-input]').value = '" + tag + "'";
		evaluateJavascript(command);
	}
}
