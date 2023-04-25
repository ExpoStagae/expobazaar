package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import baseLibrary.Base;
import pages.Kitchen_decor;

public class Kitchen_decor_test extends Base{
	
	Kitchen_decor ob;
	
	
	@Parameters({"browser", "env"})
	@BeforeTest
	public void lunch( String Browser , String env)
	{
		extentreports();
		test = reports.startTest("Kitchen");
		
		launchbrowser(Browser, env);
		
		ob = new Kitchen_decor();
	  
	}

	@Test
	public void kitchen() throws InterruptedException
	{
		try {
			ob.Kitchen();
		 
			test.log(LogStatus.PASS, "Test is passed");
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL, "Test is not passed");
		}
		
		
		
	}
	
	@AfterTest
	public void quit() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}

