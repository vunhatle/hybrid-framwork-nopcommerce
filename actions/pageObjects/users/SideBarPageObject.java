package pageObjects.users;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class SideBarPageObject extends BasePage {
	WebDriver driver;
	public SideBarPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public AddressesPageObject getAddressesPageObject() {
		return new AddressesPageObject(driver);
	}
	public CustomerPageObject getCustomerPageObject() {
		return new CustomerPageObject(driver);
	}
	public DownloadablePageObject getDowloadablePageObject() {
		return new DownloadablePageObject(driver);
	}
	public RewardPageObject getRewardPageObject() {
		return new RewardPageObject(driver);
	}
}
