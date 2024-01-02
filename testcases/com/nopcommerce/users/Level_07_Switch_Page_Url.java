package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
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


public class Level_07_Switch_Page_Url extends BaseTest {
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
	private String userUrl, adminUrl;

	// @org.testng.annotations.Parameters("browser")
	@Parameters({"browser", "userUrl", "adminUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
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
		
		homePage = customerPage.clickToLogOutLink(driver);
		homePage.openURL(driver, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardPage = adminLoginPage.loginAsAdmin("admin@yourstore.com", "admin");
		
		adminLoginPage = adminDashboardPage.adminClickOnLogOut(driver);
		
		adminLoginPage.openURL(driver, userUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		loginPage = homePage.clickOnLoginLink();
		loginPage.enterEmailAddress(emailAddress);
		loginPage.enterPassword("123456");
		loginPage.clickonLoginButton();
		
		
	}

	/*
	 * @AfterClass public void afterClass() { quitDriver(); }
	 */
}
