package pages;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.formula.functions.MinaMaxa;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.Base;

public class Kitchen_decor extends Base {
	
	int moq_int;
	
	public Kitchen_decor() {
    
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath = "(//*[text()=' KITCHEN & DINING '])[1]")
	private WebElement Kitchen_decor;
	
	@FindBy(xpath = "//*[@id='price-range-2']")
	private WebElement Slide_bar;
	
	@FindBy(xpath = "(//input[@id='checkShipForm0'])[2]")
	private WebElement Usa_side_check;
	
	@FindBy(xpath = "(//input[@id='checkShipForm1'])[2]")
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
	
	
	@FindBy(xpath = "(//h1)[2]")
	private WebElement h2;
	
	public void refresh()
	{
		
		for(WebElement dd:product_list)
	    list.add(dd);
		
	}
	
	public void minimum_value()
	{
		minimum_quantity.clear();
	    moq_int = moq_int-1;
		
		minimum_quantity.sendKeys(String.valueOf(moq_int));
		minimum_quantity.sendKeys(Keys.ENTER);
		
		
		
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
//	Usa_side_check.click();
//	logger.info("check on usa side box");
//	Thread.sleep(6000);
	
	Ready_to_ship_check.click();
	logger.info("check on ready to ship box");
	
	Thread.sleep(6000);
	category.click();
	logger.info("click on category tab");
	 refresh();
	 implicity_wait(10);
	 list.get(3).click();
	
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
	
	public void kitchen_decor() throws InterruptedException
	{
		
		
		
		implicity_wait(10);
		
		String moq_text = minimum_order_quantity.getText();
		
		 moq_int =minimum_value(moq_text);
		System.out.println( "Minimum Order quantity for this order is"+ " "+moq_int);
		
		
		minimum_value();
		
		try {
			
			String min_string = minimum_order_quantity.getText();
			
			if(min_string.contains(" Minimum quantity cannot be less than 1 "))
			{
				System.out.println("please choose order value greater minimum value");
			 moq_int++;
				minimum_value();
			}
			
			
		} catch (Exception e) {
			
			System.out.println("your order is selected");
		}
		explicity_wait(driver, 10, add_to_cart);
		
		add_to_cart.click();
		
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
	

