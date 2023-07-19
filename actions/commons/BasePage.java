 package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	
	
	// Window methods
	public void openURL(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getPageTittle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	public void backPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}
	
	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public void sendKeyToAlert(WebDriver driver, String text) {
		waitForAlertPresence(driver).sendKeys(text);
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	public Alert waitForAlertPresence (WebDriver driver) {
		  return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}
	
	public WebElement webDriverWaitForElement(WebDriver driver, String locator) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void switchToWindowByTittle(WebDriver driver,String expectedTittle) {
		Set<String> allIDs = driver.getWindowHandles();
		for(String id : allIDs) {
			driver.switchTo().window(id);
			String actualTittle = driver.getTitle();
			if(actualTittle.equals(expectedTittle)) {
				break;
			}
		}
	}
	// xem lai nhe, co switch ve expectedID khong khi close tab
	public void closeAllWindowWithoutExpectedID(WebDriver driver, String expectedTittle) {
		Set <String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTittle = driver.getTitle();
			if(!actualTittle.equals(expectedTittle)) {
				driver.close();
			}
		}
		String expectedID = driver.getWindowHandle();
		driver.switchTo().window(expectedID);
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Element methods
	public By getByXpath(String xpathExpression) {
		return By.xpath(xpathExpression);
	}
	
	public WebElement getElement(WebDriver driver, String xpathExpression) {
		return driver.findElement(By.xpath(xpathExpression));
	}
	
	public void clickToAnElement(WebDriver driver, String xpathExpression) {
		getElement(driver, xpathExpression).click();
	}
	
	public void sendkeyToAnElement(WebDriver driver, String xpathExpression, String value) {
		getElement(driver, xpathExpression).clear();
		getElement(driver, xpathExpression).sendKeys(value);
	}
	
	public String getTextFromAnElement(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).getText();
	}
	
	public List<WebElement> getListElements(WebDriver driver, String xpathExpression) {
		return driver.findElements(By.xpath(xpathExpression));
	}
}
