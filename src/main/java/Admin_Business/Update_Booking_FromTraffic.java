package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Update_Booking_FromTraffic
{
	@FindBy(xpath="//span[normalize-space()='1 Hours']")  private WebElement One_Hour ;
	@FindBy(xpath="(//div[@class='fc-timeline-events fc-scrollgrid-sync-inner'])[2]/div[1]")  private 
	WebElement ClickBookingToEditTime ;
	@FindBy(xpath="((//div[@class='fc-timeline-events fc-scrollgrid-sync-inner'])[1]//div)[6]")  private 
	WebElement ClickBookingToEditLane ;
	@FindBy(xpath="(//button[contains(@class,'MuiButtonBase-root Mu')])[10]")  private WebElement Click_Calander ;
	@FindBy(xpath="(//button[contains(@class,'MuiButtonBase-root MuiIco')])[8]") WebElement   nextArrow;
	
	public Update_Booking_FromTraffic(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void Select_One_Hour () throws InterruptedException 
	{
		One_Hour.click();
		Thread.sleep(2000);
	}

	public void Click_Booking_ToEdit_Time () throws InterruptedException 
	{
		ClickBookingToEditTime.click();
		Thread.sleep(2000);
	}
	
	public void Click_Booking_ToEdit_Lane () throws InterruptedException 
	{
		ClickBookingToEditLane.click();
		Thread.sleep(2000);
	}
	public void Click_CalanderSymbol_Homepage () throws InterruptedException 
	{
		Click_Calander.click();
		Thread.sleep(2000);
		nextArrow.click();
		Thread.sleep(2000);
	}
	
	
}
