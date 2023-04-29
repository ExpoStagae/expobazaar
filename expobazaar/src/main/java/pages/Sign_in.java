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

@FindBy(xpath = "//*[@id=\"rc-anchor-container\"]//span[@id=\"recaptcha-anchor\"]")
private WebElement checkbox;

@FindBy(xpath = "//*[text()='Login']")
private WebElement submit_button;
	
public void login() throws InterruptedException
{
	
Thread.sleep(6000);
 sign_in.click();
 
 implicity_wait(10);
 
 user_name.sendKeys(readdata_excel(2, 1, 0));
 implicity_wait(10);
 
 password.sendKeys(readdata_excel(2, 1, 1));
 implicity_wait(10);
 
 checkbox.click();
 
 Thread.sleep(10000);
 
 submit_button.click();

}
}
