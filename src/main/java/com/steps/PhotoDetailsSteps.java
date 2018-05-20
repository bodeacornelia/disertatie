package com.steps;

import org.junit.Assert;

import com.entity.Photo;

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
		Photo photo = (Photo) Serenity.getCurrentSession().get("photo");
		String actualDownloadedDocName = getDownloadedDocumentName();

		Assert.assertTrue(
				"Downloaded photo isn't the one expected. Expected: " + photo.getTag() + " Actual: "
						+ actualDownloadedDocName,
				actualDownloadedDocName.toLowerCase().contains(photo.getTag().toLowerCase()));
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

	@Step
	public void verifyPhotoTagWasAdded() {
		Photo photo = (Photo) Serenity.getCurrentSession().get("photo");
		String actualTag = getPhotoDetailsPage().getPhotoTag();

		Assert.assertTrue("Tag value is not correctly displayed. Expected: " + photo.getTag() + " Actual: " + actualTag,
				actualTag.toLowerCase().equals(photo.getTag().toLowerCase()));
	}
	
	@Step
	public void addNewCollection() {
		getPhotoDetailsPage().clickOnAddNewCollectionButton();
		getPhotoDetailsPage().clickOnCreateCollectionButton();
		getPhotoDetailsPage().enterCollectionTitle();
		getPhotoDetailsPage().clickOnCreateCollectionSubmitButton();
	}
	


}
