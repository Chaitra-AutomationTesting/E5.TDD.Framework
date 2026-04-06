package practice;

import org.testng.annotations.Test;

public class ReadDatafromCmdLine {
	
	@Test
	public void readData()
	{
		String UN = System.getProperty("username");
		System.out.println(UN);
		
		String PWD = System.getProperty("password");
		System.out.println(PWD);
	}

}
