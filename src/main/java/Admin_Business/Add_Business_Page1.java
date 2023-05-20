package Admin_Business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Business_Page1
{
	@FindBy(xpath="//div[text()='Businesses']")    private WebElement Businesses;
	@FindBy(xpath="//div[@class='css-13wmrxa']")    private WebElement AddBusiness;
	
	
	
	public Add_Business_Page1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void ClickBusinesses() throws InterruptedException 
	{
		Businesses.click();
		Thread.sleep(3000);
	}
 
	public void ClickAddBusiness() throws InterruptedException 
	{
		AddBusiness.click();
		Thread.sleep(3000);
	}
	
	
	

}
