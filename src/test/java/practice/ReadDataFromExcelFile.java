package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Open the document in Java read format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData-E5.xlsx");
		
		//Create a virtual workbook using Workbookfactory - C - POI
		Workbook wb = WorkbookFactory.create(fis);
		
		//Navigate to required sheet
		Sheet sh = wb.getSheet("Products");
		
		//Navigate to required Row
		Row rw = sh.getRow(1);
		
		//Navigate to required Cell
		Cell cl = rw.getCell(2);
		
		//Capture the data and print
		String value = cl.getStringCellValue();
		System.out.println(value);
		
		
	}

}
