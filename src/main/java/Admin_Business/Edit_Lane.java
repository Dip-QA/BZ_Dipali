package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Edit_Lane
{

	@FindBy(xpath="//img[@alt='Testing_perPerson']")    private WebElement ToLanePlan;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root MuiButton-c')])[7]")    private WebElement Select_Person;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root MuiButton-c')])[9]")    private WebElement SelectItem;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[11]")    private WebElement ScrolltoSearchBooking;

	@FindBy(xpath="(//div[contains(@class,'MuiButtonBase-ro')])[1]")    private WebElement DeselectLaane;
	@FindBy(xpath="(//div[contains(@class,'MuiButtonBase-ro')])[2]")    private WebElement updateLane;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-slot-lane fc-t')])[19]")    private WebElement ScrollRight;
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-event f')])[4]") private WebElement Click_Created_Booking;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[19]") WebElement   ScrollToBooking;
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-event f')])[5]") private WebElement Click_updated_Booking;
	
	public Edit_Lane(WebDriver driver)
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
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ScrollToBooking);
		  Thread.sleep(2000);
		  
		  Click_updated_Booking.click();
		  Thread.sleep(2000);
	  }
	
	public void Select_ToLanePlan() throws InterruptedException 
	{
		ToLanePlan.click();
		Thread.sleep(3000);
	}
	
	public void Select_PersonCount(WebDriver driver) throws InterruptedException 
	{
     	 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 		executor.executeScript("arguments[0].scrollIntoView(true);", Select_Person);    
		 		Select_Person.click();	
		 		
		 		Thread.sleep(2000);
	}
	
	public void Select_Item(WebDriver driver) throws InterruptedException 
	{
     	 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 		executor.executeScript("arguments[0].scrollIntoView(true);", SelectItem);    
		 		SelectItem.click();	
		 		
		 		Thread.sleep(2000);
	}
	
	
	
	 public void Click_DefaultLane() throws InterruptedException 
	 {
		 DeselectLaane.click();
		 Thread.sleep(3000);
	 }
	

	 public void selectNew_Lane() throws InterruptedException 
	 {
		 updateLane.click();
		 Thread.sleep(3000);
	 }
	 
	 public void scrollfor9AM(WebDriver driver) throws InterruptedException 
	 {
       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ScrolltoSearchBooking);
		  Thread.sleep(2000);
		  
	 }
	 
}