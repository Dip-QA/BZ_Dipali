package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditEvent_ViewReservation 
{
	@FindBy(xpath="//img[contains(@alt,'Party Event')]") WebElement  SelectPlan ;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root MuiButton-outlined ')])[1]") 
	WebElement  Event1 ;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root M')])[18]") WebElement  SelectChild;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root M')])[20]") WebElement  SelectItem ;
	
	@FindBy(xpath="//span[normalize-space()='View Reservations']") WebElement  ViewReservation ;
	@FindBy(xpath="(//button//span[contains(@class,'MuiIconB')])[8]") WebElement BookingArrow;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root MuiButton-outlined ')])[2]")
	WebElement Event3;
	
	
	
	
	  public EditEvent_ViewReservation (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	
	
		  public void SelectPlan() throws InterruptedException 
		  {
			  SelectPlan.click();
			  Thread.sleep(2000);
		  }
		  
		  public void Select_Event1() throws InterruptedException 
		  {
			  Event1.click();
			  Thread.sleep(2000);
		  }
		  
		  
		  
		  public void Select_Child(WebDriver driver) throws InterruptedException 
		  {
			  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", SelectChild);
			 		  Thread.sleep(2000);
			 		 JavascriptExecutor executor = (JavascriptExecutor) driver;
			 		executor.executeScript("arguments[0].scrollIntoView(true);", SelectChild);    
			 		SelectChild.click();	
			 
			 		
		  }
		  
		  public void Select_Item(WebDriver driver) throws InterruptedException 
		  {
			  JavascriptExecutor executor = (JavascriptExecutor) driver;
		 		executor.executeScript("arguments[0].scrollIntoView(true);", SelectItem);    
		 		SelectItem.click();	
			  
			  Thread.sleep(2000);
		  }
		  
		  public void Click_ViewReservation_Btn() throws InterruptedException 
		  {
			  ViewReservation.click();
			  Thread.sleep(2000);
		  }
		  
		  public void Click_BookingArrow() throws InterruptedException 
		  {
			  BookingArrow.click();
			  Thread.sleep(2000);
		  }
		  
		  public void Click_Event3() throws InterruptedException 
		  {
			  Event3.click();
			  Thread.sleep(2000);
		  }

}
