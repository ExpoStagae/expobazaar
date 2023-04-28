package test;

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
public void Social_links()
{
try {
 Assert.assertEquals(ob.facebook(), "ExpoBazaar");
 Assert.assertEquals(ob.twitter(), "ExpoBazaar");
// Assert.assertEquals(ob.Instagram(), "expobazaarindia");
 Assert.assertEquals(ob.Linkedin(), "ExpoBazaar");
 Assert.assertEquals(ob.Pinterest(), "ExpoBazaar");
 Assert.assertEquals(ob.youtube(), "ExpoBazaar");
 test.log(LogStatus.PASS, "Soical links work successfully");
}
catch (Exception e) {
	  
	test.log(LogStatus.FAIL, "Social link did not work successfully"+e);
}
}

@AfterTest
public void close()
{
driver.quit();
reports.endTest(test);
reports.flush();

}
}
