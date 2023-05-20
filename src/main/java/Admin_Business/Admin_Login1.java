package Admin_Business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Login1 
{
	@FindBy(name="email")    private WebElement UN;
	@FindBy(name="password")    private WebElement PWS;
	@FindBy(xpath="//span[text()='Login']")    private WebElement Login;
	
	
	public Admin_Login1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterUN(String Username) 
	{
		UN.sendKeys(Username);
	}
	
	public void EnterPWS(String Password) 
	{
		PWS.sendKeys(Password);
	}
	
	public void ClickLogin() throws InterruptedException 
	{
		Login.click();
		Thread.sleep(5000);
	}
	
}
