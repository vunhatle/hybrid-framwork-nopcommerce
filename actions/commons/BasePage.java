 package commons;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	
	public WebElement waitForElement(WebDriver driver, String xpathExpression) {
		return new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathExpression)));
	}
	
	public void waitForElementVisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathExpression)));
	}
	public void waitForListElementVisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathExpression)));
	}
	public void waitForElementClickable(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(getByXpath(xpathExpression)));
	}
	public void waitForElementInvisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver,15).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathExpression)));
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
		Set<String> allIDs = driver.getWindowHandles();
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
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathExpression) {
		return new Select(getElement(driver, xpathExpression)).isMultiple();
		
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String xpathParent, String xpathChild, String expectedText) {
		getElement(driver, xpathParent).click();
		sleepInSecond(1);
		
		List <WebElement> allItems = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathChild)));
		
		for (WebElement tempElement : allItems) {
			if(tempElement.getText().equals(expectedText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntroVIew(true);", tempElement);
				sleepInSecond(1);
				
				tempElement.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	
	public String getTextFromAnElement(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).getText();
	}
	
	public List<WebElement> getListElements(WebDriver driver, String xpathExpression) {
		return driver.findElements(By.xpath(xpathExpression));
	}
	
	public String getAttributeValue(WebDriver driver, String xpathExpression, String attribute) {
		return driver.findElement(By.xpath(xpathExpression)).getAttribute(attribute);
	}
	
	public String getCSSvalue(WebDriver driver, String xpathExpression, String propertyName) {
		return getElement(driver, xpathExpression).getCssValue(propertyName);
		
	}
	
	public int getListElementSize(WebDriver driver, String xpathExpression) {
		return getListElements(driver, xpathExpression).size();
	}
	
	public void checkToCheckbox(WebDriver driver, String xpathExpression) {
		if(!isElementSelected(driver, xpathExpression)) {
			clickToAnElement(driver, xpathExpression);
		}
	}
	
	public void unCheckToCheckbox(WebDriver driver, String xpathExpression) {
		if(isElementSelected(driver, xpathExpression)) {
			clickToAnElement(driver, xpathExpression);
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isDisplayed();
	}
	public boolean isElementSelected(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isSelected();
	}
	public boolean isElementEnable(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isEnabled();
	}
	
	public void switchToFrame(WebDriver driver, String xpathExpression	) {
		driver.switchTo().frame(getElement(driver, xpathExpression));
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).moveToElement(getElement(driver, xpathExpression)).perform();
	}
	
	public void doubleClickOnElement(WebDriver driver, String xpathEpression) {
		new Actions(driver).doubleClick(getElement(driver, xpathEpression)).perform();
	}
	
	public void rightClickOnElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).contextClick(getElement(driver, xpathExpression)).perform();
	}
	
	public void dragAndDropToElement(WebDriver driver, String sourceXpath, String targetXpath) {
		new Actions(driver).dragAndDrop(getElement(driver, sourceXpath), getElement(driver, targetXpath)).perform();
	}
	
	public void sendKeyBoardToElement(WebDriver driver, String xpathExpression, Keys key) {
		new Actions(driver).sendKeys(getElement(driver, xpathExpression), key).perform();
	}
	
	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}
	
	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}
	
	
	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String)((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '"+url+"'");
	}
	
	public void highlightElement(WebDriver driver, String xpathExpression) {
		WebElement element = getElement(driver, xpathExpression);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}
	
	
	public void clickToElementByJS(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].cli+ck();", getElement(driver, xpathExpression));
		sleepInSecond(3);
	}
	
	public void scrollToElementOnTop(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", getElement(driver, xpathExpression));
	}
	public void scrollToElementOnDown (WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)", getElement(driver, xpathExpression));
	}
	public void setAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName, String attributeValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "','"+ attributeValue+"');", getElement(driver, xpathExpression));
	}
	
	public void removeAttributeInDOM(WebDriver driver, String xapthExpression, String attributeRemove){
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('"+ attributeRemove+"');", getElement(driver, xapthExpression));
	}
	
	
	public void sendkeyToElementByJS(WebDriver driver, String xpathExpression, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '"+ value+"')", getElement(driver, xpathExpression));
	}
	
	public String getAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('"+attributeName+"');", getElement(driver, xpathExpression));
	}
	
	public String getElementValidationMessage(WebDriver driver, String xpathExpression) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, xpathExpression));
	}
	
	public boolean isImageLoaded(WebDriver driver, String xpathExpression) {
		return (boolean)((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, xpathExpression));
	}
	public int randomNumber() {
		Random rand = new Random();
		int randomNumber = rand.nextInt(99999);
		return randomNumber;
	}
	
	public String getEmailAddress() {
		String firstName = "snape";
		String LastName = "severus";
		return firstName + LastName + randomNumber()+"@gmail.com";
		
	}
	
	
}
