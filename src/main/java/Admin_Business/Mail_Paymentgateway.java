package Admin_Business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mail_Paymentgateway
{
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]") WebElement   Paybutton;
	@FindBy(xpath="//button[contains(text(),'Pay ')]") WebElement   PayPaymentPage;
	
    
	  public Mail_Paymentgateway (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

	  public void Click_Paybutton() throws InterruptedException 
	  {
		
		  Paybutton.click();
		  Thread.sleep(2000);
		  
	  }
	  
	  public void Click_payon_PaymentPage() 
	  {
		  PayPaymentPage.click();
	  }
	  
}
