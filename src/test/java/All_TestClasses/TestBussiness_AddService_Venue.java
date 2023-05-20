package All_TestClasses;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
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
import Admin_Business.Add_Service;
import Admin_Business.Add_VenueDetails;
import Admin_Business.Admin_LogOut;
import Admin_Business.Bussiness_Login1;

public class TestBussiness_AddService_Venue extends A_Base_Class
{
	// Initialise_Brouser();
		// Webdriver driver
	
	//Create object of logger class
	Logger logger=(Logger) LogManager.getLogger("TestBussiness_AddService_Venue");
	
	// globally declared objects
	Bussiness_Login1 Blogin;
	Add_Service  AddService;
	 Add_VenueDetails AddVenue;
	 Admin_LogOut Logout;
	
	@BeforeTest
	public void Open_Brouser (ITestContext Context) throws InterruptedException 
	{
		Initialise_Brouser(Context);
		 logger.info("Browser Opened...!");
		
		//Initialise_Brouser();

		// object of pom classes
		
	    Blogin=new Bussiness_Login1(driver);
	    AddService=new Add_Service(driver);
	    AddVenue=new Add_VenueDetails(driver);
	    Logout=new Admin_LogOut(driver);

	}
	
	@BeforeMethod
	public void Login() throws InterruptedException, IOException 
	{
		
		Blogin.Click_Radio();
		Blogin.Enter_UN(A_Utility_Class.getdatafromPF("UN_Business"));
		Blogin.Enter_PWS(A_Utility_Class.getdatafromPF("PWS_Business"));
		Blogin.Click_Login();
		logger.info("Login credentials are entered...!");

	}
	
	@Test (testName = "ADD_Service")
	public void ADD_Service() throws IOException, InterruptedException 
	{
		
		
		AddService.clickOutlet();
		extentTest.info("Click Outlet button");
		logger.info("Clicked on outlet button...!");
		
		AddService.clickArrow(driver);
		extentTest.info("Click On Arrow");
		logger.info("Login credentials are entered...!");
		
		AddService.click_Addservice();
		extentTest.info("Click On Add Service Button");
		logger.info("Clicked On Add Service Button...!");
		
		AddService.click_EntRadio();
		extentTest.info("Click On Service Radio Button ");
		logger.info("Clicked On Service Radio Button...!");
		
		AddService.click_Confirmbtn();
		extentTest.info("Click On Confirm");
		logger.info("Clicked On Confirm...!");
		
		AddService.click_Savebtn();
		extentTest.info("Click On Save");
		logger.info("Clicked On Save...!");
		
		boolean ActualResult=driver.getPageSource().contains("Service configuration has been successfully saved..!");
	       boolean ExpectedResult=true;
	       Assert.assertEquals(ActualResult, ExpectedResult);
		
	       System.out.println("Service configuration has been successfully saved..!");
	       extentTest.info("Service configuration has been successfully saved..!");
	       logger.info("Service configuration has been successfully saved..!");
	       
	}
	
	@Test (testName = "Add_Venue_Details")
	public void Add_Venue_Details() throws IOException, InterruptedException 
	{
		
		AddService.clickOutlet();
		extentTest.info("Click Outlet button");
		logger.info("Clicked on Outlet button...!");
		Thread.sleep(3000);
		
		AddService.clickArrow(driver);
		extentTest.info("Click On Arrow");
		logger.info("Clicked On Arrow...!");
		
		AddVenue.clickvenue_Detail();
		extentTest.info("Click on venue detail ");
		logger.info("Clicked on venue detail...!");
		
		AddVenue.clickAdd_VenueDetails();
		extentTest.info("Click Add Venue Details ");
		logger.info("Clicked on Add Venue Details...!");
		
		AddVenue.click_EditCategory();
		extentTest.info("Click Edit Service Category button");
		logger.info("Clicked on Edit Service Category button...!");
		
		AddVenue.Enter_service_Category(A_Utility_Class.getdatafromEs(1, 0, "Venue_Data"));
		extentTest.info("Enter Service Category");
		logger.info("Service Category Entered...!");
		
		AddVenue.Enter_venue_Type(A_Utility_Class.getdatafromEs(1, 1, "Venue_Data"));
		extentTest.info("Enter Venue Type");
		logger.info("Venue Type Entered...!");
		
		AddVenue.Enter_Service_Description(A_Utility_Class.getdatafromEs(1, 2, "Venue_Data"));
		extentTest.info("Enter Service Description");
		logger.info("Service Description Entered...!");
		
		AddVenue.Click_EditTotalCout();
		extentTest.info("Click Edit TotalCout button");
		logger.info("Clicked on Edit TotalCout button...!");
		Thread.sleep(5000);
		
		AddVenue.Select_venue();
		extentTest.info("Select Venue");
		logger.info("Venue Selected...!");
		Thread.sleep(3000);
		
		AddVenue.Clearfeild();
		extentTest.info("Clear Total Count");
		logger.info("Total Count Cleared...!");
		Thread.sleep(2000);
		
		AddVenue.Enter_TotalCount(A_Utility_Class.getdatafromEs(1, 3, "Venue_Data"));
		extentTest.info("Enter Total Count");
		logger.info("Total Count Entered...!");
		Thread.sleep(2000);
		
		AddVenue.Click_EditBookingType();
		extentTest.info("Click Edit BookingType button");
		logger.info("Clicked on Edit BookingType button...!");
		Thread.sleep(5000);
		
		AddVenue.Select_Service();
		extentTest.info("Select Service");
		logger.info("Service Selected...!");
		Thread.sleep(5000);
		
		AddVenue.Select_venueType();
		extentTest.info("Select Venue Type");
		logger.info("Venue Type Selected...!");
		
		AddVenue.Enter_From(A_Utility_Class.getdatafromEs(1, 4, "Venue_Data"));
		extentTest.info("Enter Slot From");
		logger.info("Slot From Entered...!");
		
		AddVenue.Enter_To(A_Utility_Class.getdatafromEs(1, 5, "Venue_Data"));
		extentTest.info("Enter Slot To");
		logger.info("Slot To Entered...!");
		Thread.sleep(5000);
		
		AddVenue.Select_ServiceDescription();
		extentTest.info("Select Service Description");
		logger.info("Service Description Selected...!");
		Thread.sleep(5000);
		
		AddVenue.Select_BookingType();
		extentTest.info("Select Booking Type");
		logger.info("Booking Type Selected...!");
		Thread.sleep(2000);
		
		AddVenue.Click_Savebtn();
		extentTest.info("Click on Save Button");
		logger.info("Clicked on Save Button...!");
		
		/*boolean ActualResult=driver.getPageSource().contains("Successfully Added");
	       boolean ExpectedResult=true;
	       Assert.assertEquals(ActualResult, ExpectedResult);*/
	       
	       if(driver.getPageSource().contains("Successfully Added")) 
			{
	    	   extentTest.pass("Venue Details Successfully Added") ;
			}
			
			
			else if(driver.getPageSource().contains("No Service Added. Please add a service first."))
			{
				extentTest.fail("No Service Added. Please add a service first.");
			}
		
	       
	       System.out.println("Venue details added Successfully..!");
	       extentTest.info("Venue details added Successfully..!");
	       logger.info("Venue details added Successfully..!");
	       
		
	}
	
	
	
	
	

}
