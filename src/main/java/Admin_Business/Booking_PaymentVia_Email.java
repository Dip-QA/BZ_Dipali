package Admin_Business;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Booking_PaymentVia_Email 
{
	@FindBy(xpath="//select[@name='paymentMethod']") WebElement   PymentMethod;
	@FindBy(xpath="//button//span[text()='Send Link']") WebElement   SendLink;
	@FindBy(name="login") WebElement   EnternameLogin;
	@FindBy(xpath="//button[@class='md']") WebElement   mailArrow;
	@FindBy(xpath="(//button[@class='lm'])[1]") WebElement   ClickMail;
	@FindBy(xpath="//a[text()='Link']") WebElement   LinkinMail;
	
	
    
	  public Booking_PaymentVia_Email (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	  
		
	  //This method is for selecting Email payment
	  public void Select_EmailPymentMethod() throws InterruptedException 
	  {
		  Select S1=new Select(PymentMethod);
		  S1.selectByVisibleText("Mobile Payment via Email");
		  
	  }	  
	  
	  public void Click_SendLink(WebDriver driver) 
	  {
		  ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 500)");
		  SendLink.click();
	  }
	
     public void NavigateTO_YopMail(WebDriver driver) throws InterruptedException 
     {
    	 driver.navigate().to("https://yopmail.com/");
    	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
     }
	  
     public void Entername_Login(String name) throws InterruptedException 
     {
    	 EnternameLogin.sendKeys(name);
    	 Thread.sleep(3000);
     }
     
     public void Click_mailArrow() throws InterruptedException 
     {
    	 mailArrow.click();
    	 Thread.sleep(3000);
     }
     
     public void Click_mail() throws InterruptedException 
     {
    	 ClickMail.click();
    	 Thread.sleep(3000);
     }
     
     public void LinkinMail() throws InterruptedException 
     {
    	 LinkinMail.click();
    	 Thread.sleep(3000);
     }
     
     
	  
}
