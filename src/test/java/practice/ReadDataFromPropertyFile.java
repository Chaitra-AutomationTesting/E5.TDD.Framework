package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Open the document in java read format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Create the Object of Properties class
		Properties p = new Properties();
		
		//Load the input stream into Properties
		p.load(fis);
		
		//Provide the key and capture the value
		String value = p.getProperty("url");
		
		System.out.println(value);
	}

}
