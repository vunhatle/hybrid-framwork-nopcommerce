package commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.admin.AdminLoginPageObject;
import pageObjects.users.HomePageObject;
import pageUIs.users.BasePageUI;
import pageUIs.users.SideBarPageUI;

public class BasePage {
	private Long longTimeout = GlobalConstants.LONG_TIMEOUT;

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

	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
	}

	public WebElement waitForElement(WebDriver driver, String xpathExpression) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathExpression)));
	}
	public WebElement waitForElement(WebDriver driver, String locator, String... restParams) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
	}

	public void waitForElementVisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(xpathExpression)));
	}
	public void waitForElementVisible(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
	}

	public void waitForListElementVisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(xpathExpression)));
	}
	public void waitForListElementVisible(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocator(locator, restParams))));
	}

	public void waitForElementClickable(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.elementToBeClickable(getByLocator(xpathExpression)));
	}
	public void waitForElementClickable(WebDriver driver, WebElement xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.elementToBeClickable(xpathExpression));
	}
	public void waitForElementClickable(WebDriver driver, String locator, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathExpression) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(xpathExpression)));
	}
	public void waitForElementInvisible(WebDriver driver, String loactor, String... restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(loactor, restParams))));
	}

	public void switchToWindowByTittle(WebDriver driver, String expectedTittle) {
		Set<String> allIDs = driver.getWindowHandles();
		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualTittle = driver.getTitle();
			if (actualTittle.equals(expectedTittle)) {
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
			if (!actualTittle.equals(expectedTittle)) {
				driver.close();
			}
		}
		String expectedID = driver.getWindowHandle();
		driver.switchTo().window(expectedID);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Element methods 
	 * public By getByXpath(String xpathExpression) { 
	 * return By.xpath(xpathExpression); 
	 * }
	 */

	public WebElement getElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}
	

	public void clickToAnElement(WebDriver driver, String xpathExpression) {
		getElement(driver, xpathExpression).click();
	}
	public void clickToAnElement(WebDriver driver, WebElement xpathExpression) {
		xpathExpression.click();
	}
	
	public void clickToAnElement(WebDriver driver, String locator, String... restParams) {
		getElement(driver, getDynamicLocator(locator, restParams)).click();
	}

	public void sendkeyToAnElement(WebDriver driver, String locator, String value, String... restParams) {
		getElement(driver, getDynamicLocator(locator, restParams)).clear();
		getElement(driver, getDynamicLocator(locator, restParams)).sendKeys(value);
	}
	public void sendkeyToAnElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathExpression) {
		return new Select(getElement(driver, xpathExpression)).isMultiple();
		
	}
	public void selectDefaultDropdown(WebDriver driver, String xpathExpression, String option) {
		new Select(getElement(driver, xpathExpression)).selectByVisibleText(option);
	}
	public void selectDefaultDropdown(WebDriver driver, String xpathExpression, String option, String... restParams) {
		new Select(getElement(driver,getDynamicLocator(xpathExpression, restParams))).selectByVisibleText(option);
	}

	public void selectItemInCustomDropdown(WebDriver driver, String xpathParent, String xpathChild,String expectedText) {
		getElement(driver, xpathParent).click();
		sleepInSecond(1);
		List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(xpathChild)));
		for (WebElement tempElement : allItems) {
			if (tempElement.getText().equals(expectedText)) {
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
	public String getTextFromAnElement(WebDriver driver, String locator, String... restParams) {
		return getElement(driver, getDynamicLocator(locator, restParams)).getText();
	}

	public List<WebElement> getListElements(WebDriver driver, String xpathExpression) {
		return driver.findElements(getByLocator(xpathExpression));
	}
	public List<WebElement> getListElements(WebDriver driver, String xpathExpression, String ...restParams) {
		return driver.findElements(getByLocator(getDynamicLocator(xpathExpression, restParams)));
	}

	public String getAttributeValue(WebDriver driver, String xpathExpression, String attribute) {
		return driver.findElement(getByLocator(xpathExpression)).getAttribute(attribute);
	}
	public String getAttributeValue(WebDriver driver, String locator, String attribute, String... restParams) {
		return driver.findElement(getByLocator(getDynamicLocator(locator, restParams))).getAttribute(attribute);
	}

	public String getCSSvalue(WebDriver driver, String xpathExpression, String propertyName) {
		return getElement(driver, xpathExpression).getCssValue(propertyName);	
	}
	public String getCSSvalue(WebDriver driver, String locator, String propertyName, String... restParams) {
		return getElement(driver, getDynamicLocator(locator, restParams)).getCssValue(propertyName);
	}

	public int getListElementSize(WebDriver driver, String xpathExpression) {
		return getListElements(driver, xpathExpression).size();
	}
	public int getListElementSize(WebDriver driver, String xpathExpression, String ...restParams) {
		return getListElements(driver, xpathExpression, restParams).size();
	}

	public void checkToCheckbox(WebDriver driver, String xpathExpression) {
		if (!isElementSelected(driver, xpathExpression)) {
			clickToAnElement(driver, xpathExpression);
		}
	}
	public void checkToCheckbox(WebDriver driver, String xpathExpression, String...restParams) {
		if (!isElementSelected(driver, xpathExpression, restParams)) {
			clickToAnElement(driver, xpathExpression, restParams);
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String xpathExpression) {
		if (isElementSelected(driver, xpathExpression)) {
			clickToAnElement(driver, xpathExpression);
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isDisplayed();
	}
	public boolean isElementDisplayed(WebDriver driver, String locator, String... restParams) {
		return getElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
	}

	public boolean isElementSelected(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isSelected();
	}
	public boolean isElementSelected(WebDriver driver, String locator, String... restParams) {
		return getElement(driver, getDynamicLocator(locator, restParams)).isSelected();
	}

	public boolean isElementEnable(WebDriver driver, String xpathExpression) {
		return getElement(driver, xpathExpression).isEnabled();
	}
	public boolean isElementEnable(WebDriver driver, String locator, String... restParams) {
		return getElement(driver, getDynamicLocator(locator, restParams)).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String xpathExpression) {
		driver.switchTo().frame(getElement(driver, xpathExpression));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).moveToElement(getElement(driver, xpathExpression)).perform();
	}
	public void hoverToElement(WebDriver driver, String locator, String... restParams) {
		new Actions(driver).moveToElement(getElement(driver, getDynamicLocator(locator, restParams))).perform();
	}

	public void doubleClickOnElement(WebDriver driver, String xpathEpression) {
		new Actions(driver).doubleClick(getElement(driver, xpathEpression)).perform();
	}
	public void doubleClickOnElement(WebDriver driver, String locator, String... restParams) {
		new Actions(driver).doubleClick(getElement(driver, getDynamicLocator(locator, restParams))).perform();
	}

	public void rightClickOnElement(WebDriver driver, String xpathExpression) {
		new Actions(driver).contextClick(getElement(driver, xpathExpression)).perform();
	}
	public void rightClickOnElement(WebDriver driver, String locator, String... restParams) {
		new Actions(driver).contextClick(getElement(driver, getDynamicLocator(locator, restParams))).perform();
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
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String xpathExpression) {
		WebElement element = getElement(driver, xpathExpression);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].cli+ck();", getElement(driver, xpathExpression));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",
				getElement(driver, xpathExpression));
	}

	public void scrollToElementOnDown(WebDriver driver, String xpathExpression) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)",
				getElement(driver, xpathExpression));
	}

	public void setAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName,
			String attributeValue) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('" + attributeName + "','" + attributeValue + "');",
				getElement(driver, xpathExpression));
	}

	public void removeAttributeInDOM(WebDriver driver, String xapthExpression, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getElement(driver, xapthExpression));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathExpression, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getElement(driver, xpathExpression));
	}

	public String getAttributeInDOM(WebDriver driver, String xpathExpression, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, xpathExpression));
	}

	public String getElementValidationMessage(WebDriver driver, String xpathExpression) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getElement(driver, xpathExpression));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathExpression) {
		return (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(driver, xpathExpression));
	}
	
	/*
	 * public HomePageObject clickToLogOutLink(WebDriver driver ) {
	 * waitForElementClickable(driver, BasePageUI.LOGOUT_LINK);
	 * clickToAnElement(driver, BasePageUI.LOGOUT_LINK); return
	 * PageGeneratorManager.getHomePage(driver); }
	 * 
	 * public AdminLoginPageObject adminClickOnLogOut(WebDriver driver) {
	 * waitForElementClickable(driver, BasePageUI.ADMIN_LOGOUT_LINK);
	 * clickToAnElement(driver, BasePageUI.ADMIN_LOGOUT_LINK); return
	 * PageGeneratorManager.getAdminLoginPage(driver); }
	 */
	
	public void openDynamicMorePage(WebDriver driver, String pageName) {
		waitForElementClickable(driver, SideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName);
		clickToAnElement(driver,SideBarPageUI.DYNAMIC_SIDEBAR_LINK_TEXT, pageName );
	}
	
	private By getByLocator(String locatorType) {
		By by = null;
		//System.out.println("Locator type = "+ locatorType);
		if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")){
			by = By.id(locatorType.substring(3));
		}else if(locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		}else if(locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		}else if(locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if(locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator type is not supported");
		}
		return by;
	}
	
	public String getDynamicLocator(String locator, String ... restParams) {
		return String.format(locator, (Object[]) restParams);	
	}
	
	public void uploadMultiplesFiles(WebDriver driver, String ... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullNameFiles = "";
		for (String file : fileNames) {
			fullNameFiles = fullNameFiles + filePath + file + "\n";
		}
		fullNameFiles = fullNameFiles.trim();
		getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullNameFiles);
		
		
	}
	
	public void takeSnapShot(WebDriver driver, String filePath, String photoName) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
		//File desFile = new File(filePath);
		try {
			org.openqa.selenium.io.FileHandler.copy(scrFile, new File(filePath+photoName+".jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
