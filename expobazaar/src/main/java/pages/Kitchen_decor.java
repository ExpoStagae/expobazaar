package pages;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import baseLibrary.Base;

public class Kitchen_decor extends Base {
	
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
	
	@FindBy(xpath = "(//h1)[2]")
	private WebElement h2;
	
	public void refresh()
	{
		
		for(WebElement dd:product_list)
	    list.add(dd);
		
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
	Usa_side_check.click();
	logger.info("check on usa side box");
	Thread.sleep(6000);
	
	Ready_to_ship_check.click();
	logger.info("check on ready to ship box");
	
	Thread.sleep(6000);
	category.click();
	logger.info("click on category tab");
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
		
		logger.info("test case end");
		Thread.sleep(6000);
	}
}
