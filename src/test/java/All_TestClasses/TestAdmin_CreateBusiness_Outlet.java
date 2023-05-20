package All_TestClasses;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



import Admin_Business.A_Base_Class;
import Admin_Business.A_Utility_Class;
import Admin_Business.Add_Business_Page1;
import Admin_Business.Add_Service;
import Admin_Business.Admin_LogOut;
import Admin_Business.Admin_Login1;
import Admin_Business.Bussiness_Login1;
import Admin_Business.Create_Bussiness;
import Admin_Business.Create_Outlet;


public class TestAdmin_CreateBusiness_Outlet extends A_Base_Class

{   // Initialise_Brouser();
	// Webdriver driver

	// create object pf looger class
		Logger logger = (Logger) LogManager.getLogger("TestAdmin_CreateBusiness_Outlet");
	
	// declare globally
	Admin_Login1 Admin;
	Add_Business_Page1 AddB;
	Create_Bussiness CreateB;
	Admin_LogOut Log;
	Create_Outlet CreatOutlet;
	

	@BeforeTest
	public void Open_Brouser (ITestContext Context) throws InterruptedException 
	{
		Initialise_Brouser(Context);
		logger.info("Browser opened...!");
		
		//Initialise_Brouser();

		// object of pom classes
		Admin=new Admin_Login1(driver);
		AddB=new Add_Business_Page1(driver);
		CreateB=new Create_Bussiness(driver);
		Log=new Admin_LogOut(driver);
	    CreatOutlet=new Create_Outlet(driver);
	    
	}

	@BeforeMethod
	public void Login() throws InterruptedException, IOException 
	{
		
		Admin.EnterUN(A_Utility_Class.getdatafromPF("UN"));
		Admin.EnterPWS(A_Utility_Class.getdatafromPF("PWS"));
		Admin.ClickLogin();
		logger.info("Login credentials are entered...!");


	}
// TC1= Admin user can able to create Business
	@Test (testName = "Business_Creation")
	public void Business_Creation(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException, AWTException 
	{ 
		
		AddB.ClickBusinesses();
		extentTest.info("Click Bussiness button ");
		logger.info("Clicked on bussiness button");
		
		AddB.ClickAddBusiness();
		extentTest.info("Click Add Bussiness button ");
		logger.info("Clicked on add bussiness button...!");
		
		//CreateB.ClickUploadbtn();
		//A_Utility_Class.uploadimg();
		CreateB.Enter_BussinessName(A_Utility_Class.getdatafromEs(1, 0, "Business_Data" ));
		extentTest.info("Enter Bussiness Name ");
		logger.info("Bussiness name entered...!");
		
		CreateB.Enter_FirstName(A_Utility_Class.getdatafromEs(1, 1, "Business_Data"));
		extentTest.info("Enter First name ");
		logger.info("First name entered...!");
		
		CreateB.Enter_LastName(A_Utility_Class.getdatafromEs(1, 2, "Business_Data"));
		extentTest.info("Enter Last Name");
		logger.info("Last name entered...!");
		
		CreateB.Enter_Email(A_Utility_Class.getdatafromEs(1, 3, "Business_Data"));
		extentTest.info("Enter Email");
		logger.info("Email entered...!");
		
		CreateB.Enter_Street(A_Utility_Class.getdatafromEs(1, 4, "Business_Data"));
		extentTest.info("Enter Street");
		logger.info("Street entered...!");
		CreateB.Enter_City(A_Utility_Class.getdatafromEs(1, 5, "Business_Data"));
		extentTest.info("Enter City");
		logger.info("City name entered...!");
		
		CreateB.Select_Contry();
		extentTest.info("Select Country");
		logger.info("Country name entered...!");
		
		CreateB.Enter_State(A_Utility_Class.getdatafromEs(1, 6, "Business_Data"));
		extentTest.info("Enter State");
		logger.info("State entered...!");
		
		CreateB.Enter_Zip(A_Utility_Class.getdatafromEs(1, 7, "Business_Data"));
		extentTest.info("Enter Zip");
		logger.info("Zip Code entered...!");
		
        CreateB.ClickCreate();
        extentTest.info("Click Create button ");
        logger.info("Clicked on create button ...!");
        
        CreateB.ClickNo();
        // scroll-up to capture validation message in case of TC failure
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, -500)");
        
        
       /* boolean ActualResult=driver.getPageSource().contains("Sucessfully Created");
       boolean ExpectedResult=true;
       Assert.assertEquals(ActualResult, ExpectedResult);*/
       
       
		if(driver.getPageSource().contains("Successfully Created")) 
		{
			extentTest.pass("Bussiness has been created sucessfully");
			logger.info("Bussiness has been created sucessfully...!");
			System.out.println("Bussiness has been created sucessfully...!");
		}
		
		else if(driver.getPageSource().contains("First Name is required"))
		{
			extentTest.fail("Bussiness not created due to  First Name is required ") ;
			logger.error("Bussiness not created due to  First Name is required...!");
		}
		else if(driver.getPageSource().contains("Last Name is required"))
		{
			extentTest.fail("Bussiness not created due to  Last Name is required ") ;
			logger.error("Bussiness not created due to  Last Name is required...!");
		}
		else if(driver.getPageSource().contains("Email is required"))
		{
			extentTest.fail("Bussiness not created due to  Email is required ") ;
			logger.error("Bussiness not created due to  Email is required...!");
		}
		else if(driver.getPageSource().contains("Flat/House no. is required"))
		{
			extentTest.fail("Bussiness not created due to  Flat/House no. is required ") ;
			logger.error("Bussiness not created due to  Flat/House no. is required...!");
		}
		else if(driver.getPageSource().contains("City is required"))
		{
			extentTest.fail("Bussiness not created due to  City  is required ") ;
			logger.error("Bussiness not created due to  City  is required...!");
		}
		else if(driver.getPageSource().contains("State is required"))
		{
			extentTest.fail("Bussiness not created due to  State is required ") ;
			logger.error("Bussiness not created due to  State is required...!");
		}
		else if(driver.getPageSource().contains("Zip Code is required"))
		{
			extentTest.fail("Bussiness not created due to Zip is required ") ;
			logger.error("Bussiness not created due to Zip is required...!");
		}
		else if(driver.getPageSource().contains("Business name is required"))
		{
			extentTest.fail("Bussiness not created due to  Bussiness Name is required ") ;
			logger.error("Bussiness not created due to  Bussiness Name is required...!");
		}
		
		else if(driver.getPageSource().contains("Business already registered, please try with other email"))
		{
			extentTest.fail("Business already registered, please try with other email") ;
			logger.error("Business already registered, please try with other email...!");
		}
		

	}
	
	@Test (testName = "Outlet_Creation")
	public void Outlet_Creation() throws EncryptedDocumentException, IOException, InterruptedException, InvocationTargetException 
	{
		
		
		try {
			
		AddB.ClickBusinesses();
		extentTest.info("Click Bussiness");
		logger.info("Clicked bussiness button...!");
		
		CreatOutlet.EnterMail(A_Utility_Class.getdatafromEs( 1, 0, "Outlet_Data"));
		extentTest.info("Search Mail");
		logger.info("Entered mail and search for bussiness account...!");
		
		CreatOutlet.clickSearchbtn();
		extentTest.info("Click Search Button");
		
		CreatOutlet.Click_Arrow();
		extentTest.info("Click On Bussiness Arrow");
		logger.info("Clicked On Bussiness Arrow...!");
		
		CreatOutlet.clcikAddOutlet();
		extentTest.info("Click on Add Outlet Button");
		logger.info("Clicked On Add Outlet Button...!");
		
		CreatOutlet.EnterOutletName(A_Utility_Class.getdatafromEs( 1, 1, "Outlet_Data"));
		extentTest.info("Enter Outlet Name");
		logger.info("Outlet name Entered...!");
		
		CreatOutlet.EnterOutletEmail(A_Utility_Class.getdatafromEs( 1, 0, "Outlet_Data"));//enter main in outlet crate page 
		extentTest.info("Enter Outlet Email");
		logger.info("Outlet name entered...!");
		
		CreatOutlet.EnterFlatno(A_Utility_Class.getdatafromEs( 1, 2, "Outlet_Data"));
		extentTest.info("Enter Flat No.");
		logger.info("Flat No. entered...!");
		
		
		CreatOutlet.Select_State(driver);
		extentTest.info("Select State");
		logger.info("State selected...!");
		
		CreatOutlet.Select_City(driver);
		extentTest.info("Select City");
		logger.info("City selected...!");
		
		CreatOutlet.Enter_ZipCode(A_Utility_Class.getdatafromEs(1, 3, "Outlet_Data"));
		extentTest.info("Enter Zipcode");
		logger.info("Zip Code entered...!");
		
		CreatOutlet.SelectRegion();
		extentTest.info("Select Region");
		logger.info("Region selected...!");
		
		CreateB.ClickCreate();
		extentTest.info("Click Create Button");
		logger.info("Click Create Button...!");
		
		logger.info("Outlet created successfully...!");
		System.out.println("Outlet created successfully...!");
		extentTest.info("Outlet created successfully...!");
		}
		
		catch(Exception e) 
		{
			e.getStackTrace();
	         String getCause = e.getLocalizedMessage();
	         System.out.println("issue cause is :"+getCause);
	         extentTest.fail("Outlet_Creation Test case is Fail due to" + getCause);
		}
		
	       
	       String  ActualResult=driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText();
		      String ExpectedResult="Sucessfully Created";
		      Assert.assertEquals(ActualResult, ExpectedResult);
		
		/*if(driver.getPageSource().contains("Sucessfully Created")) 
		{
			extentTest.pass("Outlet created sucessfully") ;
		}
		
		
		else if(driver.getPageSource().contains("Name is required"))
		{
			extentTest.fail("Outlet is not created due to Name is required ") ;
		}
		
		else if(driver.getPageSource().contains("Flat/House no. is required"))
		{
			extentTest.fail("Outlet is not created due to Flat/House no. is required ") ;
		}
		else if(driver.getPageSource().contains("City is required"))
		{
			extentTest.fail( "Outlet not created due to City is required");
		}
		else if(driver.getPageSource().contains("State is required"))
		{
			extentTest.fail( "Outlet not created due to State is required");
		}
		else if(driver.getPageSource().contains("Zip Code is required"))
		{
			extentTest.fail("Outlet not created due to Zip Code is required");
		}
		else if(driver.getPageSource().contains("Region is Required"))
		{
			extentTest.fail( "Outlet not created due to Region is Required");
		}*/
		
		
	}


}
