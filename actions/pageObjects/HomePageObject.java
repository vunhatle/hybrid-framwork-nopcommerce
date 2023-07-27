package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickRegisterLink() {
		waitForElement(driver, HomePageUI.REGISTER_LINK);
		clickToAnElement(driver, HomePageUI.REGISTER_LINK);
	}

	public void clickOnLoginLink() {
		// TODO Auto-generated method stub
		waitForElement(driver, HomePageUI.LOGIN_LINK);
		clickToAnElement(driver, HomePageUI.LOGIN_LINK);
	}

	public void clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitForElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToAnElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}


}
