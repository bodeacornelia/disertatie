package com.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

public class CollectionPage extends PageObject{

	public String getCollectionTitle() {
		return getDriver().findElement(By.cssSelector("h1.title-centered__headline")).getText();
	}
}
