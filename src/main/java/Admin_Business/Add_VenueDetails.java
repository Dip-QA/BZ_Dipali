package Admin_Business;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add_VenueDetails
{
    @FindBy(xpath="//span[text()='Venue Detail']") private  WebElement venue_Detail;
    @FindBy(xpath="//span[text()='Add Venue Detail']") private  WebElement Add_VenueDetails;
    @FindBy(xpath="(//button[contains(@class,'MuiButtonBase-')])[7]") private  WebElement EditCategory;
    @FindBy(xpath="(//input[contains(@class,'MuiOut')])[1]") private  WebElement service_Category;
    @FindBy(xpath="(//input[contains(@class,'MuiOut')])[2]") private  WebElement venue_Type;
    @FindBy(xpath="(//input[contains(@class,'MuiOut')])[3]") private  WebElement Service_Description;
    @FindBy(xpath="(//button[contains(@class,'MuiButtonBase-r')])[9]") private  WebElement EditTotalCout;
    @FindBy(name="totalCount.0.venue") private  WebElement Select_venue;
    @FindBy(name="totalCount.0.count") private  WebElement TotalCount;
    @FindBy(xpath="(//button[contains(@class,'MuiButtonBase-r')])[11]") private  WebElement EditBookingType;
    @FindBy(name="bookingType.0.serviceCategory") private  WebElement Select_Service;
    @FindBy(name="bookingType.0.venueType") private  WebElement Select_venueType;
    @FindBy(name="bookingType.0.serviceDescription") private  WebElement Select_ServiceDescription;
    @FindBy(name="bookingType.0.bookingType") private  WebElement Select_BookingType;
    @FindBy(name="bookingType.0.from") private  WebElement From;
    @FindBy(name="bookingType.0.to")  private WebElement To;
    @FindBy(xpath="//button[@type='submit']")  private WebElement Save;
   
    
    
	public Add_VenueDetails (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickvenue_Detail() throws InterruptedException 
	{
		venue_Detail.click();
		Thread.sleep(2000);
	}
	
	public void clickAdd_VenueDetails() throws InterruptedException 
	{
		Add_VenueDetails.click();
		Thread.sleep(2000);
	}
	
	public void click_EditCategory() throws InterruptedException 
	{
		EditCategory.click();
		Thread.sleep(5000);
	}
	
	public void Enter_service_Category(String servic_Cat) throws InterruptedException 
	{  
		
	
		service_Category.sendKeys(servic_Cat);
		Thread.sleep(2000);
	}
	
	public void Enter_venue_Type(String VType) throws InterruptedException 
	{
	
		
		venue_Type.sendKeys(VType);
		Thread.sleep(2000);
	}
	
	public void Enter_Service_Description(String SDescription) throws InterruptedException 
	{
		Service_Description.sendKeys(SDescription);
		Thread.sleep(2000);
	}
	
	public void Click_EditTotalCout() 
	{
		EditTotalCout.click();
		
	}
	
	public void Select_venue() throws InterruptedException 
	{
		
		Select V1=new Select(Select_venue);
		V1.selectByValue("GameZone");
		  Thread.sleep(3000);
		  
	}
	
	public void Clearfeild() throws InterruptedException 
	{

		TotalCount.clear();
		Thread.sleep(2000);
	}
	
	public void Enter_TotalCount(String Count) throws InterruptedException 
	{
		
		TotalCount.sendKeys(Count);
		Thread.sleep(2000);
	}
	
	public void Click_EditBookingType() 
	{
		EditBookingType.click();
		
	}
	
	public void Select_Service() throws InterruptedException 
	{
		
		Select S1=new Select(Select_Service);
		 S1.selectByValue("Entertainment");
		  Thread.sleep(2000);
		  
	}
	
	public void Select_venueType() throws InterruptedException 
	{
		
		Select S2=new Select(Select_venueType);
		S2.selectByValue("GameZone");
		   Thread.sleep(2000);
		   
		  
		   
	}
	
	public void Enter_From(String No) throws InterruptedException 
	{
		From.sendKeys(No);
		Thread.sleep(2000);
	}
	
	public void Enter_To(String ToNo) throws InterruptedException 
	{
		To.sendKeys(ToNo);
		Thread.sleep(2000);
	}
	
	public void Select_ServiceDescription() throws InterruptedException 
	{
		Select S3=new Select(Select_ServiceDescription);

		S3.selectByVisibleText("Playing");
		Thread.sleep(2000);
	}
	
	public void Select_BookingType() throws InterruptedException 
	{
		Select S4=new Select(Select_BookingType);
		  S4.selectByVisibleText("Reservation");
		  Thread.sleep(2000);
		
	}
	
	public void Click_Savebtn() throws InterruptedException 
	{
		Save.click();
		Thread.sleep(2000);
		
	}
	
	
}
