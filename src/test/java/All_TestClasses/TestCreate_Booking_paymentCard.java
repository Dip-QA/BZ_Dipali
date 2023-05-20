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



import Admin_Business.A_Base_Class;
import Admin_Business.A_Utility_Class;
import Admin_Business.Add_Service;
import Admin_Business.Add_VenueDetails;
import Admin_Business.Admin_LogOut;
import Admin_Business.Booking_CashPayment;
import Admin_Business.Bussiness_Login1;

import Admin_Business.Create_Booking1_CardPay;
import Admin_Business.Edit_Addon;

public class TestCreate_Booking_paymentCard extends A_Base_Class
{

	// Initialise_Brouser();
	// Webdriver driver

	//Crete object of logger class

	Logger logger=(Logger) LogManager.getLogger("TestCreate_Booking_paymentCard");

	Bussiness_Login1 Blogin;
	Create_Booking1_CardPay BookingCreation;
	Edit_Addon Edit_Addon;
	Booking_CashPayment CashPay;

	@BeforeClass
	public void Open_Brouser (ITestContext Context) throws InterruptedException 
	{
		Initialise_Brouser(Context);
		logger.info("Browser Opened...!");

		//Initialise_Brouser();

		// object of pom classes
		Blogin=new Bussiness_Login1(driver);
		BookingCreation=new Create_Booking1_CardPay(driver);
		Edit_Addon=new Edit_Addon(driver);
		CashPay=new Booking_CashPayment(driver);

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

	// create booking from admin by clicking on create reservation button/ payment via card
	@Test (testName = "Create_Booking_pay_ViaCard")
	public void Create_Booking_pay_ViaCard() throws IOException, InterruptedException 
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
			Thread.sleep(3000);

			BookingCreation.Customer_Name(A_Utility_Class.getdatafromEs(1, 0, "CreateBookings_CardPay"));
			extentTest.info(" Customer Name Enter ");
			Thread.sleep(5000);
			BookingCreation.EnterEmail(A_Utility_Class.getdatafromEs(1, 1, "CreateBookings_CardPay"));
			extentTest.info("Customer Mail Enter ");
			logger.info("User information are entered...!");
			Thread.sleep(2000);

			BookingCreation.Click_CreateReservation();
			extentTest.info("Click Create Reservation button");
			logger.info("Clicked on create reservation button...!");

			BookingCreation.Click_Calendersymbol();
			extentTest.info("Click on calander symbol ");
			BookingCreation.Click_nextArrow();
			extentTest.info("Click on nextMonth Arrow on calander");
			BookingCreation.SelectDate();
			extentTest.info("Select Date for booking");
			logger.info("Date selected for booking...!");
			Thread.sleep(3000);

			BookingCreation.Selectplan();
			extentTest.info("Select Plan for booking");
			logger.info("Enable Package type plan selected for booking...!");
			Thread.sleep(3000);
			
			// 5 to 7 AM
			BookingCreation.SelectDuration();
			extentTest.info("Select Duration for booking");
			Thread.sleep(5000);
			BookingCreation.SelectPackage(driver);
			extentTest.info("Select Package for booking");
			Thread.sleep(3000);
			BookingCreation.SelectaddGuest(driver);
			extentTest.info("Select additional Guest for booking");
			logger.info("Package and additional guests are selected...!");
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
			Thread.sleep(2000);


			Edit_Addon.Click_RefreshBtn();
			extentTest.info("Click Refresh Button");
			logger.info("Clicked on refresh button to change the status...!");

			CashPay.Click_ReceivedCheckBox();
			extentTest.info("Click Payment Received checkbox");
			Thread.sleep(3000);
			logger.info("Clicked on Payment Received checkbox...!");

			CashPay.Click_ConfirmBtn();
			extentTest.info("Click Confirm button");
			logger.info("Clicked on confirm button...!");


		}

		catch(Exception e) 
		{
			e.getStackTrace();
			String getCause = e.getLocalizedMessage();
			System.out.println("issue cause is :"+getCause);
			extentTest.fail("Create_Booking_pay_ViaCard test case is fail due to" + getCause);
		}


		String  ActualResult=driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText();
		String ExpectedResult="Booking Successful !";
		Assert.assertEquals(ActualResult, ExpectedResult);

		System.out.println("Booking is successfull by Card payment");
		extentTest.info("Booking is successfull by Card payment");
		logger.info("Booking is successfull by Card payment...!");


	}






}
