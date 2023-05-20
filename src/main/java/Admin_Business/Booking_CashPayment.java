package Admin_Business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Booking_CashPayment
{
	@FindBy(xpath="//tbody//tr//td[19]") WebElement   cellClick;
	@FindBy(name="paymentMethod") WebElement   PaymentMethod;
	@FindBy(name="paymentReceived") WebElement   RecievedCheckBox;
	@FindBy(xpath="//button//span[text()='Confirm']") WebElement   ConfermBtn;
	
	  public Booking_CashPayment (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	
	// for create booking by cell click on admin 
		  public void Click_Cell() throws InterruptedException 
		  {
			  cellClick.click();
			  Thread.sleep(2000);
		  }
		  
		  
       //This method is for selecting cash payment
		  public void Select_CashPymentMethod() throws InterruptedException 
		  {
			  Select S1=new Select(PaymentMethod);
			  S1.selectByVisibleText("Pay By Cash");
			  Thread.sleep(2000);
		  }
	
		  public void Click_ReceivedCheckBox() throws InterruptedException 
		  {
			  RecievedCheckBox.click();
			  Thread.sleep(2000);
		  }
	   
		  public void Click_ConfirmBtn() throws InterruptedException 
		  {
			  ConfermBtn.click();
			  Thread.sleep(2000);
		  }
	
}
