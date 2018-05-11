package com.steps;

import com.entity.EntityFactory;
import com.entity.Photo;

import net.thucydides.core.annotations.Step;

public class MyAccountSteps extends AbstractSteps {

	private static final long serialVersionUID = 1L;
	
	@Step
	public void uploadPhoto() {
		Photo photo = EntityFactory.getPhotoInstance();
		getMyAccountPage().clickOnUploadYourPhotosButton();
		getUploadPage().addPhoto("/home/corneliabodea/Pictures/photo.png");
		getUploadPage().enterLocationValue((photo.getLocation()));
		getUploadPage().selectPublishCheckbox();
		getUploadPage().clickOnPublishButton();
	}

}
