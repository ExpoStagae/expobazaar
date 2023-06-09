package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Base;


public class Sign_up extends Base{

   public Sign_up() 
   
	{
	   log();
		PageFactory.initElements(driver , this);
		
	}
   
   
	
@FindBy(xpath = "(//*[text()='Sign Up'])[1]")	
private WebElement sign_up;

@FindBy(xpath = "//*[@id='Referral-code']")
private WebElement referral_code;

// Web elements for first sign up page

@FindBy(xpath = "//*[@id='Firstname']")
private WebElement First_name;

@FindBy(xpath = "//*[@id='Middlename']")
private WebElement Middle_name;

@FindBy(xpath = "//*[@id='lastName']")
private WebElement Last_name;

@FindBy(xpath = "//*[@id='phone_number']")
private WebElement Phone_no;

@FindBy(xpath = "//*[@id='emailID']")
private WebElement Email_id;

@FindBy(xpath = "//button[text()='Next ']")
private WebElement next_button;

//web elements for sign up second page

@FindBy(xpath = "//*[@id='registeredBusiness']")
private WebElement registered_business_id;

@FindBy(xpath = "//*[@id='bus_entity_typ']")
private WebElement business_type;

@FindBy(xpath = "//*[@name='business_Tax_Id']")
private WebElement Business_tax_id;

@FindBy(xpath = "//*[@id='organizationType']")
private WebElement organization_type;

@FindBy(xpath = "//*[@id='streetNumber']")
private WebElement Delivery_address;

@FindBy(xpath = "//*[@name='dcountry']")
private WebElement country;

@FindBy(xpath = "//*[@id='state']")
private WebElement state;

@FindBy(xpath = "//*[@id='city']")
private WebElement city;

@FindBy(xpath = "//*[@id='zipCode']")
private WebElement zip_code;

@FindBy(xpath = "//*[@name='sameAsDeliveryAddress']")
private WebElement checkbox_for_billing;

@FindBy(xpath = "//*[@id='streetNumber1']")
private WebElement billing_address;

@FindBy(xpath = "//*[@name='country1']")
private WebElement billing_country;

@FindBy(xpath = "//*[@name='state1']")
private WebElement billing_state;

@FindBy(xpath = "//*[@name='city1']")
private WebElement billing_city;

@FindBy(xpath = "//*[@name='zipCode1']")
private WebElement billing_zipcode;

ArrayList<String> Child_windows_list = new ArrayList<String>();

@FindBy(xpath = "//*[@class='btn-blnk']")
private WebElement next2;

@FindBy(xpath = "//*[@name='sameAsBillingAddress']")
private WebElement same_as_billing;

@FindBy(xpath = "//div[@class='pac-item']")
private List<WebElement> Auto_option;


@FindBy(xpath = "//div[@class='pac-item']")
private List<WebElement> Auto_option1;
//web elements for sign up third page

@FindBy(xpath = "//input[@id='W9-form']")
private WebElement w9_form;

@FindBy(xpath = "//input[@name='agree_to_terms_conditions']")
private WebElement term_agree_conditions;

@FindBy(xpath = "//button[text()='Submit ']")
private WebElement submit_button;

@FindBy(xpath = "//a[@href='https://www.irs.gov/pub/irs-pdf/fw9.pdf']")
private WebElement download_w9;

@FindBy(xpath = "//a[@href='assets/fw8bene.pdf']")
private WebElement non_us_enetity;

@FindBy(xpath = "//h3[text()='Account Application ']")
private WebElement successfully_created;

@FindBy(xpath = "//a[text()='Home']")
private WebElement home;

public String first_page() throws InterruptedException
{
	driver.navigate().refresh();
	Thread.sleep(6000);
	explicity_wait_clickable(driver, 20, sign_up);
	
	sign_up.click();
	logger.info("Go to sign up page");
	implicity_wait(5);
	
	logger.info("Enter the first name"+readdata_excel(0, 1, 0));
	
	
	First_name.sendKeys(readdata_excel(0, 1, 0));
	
	implicity_wait(5);
	
	Middle_name.sendKeys(readdata_excel(0, 1, 1));
	logger.info("Enter the Middle name"+readdata_excel(0, 1, 1));
	implicity_wait(5);
	
	Last_name.sendKeys(readdata_excel(0, 1, 2));
	logger.info("Enter the Last name"+readdata_excel(0, 1, 2));
	implicity_wait(5);
  
	Phone_no.sendKeys("535353355");
	logger.info("Enter the Phone name"+"535353355");
	implicity_wait(5);
	
	String email = random_string(3);
	
	System.out.println(email);
	Email_id.sendKeys(email);
	logger.info("Enter the email"+email);
	implicity_wait(5);
	
	return email;
	//next_button.click();
}

public void second_page() throws InterruptedException
{
	implicity_wait(10);
	
	registered_business_id.sendKeys(readdata_excel(0, 1, 5));
	logger.info("Enter the business"+readdata_excel(0, 1, 5));
	implicity_wait(5);
	
	explicity_wait(driver, 10, business_type);
	explicity_wait_clickable(driver, 10, business_type);
	

      select_by_text(business_type, "Partnership");	
//	business_type.sendKeys(readdata_excel(0, 1, 6));
//    logger.info("Enter the business type"+readdata_excel(0, 1, 6));
//    implicity_wait(5);
    
    Business_tax_id.sendKeys("123456789");
    logger.info("Enter the tax id"+"123456789");
    implicity_wait(5);
    
//    organization_type.sendKeys(readdata_excel(0, 1, 8));
//    logger.info("Enter the organization type"+readdata_excel(0, 1, 8));
//    implicity_wait(5);
    
    Delivery_address.sendKeys("120");
    explicity_wait_presence_of_element(driver, 10, Auto_option);
    WebElement delivery_address = Auto_option.get(0);
   action_drag(delivery_address, driver);
   // logger.info("Enter the delivery address"+readdata_excel(0, 1, 9));
    implicity_wait(5);
    
//    country.sendKeys(readdata_excel(0, 1, 10));
//    logger.info("Enter the country "+readdata_excel(0, 1, 10));
//    implicity_wait(5);
//    
//    state.sendKeys(readdata_excel(0, 1, 11));
//    logger.info("Enter the state "+readdata_excel(0, 1, 11));
//    implicity_wait(5);
//    
//    city.sendKeys(readdata_excel(0, 1, 12));
//    logger.info("Enter the city"+readdata_excel(0, 1, 12));
//    implicity_wait(5);
//    
//    zip_code.sendKeys("13013");
//    logger.info("Enter the zipcode"+"13013");
//    implicity_wait(5);
    
    billing_address.sendKeys("123");
    explicity_wait_presence_of_element(driver, 10, Auto_option1);
    WebElement Billingaddress = Auto_option1.get(0);
   action_drag(Billingaddress, driver);
   // logger.info("Enter the delivery address"+readdata_excel(0, 1, 9));
    implicity_wait(5);
    
    
//    billing_address.sendKeys(readdata_excel(0, 1, 14));
//    logger.info("Enter the billing address"+readdata_excel(0, 1, 14));
//    implicity_wait(5);
//    
//    billing_country.sendKeys(readdata_excel(0, 1, 15));
//    logger.info("Enter the billing country"+readdata_excel(0, 1, 15));
//    implicity_wait(5);
//    
//    billing_city.sendKeys(readdata_excel(0, 1, 12));
//    logger.info("Enter the billing city"+readdata_excel(0, 1, 12));
//    implicity_wait(5);
//    
//    billing_state.sendKeys(readdata_excel(0, 1, 16));
//    logger.info("Enter the billing state"+readdata_excel(0, 1, 16));
//    implicity_wait(5);
//    
//    billing_zipcode.sendKeys("12323");
//    logger.info("Enter the billing zipcode"+"12323");
//    implicity_wait(5);
//    
    Thread.sleep(6000);
    //next2.click();
    logger.info("Click on next button");
    
    
}

public void third_page() throws InterruptedException
{

	
	implicity_wait(10);
	
	 String Main_window = driver.getWindowHandle();
		
		System.out.println(Main_window);
	
	download_w9.click();
	logger.info("Download the w9 form");
	Thread.sleep(3000);
	
  String parent = windowhandling(0);
  windowhandling(1);
  driver.close();
  
  driver.switchTo().window(parent);
  
  non_us_enetity.click();
  Thread.sleep(3000);
  
   parent = windowhandling(0);
  windowhandling(1);
  driver.close();
  
  driver.switchTo().window(parent);
    
    w9_form.sendKeys("C:\\Users\\rohit.kashyap\\fw9.pdf");
    
     Thread.sleep(5000);
	term_agree_conditions.click();
	logger.info("Click on the term and condition box");
	implicity_wait(10);
	
	

	

}

public void next()
{
next_button.click();	
}

public void next2()
{
	explicity_wait_clickable(driver, 10, next2);
//  JavascriptExecutor js = (JavascriptExecutor)driver;
//  js.executeScript("arguments[0].click();", next2);
	js_scroll();
	Actions act = new Actions(driver);
	act.click(next2).build().perform();
}
public void Submitt() throws InterruptedException
{
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();", submit_button);
	logger.info("Click on submit button");
	Thread.sleep(10000);
		
}


public String Verifymsg() throws InterruptedException
{
	String successfully = successfully_created.getText();
	successfully = successfully.replaceAll("\n", "");

	System.out.println(successfully);
	
	Thread.sleep(5000);
	return successfully;
}

public void referral_code()
{
	
   referral_code.sendKeys(property("Referral_code"));

}

public void click_on_home()
{
	
	home.click();

}

public void second_page_with_same_address() throws InterruptedException
{
	implicity_wait(10);
	
	registered_business_id.sendKeys(readdata_excel(0, 1, 5));
	logger.info("Enter the business"+readdata_excel(0, 1, 5));
	implicity_wait(5);
	
	explicity_wait_clickable(driver, 10, business_type);

	business_type.sendKeys(readdata_excel(0, 1, 6));
    logger.info("Enter the business type"+readdata_excel(0, 1, 6));
    implicity_wait(5);
    
    Business_tax_id.sendKeys("123456789");
    logger.info("Enter the tax id"+"123456789");
    implicity_wait(5);
    
//    organization_type.sendKeys(readdata_excel(0, 1, 8));
//    logger.info("Enter the organization type"+readdata_excel(0, 1, 8));
//    implicity_wait(5);
    
//    Delivery_address.sendKeys(readdata_excel(0, 1, 9));
//    logger.info("Enter the delivery address"+readdata_excel(0, 1, 9));
//    implicity_wait(5);
//    
//    country.sendKeys(readdata_excel(0, 1, 10));
//    logger.info("Enter the country "+readdata_excel(0, 1, 10));
//    implicity_wait(5);
//    
//    state.sendKeys(readdata_excel(0, 1, 11));
//    logger.info("Enter the state "+readdata_excel(0, 1, 11));
//    implicity_wait(5);
//    
//    city.sendKeys(readdata_excel(0, 1, 12));
//    logger.info("Enter the city"+readdata_excel(0, 1, 12));
//    implicity_wait(5);
//    
//    zip_code.sendKeys("13013");
//    logger.info("Enter the zipcode"+"13013");
//    implicity_wait(5);
    
//    billing_address.sendKeys(readdata_excel(0, 1, 14));
//    logger.info("Enter the billing address"+readdata_excel(0, 1, 14));
//    implicity_wait(5);
//    
//    billing_country.sendKeys(readdata_excel(0, 1, 15));
//    logger.info("Enter the billing country"+readdata_excel(0, 1, 15));
//    implicity_wait(5);
//    
//    billing_city.sendKeys(readdata_excel(0, 1, 12));
//    logger.info("Enter the billing city"+readdata_excel(0, 1, 12));
//    implicity_wait(5);
//    
//    billing_state.sendKeys(readdata_excel(0, 1, 16));
//    logger.info("Enter the billing state"+readdata_excel(0, 1, 16));
//    implicity_wait(5);
//    
//    billing_zipcode.sendKeys("12323");
//    logger.info("Enter the billing zipcode"+"12323");
//    implicity_wait(5);
    
    billing_address.sendKeys("123 can");
    explicity_wait_presence_of_element(driver, 10, Auto_option1);
    WebElement Billingaddress = Auto_option1.get(0);
   action_drag(Billingaddress, driver);
   
   Thread.sleep(5000);
   // logger.info("Enter the delivery address"+readdata_excel(0, 1, 9));
  explicity_wait_clickable(driver, 10, same_as_billing);
    
    same_as_billing.click();
    Thread.sleep(6000);
    //next2.click();
    logger.info("Click on next button");
    
    
}
public void second_page_with_blank_address() throws InterruptedException
{
	implicity_wait(10);
	
	registered_business_id.sendKeys(readdata_excel(0, 1, 5));
	logger.info("Enter the business"+readdata_excel(0, 1, 5));
	implicity_wait(5);
	
	explicity_wait_clickable(driver, 10, business_type);

	business_type.sendKeys(readdata_excel(0, 1, 6));
    logger.info("Enter the business type"+readdata_excel(0, 1, 6));
    implicity_wait(5);
    
    Business_tax_id.sendKeys("123456789");
    logger.info("Enter the tax id"+"123456789");
    implicity_wait(5);
    
//    organization_type.sendKeys(readdata_excel(0, 1, 8));
//    logger.info("Enter the organization type"+readdata_excel(0, 1, 8));
//    implicity_wait(5);
    
//    Delivery_address.sendKeys(readdata_excel(0, 1, 9));
//    logger.info("Enter the delivery address"+readdata_excel(0, 1, 9));
//    implicity_wait(5);
//    
//    country.sendKeys(readdata_excel(0, 1, 10));
//    logger.info("Enter the country "+readdata_excel(0, 1, 10));
//    implicity_wait(5);
//    
//    state.sendKeys(readdata_excel(0, 1, 11));
//    logger.info("Enter the state "+readdata_excel(0, 1, 11));
//    implicity_wait(5);
//    
//    city.sendKeys(readdata_excel(0, 1, 12));
//    logger.info("Enter the city"+readdata_excel(0, 1, 12));
//    implicity_wait(5);
//    
//    zip_code.sendKeys("13013");
//    logger.info("Enter the zipcode"+"13013");
//    implicity_wait(5);
//    
//    billing_address.sendKeys(readdata_excel(0, 1, 14));
//    logger.info("Enter the billing address"+readdata_excel(0, 1, 14));
//    implicity_wait(5);
//    
//    billing_country.sendKeys(readdata_excel(0, 1, 15));
//    logger.info("Enter the billing country"+readdata_excel(0, 1, 15));
//    implicity_wait(5);
//    
//    billing_city.sendKeys(readdata_excel(0, 1, 12));
//    logger.info("Enter the billing city"+readdata_excel(0, 1, 12));
//    implicity_wait(5);
//    
//    billing_state.sendKeys(readdata_excel(0, 1, 16));
//    logger.info("Enter the billing state"+readdata_excel(0, 1, 16));
//    implicity_wait(5);
//    
//    billing_zipcode.sendKeys("12323");
//    logger.info("Enter the billing zipcode"+"12323");
//    implicity_wait(5);
    
    billing_address.sendKeys("123 canada");
    explicity_wait_presence_of_element(driver, 10, Auto_option1);
    WebElement Billingaddress = Auto_option1.get(0);
   action_drag(Billingaddress, driver);
   // logger.info("Enter the delivery address"+readdata_excel(0, 1, 9));
    implicity_wait(5);
    
    //same_as_billing.click();
    Thread.sleep(6000);
    //next2.click();
    logger.info("Click on next button");
    
    
}

public void sign_up_again()
{
	explicity_wait_clickable(driver, 10, sign_up);
	sign_up.click();

}

}
