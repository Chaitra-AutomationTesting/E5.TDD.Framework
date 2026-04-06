package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test(dataProvider = "products")
	public void addProductToCartTest(String name, int qty, boolean available)
	{                                    //iphone      12             true
		
		System.out.println("Data is - "+name+"= "+qty+"= "+available);
	}

	@DataProvider(name = "products")
	public Object[][] getProductDetails()
	{                     // 2 rows 3 columns -> two data sets having 3 information each
		Object[][] data = new Object[2][3];
		
		data[0][0] = "Iphone";
		data[0][1] = 12;
		data[0][2] = true;
		
		data[1][0] = "Samsung";
		data[1][1] = 30;
		data[1][2] = false;
		
		return data;
	}

}
