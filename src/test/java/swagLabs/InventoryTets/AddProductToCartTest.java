package swagLabs.InventoryTets;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.CartPage;
import swagLabs.ObjectRepository.InventoryPage;
import swagLabs.ObjectRepository.LoginPage;
import swagLabs.ObjectRepository.ProductPage;

public class AddProductToCartTest {

	
	@Test
	public void tc_01_AddProductToCartTest() throws IOException	
	{
		// Create Object of All utilities
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
		
		//Login to App
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 3: Click on product - ProductName from excel
		InventoryPage ip = new InventoryPage(driver);
		String productAdded = ip.clickOnAnyProduct(driver, PRODUCTNAME);

		// Step 4: click on add To cart button
		ProductPage pp = new ProductPage(driver);
		pp.clickOnAddToCartBtn();

		// Step 5: Navigate to Cart
		ip.clickOnCartContainer();

		// Step 6: Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String productInCart = cp.getProductInfo();

		//Step 7 Validation
		if(productAdded.equals(productInCart))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("fail");
		}

		System.out.println(productInCart);
		
		//Step 8: Logout
		ip.logOutOfApp();

	}

	

}
