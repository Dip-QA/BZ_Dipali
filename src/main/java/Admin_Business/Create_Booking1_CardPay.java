package Admin_Business;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Create_Booking1_CardPay

{
	// this pom class has common code till click on proceed to pay button 
	//and there is separate code for different  payment gateway
	@FindBy(xpath="//div[normalize-space()='Calendar']") WebElement   Calenderbtn;
	@FindBy(xpath="//input[@name='name']") WebElement   Name;
	@FindBy(name="bookingEmail") WebElement   Email;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-')])[2]") WebElement   CreateReservation;
	
	@FindBy(xpath="(//button[contains(@class,'MuiButtonBase-root MuiIc')])[13]") WebElement   Calendersymbol;
	@FindBy(xpath="(//button[contains(@class,'MuiButtonBase-root MuiIco')])[15]") WebElement   nextArrow;
	@FindBy(xpath="//button[text()='20']") WebElement   SelectDate;
	
	@FindBy(xpath="//img[contains(@alt,'Enable_Package')]")WebElement   Selectplan;
	@FindBy(xpath="//div[contains(@class,'MuiGrid-root css-2w1nhr-MuiGrid-root')]//button[1]")WebElement SelectDuration;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root M')])[15]")WebElement SelectPackage;
	@FindBy(xpath="(//button[contains(@class,'MuiButton-root M')])[19]")WebElement  SelectaddGuest;
	@FindBy(xpath="//button//span[contains(text(),'Proceed to Pay')]")WebElement   ProceedToPay;
	
	@FindBy(xpath="//select[@name='paymentMethod']") WebElement   PymentMethod;
	@FindBy(name="te-connect-secure-pan") WebElement   CardNo;
	@FindBy(xpath="//input[@name='te-connect-secure-expiration']") WebElement   ExpiryDate;
	@FindBy(xpath="//input[@name='te-connect-secure-cvc']") WebElement   cvc;
	@FindBy(xpath="//button//span[contains(text(),'Pay ')]") WebElement   Pay;
	@FindBy(name="paymentReceived") WebElement   RecievedCheckBox;
	@FindBy(xpath="//button//span[text()='Submit']") WebElement   SubmitButton;
	@FindBy(xpath="//select[contains(@class,'MuiSelect-root')]")  private WebElement OultletSelected;
    
	  public Create_Booking1_CardPay (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
	  public void ClickCalenderbtn() throws InterruptedException 
	  {
		  Calenderbtn.click();
		  Thread.sleep(2000);
	  }
	  
	  public void select_Outlet(WebDriver driver) throws InterruptedException 
		{
		 /* WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		   wait.until(ExpectedConditions.visibilityOf(OultletSelected));*/
		   
		   if(OultletSelected.isDisplayed())
			{
			   OultletSelected.click();
			   Select s1=new Select(OultletSelected);
				s1.selectByVisibleText("Outlet_Demo");
			}
			
			
		}
	
	  public void Customer_Name(String BName) throws InterruptedException 
	  {
		  Name.sendKeys(BName);
		  Thread.sleep(2000);
	  }
	  
	  public void EnterEmail(String BEmai) throws InterruptedException 
	  {
		  Email.sendKeys(BEmai);
		  Thread.sleep(2000);
	  }
	
	  // for create booking by Click CreateReservation button on Admin 
	  public void Click_CreateReservation() throws InterruptedException 
	  {
		  CreateReservation.click();
		  Thread.sleep(2000);
	  }
	  
	   public void Click_Calendersymbol() throws InterruptedException 
	  {
		  Calendersymbol.click();
		  Thread.sleep(2000);
	  }
	  
	  public void Click_nextArrow() throws InterruptedException 
	  {
		  nextArrow.click();
		  Thread.sleep(2000);
	  }
	  
	  public void SelectDate() throws InterruptedException 
	  {
		  SelectDate.click();
		  Thread.sleep(2000);
	  }
	  
	  public void Selectplan() throws InterruptedException 
	  {
		  Selectplan.click();
		  Thread.sleep(2000);
	  }
	  
	  public void SelectDuration() throws InterruptedException 
	  {
		  SelectDuration.click();
		  Thread.sleep(2000);
	  }
	  
	  public void SelectPackage(WebDriver driver) throws InterruptedException 
	  {
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", SelectPackage);
		 		  Thread.sleep(2000);
		 		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 		executor.executeScript("arguments[0].scrollIntoView(true);", SelectPackage);    
		 		SelectPackage.click();	
		 
		 		
	  }
	  
	  public void SelectaddGuest(WebDriver driver) throws InterruptedException 
	  {
		  JavascriptExecutor executor = (JavascriptExecutor) driver;
	 		executor.executeScript("arguments[0].scrollIntoView(true);", SelectaddGuest);    
	 		SelectaddGuest.click();	
		  
		  Thread.sleep(2000);
	  }
	  
	  public void Click_ProceedToPay() throws InterruptedException 
	  {
		  ProceedToPay.click();
		  Thread.sleep(2000);
	  }
	  
	  //This method is for selecting card payment
	  public void Select_CardPymentMethod() throws InterruptedException 
	  {
		  Select S1=new Select(PymentMethod);
		  S1.selectByVisibleText("Pay via Credit/Debit");
		  Thread.sleep(2000);
	  }
	  
	  
	  
	
	  public void EnterCardNo(String CardDetails) throws InterruptedException 
	  {
		   CardNo.sendKeys(CardDetails);
		  Thread.sleep(2000);
	  }
	  
	  public void EnterExpiryDate(String Expiry) throws InterruptedException 
	  {
		  ExpiryDate.sendKeys(Expiry);
		  Thread.sleep(2000);
	  }
	  
	  public void Entercvc(String csv) throws InterruptedException 
	  {
		  cvc.sendKeys(csv);
		  Thread.sleep(2000);
	  }
	  
	  public void ClickPayBtn() throws InterruptedException 
	  {
		  Pay.click();
		  Thread.sleep(2000);
	  }
	  
	  public void Click_SubmitButton() throws InterruptedException 
	  {
		  SubmitButton.click();
		  Thread.sleep(2000);
	  }
	  
	 
	  
	  
	  
	  
	  
	  
	  
	  
}
