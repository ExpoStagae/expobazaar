package pages;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.formula.functions.MinaMaxa;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.Base;

public class Add_to_cart extends Base {
	
	int moq_int;
	boolean flag = true;
	
	public Add_to_cart() {
    
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath = "(//*[text()=' KITCHEN & DINING '])[1]")
	private WebElement Kitchen_decor;
	
	@FindBy(xpath = "//*[@id='price-range-2']")
	private WebElement Slide_bar;
	
	@FindBy(xpath = "(//input[@id='checkShipForm0'])[2]")
	private WebElement Usa_side_check;
	
	@FindBy(xpath = "//*[@id='accordion']//child::label[text()='Ready To Ship']")
	private WebElement Ready_to_ship_check;
	
	@FindBy(xpath = "//a[text()=' Category ']")
	private WebElement category;
	
	@FindBy(xpath = "//div[@id=\"headingTwo\"]//following::div[@id=\"collapseTwo\"]//child::ul[@id=\"myUL\"]")
	List<WebElement> categry_list;
	
	@FindBy(xpath = "//div[@id=\"myTabContent-2\"]//following::h3[@class='title show_line4']")
	List<WebElement> product_list;
	ArrayList<WebElement> list = new ArrayList<WebElement>();
	
	@FindBy(xpath = "//div//small[@class  ='col-lg-6 col-md-5 col-sm-4 col-5 small-font text-right']")
	private WebElement minimum_order_quantity;
	
	@FindBy(xpath = "//div[@role=\"alertdialog\"]")
	private WebElement alert_text_msg;
	
	@FindBy(xpath = "//*[@name='quantity']")
	private WebElement minimum_quantity;
	
	@FindBy(xpath = "//*[text()=' Add To Cart ']")
	private WebElement add_to_cart;
	
	@FindBy(xpath = "//*[text()=' Bulk Inquiry ']")
	private WebElement bulk_enquiry;
	
	@FindBy(xpath = "//*[@id='bulk_quantity']")
	private WebElement bulk_quanity;
	
	@FindBy(xpath = "//button[@class='mat-focus-indicator mat-icon-button mat-button-base']")
	private WebElement calender;
	
	@FindBy(xpath = "//table[@class=\"mat-calendar-table\"]//td[contains(@aria-label,'13')]")
	private WebElement data_picker;
	
	@FindBy(xpath = "//*[@id='mat-calendar-button-7']")
	private WebElement year_click;
	
	@FindBy(xpath = "//button[contains(@aria-label,'Next month')]")
	private WebElement date_tab;
	
	@FindBy(xpath = "//td[@class='mat-calendar-body-cell ng-star-inserted']//child::div[contains(text(),'22')]")
	private WebElement click_on_date;
	
	@FindBy(xpath = "//div[@class='form-group']//child::textarea")
	private WebElement description_text;
	
	@FindBy(xpath = "//button[text()='Submit Inquiry']")
	private WebElement submit_button;
	
	@FindBy(xpath = "(//a[@href='/cart'])[1]")
	private WebElement go_to_cart;
	
	@FindBy(xpath = "//*[@id='toast-container']")
	private WebElement product_added;
	
	@FindBy(xpath = "//*[@class='ng-tns-c41-1 toast-message ng-star-inserted']")
	private WebElement minumum_quantity_toast;
	
	@FindBy(xpath = "//*[text()= ' Detailed Information ']")
    private WebElement detailed;
	
	@FindBy(xpath = "(//h1)[2]")
	private WebElement h2;
	
	@FindBy(xpath = "//*[@id='collapseOne']//child::label[contains(text(),'USA Local')]")
	private WebElement US_local;
	
	@FindBy(xpath = "//*[@class='main-menu']//child::li[@class='ng-star-inserted']//child::a[contains(text(),' JEWELRY ')]")
	private WebElement furntiure;
	
	@FindBy(xpath = "//button[@class='btn4 btn-number']")
	private WebElement minus_button;
	
	@FindBy(xpath = "//*[@id='toast-container']")
	private WebElement toast_msg;
	
	@FindBy(xpath = "//div[@class='col-md-5 d-none d-lg-block col-12 topsearch']//child::input[@name='search']")
	private WebElement serach_id;
	
	@FindBy(xpath = "//i[@class='flaticon-magnifying-glass']//parent::button")
	private WebElement serach_button;
	
	public void refresh()
	{
		
		for(WebElement dd:product_list)
	    list.add(dd);
		
	}
	
	public void minimum_value()
	{
		
		minimum_quantity.clear();
      
		int a=moq_int-1;
		
		
		
		minimum_quantity.sendKeys(String.valueOf(a));
	   // detailed.click();
		
		
try {
			
	String min_string = minimum_order_quantity.getText();
	explicity_wait(driver, 10, minumum_quantity_toast);
	String value_of_minimum =	  minumum_quantity_toast.getText().replace("/n", " ");
	System.out.println(value_of_minimum);
			
			if(value_of_minimum.contains("Minimum quantity cannot be less than 1"));
			{
				System.out.println("please choose order value greater minimum value");
			}   
		}
			catch (Exception e) {
			
			System.out.println("Functionality not working properly");
		}
		
		
		
	}
	
	public void maximum_value() throws InterruptedException
	{
		Thread.sleep(5000);
		minimum_quantity.clear();
	      
		int a=moq_int+1;
		
		
		
		minimum_quantity.sendKeys(String.valueOf(a));
		detailed.click();
		
		
try {
			
	
	explicity_wait(driver, 10, minumum_quantity_toast);
	String value_of_minimum =	  minumum_quantity_toast.getText().replace("/n", " ");
	System.out.println(value_of_minimum);
			
			if(value_of_minimum.contains("Minimum quantity cannot be less than 1"));
			{
				System.out.println("please choose order value greater minimum value");
			}   
		}
			catch (Exception e) {
			
			System.out.println("Functionality  working properly");
		}
		
		
	}
	public void Kitchen() throws InterruptedException
	{
		explicity_wait_clickable(driver, 10, Kitchen_decor);
		
		Kitchen_decor.click();
		logger.info("Click into the kitchen and decor menu");
		
explicity_wait(driver, 20, Slide_bar);		
		

try {
	
	//actio(Slide_bar, driver);
}
catch (Exception e) 
{
	System.out.println(e);
}



Thread.sleep(10000);
explicity_wait_clickable(driver, 10, Ready_to_ship_check);
	Ready_to_ship_check.click();
	

	
	logger.info("check on ready to ship box");
	
	Thread.sleep(6000);

	
	 
	
	}
	
	public void choose_item(String env) throws InterruptedException
	{
		if(env.equalsIgnoreCase("Stage")) {
		 refresh();
		 implicity_wait(10);
		list.get(0).click();
		Thread.sleep(6000);
	gotocart_r();
		}
		
		if(env.equalsIgnoreCase("prod"))
		{
			String parent = "";
			try
			{
					explicity_wait(driver, 10, serach_id);
				serach_id.sendKeys("testBT0140F");
				explicity_wait_clickable(driver, 10, serach_button);
				js_click(serach_button);
				refresh();
						list.get(0).click();
						parent = windowhandling(0);
						windowhandling(1);
						gotocart_r();
						driver.close();
						driver.switchTo().window(parent);
			}
			catch (Exception e) {
			     explicity_wait(driver, 10, serach_id);
			     serach_id.clear();
			     serach_id.sendKeys("testFR-3 STYLE WEAVE-030");
			     explicity_wait_clickable(driver, 10, serach_button);
					js_click(serach_button);
			     refresh();
			     explicity_wait_presence_of_element(driver, 10, list);
			     list.get(0).click();
			     parent = windowhandling(0);
					windowhandling(1);
					gotocart_r();
					driver.close();
					driver.switchTo().window(parent);
			}
			
			
		}
		
	}
	
	
		
		
		
	
	
	public void check_the_product() throws InterruptedException
	{
		
		refresh();
		int i=0;
		for(WebElement dd:product_list)
		{
			refresh();
			
			Thread.sleep(6000);
			
			WebElement click = list.get(i);
			String msg = click.getText();
			System.out.println(msg);
			logger.info("get the name of product from list");
			if(click!=null) {
			click.click();
			logger.info("click on the product for go to product page");
			Thread.sleep(6000);
			String text2= h2.getText();
			System.out.println(text2);
			logger.info("get the name of product from product page");
			
			Assert.assertEquals(msg, text2);
			logger.info("check the product name are same on list and product page");
			driver.navigate().back();
			logger.info("go back for other product in list");
			Thread.sleep(6000);
			i++;
			list.removeAll(list);
			}
	   }
	
	}
	
	public void miminum_value_check_for_ready_to_ship() throws InterruptedException
	{
		
		
		
		implicity_wait(10);
		
		String moq_text = minimum_order_quantity.getText();
		
		 moq_int =minimum_value_int(moq_text);
		System.out.println( "Minimum Order quantity for this order is"+ " "+moq_int);
		
		
		minimum_value();
		
		}
	
	public void gotocart_r() throws InterruptedException
	{
explicity_wait(driver, 10, add_to_cart);
		
		add_to_cart.click();
		
		try {
			explicity_wait(driver, 10, product_added);
	String product_added_text =	product_added.getText();
	System.out.println(product_added_text);
			if(product_added_text.equalsIgnoreCase(" Product has been added in your cart "))
			{
				System.out.println("product added successfully added");
				
			}
			if(product_added_text.equalsIgnoreCase("Product already added to cart"))
			{
				System.out.println("product is alread in the card");
				
			}
			
		} catch (Exception e) {
			
			System.out.println("There have some problem to add this product in card"+e);
		}
		Thread.sleep(5000);
		go_to_cart.click();
		
	}
		
	public void bulk_enquiry()
	{
		bulk_enquiry.click();
		
		explicity_wait(driver, 10, bulk_quanity);
		
		bulk_quanity.click();
		
		select_by_value(bulk_quanity, "100-200");
		
		calender.click();
		
		date_tab.click();
		
	click_on_date.click();
	
	description_text.sendKeys("testing");
	
	
	}
	
	public void submitt_button()
	{
		
		submit_button.click();
	}
	
	
	public void us_local()
	{
		furntiure.click();
		
	explicity_wait(driver, 10, US_local);
		explicity_wait_clickable(driver, 10, US_local);
		
		US_local.click();
		
	}
		
public void minimum_value_check_for_us_local()
{
try {	
	
	minus_button.click();
	
	explicity_wait(driver, 10, Kitchen_decor);
    
	String msg = toast_msg.getText().trim();
	String alert_msg = "Minimum quantity cannot be less than 1";
	if(msg.equalsIgnoreCase(alert_msg))
	{
		System.out.println("Functionalty is working properly");
		
	}
	Thread.sleep(5000);
}
catch (Exception e) {
	System.out.println(e);
}
}
		
		
	}
	

