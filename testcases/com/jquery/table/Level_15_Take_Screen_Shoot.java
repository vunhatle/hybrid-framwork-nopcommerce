package com.jquery.table;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadFilesObject;
import pageUIs.users.BasePageUI;

public class Level_15_Take_Screen_Shoot extends BaseTest {
	WebDriver driver;
	UploadFilesObject uploadFilePage;
	static String[] fileNames = {"Test1.png", "Test2.png"} ;
	@Parameters({ "browser","url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		uploadFilePage =  PageGeneratorManager.getUploadFilesPage(driver);
	}

	

	@Test
	public void TC_01_Single_Upload_File() {
		
		uploadFilePage.uploadMultiplesFiles(driver, "Test1.png");
		uploadFilePage.sleepInSecond(2);
		
		Assert.assertTrue(uploadFilePage.isUploadedFileSuccessful(driver, "Test1.png"));
		uploadFilePage.clickOnStartButtonOfEachRow(driver);
		Assert.assertTrue(uploadFilePage.isUploadedFileSuccessful(driver, "Test1.png"));
		sleepInSecond(5);
		uploadFilePage.takeSnapShot(driver, "D:\\", "photo5");
	}
	
	
	

	/*
	 * @AfterClass public void afterClass() { quitDriver(); }
	 */

}
