package Admin_Business;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Edit_Date 
{
	
	
	@FindBy(xpath="//button//span[text()='Submit']") WebElement   Submit;
	
	//update the text of created Booking before execution according to name given to the booking
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-even')])[4]") WebElement   ClickCreatedBooking;
	
	@FindBy(xpath="//button//span[text()='Edit']") WebElement   EditButton;
	@FindBy(xpath="(//button[contains(@class,'MuiButtonBase-root Mui')])[20]") WebElement CalenderEdit;
	@FindBy(xpath="//button[text()='12']") WebElement   EditDate;
	@FindBy(xpath="//button//span[text()='Update Booking']") WebElement   UpbadateBooking;
	@FindBy(xpath="//button//span[text()='Confirm']") WebElement   ConfermEdit;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[9]") WebElement   ScrollToBooking;
    
	
	  public Edit_Date (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
	  public void Click_Submit() throws InterruptedException 
	  {
		  Submit.click();
		  Thread.sleep(2000);
	  }
	  
	  public void Click_Created_Booking(WebDriver driver) throws InterruptedException 
	  {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ScrollToBooking);
		  Thread.sleep(2000);
		  
		  ClickCreatedBooking.click();
		  Thread.sleep(2000);
	  }
	  
	  public void Click_EditButton() throws InterruptedException 
	  {
		  EditButton.click();
		  Thread.sleep(2000);
	  }
	  
	  public void Click_CalenderEdit() throws InterruptedException 
	  {
		  CalenderEdit.click();
		  Thread.sleep(2000);
	  }
	  
	  public void EditDate() throws InterruptedException 
	  {
		  EditDate.click();
		  Thread.sleep(2000);
	  }
	  
	  public void Click_UpdateBooking() throws InterruptedException 
	  {
		  UpbadateBooking.click();
		  Thread.sleep(2000);
	  }
	  public void Click_ConfirmEdit() throws InterruptedException 
	  {
		  ConfermEdit.click();
		  Thread.sleep(2000);
	  }
	  

}
