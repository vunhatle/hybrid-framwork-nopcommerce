package pageObjects.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.UploadPageUI;

public class UploadFilesObject extends BasePage {
	WebDriver driver;
	public UploadFilesObject(WebDriver driver){
		this.driver = driver;
	}
	
	public boolean isUploadedFileSuccessful(WebDriver driver, String fileName) {
		waitForElementVisible(driver, UploadPageUI.UPLOAD_FILE_BY_NAME, fileName );
		return isElementDisplayed(driver, UploadPageUI.UPLOAD_FILE_BY_NAME, fileName);
	}
	
	public void clickOnStartButtonOfEachRow(WebDriver driver) {
		List<WebElement> startButtons = getListElements(driver, UploadPageUI.START_UPLOAD_BUTTON_FOR_EACH_ROW);
		for (WebElement startButton : startButtons) {
			waitForElementClickable(driver, startButton);
			clickToAnElement(driver, startButton);
		}
	}
}
