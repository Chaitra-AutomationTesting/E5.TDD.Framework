package swagLabs.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of reusable methods related to Java
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * 	This method will capture the current system date in format and return it
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm--ss");
		String currentdate = sdf.format(d);
		return currentdate;
	} 

}
