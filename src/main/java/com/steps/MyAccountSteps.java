package com.steps;

import org.junit.Assert;

import com.entity.EntityFactory;
import com.entity.Photo;

import net.thucydides.core.annotations.Step;

public class MyAccountSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@Step
	public void uploadPhoto() {
		Photo photo = EntityFactory.getPhotoInstance();
		getPhotosPage().clickOnUploadYourPhotosButton();
		getUploadPage().addPhoto(photo.getPath());
		getUploadPage().enterLocationValue((photo.getLocation()));
		getUploadPage().selectPublishCheckbox();
		getUploadPage().clickOnPublishButton();
	}
	
	@Step
	public void verifyInfoMessageForUploadedPhoto() {
		String expectedMessage = "Successfully uploaded 1 photo.";
		String actualMessage = getPhotosPage().getInfoMessageForUploadedPhoto();
		
		Assert.assertTrue("Photo wasn't uploaded", expectedMessage.equals(actualMessage));
	}
	
	@Step
	public void openLastUploadedPhotoDetails() {
		getPhotosPage().openLastUploadedPhotoDetails();
	}

}
