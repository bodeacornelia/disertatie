package com.pages.myAccount;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.pages.PageObject;

public class CollectionsPage extends PageObject{

	public void openCollection(String collectionTitle) {
		boolean found = false;
		List<WebElement> collectionsList = getDriver().findElements(By.cssSelector("ul.collections li"));
		for (WebElement webElement : collectionsList) {
			if(webElement.findElement(By.cssSelector("h3")).getText().equals(collectionTitle)) {
				webElement.click();
				found = true;
				break;
			}
		}
		Assert.assertTrue("Collections was not found", found);
	}
}
