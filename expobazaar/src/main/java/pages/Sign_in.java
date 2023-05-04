package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Base;

public class Sign_in extends Base {
	
	public Sign_in()
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	
@FindBy(xpath = "(//*[text()='Sign In'])[1]")
private WebElement sign_in;

@FindBy(xpath = "//*[@name='email']")
private WebElement user_name;

@FindBy(xpath = "//*[@name='password']")
private WebElement password;

@FindBy(xpath = "//span[@class=\"recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox\"]")
private WebElement checkbox;

@FindBy(xpath = "//*[text()='Login']")
private WebElement submit_button;

@FindBy(xpath = "//iframe[@title=\"reCAPTCHA\"]")
private WebElement iframe;
	
public void login() throws InterruptedException
{
	
Thread.sleep(6000);
 sign_in.click();
 
 implicity_wait(10);
 
 user_name.sendKeys(property("User_name"));
 implicity_wait(10);
 
 password.sendKeys(property("password"));
 implicity_wait(10);
 
 driver.switchTo().frame(iframe);
 checkbox.click();
 Thread.sleep(25000);
 driver.switchTo().defaultContent();
 
 
 
 submit_button.click();

}
}
