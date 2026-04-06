package swagLabs.BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.JavaUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.InventoryPage;
import swagLabs.ObjectRepository.LoginPage;

/**
 * This class consists of Basic Configuration annotations of TestNG
 * @author Chaitra M
 *
 */
public class BaseClass {
	
	//Create all utility Object
	public JavaUtility jUtil = new JavaUtility();
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sDriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("========= Database Connection successfull ==========");
	}
	
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig() throws IOException
	{ 
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) // Run time Polymorphism - Driver
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
			// System.out.println("Enter a valid Browser name");
		}

		wUtil.maximizeWindow(driver); //sessionid - TRUUGHFKJ565FGCLKGFYR7RYU
		wUtil.waitForPageLoad(driver);

		// Load the url
		driver.get(URL);
		
		System.out.println("========= Browser Launch successfull ==========");
		
		//For Listener
		sDriver = driver;
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("========= Login to App successfull ==========");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logOutOfApp();
		
		System.out.println("========= Logout of App successfull ==========");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("========= Browser closure successfull ==========");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("========= Database Closure successfull ==========");
	}
	

}
