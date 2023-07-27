package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage {
	
	WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameAttributeValue() {
		// TODO Auto-generated method stub
		waitForElement(driver, CustomerPageUI.FIRST_NAME_TEXTBOX);
		return getAttributeValue(driver, CustomerPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameAttributeValue() {
		// TODO Auto-generated method stub
		waitForElement(driver, CustomerPageUI.LAST_NAME_TEXTBOX);
		return getAttributeValue(driver, CustomerPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getEmailAttributeValue() {
		// TODO Auto-generated method stub
		waitForElement(driver, CustomerPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
	}

}
