package pageObjects.jquery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputIntoColumnTextboxByName(String columnName, String value) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, columnName);
		sendkeyToAnElement(driver, HomePageUI.COLUMN_TEXTBOX_BY_NAME, value, columnName);
	}
	
	public void clickOnPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_NUMBER, pageNumber);
		clickToAnElement(driver, HomePageUI.PAGE_NUMBER, pageNumber);
	}
	
	public boolean isActivePageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.ACTIVE_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.ACTIVE_PAGE_NUMBER, pageNumber);
	}
	public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUES, female, country, male, total);
	}
	
	public void clickonActionEditOrRemove(String females, String action) {
		waitForElement(driver, HomePageUI.DYNAMIC_ACTION_BUTTON, females, action);
		clickToAnElement(driver, HomePageUI.DYNAMIC_ACTION_BUTTON, females, action);
	}
	
	public List<String> getAllPageValuesByColumnName(String columnName) {
		List<String> allValues = new ArrayList<String>();
		
		// Buoc 1: lay ra tat ca cac Page
		List<WebElement> allPageLinks = getListElements(driver, HomePageUI.ALL_PAGE_LINKS);
		
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		
		// Buoc 2: Duyet qua tung page
		for(WebElement pageLink: allPageLinks) {
			pageLink.click();
			sleepInSecond(2);
			
			//buoc 3: lay ra het cac gia tri cua 1 cot trong page do -> Luu no vao List/Set/...
			List<WebElement> allRowValues = getListElements(driver, HomePageUI.ALL_VALUES_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			for (WebElement rowValue : allRowValues) {
				allValues.add(rowValue.getText());
				
			}
		}
		//System.out.println(allValues);
		return allValues;
		
	}

	public void inputInCellByColumnNameAndRowIndex(String columnName, String rowIndex, String inputValue) {
		// TODO Auto-generated method stub
		// Buoc 1 xac dinh Row Index
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME_2, columnName) + 1;
		sendkeyToAnElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME_AND_INDEX, inputValue, columnName, rowIndex, String.valueOf(columnIndex));
		
		
		
	}

	public void selectCellByColumnNameAndRowIndex(String columnName, String rowIndex, String option) {
		// TODO Auto-generated method stub
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME_2, columnName) + 1;
		selectDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_NAME_AND_INDEX, option, columnName, rowIndex, String.valueOf(columnIndex));
		
	}

	public void clickOnCheckBoxByNameAndRowIndex(String columnName, String rowIndex) {
		// TODO Auto-generated method stub
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME_2, columnName) + 1;
		checkToCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_NAME_AND_INDEX, columnName, rowIndex, String.valueOf(columnIndex) );
		
	}
}
