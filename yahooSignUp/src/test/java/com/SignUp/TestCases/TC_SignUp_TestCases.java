package com.SignUp.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.SignUp.PageObjects.YahooPO;


public class TC_SignUp_TestCases extends BaseClass {
	
	@Test
	 public static void TC_101_StatusUpdate() throws IOException, InterruptedException {
		YahooPO object = new YahooPO(driver);
		logger = extent.createTest("TC_101 Verify Status");
		object.signup();
		logger.info("Entered the Values Sucessfully");	 
	}
}
