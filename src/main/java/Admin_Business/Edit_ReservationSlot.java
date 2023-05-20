package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_ReservationSlot
{
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root MuiButton-o')])[1]") private WebElement NewSlot;
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-event f')])[5]") private WebElement Click_Created_Booking;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[9]") WebElement   ScrollToBooking;
	
	public Edit_ReservationSlot(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_New_Resrevation_Slot() 
	{
		NewSlot.click();
	}
	
	 
	  public void Click_Created_Booking(WebDriver driver) throws InterruptedException 
	  {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ScrollToBooking);
		  Thread.sleep(2000);
		  
		  Click_Created_Booking.click();
		  Thread.sleep(2000);
	  }
	  
	

}
