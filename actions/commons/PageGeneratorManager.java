package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.AddressesPageObject;
import pageObjects.users.CustomerPageObject;
import pageObjects.users.DownloadablePageObject;
import pageObjects.users.HomePageObject;
import pageObjects.users.LoginPageObject;
import pageObjects.users.RegisterPageObject;
import pageObjects.users.RewardPageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static CustomerPageObject getCustomerPage(WebDriver driver) {
		return new CustomerPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	public static AddressesPageObject getAddressesPageObjectWe(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	public static CustomerPageObject getCustomerPageObject(WebDriver driver) {
		return new CustomerPageObject(driver);
	}
	public static DownloadablePageObject getDowloadablePageObject(WebDriver driver) {
		return new DownloadablePageObject(driver);
	}
	public static RewardPageObject getRewardPageObject(WebDriver driver) {
		return new RewardPageObject(driver);
	}
}
