package baseLibrary;

import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.Driver;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import  org.apache.log4j.*;

import javax.lang.model.element.Element;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import applicationUtility.Action;
import excelUtility.Excel;

import log.Log;


import propertyUtility.Property;
import screenshot.Screenshot;
import wait.implicity;

public class Base implements implicity,Property, Action , Excel, Screenshot , ITestListener ,Log  {

	
 public static WebDriver driver;
 
 public static Logger logger ;
 
 public static ExtentReports reports;
 
 public static ExtentTest test;
 
 public static ThreadLocal<ExtentTest> testReport ;
 
 
 
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
	String path="C:\\Users\\rohit.kashyap\\git\\repository\\expobazaar\\Test_data\\data";
	
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
	
	act.dragAndDropBy(element, 20, 0).perform();
	

}
public void explicity_wait(WebDriver driver, int time, WebElement elment) {
	WebDriverWait wait = new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.visibilityOf(elment));
	
}
public String readdata_excel( int sheet_no, int Row_no, int col_no) {
	String path="C:\\Users\\rohit.kashyap\\git\\repository\\expobazaar\\Test_data\\Test_data.xlsx";
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
	
	String path = "C:\\Users\\rohit.kashyap\\git\\repository\\expobazaar\\Screenshot";
	
	try {
		 
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File src = efw.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path));  
		
		
		
	} catch (Exception e) {
	System.out.println(e);
	}
	
}



public void pdf()
{
	File folder = new File(UUID.randomUUID().toString());
	folder.mkdir();
  ChromeOptions options = new ChromeOptions();
  
  Map<String, Object> prefs = new HashMap<String, Object>();
  
  prefs.put("profile.default_content_settings.popups", 0);
  prefs.put("download.default_directory", folder.getAbsolutePath());
 
}
	public String windowhandling(int k)
	{
		ArrayList<String> Child_windows_list = new ArrayList<String>();
		String Main_window = driver.getWindowHandle();
		
		Set<String> Child_window = driver.getWindowHandles();
		Iterator<String> itr = Child_window.iterator();
		int i=0;
		while (itr.hasNext()) {
			
			if(!Main_window.equals(Child_window)) {
			Child_windows_list.add(itr.next());
			Child_windows_list.get(i);
			
			
			}
		}

		String value = Child_windows_list.get(i);
		
	    driver.switchTo().window(Child_windows_list.get(k));
	   return value;
	      
	}
	
	public String random_string(int n)
	{
		String random = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
		
		String gen_random_string= "";
		try {
			
			StringBuilder sb = new StringBuilder(n);
			
			for (int i = 0; i < n; i++) {
				 
				   
				   int index
				    = (int)(random.length()
				      * Math.random());
				 
				   // add Character one by one in end of sb
				   sb.append(random
				      .charAt(index));
				  }
				 gen_random_string = sb.toString();
			
		} catch (Exception e) {
			System.out.println("Unable to generate string due to"+e);
		}
		gen_random_string = gen_random_string+"@"+"mailinator.com";
		return gen_random_string;
	}
	
	public void select(WebElement select, String text)
	{
		Select sel = new Select(select);
		sel.selectByValue(text);
		
		
	}
	public int minimum_value(String minimum)
	{
minimum = minimum.replaceAll("[^0-9]", "").trim();
		
		int moq_int = Integer.parseInt(minimum);
		return moq_int;
	}
	
	public float minimum_value_float(String minimum)
	{
minimum = minimum.replaceAll("[^0-9]", "").trim();
		
		float moq_float = Float.parseFloat(minimum);
		return moq_float;
	}





	public void action_drag(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		act.clickAndHold();
		
	}
	
	public void action_hold(WebElement element, WebDriver driver) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		act.clickAndHold();
		
	}
	public void js_scroll()
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,550)", "");
		
		
		
	}

	public static String capture(WebDriver driver) throws IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String formattedString = java.time.LocalDate.now().format(formatter);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//	File Dest = new File(System.getProperty("user.dir")+"/Reports/ErrImages/" + System.currentTimeMillis()
		//+ ".png");
		String Imgpath = System.getProperty("user.dir")+"/Reports/"+formattedString+"/Report/"+ System.currentTimeMillis()+ ".png";
		
		File path = new File(Imgpath);
     
		FileUtils.copyFile(scrFile, path);
		String path2=path.getName();
		return path2;
		}


public void js_over(WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
							
     js.executeScript(mouseOverScript, element);
}

public void js(String url)
{
	String Url= "window.open("+"'"+url+"'"+",'_blank');";
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript(Url);

}

public void extentreports() 
{
    
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
	String formattedString = java.time.LocalDate.now().format(formatter);
	String filename = "Expobazaar_Automation"+".html";
	
	reports = new ExtentReports(System.getProperty("user.dir")+"/Reports/"+formattedString+"/Report/"+formattedString+" "+filename , false);
         
}
public void onTestStart(ITestResult result) {

	

}

public void js_click(WebElement ele)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", ele);

}
}
