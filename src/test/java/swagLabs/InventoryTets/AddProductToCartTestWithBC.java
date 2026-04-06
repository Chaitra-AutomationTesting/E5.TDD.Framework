package swagLabs.InventoryTets;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import swagLabs.BaseTest.BaseClass;
import swagLabs.GenericUtilities.FileUtility;
import swagLabs.GenericUtilities.WebDriverUtility;
import swagLabs.ObjectRepository.CartPage;
import swagLabs.ObjectRepository.InventoryPage;
import swagLabs.ObjectRepository.LoginPage;
import swagLabs.ObjectRepository.ProductPage;

public class AddProductToCartTestWithBC extends BaseClass{

	
	@Test
	public void tc_01_AddProductToCartTest() throws IOException	
	{
		// Read all the required Data
		String PRODUCTNAME = fUtil.readDatafromExcel("Products", 1, 2);

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
//		if(productAdded.equals(productInCart))
//		{
//			System.out.println("PASS");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
		
		assertEquals(productInCart, productAdded);
		 //or
		assertTrue(productAdded.equals(productInCart));

		System.out.println(productInCart);
	

	}

	

}
