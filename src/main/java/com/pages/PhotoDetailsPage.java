package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tools.FieldGenerators;
import com.tools.FieldGenerators.Mode;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;

public class PhotoDetailsPage extends PageObject {

	public void downloadPhoto() {
		getDriver().findElement(By.cssSelector("div.btn-primary.btn--lg.btn--splitted")).click();
	}

	public void deletePhoto() {
		getDriver().findElement(By.cssSelector("form.button_to input.link")).click();
	}

	public void clickOnAddPhotoTagsButton() {
		waitABit(5000);
		WebElement button = getDriver().findElement(By.cssSelector("a.js-add-tags-link"));
		element(button).waitUntilVisible().click();
		changeAddTagInputCss();
	}

	private void changeAddTagInputCss() {
		String command = "document.getElementsByName('tags')[0].removeAttribute('class')";
		evaluateJavascript(command);
		command = "document.getElementsByName('tags')[0].removeAttribute('type')";
		evaluateJavascript(command);
		command = "document.getElementsByName('tags')[0].value = 'scsds'";
		evaluateJavascript(command);
	}

	public void enterTagValue() {
		String value = FieldGenerators.generateRandomString(12, Mode.ALPHA);
		Serenity.getCurrentSession().put("tag", value);
		String command = "document.getElementsByName('tags')[0].value = '" + value + "'";
		evaluateJavascript(command);
		waitABit(3000);
	}

	public void clickOnSubmitTagsButton() {
		getDriver().findElement(By.cssSelector("input[value='Submit tags']")).click();

	}

}
