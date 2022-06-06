package generic_library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Ravikiran
 * 
 * Baseclass is used to perform pre-condition and post-condition 
 *
 */
public class Baseclass {
	public WebDriver driver=null;
	java_utility jlib=new java_utility();
	webdriver_utility wlib=new webdriver_utility();
	File_Utility flib=new File_Utility();
	Excel_utility elib=new Excel_utility();
	
	/**
	 * BeforeSuite is used to connect to database
	 */
	@BeforeSuite
	public void dataBaseConnection() {
		System.out.println("connect to database");
	}
	/**
	 * BeforeTest used to do parallel execution
	 */
	@BeforeTest
	public void parallelmode() {
		System.out.println("to execute in parallel mode");
	}
	/**
	 * Before class will launch the browser
	 * @throws Throwable
	 */
	@BeforeClass
	public void launchBrowser() throws Throwable {
		String browser=flib.getProperty("browser");
		String url = flib.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else throw new Exception("browser is not compatible");
		
		wlib.maximizeWindow(driver);
		wlib.WaitforpagetoLoad(driver);
		driver.get(url);
	}
	/**
	 * BeforeMethod is used to perform login function of the application
	 */
	@BeforeMethod
	public void login() {
		System.out.println("login to application");
	}
	/**
	 * AfterMethod is used to perform logout function of the application
	 */
	@AfterMethod
	public void logout() {
		System.out.println("logout from application");
	}
	/**
	 * AfterClass is used to quit/close the browser
	 */
	@AfterClass
	public void closebrowser() {
		driver.quit();
	}
	/**
	 * AfterTest is used to close parallel connection
	 */
	@AfterTest
	public void afterParallelMode() {
		System.out.println("close parallel Mode of Execution");
	}
	/**
	 * AfterSuite is used to close database connection
	 */
	@AfterSuite
	public void closeDataBaseConnection() {
		System.out.println("close database connection");
	}

}
