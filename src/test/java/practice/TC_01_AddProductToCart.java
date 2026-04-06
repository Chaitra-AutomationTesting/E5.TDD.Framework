package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01_AddProductToCart {
	
	@Test
	public void addProductToCartTest() throws InterruptedException
	{
		
		//Launch the Browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load the URL
		driver.get("https://www.saucedemo.com/");
		
		//Login to the Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Click on Product - Sauce Labs Bike Light
		driver.findElement(By.xpath("//div[.='Sauce Labs Bike Light']")).click();		
		
		//Add Product to Cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Navigate to Cart
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
		//Capture the product information
		String actResult = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		
		//Validate for the proudct
		Assert.assertTrue(actResult.equalsIgnoreCase("Sauce Labs Bike Light"));
		
		//or
		Assert.assertEquals(actResult, "Sauce Labs Bike Light");
		
		//Logout of the App
		Thread.sleep(2000);
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		//Close the Browser
		driver.quit();
		
		
	}

}
