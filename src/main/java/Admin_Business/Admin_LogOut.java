package Admin_Business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_LogOut 
{
@FindBy(xpath="//button[@class='MuiButtonBase-root css-1lk0u3-MuiButtonBase-root']") private WebElement ClickIcon;
@FindBy(xpath="//button/span[text()='Logout']") private WebElement Logout;
	
	
	public Admin_LogOut(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void ClickprofileIcon() throws InterruptedException 
	{
		ClickIcon.click();
		Thread.sleep(5000);
	}

	public void Click_Logout() 
	{
		Logout.click();
	}

}
