package com.steps;

import org.junit.Assert;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class PhotoDetailsSteps extends GeneralSteps {

	private static final long serialVersionUID = 1L;

	@Step
	public void downloadPhoto() {
		cleanDownloadsDirectory();
		getPhotoDetailsPage().downloadPhoto();
	}

	@Step
	public void verifyDownloadedDocument() {
		String expectedDownloadedDocName = (String) Serenity.getCurrentSession().get("tag");
		String actualDownloadedDocName = getDownloadedDocumentName();

		Assert.assertTrue(
				"Downloaded photo isn't the one expected. Expected: " + expectedDownloadedDocName + " Actual: "
						+ actualDownloadedDocName,
				actualDownloadedDocName.toLowerCase().contains(expectedDownloadedDocName.toLowerCase()));
	}

	@StepGroup
	public void deletePhoto() {
		getPhotoDetailsPage().deletePhoto();
		clickOnOkButtonFromAlertWindow();
	}

	@Step
	public void addPhotoTag() {
		getPhotoDetailsPage().clickOnAddPhotoTagsButton();
		getPhotoDetailsPage().enterTagValue();
		getPhotoDetailsPage().clickOnSubmitTagsButton();
	}

}
