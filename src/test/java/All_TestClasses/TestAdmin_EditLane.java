package All_TestClasses;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Admin_Business.A_Base_Class;
import Admin_Business.A_Utility_Class;
import Admin_Business.Add_Service;
import Admin_Business.Add_VenueDetails;
import Admin_Business.Admin_LogOut;
import Admin_Business.Booking_CashPayment;
import Admin_Business.Bussiness_Login1;

import Admin_Business.Create_Booking1_CardPay;
import Admin_Business.Edit_Date;
import Admin_Business.Edit_Lane;

public class TestAdmin_EditLane extends A_Base_Class
{
	// Initialise_Brouser();
	// Webdriver driver

	// create object  logger class
	Logger logger = (Logger) LogManager.getLogger("TestAdmin_EditLane");



	Bussiness_Login1 Blogin;
	Create_Booking1_CardPay BookingCreation;
	Booking_CashPayment CashPayment;
	Edit_Date EditDate;
	Edit_Lane Edit_Lane;

	@BeforeClass
	public void Open_Brouser (ITestContext Context) throws InterruptedException 
	{
		Initialise_Brouser(Context);
		logger.info("Browser opened...!");

		//Initialise_Brouser();

		// object of pom classes
		Blogin=new Bussiness_Login1(driver);
		BookingCreation=new Create_Booking1_CardPay(driver);
		CashPayment=new Booking_CashPayment(driver);
		EditDate=new Edit_Date(driver);
		Edit_Lane=new Edit_Lane(driver);

	}

	@BeforeMethod
	public void Login() throws InterruptedException, IOException 
	{

		Blogin.Click_Radio();
		Blogin.Enter_UN(A_Utility_Class.getdatafromPF("UN_Business"));
		Blogin.Enter_PWS(A_Utility_Class.getdatafromPF("PWS_Business"));
		Blogin.Click_Login();
		Thread.sleep(5000);
		logger.info("Login credentials are entered...!");


	}

	// User should able to Edit Lane and update the same slot  
	@Test  (testName = "Admin_EditLane")
	public void Admin_EditLane() throws IOException, InterruptedException 
	{

		try 
		{
			//create booking
			// 9 am --> 2nd slot
			BookingCreation.ClickCalenderbtn();
			extentTest.info("Click Calander button ");
			logger.info("Clicked on calendar button...!");
			Thread.sleep(20000);
			
			BookingCreation.select_Outlet(driver);
			extentTest.info("Outlet selected");
			logger.info("Outlet selected...!");
			Thread.sleep(5000);

			BookingCreation.Customer_Name(A_Utility_Class.getdatafromEs(1, 0, "CreateBookings_CardPay"));
			extentTest.info("Customer Name Enter...!");
			Thread.sleep(5000);
			BookingCreation.EnterEmail(A_Utility_Class.getdatafromEs(1, 1, "CreateBookings_CardPay"));
			extentTest.info("Customer Mail Enter ");
			logger.info("User information are entered...!");
			Thread.sleep(5000);

			Edit_Lane.scrollfor9AM(driver);
			CashPayment.Click_Cell(); //This method use to click cell on calendar
			extentTest.info("Cell click  on calander...!");
			logger.info("Clicked cell on calander...!");
			Thread.sleep(3000);

			BookingCreation.Click_Calendersymbol();
			extentTest.info("click on calander symbol...!");
			BookingCreation.Click_nextArrow();
			extentTest.info("Click on nextMonth Arrow on calander...!");
			BookingCreation.SelectDate();
			extentTest.info("Select Date for booking");
			logger.info("Date selected for booking...!");
			Thread.sleep(3000);

			Edit_Lane.Select_ToLanePlan();// select plan which have only two lanes
			extentTest.info("Select Plan for booking");
			logger.info("Per Person type plan selected for booking...!");

			Thread.sleep(3000);
			Edit_Lane.Select_PersonCount(driver);
			extentTest.info("Select Person/guest");
			Edit_Lane.Select_Item(driver);
			extentTest.info("Select Item");
			logger.info("Person/Item are selected...!");
			Thread.sleep(3000);

			BookingCreation.Click_ProceedToPay();
			extentTest.info("Click on Proceed to pay button");
			logger.info("Clicked on proceed to pay button...!");
			Thread.sleep(5000);

			CashPayment.Select_CashPymentMethod();
			extentTest.info("Select Cash payment for booking");
			logger.info("Payment via cash option selected for payment...!");
			Thread.sleep(10000);

			CashPayment.Click_ReceivedCheckBox();
			extentTest.info("Click Payment Received checkbox ");
			logger.info("Clicked on payment received checkbox...!");
			Thread.sleep(3000);

			CashPayment.Click_ConfirmBtn();
			extentTest.info("Click Confirm Button");
			logger.info("Clicked on Confirm Button...!");

			logger.info("Cash payment done successfully...!");

			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']"))
					.isDisplayed(), true);

			Thread.sleep(5000);
			EditDate.Click_Submit();
			extentTest.info("Click Submit Button");
			logger.info("Click on submit button...!");
			Thread.sleep(5000);

			extentTest.info(MarkupHelper.createLabel("Booking created successfully...!", ExtentColor.ORANGE));
			System.out.println("Booking created successfully...!");
			logger.info("Booking created successfully...!");

			//click created booking for update lane
			Edit_Lane.Click_Created_Booking(driver);
			extentTest.info("Click Created booking to edit lane");
			logger.info("Clicked on created booking to update the lane...!");
			Thread.sleep(5000);

			EditDate.Click_EditButton();
			extentTest.info("Click Edit Button");
			logger.info("Clicked on edit button...!");
			Thread.sleep(5000);

			Edit_Lane.Click_DefaultLane();//lane1
			extentTest.info("UnClick Default selected lane ");
			logger.info("Default selected lane unClicked...!");
			Thread.sleep(5000);

			Edit_Lane.selectNew_Lane();//lane2
			extentTest.info("Click New Lane ");
			logger.info("Select updated lane...!");
			Thread.sleep(5000);

			EditDate.Click_UpdateBooking();
			extentTest.info("Click Update Booking Button");
			logger.info("Clicked on Update Booking Button...!");
			Thread.sleep(5000);

			EditDate.Click_ConfirmEdit();
			extentTest.info("Click Conferm Button");
			logger.info("Clicked on Conferm Button...!");

			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']"))
					.isDisplayed(), true);

			EditDate.Click_Submit();
			extentTest.info("Click Submit Button");
			logger.info("Click on submit Button...!");

			extentTest.info(MarkupHelper.createLabel("Booking Lane updated successfully...!", ExtentColor.ORANGE));
			System.out.println("Booking Lane updated successfully...!");
			logger.info("Booking Lane updated successfully...!");

			//click updated booking- To update the free slot
			// click lane updated booking--> 9 AM ---> 3rd slot
			Edit_Lane.Click_Updated_Booking(driver);
			extentTest.info("Click updated booking for booking same slot");
			logger.info("Click on updated booking for booking free slot...!");
			Thread.sleep(5000);

			EditDate.Click_EditButton();
			extentTest.info("Click Edit Button");
			logger.info("Click on edit button...!");

			Edit_Lane.Select_PersonCount(driver);
			extentTest.info("Increase person count");
			logger.info("Increase person count...!");

			Edit_Lane.selectNew_Lane();// xpath get change alternately  so that we are calling this method
			extentTest.info("Click previous free slot");
			logger.info("Previous lane selected for booking...!");

			EditDate.Click_UpdateBooking();
			extentTest.info("Click Update Booking Button");
			logger.info("Click Update Booking Button...!");
			Thread.sleep(5000);

			EditDate.Click_ConfirmEdit();
			extentTest.info("Click Confirm Button");
			logger.info("Clicked on Confirm Button...!");
			Thread.sleep(5000);
			
			CashPayment.Select_CashPymentMethod();
			extentTest.info("Select Cash payment method for booking");
			logger.info("Pay via Cash option selected for payment...!");
			Thread.sleep(3000);

			CashPayment.Click_ReceivedCheckBox();
			extentTest.info("Click Payment Recieved checkbox ");
			logger.info("Clicked on payment received checkbox...!");
			Thread.sleep(3000);

			CashPayment.Click_ConfirmBtn();
			extentTest.info("Click Conferm Button");
			logger.info("Click on confirm Button...!");
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']"))
					.isDisplayed(), true);

			Thread.sleep(5000);
			
			EditDate.Click_Submit();
			extentTest.info("Click Submit Button");
			logger.info("Click on Submit Button...!");

			extentTest.info(MarkupHelper.createLabel("Free lane updated successfully...!", ExtentColor.ORANGE));
			System.out.println("Free lane updated successfully...!");
			logger.info("Free lane updated successfully...!");

		}

		catch(Exception e) 
		{
			e.getStackTrace();
			String getCause = e.getLocalizedMessage();
			System.out.println("issue cause is :"+getCause);
			extentTest.fail("Admin_EditLane Test case is Fail due to" + getCause);
		}

		String  ActualResult=driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText();
		String ExpectedResult="Booking Successful !";
		Assert.assertEquals(ActualResult, ExpectedResult);

	}





}
