package test;

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
		extentreports();
	   test= reports.startTest("Login");
		launchbrowser(browser, env);
	  
	  ob = new Sign_up();
	  
		
	}

	@Test(priority = 1)
public void	Sign_up_first() 
	{
		try {
			ob.first_page();
			test.log(LogStatus.PASS, "First page sign up sucessfully");
			
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL,"There have some problem in sign up"+e);
		}
	
	}
	
	@Test(priority = 2)
	public void sign_up_second_page()
	{
		try {
			
			ob.second_page();
			test.log(LogStatus.PASS, "Second page sign up successfully ");
			
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "There have some problem in sign up"+e);
		}
		
		
		
	}
	
	@Test(priority = 3)
	public void third_page_sign_up()
	{
		try {
			
			ob.third_page();
			test.log(LogStatus.PASS, "Sign up successfully , wait for the approval");
		} catch (Exception e) {
			
			test.log(LogStatus.FAIL, "there have some problem in sign_up"+e);
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
