package commons;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;



public class BaseTest {
	protected final Logger log;
	private WebDriver driver;
	//String projectPath = System.getProperty("user.dir");
	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}
	protected WebDriver getBrowserDriver(String browserName, String userUrl) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver.exe");
			driver = new ChromeDriver();
			
			/*
			 * ChromeOptions options=new ChromeOptions();
			 * 
			 * 
			 * 
			 * Map<String, Object> prefs = new HashMap<String, Object>();
			 * 
			 * 
			 * 
			 * prefs.put("download.default_directory", "C:\\download");
			 * 
			 * 
			 * 
			 * options.setExperimentalOption("prefs", prefs);
			 * 
			 * 
			 * 
			 * driver=new ChromeDriver(options);
			 */
			break;
		case FIREFOX:
			//	System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case EDGE:
			//System.setProperty("webdriver.edge.driver", projectPath + "/browserDriver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		default:
			throw new RuntimeException("Browser name is invalid");
		}
		
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(userUrl);
		return driver;
	}
	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
			case CHROME:
				//System.setProperty("webdriver.chrome.driver", projectPath + "/browserDriver/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case FIREFOX:
			//	System.setProperty("webdriver.gecko.driver", projectPath + "/browserDriver/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case EDGE:
				//System.setProperty("webdriver.edge.driver", projectPath + "/browserDriver/msedgedriver.exe");
				driver = new EdgeDriver();
				break;
			default:
				throw new RuntimeException("Browser name is invalid");
		}
		
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com");
		return driver;
		}
		
	 protected int randomNumber() { 
		 Random rand = new Random(); 
		 int randomNumber = rand.nextInt(99999); 
		 return randomNumber; 
		 }

	 protected String getEmailAddress() { 
		 String firstName = "snape"; 
		 String LastName = "severus"; 
		 return firstName + LastName + randomNumber()+"@gmail.com"; 
		 }
	 
	 protected void sleepInSecond(long timeInSecond) {
			try {
				Thread.sleep(timeInSecond * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 protected boolean verifyTrue(boolean condition) {
			boolean pass = true;
			try {
				Assert.assertTrue(condition);
				log.info("-------------PASSED-------------");
			} catch (Throwable e) {
				log.info("-------------FAILED-------------");
				pass = false;

				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}

		protected boolean verifyFalse(boolean condition) {
			boolean pass = true;
			try {
				Assert.assertFalse(condition);
				log.info("-------------PASSED-------------");
			} catch (Throwable e) {
				log.info("-------------FAILED-------------");
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}

		protected boolean verifyEquals(Object actual, Object expected) {
			boolean pass = true;
			try {
				Assert.assertEquals(actual, expected);
				log.info("-------------PASSED-------------");
			} catch (Throwable e) {
				log.info("-------------FAILED-------------");
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}
	 
	
}
