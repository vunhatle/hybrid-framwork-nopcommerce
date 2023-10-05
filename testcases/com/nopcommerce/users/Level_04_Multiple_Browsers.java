package com.nopcommerce.users;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;


public class Level_04_Multiple_Browsers extends BaseTest {
	WebDriver driver;
	String osName = System.getProperty("os.name");
	JavascriptExecutor js = (JavascriptExecutor) driver;;
	BasePage basePage = new BasePage();
	String emailAddress = getEmailAddress();

	HomePageObject homePage;
	CustomerPageObject customerPage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

	@org.testng.annotations.Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		
	}
	
	@Test
	public void Register_01_Empty_Data() {
		homePage = new HomePageObject(driver);

		homePage.clickRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");

	}
	@Test
	public void Register_02_Invalid_Email() {
		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);
		homePage.clickRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterFirstNameTextbox("Snape");
		registerPage.enterLastNameTextbox("Severus");
		registerPage.enterEmailTextbox("snapeseverus.com");
		registerPage.enterPassword("123456");
		registerPage.enterConfirmPassword("123456");

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}
	@Test
	public void Register_03_Invalid_Password() {
		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);
		homePage.clickRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterFirstNameTextbox("Snape");
		registerPage.enterLastNameTextbox("Severus");
		registerPage.enterEmailTextbox("snapeseverus@gmail.com");
		registerPage.enterPassword("123");
		registerPage.enterConfirmPassword("123");

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessage(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}
	@Test
	public void Register_04_Invalid_Confirm_Password() {
		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);
		homePage.clickRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterFirstNameTextbox("Snape");
		registerPage.enterLastNameTextbox("Severus");
		registerPage.enterEmailTextbox("snapeseverus@gmail.com");
		registerPage.enterPassword("123456");
		registerPage.enterConfirmPassword("123");

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(),
				"The password and confirmation password do not match.");
	}
	@Test
	public void Register_05_Success() {
		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);
		homePage.clickRegisterLink();

		registerPage = new RegisterPageObject(driver);

		registerPage.enterFirstNameTextbox("Snape");
		registerPage.enterLastNameTextbox("Severus");
		registerPage.enterEmailTextbox(emailAddress);
		registerPage.enterPassword("123456");
		registerPage.enterConfirmPassword("123456");

		registerPage.clickRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	@Test
	public void Register_06_Verify_Login() {
		registerPage.clickToHomePageLogo();

		homePage = new HomePageObject(driver);
		homePage.clickOnLoginLink();

		registerPage = new RegisterPageObject(driver);

		loginPage = new LoginPageObject(driver);
		loginPage.enterEmailAddress(emailAddress);
		loginPage.enterPassword("123456");
		loginPage.clickonLoginButton();

		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();

		customerPage = new CustomerPageObject(driver);

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Snape");
		Assert.assertEquals(customerPage.getLastNameAttributeValue(), "Severus");
		Assert.assertEquals(customerPage.getEmailAttributeValue(), emailAddress);
	}

	@AfterClass
	public void afterClass() {
		quitDriver();
	}

}
