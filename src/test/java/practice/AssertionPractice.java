package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sample()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
//		if(1==0) // cannot fail the test script
//		{
//			System.out.println("pass");
//		}
//		else
//		{
//			System.out.println("fail");
//		}
		
		
		//Assert.assertEquals(0,1); // when u comparing two values
		
		sa.assertEquals(0, 1);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		sa.assertAll(); // log all the failures
	}

}
