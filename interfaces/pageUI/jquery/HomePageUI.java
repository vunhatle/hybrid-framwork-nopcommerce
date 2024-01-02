package pageUI.jquery;

public class HomePageUI {
	public static final String COLUMN_TEXTBOX_BY_NAME = "xpath=//div[text() ='%s']/parent::div/following-sibling::input";
	public static final String PAGE_NUMBER = "xpath=//ul[@class = 'qgrd-pagination-ul']/li/a[text()='%s']";
	public static final String ACTIVE_PAGE_NUMBER = "xpath=//ul[@class = 'qgrd-pagination-ul']/li/a[contains(@class,'active') and text()='%s']";
	public static final String DYNAMIC_ROW_VALUES = "xpath=//tr/td[@data-key='females' and text() = '%s']/following-sibling::td[@data-key='country' and text() = '%s']/following-sibling::td[@data-key='males' and text() = '%s']/following-sibling::td[@data-key='total' and text() = '%s']";
	public static final String DYNAMIC_ACTION_BUTTON ="xpath=//td[@data-key='females' and text()='%s']/preceding-sibling::td/button[contains(@class,'%s')]";
	public static final String ALL_PAGE_LINKS = "xpath=//li[contains(@class,'pagination-page')]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME ="xpath=//th//div[text()='%s']/ancestor::th/preceding-sibling::th/div[@class='qgrd-header-wrap']";
	public static final String ALL_VALUES_BY_COLUMN_INDEX = "xpath=//table//tr/td[%s]";
	
	public static final String COLUMN_INDEX_BY_COLUMN_NAME_2 = "xpath=//th[text() = '%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_COLUMN_NAME_AND_INDEX = "xpath=//th[text()='%s']/ancestor::thead/following-sibling::tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_NAME_AND_INDEX = "xpath=//th[text()='%s']/ancestor::thead/following-sibling::tbody/tr[%s]/td[%s]//select";
	public static final String CHECKBOX_BY_COLUMN_NAME_AND_INDEX = "xpath=//th[text()='%s']/ancestor::thead/following-sibling::tbody/tr[%s]/td[%s]//input";

}
