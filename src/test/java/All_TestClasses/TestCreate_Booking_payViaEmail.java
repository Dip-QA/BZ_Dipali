package All_TestClasses;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver.Timeouts;


import Admin_Business.A_Base_Class;
import Admin_Business.A_Utility_Class;
import Admin_Business.Add_Service;
import Admin_Business.Add_VenueDetails;
import Admin_Business.Admin_LogOut;
import Admin_Business.Booking_CashPayment;
import Admin_Business.Booking_PaymentVia_Email;
import Admin_Business.Bussiness_Login1;

import Admin_Business.Create_Booking1_CardPay;
import Admin_Business.Mail_Paymentgateway;

public class TestCreate_Booking_payViaEmail extends A_Base_Class
{
	// Initialise_Brouser();
	// Webdriver driver

	//Create object of logger class

	

	Logger logger=(Logger) LogManager.getLogger("TestCreate_Booking_payViaEmail");


	Bussiness_Login1 Blogin;
	Create_Booking1_CardPay BookingCreation;
	Booking_PaymentVia_Email PayviaEmail;
	Mail_Paymentgateway Paymentgetway;


	@BeforeClass
	public void Open_Brouser (ITestContext Context) throws InterruptedException 
	{
		Initialise_Brouser(Context);
		logger.info("Browser Opened...!");


		// object of pom classes
		Blogin=new Bussiness_Login1(driver);
		BookingCreation=new Create_Booking1_CardPay(driver);
		PayviaEmail=new Booking_PaymentVia_Email(driver); 
		Paymentgetway=new Mail_Paymentgateway(driver);


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

	// Create booking from Admin by clicking on Create Reservation button/ pay via Email Calendar
	@Test (testName = "Create_Booking_PayviaEmail")
	public void Create_Booking_PayviaEmail() throws IOException, InterruptedException 
	{

		try
		{
			BookingCreation.ClickCalenderbtn();
			extentTest.info("Click Calendar button ");
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
			Thread.sleep(5000);

			PayviaEmail.Select_EmailPymentMethod();
			extentTest.info("Select Email payment method for booking");
			logger.info("Pay via email option selected for payment...!");
			Thread.sleep(3000);

			PayviaEmail.Click_SendLink(driver);
			extentTest.info("Link has been send successfully");
			logger.info("Link has been send sucessfully...!");
			Thread.sleep(5000);

			PayviaEmail.NavigateTO_YopMail(driver);
			extentTest.info("Navigated to yopmail.com");
			logger.info("Navigated to yopmail.com...!");
			Thread.sleep(5000);

			PayviaEmail.Entername_Login("dip");//hardcoded
			extentTest.info("Enter UN for yopmail");
			Thread.sleep(5000);
			PayviaEmail.Click_mailArrow();
			extentTest.info("Click on next arrow on yopmail");
			logger.info("Logged in into yop mail account...!");
			Thread.sleep(10000);

			//PayviaEmail.Click_mail();// no need to click on mail
			//Thread.sleep(5000);

			// To handle iframe element
			driver.switchTo().frame("ifmail");

			PayviaEmail.LinkinMail();// click link inside mail
			extentTest.info("Click Link Given in mail");
			logger.info("Clicked on link which navigates to payment page...!");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// wait


			//To switch focus of selenium on main page
			driver.switchTo().defaultContent();
			Thread.sleep(10000);

			// need to handle window pop-up
			Set<String>  AllIds=driver.getWindowHandles();
			ArrayList<String> ar=new  ArrayList<String>(AllIds);
			String WindowPopId=ar.get(1);
			// To switch focus window pop-up
			driver.switchTo().window(WindowPopId);
			Paymentgetway.Click_Paybutton();
			logger.info("Clicked on pay button...!");
			Thread.sleep(3000);


			// need to handle iframe element
			driver.switchTo().frame("__teConnectSecureFrame");
			BookingCreation.EnterCardNo(A_Utility_Class.getdatafromEs(1, 2, "CreateBookings_CardPay"));
			extentTest.info("Enter Card No.");
			Thread.sleep(3000);
			BookingCreation.EnterExpiryDate(A_Utility_Class.getdatafromEs(1, 3, "CreateBookings_CardPay"));
			extentTest.info("Enter Expiry Date");
			Thread.sleep(3000);
			BookingCreation.Entercvc(A_Utility_Class.getdatafromEs(1, 4, "CreateBookings_CardPay"));
			extentTest.info("Enter CVC");
			logger.info("Card details entered successfully...!");

			//To switch focus of selenium on main page
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
			Paymentgetway.Click_payon_PaymentPage();
			extentTest.info("Click pay on Payment Page");
			logger.info("Clicked on final pay button...!");



		}
		catch(Exception e) 
		{
			e.getStackTrace();
			String getCause = e.getLocalizedMessage();
			System.out.println("issue cause is :"+getCause);
			extentTest.fail("Create_Booking_PayviaEmail test case is fail due to" + getCause);
		}

		String  ActualResult=driver.findElement(By.xpath("//div[contains(@class,'BookingStatus_bill__status__nj')]")).getText();
		String ExpectedResult="Your Party Is Booked!";
		Assert.assertEquals(ActualResult, ExpectedResult);

		System.out.println("Your Party is Booked by paying via email!");
		extentTest.info("Your Party is Booked by paying via email!");
		logger.info("Your Party is Booked by paying via email...!");

	}





}
