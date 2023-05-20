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
import Admin_Business.Create_Multiple_Bookings;
import Admin_Business.EditEvent_ViewReservation;
import Admin_Business.Edit_Addon;
import Admin_Business.Edit_Date;
import Admin_Business.Edit_Lane;
import Admin_Business.Edit_Time;

public class TestEdit_Event_FromViewReservation extends A_Base_Class
{

	// Initialise_Brouser();
	// Webdriver driver


	// create object  logger class
	Logger logger = (Logger) LogManager.getLogger("TestEdit_Event_FromViewReservation");

	Bussiness_Login1 Blogin;
	Create_Booking1_CardPay BookingCreation;
	Booking_CashPayment CashPay;
	Edit_Lane Edit_Lane;
	Edit_Date EditDate;
	Edit_Addon Edit_Addon;
	Edit_Time  EditTime;
	Create_Multiple_Bookings Create_Multi_Bookings;
	EditEvent_ViewReservation EditEvent;

	@BeforeClass
	public void Open_Brouser (ITestContext Context) throws InterruptedException 
	{
		Initialise_Brouser(Context);
		logger.info("Browser opened...!");


		//Initialise_Brouser();

		// object of pom classes
		Blogin=new Bussiness_Login1(driver);
		BookingCreation=new Create_Booking1_CardPay(driver);
		CashPay=new Booking_CashPayment(driver);
		Edit_Lane=new Edit_Lane(driver);
		EditDate=new Edit_Date(driver);
		Edit_Addon=new Edit_Addon(driver);
		EditTime=new Edit_Time(driver);
		Create_Multi_Bookings=new Create_Multiple_Bookings(driver);
	    EditEvent=new EditEvent_ViewReservation(driver);
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

	// Edit the Event by clicking on view reservation button 
	@Test (testName = "EditEvent_Clicking_on_ViewReservation")
	public void EditEvent_Clicking_on_ViewReservation() throws IOException, InterruptedException 
	{
		try
		{ 
			BookingCreation.ClickCalenderbtn();
			extentTest.info("Click Calander button ");
			logger.info("Clicked on calendar button...!");
			Thread.sleep(20000);

			BookingCreation.select_Outlet(driver);
			extentTest.info("Outlet selected");
			logger.info("Outlet selected...!");
			Thread.sleep(5000);

			BookingCreation.Customer_Name(A_Utility_Class.getdatafromEs(1, 0, "CreateBookings_CardPay"));
			extentTest.info(" Customer Name Enter ");
			Thread.sleep(2000);
			BookingCreation.EnterEmail(A_Utility_Class.getdatafromEs(1, 1, "CreateBookings_CardPay"));
			extentTest.info("Customer Mail Enter ");
			logger.info("User information are entered...!");
			Thread.sleep(2000);

			BookingCreation.Click_CreateReservation();
			extentTest.info("Click Create Reservation button");
			logger.info("Clicked on create reservation button...!");
			
			// Enter time for event type plan // 1 AM 
			EditTime.Edit_Time(driver, A_Utility_Class.getdatafromEs(1, 0,  "multiple Booking creation"));
			Thread.sleep(2000);
			Create_Multi_Bookings.Enter_Minutes(driver, A_Utility_Class.getdatafromEs(1, 3, "multiple Booking creation"));
			Thread.sleep(2000);
			Create_Multi_Bookings.Select_AM_StartTime(driver, A_Utility_Class.getdatafromEs(1, 2, "EditBooking"));
			extentTest.info("Select New Time To Edit");
			logger.info("New time selected for booking...!");
			Thread.sleep(5000);

			BookingCreation.Click_Calendersymbol();
			extentTest.info("Click on calander symbol ");
			BookingCreation.Click_nextArrow();
			extentTest.info("Click on nextMonth Arrow on calander");
			BookingCreation.SelectDate();
			extentTest.info("Select Date for booking");
			logger.info("Date selected for booking...!");
			Thread.sleep(3000);

			EditEvent.SelectPlan();
			extentTest.info("Select Plan for booking");
			logger.info("Event type plan selected for booking...!");
            Thread.sleep(3000);
            
            EditEvent.Select_Event1();
            extentTest.info("Select Event1");
			logger.info("Event1 selected...!");
			Thread.sleep(3000);
            
            
            EditEvent.Select_Child(driver);
			extentTest.info("Select Child for booking");
			Thread.sleep(3000);
			EditEvent.Select_Item(driver);
			extentTest.info("Select Itemfor booking");
			logger.info("Child/Item are selected...!");
			Thread.sleep(3000);

			BookingCreation.Click_ProceedToPay();
			extentTest.info("Click on Proceed to pay button");
			logger.info("Clicked on proceed to pay button...!");
			Thread.sleep(10000);

			BookingCreation.Select_CardPymentMethod();
			extentTest.info("Select Card payment method for booking");
			logger.info("Pay via Card option selected for payment...!");
			Thread.sleep(5000);

			// To handle iframe element
			driver.switchTo().frame("__teConnectSecureFrame");
			BookingCreation.EnterCardNo(A_Utility_Class.getdatafromEs(1, 2, "CreateBookings_CardPay"));
			extentTest.info("Enter card no.");
			Thread.sleep(3000);
			BookingCreation.EnterExpiryDate(A_Utility_Class.getdatafromEs(1, 3, "CreateBookings_CardPay"));
			extentTest.info("Enter Expiry Date");
			Thread.sleep(3000);
			BookingCreation.Entercvc(A_Utility_Class.getdatafromEs(1, 4, "CreateBookings_CardPay"));
			extentTest.info("Enter CVC");
			logger.info("Card details entered successfully...!");
			Thread.sleep(3000);

			//To switch focus of selenium on main page
			driver.switchTo().defaultContent();
			BookingCreation.ClickPayBtn();
			extentTest.info("Click Pay Button");
			logger.info("Clicked on pay button...!");
			Thread.sleep(7000);

			Edit_Addon.Click_RefreshBtn();
			extentTest.info("Click Refresh Button");
			logger.info("Clicked on refresh button to change the status...!");
			Thread.sleep(2000);
			
			CashPay.Click_ReceivedCheckBox();
			logger.info("Clicked on Payment Received check box...!");
			extentTest.info("Click Payment Received check box");
			Thread.sleep(3000);

			CashPay.Click_ConfirmBtn();
			extentTest.info("Click Confirm button");
			logger.info("Clicked on confirm button...!");
			

			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']"))
					.isDisplayed(), true);
			
			Thread.sleep(3000);

			BookingCreation.Click_SubmitButton();
			extentTest.info("Click Submit Button");
			logger.info("Clicked on submit button...!");
			Thread.sleep(5000);

		    extentTest.info(MarkupHelper.createLabel("Booking created successfully...!", ExtentColor.ORANGE));
			System.out.println("Booking created successfully...!");
			logger.info("Booking created successfully...!");
			Thread.sleep(3000);
			
			//click on view reservation button
			EditEvent.Click_ViewReservation_Btn();
			extentTest.info("Click View Reservation Button");
			logger.info("Clicked on View Reservation button...!");
			Thread.sleep(3000);
			EditEvent.Click_BookingArrow();
			extentTest.info("Click on booking arrow");
			logger.info("Clicked on Booking arrow...!");
			Thread.sleep(3000);
			
			EditDate.Click_EditButton();
			extentTest.info("Click Edit Button");
			logger.info("Clicked on edit button...!");
			Thread.sleep(5000);
			
			EditEvent.Click_Event3();
			extentTest.info("Edit Event1 to Event3");
			logger.info("Event1 edited to Event3...!");
			Thread.sleep(5000);
			
			Edit_Addon.Click_UpdateBookingBTN();
			extentTest.info("Click Update Booking Button");
			logger.info("Clicked on update booking button...!");
			Thread.sleep(2000);

			Edit_Addon.Click_ConfirmBTN();
			extentTest.info("Click Confirm Button");
			logger.info("Clicked on Confirm Button...!");
			Thread.sleep(5000);

			BookingCreation.Select_CardPymentMethod();
			extentTest.info("Select Card payment method for booking");
			logger.info("Card payment method selected for payment...!");
			Thread.sleep(5000);

			Edit_Addon.Click_Payvia_savedcard();
			extentTest.info("Click Pay Via Save Card Option");
			logger.info("Clicked on Pay Via Save Card Option...!");
			Thread.sleep(3000);

			Edit_Addon.payupdate();
			extentTest.info("Click pay Button");
			logger.info("Clicked on Pay button...!");
			Thread.sleep(5000);

			Edit_Addon.Click_RefreshBtn();
			extentTest.info("Click Refresh Button");
			logger.info("Clicked on refresh button...!");
			Thread.sleep(5000);

			BookingCreation.Click_SubmitButton();
			extentTest.info("Click Submit Button");
			logger.info("Clicked on submit button...!");

			String  ActualResult=driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText();
			String ExpectedResult="Booking status updated successfully";
			Assert.assertEquals(ActualResult, ExpectedResult);

			
			extentTest.info(MarkupHelper.createLabel("Event updated successfully", ExtentColor.ORANGE));
			System.out.println("Event updated successfully...!");
			logger.info("Event updated successfully...!");


		}

		catch(Exception e) 
		{
			e.getStackTrace();
			String getCause = e.getLocalizedMessage();
			System.out.println("issue cause is :"+getCause);
			extentTest.fail("EditEvent_Clicking_on_ViewReservation test case is fail due to" + getCause);
		}


		



	}






}
