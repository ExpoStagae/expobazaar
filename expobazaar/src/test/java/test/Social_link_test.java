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
import pages.Social_sites;

public class Social_link_test extends Base{
	
	Social_sites ob;
	
	@BeforeTest
	@Parameters({"browser","env"})
	public void launc(String browser, String env)
	{
	extentreports();
	 test =reports.startTest("Social_link_test");
		launchbrowser(browser, env);
		ob = new Social_sites();
		
	}
@Test
public void Social_links() throws InterruptedException, IOException
{

 Assert.assertEquals(ob.facebook(), "ExpoBazaar");
 test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Facebook page is working");
ob.close();

 Assert.assertEquals(ob.twitter(), "ExpoBazaar");
 test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Twitter page is working ");
 ob.close();
 
 Assert.assertEquals(ob.Instagram(), "expobazaarindia");
 test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Instagram page is working");
 ob.close();
 
// Assert.assertEquals(ob.Linkedin(), "ExpoBazaar");
// test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Linkedin page is working");
// ob.close();
 
 Assert.assertEquals(ob.Pinterest(), "ExpoBazaar");
 test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Pinterest page is working");
 ob.close();
 
 Assert.assertEquals(ob.youtube(), "ExpoBazaar");
 test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+"Youtube page is working");
 ob.close();
 
}



@AfterTest
public void close()
{
driver.quit();
reports.endTest(test);
reports.flush();

}
}
