package commons;

import java.io.File;

public class GlobalConstants {
	// Server URL: Dev/ Testing/ Staging/ Product
	// Database: Dev/ testing/ Staging/ Product
	// Timeout: Short/ Long
	// Username/ Pass
	// Third Party: Sandbox Paypal
	// Download/ Upload folder
	// Relative Project Path
	// OS name
	// Cloud Testing: Browserstack/ Saucelab/ CrossbrowserTesting (Access Token/ID)
	// ..
	
	public static final String DEV_JQUERY_URL = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
	public static final String DEV_USER_URL = "https://demo.nopcommerce.com";
	public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 15;
	public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
	public static final String DEV_ADMIN_PASSWORD = "admin";
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE = RELATIVE_PROJECT_PATH + File.separator +  "downloadFiles" + File.separator;
	

	

}
