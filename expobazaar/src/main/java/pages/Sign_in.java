package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import baseLibrary.Base;

public class Sign_in extends Base {
	@Parameters("env")
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

@FindBy(xpath = "//*[@id='toast-container']")
private WebElement success_msg;

public void login() throws InterruptedException
{
	driver.navigate().refresh();

	
//Thread.sleep(6000);
// sign_in.click();
 
 implicity_wait(10);
 
 user_name.clear();
 user_name.sendKeys(property("User_name_com"));
 implicity_wait(10);
 
 password.clear();
 password.sendKeys(property("password_com"));
 implicity_wait(10);
 
 driver.switchTo().frame(iframe);
 checkbox.click();
 Thread.sleep(5000);
 driver.switchTo().defaultContent();
 
 
 
 submit_button.click();

}

public String verify()
{
	explicity_wait(driver, 10, success_msg);
	String success_msg_text = success_msg.getText().replace("\n", " ");
	System.out.println(success_msg_text);
return success_msg_text;
}

public void invalid_password() throws InterruptedException
{
	driver.navigate().refresh();
	
	implicity_wait(10);
	 
	user_name.clear();
	 user_name.sendKeys(property("User_name_com"));
	 implicity_wait(10);
	 
	 password.clear();
	 password.sendKeys("Invalidpassword");
	 implicity_wait(10);
	 
	 driver.switchTo().frame(iframe);
	 checkbox.click();
	 Thread.sleep(5000);
	 driver.switchTo().defaultContent();
	 
	 
	 
	 submit_button.click();


}

public void invalid_user() throws InterruptedException
{
	
	driver.navigate().refresh();

	implicity_wait(10);
	 
	user_name.clear();
	 user_name.sendKeys("Invalid@gamil.com");
	 implicity_wait(10);
	 
	 password.clear();
	 password.sendKeys(property("password_com"));
	 implicity_wait(10);
	 
	 driver.switchTo().frame(iframe);
	 checkbox.click();
	 Thread.sleep(5000);
	 driver.switchTo().defaultContent();
	 
	 
	 
	 submit_button.click();


}
public void sign() throws InterruptedException
{
	Thread.sleep(6000);
	 sign_in.click();	
}
}
