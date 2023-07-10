  package pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

import baseLibrary.Base;

public class All_category_working extends Base{
	
	static int i=0;
	static int j;
	int k;
	String msg ="";
	String menu_name="";
	public All_category_working()
	{
		PageFactory.initElements(driver, this);
		
	}

@FindBy(xpath = "//nav[@class='main-menu']//a")
private List<WebElement> menu_tabl;

@FindBy(xpath = "//*[@id='main-wrapper']//child::ul//h1")
private WebElement massage;

@FindBy(xpath = "//li[@class=\"text-upper\"]//a")
private List<WebElement> more_list;

	ArrayList<WebElement> menu_list = new ArrayList<>();
	ArrayList<WebElement> more_list1 = new ArrayList<>();
	
	public void refresh()
	{

		for(WebElement Menu_tab:menu_tabl)
		{
			
			menu_list.add(Menu_tab);
			
		}
		
	}
	public int size_array() throws InterruptedException
	{
		Thread.sleep(5000);
		refresh();
		 k = menu_list.size();
		return k;
	}
	public String menu_name()
	{String menu_name_msg="";
		String More = "More";
		if(!More.equalsIgnoreCase(menu_name)) {
			
		 menu_name_msg = menu_name;
		
		
		}
		
		if(More.equalsIgnoreCase(menu_name_msg)) {
			
			 menu_name_msg = menu_name;
			
			
			}
		return menu_name_msg;
	}
	
	public String menu_tab(int k) throws InterruptedException
	{     
		menu_list.clear();
		Thread.sleep(3000);
		refresh();
		Thread.sleep(3000);
	  
			WebElement menu_click = menu_list.get(i);
			menu_name = menu_click.getText().trim();
			
			menu_click.click();
			explicity_wait(driver, 10, menu_click);
			String more_msg = menu_click.getText().trim();
			
			
		
			
			String More = "More";
			if (more_msg.equalsIgnoreCase(More)) 
			{
				action_hold(menu_click, driver);
				i=i;
				 refresh2();
					more_tab(j);
			} 
			else {
				menu_click.click();
                     i++;
                 	explicity_wait(driver, 20, massage);
                     msg = massage.getText();
                   
			}
			
			return msg;
	}
	public void back() throws InterruptedException
	{
		 driver.navigate().back();
	      Thread.sleep(5000);
	}
	


	
	public void refresh2()
	{
		for(WebElement Menu_tab:more_list)
		{
			more_list1.add(Menu_tab);
			
		}
		
	}
	
	public void more_tab(int k) throws InterruptedException
	{
		
	
			WebElement menu_click = more_list1.get(j);
			menu_name= menu_click.getText().trim();
		
			menu_click.click();
			
			implicity_wait(10);
			explicity_wait(driver, 10, massage);
			msg = massage.getText();
			
			j++;
	}

		
	
	}

