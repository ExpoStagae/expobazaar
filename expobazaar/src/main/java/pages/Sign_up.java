package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

@FindBy(xpath = "//button[text()='Next ']")
private WebElement next2;

//web elements for sign up third page

@FindBy(xpath = "//input[@id='W9-form']")
private WebElement w9_form;

@FindBy(xpath = "//*[@name='agree_to_terms_conditions']")
private WebElement term_agree_conditions;

@FindBy(xpath = "//button[text()='Submit ']")
private WebElement submit_button;

@FindBy(xpath = "//a//span[text()=' Download W-9 Form Template ']")
private WebElement download_w9;

@FindBy(xpath = "//h3[text()='Account Application ']")
private WebElement successfully_created;

public void first_page() throws InterruptedException
{
	Thread.sleep(6000);
	explicity_wait(driver, 10, sign_up);
	
	sign_up.click();
	logger.info("Go to sign up page");
	implicity_wait(5);
	
	First_name.sendKeys(readdata_excel(0, 1, 0));
	logger.info("Enter the first name");
	implicity_wait(5);
	
	Middle_name.sendKeys(readdata_excel(0, 1, 1));
	logger.info("Enter middle name");
	implicity_wait(5);
	
	Last_name.sendKeys(readdata_excel(0, 1, 2));
	logger.info("Enter the last name");
	implicity_wait(5);
  
	Phone_no.sendKeys("535353355");
	logger.info("Enter the phone number");
	implicity_wait(5);
	
	String email = random_string(5);
	
	System.out.println(email);
	Email_id.sendKeys(email);
	logger.info(email);
	implicity_wait(5);
	
	next_button.click();
}

public void second_page() throws InterruptedException
{
	implicity_wait(10);
	
	registered_business_id.sendKeys(readdata_excel(0, 1, 5));
	logger.info("Enter the register business name");
	implicity_wait(5);

	business_type.sendKeys(readdata_excel(0, 1, 6));
    logger.info("Select business in drop down");
    implicity_wait(5);
    
    Business_tax_id.sendKeys("123456789");
    logger.info("Enter the business tax id ");
    implicity_wait(5);
    
    organization_type.sendKeys(readdata_excel(0, 1, 8));
    logger.info("Enter the organization type");
    implicity_wait(5);
    
    Delivery_address.sendKeys(readdata_excel(0, 1, 9));
    logger.info("Enter the delivery address");
    implicity_wait(5);
    
    country.sendKeys(readdata_excel(0, 1, 10));
    logger.info("Enter the country ");
    implicity_wait(5);
    
    state.sendKeys(readdata_excel(0, 1, 11));
    logger.info("Enter the state ");
    implicity_wait(5);
    
    city.sendKeys(readdata_excel(0, 1, 12));
    logger.info("Enter the city");
    implicity_wait(5);
    
    zip_code.sendKeys("13013");
    logger.info("Enter the zipcode");
    implicity_wait(5);
    
    billing_address.sendKeys(readdata_excel(0, 1, 14));
    logger.info("Enter the billing address");
    implicity_wait(5);
    
    billing_country.sendKeys(readdata_excel(0, 1, 15));
    logger.info("Enter the billing country");
    implicity_wait(5);
    
    billing_city.sendKeys(readdata_excel(0, 1, 12));
    logger.info("Enter the billing city");
    implicity_wait(5);
    
    billing_state.sendKeys(readdata_excel(0, 1, 16));
    logger.info("Enter the billing state");
    implicity_wait(5);
    
    billing_zipcode.sendKeys("12323");
    logger.info("Enter the billing zipcode");
    implicity_wait(5);
    
    Thread.sleep(6000);
    next2.click();
    logger.info("Click on next button");
    
    
}

public String third_page() throws InterruptedException
{

	
	implicity_wait(10);
	
	 String Main_window = driver.getWindowHandle();
		
		System.out.println(Main_window);
	
	download_w9.click();
	logger.info("Download the w9 form");
	implicity_wait(10);
	
  String parent = windowhandling(0);
  windowhandling(1);
  driver.close();
  
  driver.switchTo().window(parent);
    
    w9_form.sendKeys("C:\\Users\\rohit.kashyap\\fw9.pdf");
    
	term_agree_conditions.click();
	logger.info("Click on the term and condition box");
	implicity_wait(10);
	
	submit_button.click();
	logger.info("Click on submit button");
	implicity_wait(10);

	String successfully = successfully_created.getText();
	System.out.println(successfully);
	
	Thread.sleep(10000);
	return successfully;

}

}
