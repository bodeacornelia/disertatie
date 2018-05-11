package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.thucydides.core.pages.PageObject;

public class HeaderPage extends PageObject{

	private void hoverDotDropdownButton() {
		WebElement button = getDriver().findElement(By.cssSelector("li.navbar__dropdown [data-track-label='more']"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(button).build().perform();
	}
	
	public void selectHoveredDropdownValue(String value) {
		hoverDotDropdownButton();
		List<WebElement> listItem = getDriver().findElements(By.cssSelector("div.btn__dropdown.open li"));
		for (WebElement itemNow : listItem) {
			if (itemNow.getText().toLowerCase().equals(value.toLowerCase())) {
				itemNow.click();
				break;
			}
		}
	}
}
