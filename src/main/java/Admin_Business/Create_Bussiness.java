package Admin_Business;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Create_Bussiness 
{   @FindBy(xpath="//span[text()='Upload Image']")    private WebElement Upload;
	@FindBy(name="businessName")    private WebElement BussinessName;
	@FindBy(name="firstName")    private WebElement FirstName;
	@FindBy(name="lastName")    private WebElement LastName;
	@FindBy(name="email")    private WebElement Email;
	@FindBy(name="address.street")    private WebElement Street;
	@FindBy(name="address.city")    private WebElement City;
	@FindBy(name="address.state")    private WebElement State;
	@FindBy(name="address.zip")    private WebElement Zip;
	@FindBy(xpath="//span[contains(text(),'Create Business')]")    private WebElement CreateBussiness;
	@FindBy(name="address.country")    private WebElement StateDropDown;
	@FindBy(xpath="//span[text()='No']")    private WebElement AddNo;
	
	public Create_Bussiness(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickUploadbtn() 
	{
		Upload.click();
	}
	
	
	public void Enter_BussinessName(String BName) throws InterruptedException 
	{
		BussinessName.sendKeys(BName);
		Thread.sleep(2000);
	}
	
	
	public void Enter_FirstName(String Fname) throws InterruptedException 
	{
		FirstName.sendKeys(Fname);
		Thread.sleep(2000);
	}
	
	public void Enter_LastName(String LName) throws InterruptedException 
	{
		LastName.sendKeys(LName);
		Thread.sleep(2000);
	}
	
	public void Enter_Email(String Mail) throws InterruptedException 
	{
		Email.sendKeys(Mail);
		Thread.sleep(2000);
	}

	public void Enter_Street(String Add) throws InterruptedException 
	{
		Street.sendKeys(Add);
		Thread.sleep(2000);
	}

	public void Enter_City(String CityName) throws InterruptedException 
	{
		City.sendKeys(CityName);
		Thread.sleep(2000);
	}

	public void Enter_State(String StateName) throws InterruptedException 
	{
		State.sendKeys(StateName);
		Thread.sleep(2000);
	}
	
	public void Select_Contry() 
	{
		Select S1=new Select(StateDropDown);
		       S1.selectByVisibleText("America");
	}
	
	
	public void Enter_Zip(String ZipName) throws InterruptedException 
	{
		Zip.sendKeys(ZipName);
		Thread.sleep(5000);
	}
	
	public void ClickCreate() throws InterruptedException 
	{
		CreateBussiness.click();
		Thread.sleep(5000);
	}
	
	//need to check
	public void ClickNo() throws InterruptedException 
	{
		AddNo.click();
		Thread.sleep(2000);
	}
	
	
	
	
}
