package com.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.tests.Test_CreateANewCollection;
import com.tests.Test_DownloadPhoto;
import com.tests.Test_UploadPhoto;

@Suite.SuiteClasses({

		Test_CreateANewCollection.class,
		Test_DownloadPhoto.class,
		Test_UploadPhoto.class

})

@RunWith(Suite.class)
public class TheSuite {

}
