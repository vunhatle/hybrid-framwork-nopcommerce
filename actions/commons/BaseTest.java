package commons;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	//String projectPath = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName, String userUrl) {
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
		driver.get(userUrl);
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
	 
	protected void quitDriver() {
		driver.quit();
	}
}
