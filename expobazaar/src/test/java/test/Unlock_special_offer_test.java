package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseLibrary.Base;
import pages.Unlock_special_prices;

public class Unlock_special_offer_test extends Base {

	Unlock_special_prices ob;
	String mssg;
	
	@BeforeTest
	@Parameters({"browser","env"} )
	public void lunch(String browser, String env)
	{
		
		log();
		launchbrowser(browser, env);
		extentreports();
		   test= reports.startTest("Unloack_offer");
		ob = new Unlock_special_prices();
		
	}
	
	@Test
	public void Unloac_offer_price() throws InterruptedException, IOException
	{
		try {
			
	 mssg = ob.unlock_offer();
	 test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Unlock the Special offer");
 			System.out.println(mssg);
			
		} catch (Exception e) {
			System.out.println(e);
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Test is passed");
		}
	   
		
		AssertJUnit.assertEquals( mssg, "Your form has been submitted. We'll be in touch really soon.");
		test.log(LogStatus.PASS, "Price unlock successfully");
		
		
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
		reports.endTest(test);
		reports.flush();
		
		
	}
}
