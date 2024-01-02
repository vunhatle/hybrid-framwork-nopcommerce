package com.jquery.table;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;

public class Level_13_Handle_DataTable extends BaseTest {
	WebDriver driver;
	String osName = System.getProperty("os.name");
	String url = GlobalConstants.DEV_JQUERY_URL;
	pageObjects.jquery.HomePageObject homePage;
	List<String> allValuesUI;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, url);
		homePage = pageObjects.jquery.PageGeneratorManager.getHomePage(driver);
	}

	
	/*
	 * @Test public void TC_01_Search() {
	 * homePage.inputIntoColumnTextboxByName("Females", "384187"); }
	 */
	/*
	 * @Test public void TC_02_Paging() { homePage.scrollToBottomPage(driver);
	 * homePage.clickOnPageNumber("6");
	 * Assert.assertTrue(homePage.isActivePageNumber("6")); }
	 * 
	 * @Test public void TC_03_Displayed() {
	 * Assert.assertTrue(homePage.isRowValuesDisplayed("7468", "Cyprus", "7875",
	 * "15343")); }
	 * 
	 * @Test public void TC_04_Doing_Action() {
	 * homePage.clickonActionEditOrRemove("7468", "edit");
	 * homePage.refreshCurrentPage(driver);
	 * homePage.clickonActionEditOrRemove("777", "remove"); }
	 */
	
	/*
	 * @Test public void TC_05_Get_All_Column_Values() { allValuesUI =
	 * homePage.getAllPageValuesByColumnName("Males"); }
	 */
	
	@Test
	public void TC_06_Action_By_Index() {
		homePage.openURL(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		
		//Nhap vao textbox cot Contact Person, dong thu 2
		homePage.inputInCellByColumnNameAndRowIndex("Contact Person","2","hello");
		homePage.inputInCellByColumnNameAndRowIndex("Company", "3", "hi");
		
		
		// Select du lieu
		homePage.selectCellByColumnNameAndRowIndex("Country","2","Japan");
		
		
		// click on checkbox
		homePage.clickOnCheckBoxByNameAndRowIndex("NPO?","3");
	}
	
	

	/*
	 * @AfterClass public void afterClass() { quitDriver(); }
	 */

}
