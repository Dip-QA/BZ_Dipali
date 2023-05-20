package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Edit_Time 
{
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-slot-lane fc-t')])[11]")
	private WebElement ScrollTo5AM;
	@FindBy(xpath="//tbody//tr//td[11]")    private WebElement Clickcell5AM;
	@FindBy(xpath="//img[@alt='per_Hour']")    private WebElement SelectPerHourplan;
	@FindBy(xpath="//button//span[text()='1 Hours']")    private WebElement SelectHour;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root MuiButton-c')])[8]")    private WebElement SelectGuest;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root MuiButton-c')])[10]")    private WebElement SelectItems;
	@FindBy(xpath="(//input[@id='combo-box-demo'])[1]")    private WebElement ChangeTime;
	@FindBy(xpath="//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-md-1 css-i')]") 
	private WebElement RefreshButton;
	@FindBy(xpath="//select[contains(@class,'MuiSelect-root')]")  private WebElement OultletSected;
	@FindBy(xpath="(//div//a[contains(@class,'fc-timeline-event f')])[8]") private WebElement Click_Created_Booking;
	@FindBy(xpath="(//div//td[contains(@class,'fc-timeline-slot fc-timeline-s')])[9]") WebElement   ScrollToBooking;
	
	public Edit_Time(WebDriver driver)
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
	
	public void ScrollTo5AM (WebDriver driver) throws InterruptedException 
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ScrollTo5AM);
		Thread.sleep(2000);
	}
	
	public void Click5AMCell() throws InterruptedException 
	{
		Clickcell5AM.click();
		Thread.sleep(2000);
	}
	
	public void Select_PerHourplan() throws InterruptedException 
	{
		SelectPerHourplan.click();
		
		Thread.sleep(0);
		
	}
	
	public void Select_1Hour() throws InterruptedException 
	{
		SelectHour.click();
		Thread.sleep(2000);
	}
	
	public void Select_Guest(WebDriver driver) throws InterruptedException 
	{
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
	 		executor.executeScript("arguments[0].scrollIntoView(true);", SelectGuest);    
	 		SelectGuest.click();	
		  
		  Thread.sleep(2000);
		
	}

	public void SelectItems() throws InterruptedException 
	{
		SelectItems.click();
		Thread.sleep(2000);
	}
	
	public void Edit_Time(WebDriver driver, String Time) 
	{
		Actions A1=new Actions(driver);
		
		A1.click(ChangeTime).perform();
		A1.sendKeys(Time).perform();
		A1.sendKeys(Keys.ENTER).perform();
		
	}
	
	
	public void Select_PreviousTime(WebDriver driver, String Time) 
	{
		Actions A1=new Actions(driver);
		
		A1.click(ChangeTime).perform();
		A1.sendKeys(Time).perform();
		A1.sendKeys(Keys.ENTER).perform();
		
	}
	
	public void Click_RefreshButton() 
	{
		RefreshButton.click();
	}
	
	public void select_Outlet() throws InterruptedException 
	{
		OultletSected.click();
		Select s1=new Select(OultletSected);
		s1.selectByVisibleText("Automation");
		Thread.sleep(5000);
		s1.selectByVisibleText("Outlet_Demo");
		
	}
	
}
