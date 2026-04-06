package practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSONFile {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		//Open document in Java Read format
		FileReader fr = new FileReader(".\\src\\test\\resources\\CommonData.json"); 
		
		//Create object of JSON Parser
		JSONParser jparser = new JSONParser();
		
		//Parse the json file to Object
		Object obj = jparser.parse(fr);
		JSONObject jObj = (JSONObject) obj;
		
		//Provide the key to fetch the value
		String value = jObj.get("browser").toString();
		String urlValue = (String) jObj.get("url");
		
		
		System.out.println(value);
		System.out.println(urlValue);
		
	}

}
