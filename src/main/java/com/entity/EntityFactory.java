package com.entity;

import com.tools.FieldGenerators;
import com.tools.FieldGenerators.Mode;

public class EntityFactory {

	public static Photo getPhotoInstance() {

		Photo photo = new Photo();
		photo.setTag(FieldGenerators.generateRandomString(5, Mode.ALPHA));
		photo.setLocation("Cluj-Napoca");

		return photo;
	}
}
