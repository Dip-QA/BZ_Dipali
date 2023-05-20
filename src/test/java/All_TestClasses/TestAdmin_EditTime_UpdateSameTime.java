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
import Admin_Business.Edit_Lane;
import Admin_Business.Edit_Time;
import Admin_Business.Edit_Time_Updatesame;

public class TestAdmin_EditTime_UpdateSameTime extends A_Base_Class
{
	// Initialise_Brouser();
	// Webdriver driver

	// create object  logger class
	Logger logger = (Logger) LogManager.getLogger("TestAdmin_EditTime_UpdateSameTime");

	Bussiness_Login1 Blogin;
	Create_Booking1_CardPay BookingCreation;
	Booking_CashPayment CashPayment;
	Edit_Date EditDate;
	Edit_Lane Edit_Lane;
	Edit_Time  EditTime;
	Edit_Time_Updatesame EditTime_UpdateSame;

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
	    EditTime_UpdateSame=new Edit_Time_Updatesame(driver);
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

	// User should able to Edit time and update the same time from which we have update the time  
	@Test  (testName = "Admin_Edit_UpdateTime")
	public void Admin_Edit_UpdateTime() throws IOException, InterruptedException 
	{

		try 
		{
			//create booking
			// on 5 AM--> 8thslot
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

			EditTime.Click5AMCell();
			extentTest.info("Cell click  on calendar");
			logger.info("Clicked on 5 AM cell on calendar...!");
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
			extentTest.info("Click Payment Received check box ");
			logger.info("Clicked on payment received check box...!");
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

			//click created booking for update Time
			// click booking created on 5 am--> 8 th slot
			EditTime_UpdateSame.Click_Created_Booking(driver);
			extentTest.info("Click Created booking for Edit");
			logger.info("Clicked on Created booking to edit time");
			Thread.sleep(5000);

			EditDate.Click_EditButton();
			extentTest.info("Click Edit Button");
			logger.info("Clicked on edit button...!");
			Thread.sleep(5000);

			//10 Am
			EditTime.Edit_Time(driver, A_Utility_Class.getdatafromEs(1, 0, "EditTime"));
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

			Thread.sleep(5000);
			
			//click updated booking- To update the free slot on same time
			// click created booking updated on 10 am--> 2nd slot
			EditTime_UpdateSame.Click_Updated_Booking(driver);
			extentTest.info("Click updated booking to book free slot on same time ");
			logger.info("Clicked on Created booking to book free slot on same time");
			Thread.sleep(5000);

			EditDate.Click_EditButton();
			extentTest.info("Click Edit Button");
			logger.info("Clicked on edit button...!");
			Thread.sleep(3000);

			EditTime.Select_PreviousTime(driver,  A_Utility_Class.getdatafromEs(1, 1, "EditTime"));
			extentTest.info("Select Previous Time To Check Free Slot");
			logger.info("Previous time selected to move the booking...!");

			EditDate.Click_UpdateBooking();
			extentTest.info("Click Upbadate Booking Button");
			logger.info("Clicked on Update Booking Button...!");
			Thread.sleep(5000);

			EditDate.Click_ConfirmEdit();
			extentTest.info("Click Confirm Button");
			logger.info("Clicked on Confirm Button...!");

			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']"))
					.isDisplayed(), true);
			
			Thread.sleep(5000);
			
			EditDate.Click_Submit();
			logger.info("Click on submit Button...!");
			extentTest.info("Click Submit Button");

			extentTest.info(MarkupHelper.createLabel("Successfully update the booking on previous time...!", ExtentColor.ORANGE));
			System.out.println("Successfully update the booking on previous time...!");
			logger.info("Successfully update the booking on previous time...!");

		}
		catch(Exception e) 
		{
			e.getStackTrace();
			String getCause = e.getLocalizedMessage();
			System.out.println("issue cause is :"+getCause);
			extentTest.fail("Admin_Edit_UpdateTime test case is fail due to" + getCause);
		}

		String  ActualResult=driver.findElement(By.xpath("//div[@id='notistack-snackbar']"))
				.getText();
	      String ExpectedResult="Booking status updated successfully]";
	      Assert.assertEquals(ActualResult, ExpectedResult);

		
		
	}





}
