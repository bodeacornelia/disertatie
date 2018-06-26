package com.pages;

import org.openqa.selenium.WebElement;

import com.tools.FieldGenerators;
import com.tools.FieldGenerators.Mode;

import net.serenitybdd.core.Serenity;
//import org.openqa.selenium.By;
import net.serenitybdd.core.annotations.findby.By;
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

	public String getPhotoTag() {
		return getDriver().findElement(By.cssSelector("div.box ul li a.btn-light")).getText();
	}

	public void clickOnAddNewCollectionButton() {
		getDriver().findElement(By.cssSelector("button[class*='btn-quiet js-collect']")).click();
	}

	public void clickOnCreateCollectionButton() {
		getDriver().findElement(By.cssSelector("button.btn-quiet.btn--sm")).click();
	}

	public void clickOnCreateCollectionSubmitButton() {
		getDriver().findElement(By.cssSelector("button.btn-secondary")).click();
	}

	public void enterCollectionTitle() {
		String title = FieldGenerators.generateRandomString(10, Mode.ALPHA);
		getDriver().findElement(By.cssSelector("#collection_title")).sendKeys(title);

		Serenity.getCurrentSession().put("collectionTitle", title);
	}

	public void clickOnViewYourCollections() {
		getDriver().findElement(By.cssSelector("p.collections__footer a")).click();
	}
}
