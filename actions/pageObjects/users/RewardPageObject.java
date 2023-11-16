package pageObjects.users;

import org.openqa.selenium.WebDriver;

import pageUIs.users.SideBarPageUI;

public class RewardPageObject extends SideBarPageObject {
	WebDriver driver;
	public RewardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public CustomerPageObject openCustomerPageObject () {
		waitForElementClickable(driver, SideBarPageUI.CUSTOMERINFO_PAGE_LINK);
		clickToAnElement(driver, SideBarPageUI.CUSTOMERINFO_PAGE_LINK);
		return getCustomerPageObject();
	}
	public AddressesPageObject openAddressesPageObject () {
		waitForElementClickable(driver, SideBarPageUI.ADDRESS_PAGE_LINK);
		clickToAnElement(driver, SideBarPageUI.ADDRESS_PAGE_LINK);
		return getAddressesPageObject();
	}
	public DownloadablePageObject openDownloadPageObject () {
		waitForElementClickable(driver, SideBarPageUI.DOWNLOADABLE_PAGE_LINK);
		clickToAnElement(driver, SideBarPageUI.DOWNLOADABLE_PAGE_LINK);
		return getDowloadablePageObject();
	}

	
}
