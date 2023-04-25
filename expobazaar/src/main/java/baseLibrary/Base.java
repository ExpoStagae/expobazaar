package baseLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.*;

import applicationUtility.Action;
import excelUtility.Excel;
import extentreport.Extentreports;
import log.Log;
import net.bytebuddy.agent.builder.AgentBuilder.Identified.Extendable;
import net.bytebuddy.description.annotation.AnnotationDescription.Loadable;
import propertyUtility.Property;
import screenshot.Screenshot;
import wait.implicity;

public class Base implements implicity,Property, Action , Excel, Screenshot , Extentreports  {

	
 public static WebDriver driver;
 
 public static Logger logger ;
 
 public static ExtentReports reports;
 
 public static ExtentTest test;
 
 public void log()
 {
	 logger = Logger.getLogger(getClass());
	 PropertyConfigurator.configure("Log4j.properties");
	 
	 
 }
 


 
 
 public void launchbrowser(String broswer, String env)
 {
	
	 log();
	 try {
		 if(broswer.equalsIgnoreCase("chrome")) {
			 String path ="C:\\Users\\rohit.kashyap\\eclipse-workspace\\expobazaar\\webdriver\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver", path);
		 logger.info("launch the browser");
		 driver= new ChromeDriver();
		 driver.get(property(env));
		 logger.info("Go to the website");
		 driver.manage().window().maximize();
		 logger.info("maximize the window");
		 }
		 
		 if(broswer.equalsIgnoreCase("firefox")) {
			 String path="C:\\Users\\rohit.kashyap\\eclipse-workspace\\expobazaar\\webdriver\\geckodriver.exe";
			 System.setProperty("webdriver.gecko.driver", path);
			 driver= new FirefoxDriver();
			 driver.get(property(env));
			 driver.manage().window().maximize();}
		
	} 
	 catch (Exception e) {
		 
		 System.out.println(e);
		
	}
	 
 }
public void implicity_wait(int time) {
	 driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	
}
public void thread_sleep(int time) {
	thread_sleep(time);
	
}
public String property(String Key) {
	String value = "";
	String path="C:\\Users\\rohit.kashyap\\eclipse-workspace\\expobazaar\\Test_data\\data";
	
	try {
		
		FileInputStream fis = new FileInputStream(path);
		  Properties prop = new Properties();
		  prop.load(fis);
	      value = prop.getProperty(Key);
		  
		
	} catch (Exception e) {
		
		System.out.println(e);
	}
	return value;
}
public void actio(WebElement element, WebDriver driver) {
	
	Actions act = new Actions(driver);
	
	act.dragAndDropBy(element, 0, 0).perform();
	

}
public void explicity_wait(WebDriver driver, int time, WebElement elment) {
	WebDriverWait wait = new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.elementToBeClickable(elment));
	
}
public String readdata_excel( int sheet_no, int Row_no, int col_no) {
	String path="C:\\Users\\rohit.kashyap\\eclipse-workspace\\expobazaar\\Test_data\\Test_data.xlsx";
	String value = "";
	try {
		
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(sheet_no);
		
		value = sheet.getRow(Row_no).getCell(col_no).getStringCellValue();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	return value;
}
public void getscreenshots(String foldername, String filename) {
	String loc = System.getProperty("user.dir");
	
	String path = "";
	
	try {
		 
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File src = efw.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path));  
		
		
		
	} catch (Exception e) {
	System.out.println(e);
	}
	
}
public void extentreports() 
{
	
	reports = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");

}



	
	
}