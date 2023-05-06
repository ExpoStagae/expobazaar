package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import baseLibrary.Base;
import pages.Kitchen_decor;
import pages.Ready_to_ship;
import pages.Sign_in;

public class Kitchen_decor_test extends Base{
	
	Kitchen_decor ob;
	Sign_in ob2;
	Ready_to_ship ob3;
	
	@Parameters({"browser", "env"})
	@BeforeTest
	public void lunch( String Browser , String env) throws InterruptedException
	{
		
		extentreports();
		test = reports.startTest("Kitchen");
		
		launchbrowser(Browser, env);
		
		
		ob = new Kitchen_decor();
		ob2 = new Sign_in();
		ob3 = new Ready_to_ship();
		
		
		ob2.login();
		
	  
	}

	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void select_item() throws InterruptedException
	{
		ob.kitchen_decor();
		
	}
	
//	//@Test(priority = 3)
//	
//	public void buk()
//	{
//		ob.bulk_enquiry();
//		
//	}
	
	
	@Test(priority = 4)
	public void ready_to_ship() throws InterruptedException 
	{
		ob3.check_minimum_quantity();
		
	}
	@AfterTest
	public void quit() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}

