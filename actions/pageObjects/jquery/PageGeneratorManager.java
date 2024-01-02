package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static UploadFilesObject getUploadFilesPage(WebDriver driver) {
		return new UploadFilesObject(driver);
	}
	public static DownloadPageObject getDownloadPage(WebDriver driver) {
		return new DownloadPageObject(driver);
	}
}
