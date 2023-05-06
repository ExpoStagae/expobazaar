package test;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import baseLibrary.Base;
import pages.Add_to_cart;
import pages.Ready_to_ship;
import pages.Sign_in;

public class Add_to_cart_test extends Base{
	
	Add_to_cart ob;
	Sign_in ob2;
	Ready_to_ship ob3;
	
	@Parameters({"browser", "env"})
	@BeforeTest
	public void lunch( String Browser , String env) throws InterruptedException, IOException
	{
		
		extentreports();
		test = reports.startTest("Kitchen");
		
		launchbrowser(Browser, env);
		
		
		ob = new Add_to_cart();
		ob2 = new Sign_in();
		ob3 = new Ready_to_ship();
		
		ob2.sign();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Click on Sign in button");

		ob2.login();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Try to sign in with valide credential");
        
		ob2.verify();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Login successfully");

	  
	}

	@Test(priority = 1)
	public void kitchen() throws InterruptedException
	{
		try {
			ob.Kitchen();
		 
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Click on Kitchen and decor tab");
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL, "Test is not passed");
		}
		
		
		
	}
	
	
	@Test(priority = 2)
	public void choose() throws InterruptedException
	{
		try {
	       
			ob.choose_item();
		 
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Select the item in given list");
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.FAIL, "Test is not passed");
		}
		
		
		
	}
	
	@Test(priority = 3)
	public void select_item() throws InterruptedException, IOException
	{
		ob.miminum_value_check();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Check for Minimum order value");
		
		ob.maximum_value();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Test is passed");

	}
	
	@Test(priority = 4)
	public void gotocart() throws InterruptedException, IOException
	{
		ob.gotocart();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Go to card after for place order");
		
	}

	
	
	@Test(priority = 5)
	public void ready_to_ship() throws InterruptedException, IOException 
	{
		ob3.ready_to_ship();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Click on ready to ship");
		
		ob3.check_minimum_value();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Check minimum value for place the order");

		ob3.proceed_check();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Click on proceed");
       
		ob3.proceed_check2();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Click on proceed");

		ob3.place_order();
		test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Check term and condition check box & place order");

	}
	@AfterTest
	public void quit() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}

