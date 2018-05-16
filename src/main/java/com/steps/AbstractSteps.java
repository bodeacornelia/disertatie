package com.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.pages.GeneralPage;
import com.pages.HeaderPage;
import com.pages.LoginPage;
import com.pages.PhotoDetailsPage;
import com.pages.UploadPage;
import com.pages.account.PhotosPage;

import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	public void navigateTo(String URL) {
		getDriver().get(URL);
	}

	public HeaderPage getHeaderPage() {
		return getPages().currentPageAt(HeaderPage.class);
	}
	
	public LoginPage getLoginPage() {
		return getPages().currentPageAt(LoginPage.class);
	}
	
	public PhotosPage getPhotosPage() {
		return getPages().currentPageAt(PhotosPage.class);
	}
	
	public UploadPage getUploadPage() {
		return getPages().currentPageAt(UploadPage.class);
	}

	public PhotoDetailsPage getPhotoDetailsPage() {
		return getPages().currentPageAt(PhotoDetailsPage.class);
	}
	
	public GeneralPage getGeneralPage() {
		return getPages().currentPageAt(GeneralPage.class);
	}
	
	public void cleanDownloadsDirectory() {
		String downloadsdirectory = "/home/corneliabodea/disertatie/disertatiePractic/docker/Downloads";
		try {
			FileUtils.cleanDirectory(new File(downloadsdirectory));
		} catch (IOException e) {
			System.out.println("Could not clean directory.");
			e.printStackTrace();
		}
	}
	
	public File[] getFilesFromDownloadsDirectory() {
		String downloadsdirectory = "/home/corneliabodea/disertatie/disertatiePractic/docker/Downloads";
		File folder = new File(downloadsdirectory);
		return folder.listFiles();
	}
	
	public String getDownloadedDocumentName() {
		File[] listOfFiles = getFilesFromDownloadsDirectory();
		return listOfFiles[0].getName();
	}
}
