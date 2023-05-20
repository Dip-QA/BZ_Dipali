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
import Admin_Business.Edit_Date;

public class TestAdmin_EditDate extends A_Base_Class
{
	// Initialise_Brouser();
	// Webdriver driver

	// create object  logger class
	Logger logger = (Logger) LogManager.getLogger("TestAdmin_EditDate");



	Bussiness_Login1 Blogin;
	Create_Booking1_CardPay BookingCreation;
	Booking_CashPayment CashPayment;
	Edit_Date EditDate;

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


	// User should able to Edit date and update the booking on same date
	@Test (testName = "Admin_EditDate")
	public void Admin_EditDate() throws IOException, InterruptedException 
	{

		try {
			//create booking
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
			Thread.sleep(3000);

			CashPayment.Click_Cell();//This method use to click cell on calendar // 9 AM
			extentTest.info("Cell click  on calander");
			logger.info("Clicked cell on calander...!");

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
			//5 to 7 AM
			BookingCreation.SelectDuration();
			extentTest.info("Select Duration for booking");
			Thread.sleep(5000);
			BookingCreation.SelectPackage(driver);
			extentTest.info("Select Package for booking");
			Thread.sleep(3000);
			BookingCreation.SelectaddGuest(driver);
			extentTest.info("Select additional Guest for booking");
			logger.info("Package/Additional guests are selected...!");
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
			Thread.sleep(3000);

			extentTest.info(MarkupHelper.createLabel("Booking created successfully...!", ExtentColor.ORANGE));
			System.out.println("Booking created successfully...!");
			logger.info("Booking created successfully...!");
			Thread.sleep(5000);

			//update the date of created booking 
			// click booking created on 4th slot of 5 to 7 am
			EditDate.Click_Created_Booking(driver);//created booking
			extentTest.info("Click Created booking for Edit");
			logger.info("Clicked on Created booking to edit lane");
			Thread.sleep(5000);

			EditDate.Click_EditButton();
			extentTest.info("Click Edit Button");
			logger.info("Clicked on edit button...!");
			Thread.sleep(5000);

			EditDate.Click_CalenderEdit();
			extentTest.info("Click Calender to select new date");
			logger.info("Clicked on Calender to select new date...!");
			Thread.sleep(5000);

			EditDate.EditDate();//update date
			extentTest.info("Click Date for update");
			logger.info("Clicked on new date...!");
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

			extentTest.info(MarkupHelper.createLabel("Booking Date updated successfully...!", ExtentColor.ORANGE));
			System.out.println("Booking Date updated successfully...!");
			logger.info("Booking Date updated successfully...!");
			
			//Create new booking on previous date
			// on previous date --on 4 th slot--> 5 to 7 am
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
			BookingCreation.SelectDate();
			extentTest.info("Select Date for booking");
			logger.info("Date selected for booking...!");
			Thread.sleep(3000);


			BookingCreation.Selectplan();
			extentTest.info("Select Plan for booking");
			logger.info("Enable Package type plan selected for booking...!");

			Thread.sleep(3000);
			//5 to 7 am
			BookingCreation.SelectDuration();
			extentTest.info("Select Duration for booking");
			Thread.sleep(5000);
			BookingCreation.SelectPackage(driver);
			extentTest.info("Select Package for booking");
			Thread.sleep(3000);
			BookingCreation.SelectaddGuest(driver);
			extentTest.info("Select additional Guest for booking");
			logger.info("Package/Additional guests are selected...!");
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
		

			
			

		}
		catch(Exception e) 
		{
			e.getStackTrace();
			String getCause = e.getLocalizedMessage();
			System.out.println("issue cause is :"+getCause);
			extentTest.fail("Edit_Date test case is fail due to" + getCause);
		}

		String  ActualResult=driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText();
		String ExpectedResult="Booking status updated successfully";
		Assert.assertEquals(ActualResult, ExpectedResult);
		
		extentTest.info(MarkupHelper.createLabel("Booking created successfully on previous date...!", ExtentColor.ORANGE));
		System.out.println("Booking created successfully on previous date...!");
		logger.info("Booking created successfully on previous date...!");
		

	}




}
