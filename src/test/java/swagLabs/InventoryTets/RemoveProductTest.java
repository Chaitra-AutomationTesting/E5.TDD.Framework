package swagLabs.InventoryTets;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import swagLabs.BaseTest.BaseClass;

@Listeners(swagLabs.Listeners.ListenersImplementation.class)
public class RemoveProductTest extends BaseClass{
	
	@Test(groups = "SmokeSuite")
	public void removeproductTest()
	{
		//Assert.fail();
		System.out.println("product Removed");
	}

	
	@Test
	public void demoproductTest()
	{
		System.out.println("product demo");
	}
}
