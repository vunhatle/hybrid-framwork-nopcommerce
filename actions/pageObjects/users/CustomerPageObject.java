package pageObjects.users;

import org.openqa.selenium.WebDriver;


import pageUIs.users.CustomerPageUI;
import pageUIs.users.SideBarPageUI;

public class CustomerPageObject extends SideBarPageObject {
	
	WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		super(driver);
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
	
	public DownloadablePageObject openDownloadablePageObject () {
		waitForElementClickable(driver, SideBarPageUI.DOWNLOADABLE_PAGE_LINK);
		clickToAnElement(driver, SideBarPageUI.DOWNLOADABLE_PAGE_LINK);
		return getDowloadablePageObject();
	}
	public AddressesPageObject openAddressesPageObject () {
		waitForElementClickable(driver, SideBarPageUI.ADDRESS_PAGE_LINK);
		clickToAnElement(driver, SideBarPageUI.ADDRESS_PAGE_LINK);
		return getAddressesPageObject();
	}
	public RewardPageObject openRewardPageObject () {
		waitForElementClickable(driver, SideBarPageUI.REWARD_PAGE_LINK);
		clickToAnElement(driver, SideBarPageUI.REWARD_PAGE_LINK);
		return getRewardPageObject();
	}
	


}
