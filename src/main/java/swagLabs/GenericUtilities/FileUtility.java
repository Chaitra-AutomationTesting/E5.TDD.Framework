package swagLabs.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class consists of generic methods related to File operations
 * @author Chaitra M
 *
 */
public class FileUtility {
	
	/**
	 * This method reads data from property file and returns the value to caller 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	//create a utility method to read data from json file
	
	/**
	 * This method reads data from JSON file and returns the value
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String readDataFromJsonFile(Object key) throws IOException, ParseException
	{
		FileReader fr = new FileReader(".\\src\\test\\resources\\CommonData.json");		
		JSONParser parser = new JSONParser();		
		Object obj = parser.parse(fr);		
		JSONObject jobj = (JSONObject) obj;		
		String value = jobj.get(key).toString();
		return value;
	} 
	
	
	/**
	 * This method will read data from Excel file using row and cell indexing and
	 * returns the value
	 * @param sheetName
	 * @param rowNo
	 * @param celNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDatafromExcel(String sheetName, int rowNo, int celNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData-E5.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
	    return value;
	}
	

}
