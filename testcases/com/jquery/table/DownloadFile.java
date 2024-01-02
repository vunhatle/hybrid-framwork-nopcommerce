package com.jquery.table;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.jquery.DownloadPageObject;

public class DownloadFile extends BaseTest {
	WebDriver driver;
	DownloadPageObject download;
	// @org.testng.annotations.Parameters("browser")
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		download = pageObjects.jquery.PageGeneratorManager.getDownloadPage(driver);
	}
	
	
	@Test
	public void SetDownloadDefaultDirectory() {
		//download.scrollToElementOnDown(driver, "xpath=//p[contains(text(),'Latest stable version')]/following-sibling::p");
		download.clickToAnElement(driver, "xpath=//p[contains(text(),'Latest stable version')]/a");
		// test edit

		}




 
 
} 
 
      

