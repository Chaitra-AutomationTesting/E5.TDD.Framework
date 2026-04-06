package swagLabs.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to Selenium
 * @author Chaitra M
 *
 */
public class WebDriverUtility {
	
	//WebDriver driver= new EdgeDriver();// - runtime event  //null - browsername - property file
	
	/**
	 * This method will maximize the browser
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize(); //null
	}
	
	/**
	 * This method will minimize the browser
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicitly wait of 10 s
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait until the element is visible in DOM
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisibile(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handlingDropdown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	// create overloaded methods for dropdown handling
	
	/**
	 * This method will perform click action where the mouse cursor is pointing
	 * @param driver
	 */
	public void clickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.click().perform();
	}
	
	/**
	 * This method will perform click action on a web element
	 * @param element
	 * @param driver
	 */
	public void clickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.click(element).perform();
	}
	
	//Frames - <iframe> - adds, info <html> 
	
	/**
	 * This method will switch the driver control to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * This method will switch the driver control to frame based on name or ID
	 * @param driver
	 * @param name or ID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	/**
	 * This method will switch the driver control to frame based on Web element
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch the driver control from frame to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the driver control from frame to main window
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will click OK in alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
		
	/**
	 * This method will click cancel in alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method capture text of alert popup and return it
	 * @param driver
	 * @return 
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will enter data to alert popup
	 * @param driver
	 */
	public void enterDataToAlert(WebDriver driver, String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	
	/**
	 * This method will scroll until a webelemnet
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
		
	}
	
	
	/**
	 * This method will scroll by a random coordinate value
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, int x, int y)
	{
		Actions act = new Actions(driver);
		act.scrollByAmount(x,y).perform();
		
	}
	
	/**
	 * This Method will perform random scroll down operation upto 500 units
	 * @param driver
	 */
	public void scrollUsingJSE(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; // TypeCasting
		js.executeScript("Window.scrollBy(0,500);", "");
	}
	
	/**
	 * This method will switch to window based on required window
	 * @param driver
	 * @param requiredTitle
	 */
	public void switchTowindow(WebDriver driver, String requiredTitle)
	{
		//Capture all window IDs
		Set<String> allWindID = driver.getWindowHandles(); //bhsdytrw6twuyqhs
		
		//Navigate to each window and capture the title of window
		for(String win:allWindID)
		{
			//Switch the control to window n capture the title
			String actualTitle = driver.switchTo().window(win).getTitle();
			
			//compare the title with required title
			if(actualTitle.contains(requiredTitle))
			{
				break;
			}
		}
		
		
	}
	
	/**
	 * This method will take screenshot and return the path
	 * @param driver
	 * @param screenshotName
	 * @return 
	 * @throws IOException
	 */
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenshotName+".png");
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); // For Extent Reports
		
	}
	
	
}
