package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseLibrary.Base;
import pages.Login;

public class Login_test extends Base {
	Login ob;
	
	@BeforeTest
	
	@Parameters({"browser","env"} )
	
	public void lunch(String browser, String env)
	{
		extentreports();
	   test= reports.startTest("Login");
		launchbrowser(browser, env);
	  
	  ob = new Login();
	  
		
	}

	@Test(priority = 1)
public void	Sign_up_first() 
	{
		try {
			ob.first_page();
			test.log(LogStatus.PASS, "Login sucessfully");
			
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL,"this problem is occur"+e);
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
