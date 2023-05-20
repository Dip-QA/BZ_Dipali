package All_TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Admin_Business.A_Utility_Class;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demo1

{
	public static  WebDriver driver;
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		WebDriverManager.chromedriver().setup(); //.exe file is there or not
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		   driver=new ChromeDriver(options);
		
			Thread.sleep(2000);
			
			driver.get("https://admin.test.bookingzone.com/");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@name='email']"))
			.sendKeys(A_Utility_Class.getdatafromEs(1, 0, "CreateBookings_CardPay"));
			
	}

}
