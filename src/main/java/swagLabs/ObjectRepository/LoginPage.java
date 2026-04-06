package swagLabs.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1
	
	//rule 2 --- Declaration
	@FindBy(id = "user-name") 
	private WebElement usernameTF;
	
	@FindBy(id = "password")
	private WebElement passwordTF;
	
	@FindBy(name = "login-button")
	private WebElement loginBtn;
	
	//rule 3 --- Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4 --- Utilization
	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library - Generic method - project specific - Optimise test script - Clean 
	
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(/*WebDriver driver,*/ String username, String password)
	{
		//driver.findElement(By.xpath("//div[.='"+username+"']"));
		
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBtn.click();
		
	}
	
	
	

}
