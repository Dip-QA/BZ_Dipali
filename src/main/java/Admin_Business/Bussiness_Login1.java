package Admin_Business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bussiness_Login1
{
	@FindBy (xpath="(//input[contains(@class,'Pr')])[2]")WebElement Radiobtn;
	@FindBy (name="email")WebElement UN;
	@FindBy (name="password")WebElement PWS;
	@FindBy (xpath="//span[text()='Login']")WebElement Loginbtn;
	
	public Bussiness_Login1(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}

	public void Click_Radio() throws InterruptedException 
	{
		Radiobtn.click();
		Thread.sleep(2000);
	}
	
	public void Enter_UN(String USERNAME) throws InterruptedException 
	{
		UN.sendKeys(USERNAME);
		Thread.sleep(2000);
	}
	
	public void Enter_PWS(String PASSWORD) throws InterruptedException 
	{
		PWS.sendKeys(PASSWORD);
		Thread.sleep(2000);
	}
	
	public void Click_Login() throws InterruptedException 
	{
		Loginbtn.click();
		Thread.sleep(3000);
	}
	
}
