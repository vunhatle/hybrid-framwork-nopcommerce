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


public class Level_10_String_Format extends BaseTest {
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
		

		homePage = registerPage.clickToHomePageLogo();

		//homePage = new HomePageObject(driver);
		registerPage = homePage.clickRegisterLink();

		// registerPage = new RegisterPageObject(driver);

		registerPage.enterFirstNameTextbox("Snape");
		registerPage.enterLastNameTextbox("Severus");
		registerPage.enterEmailTextbox(emailAddress);
		registerPage.enterPassword("123456");
		registerPage.enterConfirmPassword("123456");

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	@Test
	public void Register_02_Verify_Login() {
		homePage = registerPage.clickToHomePageLogo();
		
		// homePage = new HomePageObject(driver);
		loginPage = homePage.clickOnLoginLink();
		
		//registerPage = new RegisterPageObject(driver);
		
		//loginPage = new LoginPageObject(driver);
		loginPage.enterEmailAddress(emailAddress);
		loginPage.enterPassword("123456");
		loginPage.clickonLoginButton();
		
		//homePage = new HomePageObject(driver);
		customerPage = loginPage.clickToMyAccountLink();
		
		// customerPage = new CustomerPageObject(driver);
		
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Snape");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Severus");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	}
	@Test
	public void Register_03_Switch_Url() {
		customerPage.openDynamicMorePage(driver, "Addresses");
		addressesPage =PageGeneratorManager.getAddressesPageObjectWe(driver);
		

		
	}

	/*
	 * @AfterClass public void afterClass() { quitDriver(); }
	 */
}
