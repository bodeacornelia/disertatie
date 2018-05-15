package com.steps;

import org.junit.Assert;

import com.entity.EntityFactory;
import com.entity.Photo;
import com.tools.utils.FileUtils;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

public class MyAccountSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@Step
	public void uploadPhoto() {
		Photo photo = EntityFactory.getPhotoInstance();
		getPhotosPage().clickOnUploadYourPhotosButton();
//		getUploadPage().addPhoto("/home/corneliabodea/disertatie/disertatiePractic/docker/upload/photo.png");
		String expectedChecksum = FileUtils.calculateFileChecksum("/home/corneliabodea/disertatie/disertatiePractic/docker/upload/photo.png");
		System.out.println("Expected Checksum: " + expectedChecksum);
		Serenity.getCurrentSession().put("checksum", expectedChecksum);
		getUploadPage().addPhoto("/home/seluser/upload/photo.png");
		getUploadPage().enterLocationValue((photo.getLocation()));
		getUploadPage().selectPublishCheckbox();
		getUploadPage().clickOnPublishButton();
	}
	
	@Step
	public void verifyPhotoUploaded() {
		String expectedMessage = "Successfully uploaded 1 photo.";
		String actualMessage = getPhotosPage().getInfoMessageForUploadedPhoto();
		
		Assert.assertTrue("Photo wasn't uploaded", expectedMessage.equals(actualMessage));
	}
	
	@Step
	public void openLasUploadedPhotoDetails() {
		getPhotosPage().openLastUploadedPhotoDetails();
	}

}
