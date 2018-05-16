package com.entity;

import com.tools.FieldGenerators;
import com.tools.FieldGenerators.Mode;
import com.tools.constants.EnvironmentConstants;

public class EntityFactory {

	public static Photo getPhotoInstance() {

		Photo photo = new Photo();
		photo.setTag(FieldGenerators.generateRandomString(5, Mode.ALPHA));
		photo.setLocation("Cluj-Napoca");
		if(System.getProperty("isZalenium").equals("true")) {
			photo.setPath(EnvironmentConstants.FILE_PATH_ZALENIUM);
		}else {
			photo.setPath(EnvironmentConstants.FILE_PATH);
		}

		return photo;
	}
}
