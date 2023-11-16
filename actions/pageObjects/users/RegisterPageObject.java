package pageObjects.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.users.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickRegisterButton() {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToAnElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public String getFirstNameErrorMessage() {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE).getText() ;
	}

	public String getLastNameErrorMessage() {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE).getText();
	}

	public String getEmailErrorMessage() {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE).getText();
	}

	public String getPasswordErrorMessage() {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE).getText();
	}

	public String getConfirmPasswordErrorMessage() {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE).getText();
	}

	public HomePageObject clickToHomePageLogo() {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.HOME_PAGE_LOGO);
		getElement(driver, RegisterPageUI.HOME_PAGE_LOGO).click();
		return PageGeneratorManager.getHomePage(driver);
		
	}

	public void enterFirstNameTextbox(String firstName) {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		getElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX).sendKeys(firstName);
	}

	public void enterLastNameTextbox(String lastName) {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		getElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX).sendKeys(lastName);
		
	}

	public void enterEmailTextbox(String email) {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.EMAIL_TEXTBOX);
		getElement(driver, RegisterPageUI.EMAIL_TEXTBOX).sendKeys(email);	
	}

	public void enterPassword(String password) {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		getElement(driver, RegisterPageUI.PASSWORD_TEXTBOX).sendKeys(password);
		
	}

	public void enterConfirmPassword(String confirmPassword) {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		getElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX).sendKeys(confirmPassword);
		
	}

	public String getRegisterSuccessMessage() {
		// TODO Auto-generated method stub
		waitForElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE).getText();
	}


}
