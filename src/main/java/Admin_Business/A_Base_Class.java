package Admin_Business;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;


public class A_Base_Class
{
	// create object  logger class
		Logger logger = (Logger) LogManager.getLogger("A_Base_Class");
		
	       public  WebDriver driver; 
	       public static String screenshotsSubFolderName;
	    	public static ExtentReports extentReports;
	    	public static ExtentTest extentTest;
	    	private Timeouts implicitlyWait2;
	    	private Timeouts implicitlyWait;
	    	
	public void Initialise_Brouser(ITestContext Context) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup(); //.exe file is there or not
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
	   driver=new ChromeDriver(options);
	
		Thread.sleep(2000);
		
		driver.get("https://admin.test.bookingzone.com");
		
        driver.manage().timeouts() .implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName() + " " + capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf("."));
		String author = Context.getCurrentXmlTest().getParameter("author");
		
		extentTest = extentReports.createTest(Context.getName());
		extentTest.assignAuthor(author);
		extentTest.assignDevice(device);
		
	}

	 @BeforeSuite
		public void initialiseExtentReports() {
			ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("./reports/BZTestPassreport.html");
			sparkReporter_all.config().setReportName("BZ Tests report");
			sparkReporter_all.config().setTheme(Theme.DARK);
			sparkReporter_all.config().setDocumentTitle("TestCasesAll");
			
			ExtentSparkReporter sparkReporter_failed = new ExtentSparkReporter("./reports/FailExtent.html");
			sparkReporter_failed.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
			sparkReporter_failed.config().setReportName("Failure report");
			
			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter_all, sparkReporter_failed);
			
			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
	 
	 @AfterSuite
		public void generateExtentReports() throws Exception {
			extentReports.flush();
			Desktop.getDesktop().browse(new File("AllTests.html").toURI());
			Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		}
	 
	 @AfterMethod
		public void checkStatus(Method m, ITestResult result) {
			if(result.getStatus() == ITestResult.FAILURE) {
				String screenshotPath = null;
				screenshotPath = captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
				extentTest.addScreenCaptureFromPath(screenshotPath);
				extentTest.fail(result.getThrowable());
			} else if(result.getStatus() == ITestResult.SUCCESS) {
				extentTest.pass(m.getName() + " is passed");
			}
			
			//extentTest.assignCategory(m.getAnnotation(Test.class).groups());
		}
	 
	 public String captureScreenshot(String fileName) {
			if(screenshotsSubFolderName == null) {
				LocalDateTime myDateObj = LocalDateTime.now();
			    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			    screenshotsSubFolderName = myDateObj.format(myFormatObj);
			}
			
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./Screenshots/"+ screenshotsSubFolderName+"/"+fileName);
			try {
				FileUtils.copyFile(sourceFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Screenshot saved successfully");
			return destFile.getAbsolutePath();
		}
	 
	 @AfterTest 
		public void teardown() {
		driver.quit();
		extentTest.info("Browser closed");
		logger.info("Browser closed...!");
			
		}
	 
	 
	 
	 
	 
	 
	 
}
