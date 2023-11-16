package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.admin.AdminBasePageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public void inputEmailAddress(String emailAddress) {
		waitForElement(driver, AdminBasePageUI.EMAIL_ADDRESS_LINK);
		sendkeyToAnElement(driver, AdminBasePageUI.EMAIL_ADDRESS_LINK, emailAddress );
	}
	
	public void inputPassword(String password) {
		waitForElement(driver, AdminBasePageUI.PASSWORD_LINK);
		sendkeyToAnElement(driver, AdminBasePageUI.PASSWORD_LINK, password);
	}
	
	public void clickOnLoginButton() {
		waitForElementClickable(driver, AdminBasePageUI.LOGIN_BUTTON_LINK);
		clickToAnElement(driver, AdminBasePageUI.LOGIN_BUTTON_LINK);
	}
	
	public AdminDashboardPageObject loginAsAdmin(String emailAddress, String password) {
		inputEmailAddress(emailAddress);
		inputPassword(password);
		clickOnLoginButton();
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

}
