package pages;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Base;


public class Login extends Base{

   public Login() 
   
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

@FindBy(xpath = "//*[@name='country1']")
private WebElement billing_country;

@FindBy(xpath = "//*[@name='state1']")
private WebElement billing_state;

@FindBy(xpath = "//*[@name='city1']")
private WebElement billing_city;

@FindBy(xpath = "//*[@name='zipCode1']")
private WebElement billing_zipcode;

//web elements for sign up third page

@FindBy(xpath = "//*[@id='W9-form']")
private WebElement w9_form;

@FindBy(xpath = "//*[@name='agree_to_terms_conditions']")
private WebElement term_agree_conditions;

@FindBy(xpath = "//button[text()='Submit ']")
private WebElement submit_button;




public void first_page()
{
	sign_up.click();
	logger.info("Go to sign up page");
	implicity_wait(5);
	
	First_name.sendKeys(readdata_excel(0, 1, 0));
	logger.info("Enter the first name");
	
	Middle_name.sendKeys(readdata_excel(0, 1, 1));
	logger.info("Enter middle name");
	
	Last_name.sendKeys(readdata_excel(0, 1, 2));
	logger.info("Enter the last name");
	
  
	Phone_no.sendKeys("535353355");
	logger.info("Enter the phone number");
	
	Email_id.sendKeys(readdata_excel(0, 1, 4));
	logger.info("Enter the email address");
	
	next_button.click();
}

}
