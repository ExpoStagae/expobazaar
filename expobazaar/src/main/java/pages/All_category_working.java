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
	
	static int i;
	static int j;
	String msg ="";
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
	
	public void menu_tab(int k) throws InterruptedException
	{
		Thread.sleep(3000);
	
			WebElement menu_click = menu_list.get(i);
			String more_msg = menu_click.getText().trim();
			
			
		Thread.sleep(5000);
			
			String More = "More";
			if (more_msg.equalsIgnoreCase(More)) 
			{
				action_hold(menu_click, driver);
				i=i;
			} 
			else {
				menu_click.click();
                     i++;
                 	Thread.sleep(5000);
                     msg = massage.getText();
			}
			Thread.sleep(5000);
			
	}
	public void back() throws InterruptedException
	{
		 driver.navigate().back();
	      Thread.sleep(5000);
	}
	
	public String kitchen_Dining() throws InterruptedException
	{
		refresh();
		menu_tab(i);
		return msg;
	}
	
	public String Home_Accent() throws InterruptedException
	{
	
		 refresh();
		menu_tab(i);
		return msg;
	}
	
	public String Home_Furnishing() throws InterruptedException
	{
	
		 refresh();
		menu_tab(i);
		return msg;
	}
	public String furtniure() throws InterruptedException
	{
	
		 refresh();
		menu_tab(i);
		return msg;
	}
	
	
	public String Jewelry() throws InterruptedException
	{
	
		 refresh();
		menu_tab(i);
		return msg;
	}
	
	public String Kid_Babies() throws InterruptedException
	{
	
		 refresh();
		menu_tab(i);
		return msg;
	}
	public String fashion() throws InterruptedException
	{
		refresh();
		menu_tab(i);
		 refresh2();
			more_tab(j);
			return msg;
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
		
			menu_click.click();
			
			implicity_wait(10);
			Thread.sleep(5000);
			msg = massage.getText();
			
			j++;
	}
	public String nature_fibre() throws InterruptedException
	{
		refresh();
		menu_tab(i);
		Thread.sleep(5000);
		 refresh2();
			more_tab(j);
			return msg;
		}
	
	public String hobbies_liesure() throws InterruptedException
	{
		refresh();
		menu_tab(i);
		 refresh2();
			more_tab(j);
			return msg;
		}
	
	public String lighting() throws InterruptedException
	{
		refresh();
		menu_tab(i);
		 refresh2();
			more_tab(j);
			return msg;
		}
	public String gifting() throws InterruptedException
	{
		refresh();
		menu_tab(i);
		 refresh2();
			more_tab(j);
			return msg;
		}
	
	public String Artinsal() throws InterruptedException
	{
		refresh();
		menu_tab(i);
		 refresh2();
			more_tab(j);
			return msg;
		}
	}

