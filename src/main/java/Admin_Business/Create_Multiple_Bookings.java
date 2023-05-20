package Admin_Business;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_Multiple_Bookings 
{
	@FindBy(xpath="//img[@alt='Per Hour Slot']")  private WebElement Per_Hour_Slot ;
	@FindBy(xpath="//span[normalize-space()='2 Hours']")  private WebElement Two_Hour ;
	@FindBy(xpath="(//input[@id='combo-box-demo'])[2]")  private WebElement EnterMinutes ;
	@FindBy(xpath="(//input[@id='combo-box-demo'])[3]") WebElement   SelectAMStartTime;
	@FindBy(xpath="//img[@alt='Birthday Package']") WebElement   SelectBirthPackageplan;
	@FindBy(xpath="(//div[@class='css-4ysqot']//button)[14]") WebElement   SelectPackage;
	@FindBy(xpath="(//div[@class='css-4ysqot']//button)[18]") WebElement   SelectaddPackage;
	@FindBy(xpath="(//button[contains(@class,'MuiButtonBase-root MuiIc')])[13]") WebElement   Calendersymbol;
	@FindBy(xpath="(//button[contains(@class,'MuiButtonBase-root MuiIco')])[15]") WebElement   nextArrow;
	@FindBy(xpath="//button[text()='20']") WebElement   SelectDate;

	WebDriverWait wait;

	public Create_Multiple_Bookings (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
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

	public void Select_Per_Hour_Slot () throws InterruptedException 
	{
		Per_Hour_Slot.click();
		Thread.sleep(2000);
	}

	public void Select_Two_Hour () throws InterruptedException 
	{
		Two_Hour.click();
		Thread.sleep(2000);
	}

	public void Enter_Minutes (WebDriver driver, String Minute) throws InterruptedException 
	{
		Actions A1=new Actions(driver);

		A1.click(EnterMinutes).perform();
		A1.sendKeys(Minute).perform();
		A1.sendKeys(Keys.ENTER).perform();
	}

	public void Select_AM_StartTime(WebDriver driver, String Time) throws InterruptedException 
	{
		Actions A1=new Actions(driver);

		A1.click(SelectAMStartTime).perform();
		A1.sendKeys(Time).perform();
		A1.sendKeys(Keys.ARROW_DOWN).perform();

		A1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(2000);

	}


	public void Select_BirthDayPackagePlan() 
	{
		SelectBirthPackageplan.click();
	}

	public void SelectPackage(WebDriver driver) throws InterruptedException 
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", SelectPackage);
		  Thread.sleep(20000);
		  
		if(SelectPackage.isDisplayed())
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement   element=wait.until(ExpectedConditions.elementToBeClickable(SelectPackage));
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		}
	}

	public void SelectaddGuest(WebDriver driver) throws InterruptedException 
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", SelectaddPackage);    
		SelectaddPackage.click();	

		Thread.sleep(2000);
	}

}
