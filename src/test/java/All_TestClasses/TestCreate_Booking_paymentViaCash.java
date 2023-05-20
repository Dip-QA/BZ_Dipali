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

public class TestCreate_Booking_paymentViaCash extends A_Base_Class
{
	// Initialise_Brouser();
	// Webdriver driver

	//Create object of logger class

	Logger logger=(Logger) LogManager.getLogger("TestCreate_Booking_paymentViaCash");

	Bussiness_Login1 Blogin;
	Create_Booking1_CardPay BookingCreation;
	Booking_CashPayment CashPayment;

	@BeforeClass
	public void Open_Brouser (ITestContext Context) throws InterruptedException 
	{
		Initialise_Brouser(Context);
		logger.info("Browser Opened...!");

		//Initialise_Brouser();

		// object of pom classes
		Blogin=new Bussiness_Login1(driver);
		BookingCreation=new Create_Booking1_CardPay(driver);
		CashPayment=new Booking_CashPayment(driver);

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

	// create booking from admin by clicking on cell/ pay via cash
	@Test (testName = "Create_Booking_CellClick_Payvia_Cash")
	public void Create_Booking_CellClick_Payvia_Cash() throws IOException, InterruptedException 
	{
		try
		{ 
			BookingCreation.ClickCalenderbtn();
			extentTest.info("Click Calander button ");
			logger.info("Clicked on calendar button...!");
			Thread.sleep(70000);

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
			Thread.sleep(3000);
			

			CashPayment.Click_Cell();//This method use to click cell on calendar
			extentTest.info("Click cell on calander");
			logger.info("Clicked on calander cell...!");

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
			Thread.sleep(2000);
			
			
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
			Thread.sleep(5000);

			CashPayment.Select_CashPymentMethod();
			extentTest.info("Select Cash payment method for booking");
			logger.info("Pay via Cash option selected for payment...!");
			Thread.sleep(3000);

			CashPayment.Click_ReceivedCheckBox();
			extentTest.info("Click payment Received Check Box");
			logger.info("Clicked on payment Received check box...!");
			Thread.sleep(2000);

			CashPayment.Click_ConfirmBtn();
			extentTest.info("Click Confirm Button");
			logger.info("Clicked on Confirm Button...!");

		}
		catch(Exception e) 
		{
			e.getStackTrace();
			String getCause = e.getLocalizedMessage();
			System.out.println("issue cause is :"+getCause);
			extentTest.fail(" Create_Booking_CellClick_Payvia_Cash test case is fail due to" + getCause);
		}

		String  ActualResult=driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText();
		String ExpectedResult="Booking Successful !";
		Assert.assertEquals(ActualResult, ExpectedResult);

		System.out.println("Booking is successfull by cash payment");
		extentTest.info("Booking is successfull by cash payment");
		logger.info("Booking is successfull by cash payment...!");



	}


}
