package pageObjects.users;

import org.openqa.selenium.WebDriver;

import pageUIs.users.SideBarPageUI;

public class AddressesPageObject extends SideBarPageObject {
	WebDriver driver;
	public AddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	public CustomerPageObject openCustomerObject() {
		waitForElementClickable(driver, SideBarPageUI.CUSTOMERINFO_PAGE_LINK );
		clickToAnElement(driver, SideBarPageUI.CUSTOMERINFO_PAGE_LINK);
		return getCustomerPageObject();
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
