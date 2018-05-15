package com.pages;

import org.openqa.selenium.By;

import net.thucydides.core.pages.PageObject;

public class PhotoDetailsPage extends PageObject{

	public void downloadPhoto() {
		getDriver().findElement(By.cssSelector("div.btn-primary.btn--lg.btn--splitted")).click();
	}
	
	public void deletePhoto() {
		getDriver().findElement(By.cssSelector("form.button_to input.link")).click();
	}
	
	public void clickOnAddPhotoTagsButton() {
		getDriver().findElement(By.cssSelector("a.js-add-tags-link")).click();
	}
}
