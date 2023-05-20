package Admin_Business;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Create_Outlet 
{
	@FindBy(xpath="//input[@type='text']") private  WebElement SearchBox;
	@FindBy(xpath="//button//span[text()='Search']")      private  WebElement Searchbtn;
	@FindBy(xpath="//tbody/tr[1]/td[7]/a[1]/span[1]/*[1]") private  WebElement Arrow;
	@FindBy(xpath="//a[contains(@class, 'MuiButton-root MuiButton-c')]") private  WebElement AddOutlet;
	@FindBy(name="name")  private  WebElement OutletName;
	@FindBy(name="email")  private  WebElement OutletEmail;
	@FindBy(name="address.street") private  WebElement Flatno;
	@FindBy(name="address.state") private  WebElement State;
	@FindBy(name="address.city") private  WebElement City;
	@FindBy(name="address.zip")  private  WebElement ZipCode;
    @FindBy(name="region") private  WebElement Region;
    @FindBy(xpath="//div[contains(@class,'MuiAutocomplete-popper')]") private  WebElement ListoptionsState;
	
	
	
	

	public Create_Outlet(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void EnterMail(String Mail) throws InterruptedException 
	{
		SearchBox.sendKeys(Mail);
		Thread.sleep(2000);
	}

	public void clickSearchbtn() throws InterruptedException 
	{
		Searchbtn.click();
		Thread.sleep(2000);
	}
   
	public void Click_Arrow() throws InterruptedException 
	{
		Arrow.click();
		Thread.sleep(2000);
	}
	
	public void clcikAddOutlet() throws InterruptedException 
	{
		AddOutlet.click();
		Thread.sleep(2000);
	}
	

	public void EnterOutletName(String name) throws InterruptedException 
	{
		OutletName.sendKeys(name);
		Thread.sleep(2000);
	}
	
	public void EnterOutletEmail(String Email) throws InterruptedException 
	{
		OutletEmail.sendKeys(Email);
		Thread.sleep(2000);
	}
	
	
	
	public void EnterFlatno(String No) throws InterruptedException 
	{
		Flatno.sendKeys(No);
		Thread.sleep(3000);
	}
	
	public void Select_State(WebDriver driver) throws InterruptedException 
	{
		 State.click();
		 
		 List<WebElement> list = (List<WebElement>) (ListoptionsState);
			
		 System.out.println("Auto Suggest List ::" + list.size());
		 
		 for(int i = 0 ; i< list.size();  i++)
			{
				System.out.println(list.get(i).getText());
				
				if(list.get(i).getText().equals("New York"))
				{
					list.get(i).click();
					break;
				}
			}
		
		/*Actions A1=new Actions(driver);
		A1.click(State).perform();
		Thread.sleep(3000);
		A1.sendKeys(Keys.ARROW_DOWN).perform();
		
		Thread.sleep(3000);
		A1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);*/
		
	}
	
	
	public void Select_City(WebDriver driver) throws InterruptedException 
	{
		Actions A1=new Actions(driver);
		A1.click(City).perform();
		A1.sendKeys(Keys.ARROW_DOWN).perform();
		A1.sendKeys(Keys.ARROW_DOWN).perform();
		A1.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		
	}
	
	public void Enter_ZipCode(String zip) throws InterruptedException 
	{
		ZipCode.sendKeys(zip);
		Thread.sleep(2000);
	}
	
	public void SelectRegion() throws InterruptedException 
	{
		Select S1=new Select(Region);
		S1.deselectByVisibleText("US/Eastern");
		Thread.sleep(2000);
	}
	
	

	
	
	
}
