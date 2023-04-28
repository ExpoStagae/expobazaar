package pages;

import org.apache.tools.ant.taskdefs.Concat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Base;

public class Unlock_special_prices extends Base {
	
	public Unlock_special_prices() {
		
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath = "(//*[text()='Unlock Special Prices'])[1]")	
private WebElement unlock_special_offer;

@FindBy(xpath = "//*[@name='name']")
private WebElement Name;

@FindBy(xpath = "//*[@name='email']")
private WebElement email;

@FindBy(xpath = "//*[@name='phone_number']")
private WebElement phone_number;

@FindBy(xpath = "//*[@name='company_name']")
private WebElement company_name;

@FindBy(xpath = "//*[text()=' Unlock Special prices ']")
private WebElement submit_button;

@FindBy(xpath = "//*[@id=\"tymsg\"]//p")
private WebElement confrimation_msg;

@FindBy(xpath = "//*[@id=\"tymsg\"]//span[contains(text(),'×')]")
private WebElement cross_button;

public String unlock_offer() throws InterruptedException
{
	
Thread.sleep(6000);

unlock_special_offer.click();
logger.info("Go to the offer unlock tab");
implicity_wait(10);

Name.sendKeys(readdata_excel(1, 1, 0));
logger.info("Enter the Name");
implicity_wait(10);

email.sendKeys(readdata_excel(1, 1, 1));
logger.info("Enter the email");
implicity_wait(10);

phone_number.sendKeys("1234556865");
logger.info("Enter the phone number");
implicity_wait(10);

company_name.sendKeys(readdata_excel(1, 1, 3));
logger.info("Enter the company name");
implicity_wait(10);

submit_button.click();

explicity_wait(driver, 10, confrimation_msg);
implicity_wait(10);
 String msg =confrimation_msg.getText();
 System.out.println(msg);

 
 cross_button.click();
 
return msg;


}
public void dff() throws InterruptedException
{
	System.out.println(unlock_offer());
}

}
