package Admin_Business;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class A_Utility_Class 
{

	//TE:@Dipali Pawar
	//Day : Thursday
	//Date : 22-12-22
	// Featch Data from property file
	
	int NoofRows;
	int   NoofCell;
	XSSFSheet Sheet;
	
	public static String getdatafromPF(String key) throws IOException 
	{
		// to reach Property file 
		FileInputStream File=new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\Booking_zone1\\Admin.properties");		

		// to open property file 
		Properties Prop=new Properties();
		Prop.load(File);

		// To get data of property file  //PSW
		String  Value1=Prop.getProperty(key);   //admin123

		return Value1;


	}

	// TE:@Dipali
	//Day:Friday
	//Date:23-12-22
	// To featch data from ExcelSheet
	//0            //0                 //0
	public static String getdatafromEs( int RowIndex, int CellIndex,  String Sheetname) throws EncryptedDocumentException, IOException 
	{
		String CellData="";
		FileInputStream File=new FileInputStream("./Test_DataAdmin_Business/Admin_Bussiness_Create_Data.xlsx");

		XSSFWorkbook workbook=new XSSFWorkbook(File);
		XSSFSheet Sheet=workbook.getSheet(Sheetname);

		XSSFCell Cell=Sheet.getRow(RowIndex).getCell(CellIndex);

		int NoofRows=Sheet.getLastRowNum();//get physical no of rows
		int   NoofCell=Sheet.getRow(0).getLastCellNum();


		if(Cell.getCellType()==CellType.STRING) 
		{
			CellData=Cell.getStringCellValue();
		}

		else if(Cell.getCellType()==CellType.NUMERIC) 
		{
			double Dp=Cell.getNumericCellValue();
			DecimalFormat df=new DecimalFormat("0");
			String  FormatNumber=df.format(Dp);
			CellData= FormatNumber;
		}

		else if(Cell.getCellType()==CellType.BLANK) 
		{
			CellData= "";
		}
		return CellData;

	}

	public static void uploadimg() throws AWTException 
	{

		// create instance of robot class
		Robot rb=new Robot();
		rb.delay(2000);

		// copy to clipboard 
		StringSelection ss=new StringSelection("\"C:\\Users\\dell\\Downloads\\Bowling_Image.jpg\"");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// press control
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// Release press control
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// press Enter   
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);




	}
	
	/*public String [][] grtdata()
	{
		
		String [][] data=new String [NoofRows][NoofCell];
		
		for(int i=1; i<NoofRows; i++) 
		{
			
			for (int j=0; j<NoofCell; j++) 
			{
				DataFormatter df=new DataFormatter();
				data[i][j]= df.formatCellValue(Sheet.getRow(i+1).getCell(j));
			}
			
			
		}
		
		
		return data;
	}*/

	// TE:@Dipali
	//Day:Wendsday
	//Date:01-02-23

	/*  public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				// after execution, you could see a folder "FailedTestsScreenshots"
				// under src folder
				String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
						+ ".png";
				File finalDestination = new File(destination);
				FileUtils.copyFile(source, finalDestination);
				return destination;
			}*/









}
