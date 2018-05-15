package com.steps;

import org.junit.Assert;

import com.tools.utils.FileUtils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class PhotoDetailsSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void downloadPhoto() {
		cleanDownloadsDirectory();
		getPhotoDetailsPage().downloadPhoto();
	}

	@Step
	public void verifyDownloadedDocument() {
		String expectedChecksum = (String) Serenity.getCurrentSession().get("checksum");
		String actualChecksum = FileUtils.calculateFileChecksum(
				"/home/corneliabodea/disertatie/disertatiePractic/docker/Downloads/" + getDownloadedDocumentName());
		System.out.println("Expected: " + expectedChecksum);
		System.out.println("Actual: " + actualChecksum);
		Assert.assertTrue("Downloaded photo isn't the one expected", expectedChecksum.equals(actualChecksum));
	}

}
