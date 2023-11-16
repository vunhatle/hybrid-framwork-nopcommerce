package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.HomePageUI;
import pageUIs.users.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		waitForElement(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToAnElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterPassword(String password) {
		// TODO Auto-generated method stub
		waitForElement(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToAnElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickonLoginButton() {
		// TODO Auto-generated method stub
		waitForElement(driver, LoginPageUI.LOGIN_BUTTON);
		clickToAnElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}
	
	public CustomerPageObject clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitForElement(driver, LoginPageUI.MY_ACCOUNT_LINK);
		clickToAnElement(driver, LoginPageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPage(driver);
	}


}
