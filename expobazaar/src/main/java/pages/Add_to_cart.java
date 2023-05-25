package pages;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.formula.functions.MinaMaxa;
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
	
	@FindBy(xpath = "//*[@id='collapseOne']//child::label[contains(text(),'Ready To Ship')]")
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
	
	@FindBy(xpath = "//*[@name=\"expe_date_delivery\"]")
	private WebElement calender;
	
	@FindBy(xpath = "//table[@class=\"mat-calendar-table\"]//td[contains(@aria-label,'13')]")
	private WebElement data_picker;
	
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
		Thread.sleep(5000);
		
		Kitchen_decor.click();
		logger.info("Click into the kitchen and decor menu");
		
explicity_wait(driver, 20, Slide_bar);		
		
Thread.sleep(6000);
try {
	//actio(Slide_bar, driver);
} catch (Exception e) {
	System.out.println(e);
}

implicity_wait(10);

	
	Ready_to_ship_check.click();
	
	//US_local.click();
	
	logger.info("check on ready to ship box");
	
	Thread.sleep(6000);

	
	 
	
	}
	
	public void choose_item() throws InterruptedException
	{
		 refresh();
		 implicity_wait(10);
		list.get(0).click();
		Thread.sleep(6000);
		
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
	
	public void miminum_value_check() throws InterruptedException
	{
		
		
		
		implicity_wait(10);
		
		String moq_text = minimum_order_quantity.getText();
		
		 moq_int =minimum_value(moq_text);
		System.out.println( "Minimum Order quantity for this order is"+ " "+moq_int);
		
		
		minimum_value();
		
		}
	
	public void gotocart() throws InterruptedException
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
		Thread.sleep(10000);
		go_to_cart.click();
		
	}
		
	public void bulk_enquiry()
	{
		bulk_enquiry.click();
		
		bulk_quanity.click();
		
		select(bulk_quanity, "100-200");
		
		calender.click();
		
		data_picker.click();
			
		
	}
		

		
		
	}
	

