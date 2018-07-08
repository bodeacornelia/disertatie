package com.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.pages.CollectionPage;
import com.pages.GeneralPage;
import com.pages.HeaderPage;
import com.pages.LoginPage;
import com.pages.PhotoDetailsPage;
import com.pages.UploadPage;
import com.pages.myAccount.CollectionsPage;
import com.pages.myAccount.PhotosPage;

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

	public CollectionsPage getCollectionsPage() {
		return getPages().currentPageAt(CollectionsPage.class);
	}

	public CollectionPage getCollectionPage() {
		return getPages().currentPageAt(CollectionPage.class);
	}

	public void cleanDownloadsDirectory() {
		File fileToUpload = new File(new File("").getAbsolutePath());
		System.out.println("Hamsteeeerrrr=====" + fileToUpload);
		String downloadsdirectory = "";
		if (System.getProperty("isZalenium").equals("true")) {
			downloadsdirectory = "/var/lib/jenkins/Downloads";
		} else {
			downloadsdirectory = "/home/corneliabodea/disertatie/disertatiePractic/disertatie/resources/downloads";
		}
		try {
			FileUtils.cleanDirectory(new File(downloadsdirectory));
		} catch (IOException e) {
			System.out.println("Could not clean directory.");
			e.printStackTrace();
		}
	}

	public File[] getFilesFromDownloadsDirectory() {
		String downloadsdirectory = "";
		if (System.getProperty("isZalenium").equals("true")) {
			downloadsdirectory = "/var/lib/jenkins/Downloads";
		} else {
			downloadsdirectory = "/home/corneliabodea/disertatie/disertatiePractic/disertatie/resources/downloads";
		}
		File folder = new File(downloadsdirectory);
		return folder.listFiles();
	}

	public String getDownloadedDocumentName() {
		File[] listOfFiles = getFilesFromDownloadsDirectory();
		return listOfFiles[0].getName();
	}

}
