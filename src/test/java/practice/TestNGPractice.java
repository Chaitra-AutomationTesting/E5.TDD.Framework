package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void addProductTest()
	{
		Assert.fail();
		System.out.println("product added");//pass failed
	}

	
	@Test(dependsOnMethods = "addProductTest")
	public void updateProductTest()
	{
		System.out.println("product updated");
	}
	
	@Test(enabled = false)
	public void removeProductTest()
	{
		System.out.println("product removed");
	}

}
