package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadablePageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPageObject;
import pageObjects.users.SideBarPageObject;


public class Level_12_Log extends BaseTest {
	WebDriver driver;
	String osName = System.getProperty("os.name");
	String emailAddress = getEmailAddress();

	HomePageObject homePage;
	CustomerPageObject customerPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	SideBarPageObject sideBar;
	CustomerPageObject customerInfor;
	DownloadablePageObject downloadablePage;
	AddressesPageObject addressesPage;
	RewardPageObject rewardPage;
	
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashboardPage;
	private String userUrl = GlobalConstants.DEV_USER_URL;
	private String adminUrl = GlobalConstants.DEV_ADMIN_URL;

	// @org.testng.annotations.Parameters("browser")
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, userUrl);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}
	
	@Test
	public void Register_01_Success() {
		
		log.info("Register 01 - Step 01: Initializing home page object");
		homePage = registerPage.clickToHomePageLogo();
		log.info("Register 01 - Step 02: Click on Register ");
		registerPage = homePage.clickRegisterLink();
		log.info("Register 01 - Step 03: Click on Register button");
		registerPage.clickRegisterButton();
		log.info("Register 01 - Step 04: Verify Error on first name");
		verifyEquals(registerPage.getFirstNameErrorMessage(),"First name is required.." );
		log.info("Register 01 - Step 05: Enter first name");
		registerPage.enterFirstNameTextbox("Snape");
		log.info("Register 01 - Step 06: Enter last name");
		registerPage.enterLastNameTextbox("Severus");
		log.info("Register 01 - Step 07: Enter email");
		registerPage.enterEmailTextbox(emailAddress);
		log.info("Register 01 - Step 08: Enter password");
		registerPage.enterPassword("123456");
		log.info("Register 01 - Step 09: Enter confirm password");
		registerPage.enterConfirmPassword("123456");
		log.info("Register 01 - Step 02: Click on register button");
		registerPage.clickRegisterButton();
		log.info("Register 01 - Step 02: Verify register success message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
	}
	
	/*
	 * @AfterClass public void afterClass() { quitDriver(); }
	 */
}
