package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Items 
{
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root M')])[17]") WebElement   SelectItem;
	@FindBy(xpath="//button//span[contains(text(),'Pay ')]") WebElement   paybutton;
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-even')])[7]") WebElement   ClickCreatedBooking;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[9]") WebElement   ScrollToBooking;
	
	  public Edit_Items (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	  
	  
	  public void Click_Created_Booking(WebDriver driver) throws InterruptedException 
	  {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ScrollToBooking);
		  Thread.sleep(2000);
		  
		  ClickCreatedBooking.click();
		  Thread.sleep(2000);
	  }
		
	  public void Select_Items(WebDriver driver) throws InterruptedException 
	  {
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
	 		executor.executeScript("arguments[0].scrollIntoView(true);", SelectItem);    
	 		SelectItem.click();
	  }

	  public void Click_payButton() 
	  {
		  paybutton.click();
	  }
	  
	  
	  
}
