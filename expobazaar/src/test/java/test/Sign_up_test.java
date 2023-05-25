package test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseLibrary.Base;
import pages.Sign_up;

public class Sign_up_test extends Base {
	Sign_up ob;
	
	@BeforeTest
	
	@Parameters({"browser","env"} )
	
	public void lunch(String browser, String env)
	{
		log();
		extentreports();
	   test= reports.startTest("Login");
		launchbrowser(browser, env);
	  
	  ob = new Sign_up();
	  
		
	}

	@Test(priority = 1)
public void	Sign_up_first() throws IOException 
	{
		try {
			ob.first_page();
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"First page is completed successfully");
			ob.next();
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+"Please fill all the required field");
		}
	
	}
	
	@Test(priority = 2)
	public void sign_up_second_page() throws IOException
	{
		try {
			
			ob.second_page();
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Second page is completed successfully");
			ob.next2();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+"Please fill all the required field"+e);
		}
		
		
		
	}
	
	@Test(priority = 3)
	public void third_page_sign_up() throws IOException
	{
		try {
			
			ob.third_page();
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Sign up successfully");
		   ob.Submitt();
		} catch (Exception e) {
			
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+"Please fill all the information carefully");
		}
		
		
	}
	
	@Test(priority = 4)
	
	public void Verify_msg() throws IOException
	{
		try {
			
			Assert.assertEquals(ob.Verifymsg(), "Account ApplicationSucessfully Submitted!");
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Please wait for approved");
		} catch (Exception e) {
			
			test.log(LogStatus.FAIL, test.addScreenCapture(capture(driver))+"Please fill all the information carefully");
		}
		
		
	}
	
	@AfterTest
	public void quit()
	{
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}
