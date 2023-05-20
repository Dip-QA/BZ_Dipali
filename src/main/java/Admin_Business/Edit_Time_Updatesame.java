package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Time_Updatesame
{
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-event f')])[10]") private WebElement Click_Created_Booking;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[9]") WebElement   ScrollToBooking;
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-event f')])[4]") private WebElement Click_Updated_Booking;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[21]") WebElement   ScrollToupdatedBooking;
	
	public Edit_Time_Updatesame(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	 public void Click_Created_Booking(WebDriver driver) throws InterruptedException 
	  {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ScrollToBooking);
		  Thread.sleep(2000);
		  
		  Click_Created_Booking.click();
		  Thread.sleep(2000);
	  }
	 
	 public void Click_Updated_Booking(WebDriver driver) throws InterruptedException 
	  {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ScrollToupdatedBooking);
		  Thread.sleep(2000);
		  
		  Click_Updated_Booking.click();
		  Thread.sleep(2000);
	  }

}
