package com.pages;

import org.openqa.selenium.By;

import com.tools.utils.FileUtils;

import net.thucydides.core.pages.PageObject;

public class PhotoDetailsPage extends PageObject{

	public void downloadPhoto() {
		getDriver().findElement(By.cssSelector("div.btn-primary.btn--lg.btn--splitted")).click();
	}
	
	public void verifyDownloadedPhoto() {
		FileUtils.calculateFileChecksum("/home/corneliabodea/disertatie/disertatiePractic/docker/upload/photo.png");
	}
	
}
