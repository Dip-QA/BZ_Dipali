package Admin_Business;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_Service 
{
	  @FindBy(xpath="//div[text()='Outlets']") WebElement   OutletBtn;
	  @FindBy(xpath="(//button[contains(@class,'MuiButto')])[5]") WebElement  clcikarrow;
	  @FindBy(xpath="(//button[contains(@class,'MuiButton-root Mui')])[7]") WebElement   AddService;
	  @FindBy(name="BOWLING") WebElement   EntRadio;
	  @FindBy(xpath="//span[text()='Confirm']") WebElement   Confermbtn;
	  @FindBy(xpath="//span[text()='Save']") WebElement   Savebtn;
	    
	  public Add_Service (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
	  public void clickOutlet() throws InterruptedException 
	  {
		  OutletBtn.click();
		  Thread.sleep(5000);
		  
	  }
	  
	  public void clickArrow(WebDriver driver) throws InterruptedException 
	  {
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("arguments[0].click();", clcikarrow);
		  Thread.sleep(2000);
	  }
	  
	  public void click_Addservice() throws InterruptedException 
	  {
		  AddService.click();
		  Thread.sleep(2000);
		  
	  }
	  
	  public void click_EntRadio() throws InterruptedException 
	  {
		  EntRadio.click();
		  Thread.sleep(2000);
		  
	  }
	  
	  public void click_Confirmbtn() throws InterruptedException 
	  {
		  Confermbtn.click();
		  Thread.sleep(2000);
		  
	  }
	  
	  public void click_Savebtn() throws InterruptedException 
	  {
		  Savebtn.click();
		  Thread.sleep(2000);
	  }
	  
}
