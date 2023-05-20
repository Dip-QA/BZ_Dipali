package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Addon
{
	@FindBy(xpath="//button//span[text()='Update Add-on']") WebElement  UpdateAddon_Button ;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root M')])[18]") WebElement  selectAddon ;
	@FindBy(xpath="//button//span[text()='Update Booking']") WebElement  UpdateBookingBTN;
	@FindBy(xpath="//button//span[text()='Confirm']") WebElement   ConfermBTN;
	@FindBy(xpath="//input[@name='saveCheck']") WebElement  Payvia_savedcard ;
	@FindBy(xpath="//button//span[contains(text(),'Pay ')]") WebElement   payupdate;
	@FindBy(xpath="(//div[@class='MuiGrid-root MuiGrid-item css-10texkh-MuiGrid-root'])[2]") WebElement   RefreshBtn;
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-even')])[5]") WebElement   ClickCreatedBooking;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[9]") WebElement   ScrollToBooking;
	  public Edit_Addon (WebDriver driver)
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
		
	  public void Click_UpdateAddon_Button() throws InterruptedException 
	  {
		  UpdateAddon_Button.click();
		  Thread.sleep(2000);
	  }
	  
	  public void selectAddon(WebDriver driver) throws InterruptedException 
	  {
		  	 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 		executor.executeScript("arguments[0].scrollIntoView(true);", selectAddon);    
		 		selectAddon.click();	
		 		
	  }
	  
	  public void Click_UpdateBookingBTN() 
	  {
		  UpdateBookingBTN.click();
	  }
	  
	  public void Click_ConfirmBTN () 
	  {
		  ConfermBTN.click();
	  }
	
	  public void Click_Payvia_savedcard() 
	  {
		  Payvia_savedcard.click();
	  }
	  
	  public void payupdate() 
	  {
		  payupdate.click();
	  }
	  
	  public void Click_RefreshBtn() 
	  {
		  RefreshBtn.click();
	  }
	  
	  
}
