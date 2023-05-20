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
import Admin_Business.Edit_Date;
import Admin_Business.Edit_Lane;
import Admin_Business.Edit_Time;

public class TestAdmin_EditTime_CreateNewBooking extends A_Base_Class
{
	// Initialise_Brouser();
	// Webdriver driver

	// create object  logger class
	Logger logger = (Logger) LogManager.getLogger("TestAdmin_EditTime_CreateNewBooking");




	Bussiness_Login1 Blogin;
	Create_Booking1_CardPay BookingCreation;
	Booking_CashPayment CashPayment;
	Edit_Date EditDate;
	Edit_Lane Edit_Lane;
	Edit_Time  EditTime;
	Create_Multiple_Bookings Create_Multi_Bookings;

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
		EditTime=new Edit_Time(driver);
		Create_Multi_Bookings=new Create_Multiple_Bookings(driver);
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

	// User should able to Edit time and create new booking on previous time  
	@Test  (testName = "Admin_EditTime_CreateNewBooking")
	public void Admin_EditTime_CreateNewBooking() throws IOException, InterruptedException 
	{

		try 
		{
			//create booking
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
			Thread.sleep(5000);
			BookingCreation.EnterEmail(A_Utility_Class.getdatafromEs(1, 1, "CreateBookings_CardPay"));
			extentTest.info("Customer Mail Enter ");
			logger.info("User information are entered...!");
			Thread.sleep(5000);

			EditTime.ScrollTo5AM(driver);
			Thread.sleep(5000);
			EditTime.Click5AMCell();//5Am
			extentTest.info("Cell click  on calander");
			logger.info("Clicked on 5 AM cell on calander...!");
			Thread.sleep(3000);

			BookingCreation.Click_Calendersymbol();
			extentTest.info(" click on calander symbol");
			BookingCreation.Click_nextArrow();
			extentTest.info("Click on nextMonth Arrow on calander");
			BookingCreation.SelectDate();
			extentTest.info("Select Date for booking");
			logger.info("Date selected for booking...!");
			Thread.sleep(3000);

			EditTime.Select_PerHourplan();
			extentTest.info("Select Plan for booking");
			logger.info("Per Hour type plan selected for booking...!");
			Thread.sleep(3000);

			EditTime.Select_1Hour();
			extentTest.info("Select 1hour ");
			EditTime.Select_Guest(driver);
			extentTest.info("Select Guest");
			EditTime.SelectItems();
			extentTest.info("Select Item");
			logger.info("Hour/Guest/Items are selected...!");
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

			extentTest.info(MarkupHelper.createLabel("Booking created sucessfully...!", ExtentColor.ORANGE));
			System.out.println("Booking created successfully...!");
			logger.info("Booking created successfully...!");
			Thread.sleep(5000);

			//click created booking for update Time
			// click booking on 5 am--> 1hour--> 7th slot
			EditTime.Click_Created_Booking(driver);
			extentTest.info("Click Created booking for Edit");
			logger.info("Clicked on Created booking to edit time");
			Thread.sleep(5000);

			EditDate.Click_EditButton();
			extentTest.info("Click Edit Button");
			logger.info("Clicked on edit button...!");
			Thread.sleep(5000);

			EditTime.Edit_Time(driver, A_Utility_Class.getdatafromEs(1, 0, "EditTime"));//10Am
			Thread.sleep(2000);
			Create_Multi_Bookings.Enter_Minutes(driver, A_Utility_Class.getdatafromEs(1, 3, "multiple Booking creation"));
			Thread.sleep(2000);
			Create_Multi_Bookings.Select_AM_StartTime(driver, A_Utility_Class.getdatafromEs(1, 2, "EditBooking"));
			extentTest.info("Select New Time To Edit");
			logger.info("New time selected for booking...!");
			Thread.sleep(5000);

			EditDate.Click_UpdateBooking();
			extentTest.info("Click Upbadate Booking Button");
			logger.info("Clicked on Update Booking Button...!");
			Thread.sleep(5000);

			EditDate.Click_ConfirmEdit();
			extentTest.info("Click Confirm Button");
			logger.info("Clicked on Confirm Button...!");

			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']"))
					.isDisplayed(), true);

			EditDate.Click_Submit();
			extentTest.info("Click Submit Button");
			logger.info("Click on submit Button...!");

			extentTest.info(MarkupHelper.createLabel("Booking Time updated successfully...!", ExtentColor.ORANGE));
			System.out.println("Booking Time updated successfully...!");
			logger.info("Booking Time updated successfully...!");

			//Create new booking on same time from which we have update the booking..
			// on 5 AM --> 7 th slot

			EditTime.Click_RefreshButton();
			Thread.sleep(5000);
			EditTime.Click_RefreshButton();

			logger.info("Clicked on refresh button...!");
			Thread.sleep(10000);

			BookingCreation.Customer_Name(A_Utility_Class.getdatafromEs(1, 0, "CreateBookings_CardPay"));
			extentTest.info(" Customer Name Enter ");
			Thread.sleep(5000);
			BookingCreation.EnterEmail(A_Utility_Class.getdatafromEs(1, 1, "CreateBookings_CardPay"));
			extentTest.info("Customer Mail Enter ");
			logger.info("User information are entered...!");
			Thread.sleep(5000);

			BookingCreation.Click_CreateReservation();
			extentTest.info("Click Create Reservation button");
			logger.info("Clicked on create reservation button...!");

			EditTime.Edit_Time(driver, A_Utility_Class.getdatafromEs(1, 1, "EditTime"));//5Am
			Thread.sleep(2000);
			Create_Multi_Bookings.Enter_Minutes(driver, A_Utility_Class.getdatafromEs(1, 3, "multiple Booking creation"));
			Thread.sleep(2000);
			Create_Multi_Bookings.Select_AM_StartTime(driver, A_Utility_Class.getdatafromEs(1, 2, "EditBooking"));
			extentTest.info("Select previous Time to create new booking");
			logger.info("Previous time selected for booking...!");
			Thread.sleep(5000);

			EditTime.Select_PerHourplan();
			extentTest.info("Select Plan for booking");
			Thread.sleep(3000);
			EditTime.Select_1Hour();
			extentTest.info("Select 1hour ");
			EditTime.Select_Guest(driver);
			extentTest.info("Select Guest");
			EditTime.SelectItems();
			extentTest.info("Select Item");
			logger.info("Hour/Guest/Items are selected...!");
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
            Thread.sleep(2000);

			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']"))
					.isDisplayed(), true);
			
			Thread.sleep(5000);

			EditDate.Click_Submit();
			extentTest.info("Click Submit Button");
			logger.info("Click on submit button...!");

			


		}
		catch(Exception e) 
		{
			e.getStackTrace();
			String getCause = e.getLocalizedMessage();
			System.out.println("issue cause is :"+getCause);
			extentTest.fail("Admin_EditTime_CreateNewBooking Test case is Fail due to" + getCause);
		}

		String  ActualResult=driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText();
		String ExpectedResult="Booking status updated successfully";
		Assert.assertEquals(ActualResult, ExpectedResult);

		extentTest.info(MarkupHelper.createLabel("Booking created on previous time successfully...!", ExtentColor.ORANGE));
		System.out.println("Booking created on previous time successfully...!");
		logger.info("Booking created on previous time successfully...!...!");
	}





}
