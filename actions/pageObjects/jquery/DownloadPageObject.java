package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DownloadPageObject extends BasePage {
	WebDriver driver;
	
	public DownloadPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
