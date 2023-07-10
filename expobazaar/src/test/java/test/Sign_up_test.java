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
public void	Sign_up_first() throws IOException, InterruptedException 
	{
	
			ob.first_page();
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"First page is completed successfully");
		
		
		ob.next();
	}
	
	@Test(priority = 2)
	public void sign_up_second_page() throws IOException, InterruptedException
	{
		
			
			ob.second_page();
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Second page is completed successfully");
		
		
		
		ob.next2();
		
	}
	
	@Test(priority = 3)
	public void third_page_sign_up() throws IOException, InterruptedException
	{
		
			
			ob.third_page();
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Sign up successfully");
		
	
		   ob.Submitt();
		
	}
	
	@Test(priority = 4)
	
	public void Verify_msg() throws IOException, InterruptedException
	{
		 
			
			Assert.assertEquals(ob.Verifymsg(), "Account ApplicationSucessfully Submitted!");
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Please wait for approved");
		
		
		
	}
	
	@Test(priority = 5)
	public void go_back()
	{
		
		ob.click_on_home();
	}
	@Test(priority = 6)
public void	sign_up_with_same_address() throws IOException, InterruptedException 
	{
		
		Sign_up_first();
		
		ob.second_page_with_same_address();
		ob.next2();
		
		third_page_sign_up();
		
		Verify_msg();
	
		
		
	}
	
	
	@Test(priority = 7)
	public void back_again()
	{
		ob.click_on_home();
		
	}
	
	@Test(priority = 8)
public void	sign_up_with_blank_address() throws IOException, InterruptedException 
	{
		
		Sign_up_first();
		
		ob.second_page_with_blank_address();
		ob.next2();
		third_page_sign_up();
	}
	@AfterTest
	public void quit()
	{
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}
