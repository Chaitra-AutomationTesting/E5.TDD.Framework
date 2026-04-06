package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.LoginPage;

public class TC_01_AddProductToCartUsingDDTAndGU {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Create Object of All utilities
		FileUtility fUtil = new FileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		// Read all the required Data
		/* Common data - Property file */		
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		/* Test Data - Excel File */
		String PRODUCTNAME = fUtil.readDatafromExcel("Products", 1, 2);
		 
		WebDriver driver;

		// Launch the browser
		// WebDriver driver = new EdgeDriver();

		if (BROWSER.equalsIgnoreCase("chrome")) // Run time Polymorphism - Driver
		{
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new EdgeDriver();
			// System.out.println("Enter a valid Browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);

		// Load the url
		driver.get(URL);

		// Login to the Application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.name("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
//		lp.getUsernameTF().sendKeys(USERNAME);
//		lp.getPasswordTF().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
	
		
		

		// Click on Product - PRODUCTNAME - Excel - Dynamic Xpath - //div[.='Sauce Labs backpack'] - //div[.='Sauce Labs Bike light']
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();

		// Add Product to Cart
		driver.findElement(By.id("add-to-cart")).click();

		// Navigate to Cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		// Capture the product information
		String actResult = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

		// Validate for the proudct
		Assert.assertTrue(actResult.equalsIgnoreCase(PRODUCTNAME));

		// or
		Assert.assertEquals(actResult, PRODUCTNAME);

		// Logout of the App
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();

		// Close the Browser
		driver.quit();

	}

}
