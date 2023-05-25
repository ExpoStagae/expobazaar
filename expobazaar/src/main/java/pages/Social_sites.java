package pages;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Base;

public class Social_sites extends Base {
	
    public Social_sites()
    {
    	
    	PageFactory.initElements(driver, this);
    	
    }
    
@FindBy(xpath = "//footer//a[@href=\"https://www.facebook.com/expobazaarindia\"]")
private WebElement  Facebook_link;

@FindBy(xpath = "//*[@class=\"x92rtbv x10l6tqk x1tk7jg1 x1vjfegm\"]")
private WebElement cross_fab_tab;

@FindBy(xpath = "//h1")
private WebElement Facebook_Msg;

@FindBy(xpath = "//footer//a[@href='https://www.linkedin.com/company/expobazaarindia/']")
private WebElement Linkedin_link;

@FindBy(xpath = "(//div[@class=\"modal__overlay flex items-center bg-color-background-scrim justify-center fixed bottom-0 left-0 right-0 top-0 opacity-0 invisible pointer-events-none z-[1000] transition-[opacity] ease-[cubic-bezier(0.25,0.1,0.25,1.0)] duration-[0.17s] py-4 modal__overlay--visible\"]//section//button[contains(@aria-label,'Dismiss')])[1]")
private WebElement crosstab;

@FindBy(xpath = " //h1")
private WebElement Linkedin_msg;

@FindBy(xpath = "//footer//a[@href='https://twitter.com/expobazaarindia']")
private WebElement Twitter_link;

@FindBy(xpath = "(//span[text()='ExpoBazaar'])[1]")
private WebElement twitter_msg;

@FindBy(xpath = "//footer//a[@href='https://www.instagram.com/expobazaarindia/']")
private WebElement instagram_link;

@FindBy(xpath = "//*[text()='expobazaarindia']")
private WebElement instagram_msg;

@FindBy(xpath = "//footer//a[@href='https://in.pinterest.com/expobazaarindia/']")
private WebElement pinterest_link;

@FindBy(xpath = "//h1")
private WebElement Pinterest_msg;

@FindBy(xpath = "//footer//a[@href='https://www.youtube.com/channel/UCWA6jjcGqpXj9_6A0rZGk-A']")
private WebElement youtube_link;

@FindBy(xpath = "//*[@id='text'][text()='ExpoBazaar']")
private WebElement youtube_msg;

public String facebook() throws InterruptedException
{
	
	Thread.sleep(6000);
	Facebook_link.click();
	
	
String parent = windowhandling(0);
windowhandling(1);
	
	
	implicity_wait(10);
	cross_fab_tab.click();
	
	String Msg =driver.getCurrentUrl();
	if(Msg.contains("facebook"))
	{
		System.out.println("Facebook page is working");
		
	}
	else {
		System.out.println("Facebook link is not working");
	}
	
	
	String Facebook_Msg_text = Facebook_Msg.getText();
      

	
	System.out.println(Facebook_Msg_text);
	
	return Facebook_Msg_text;
}
   public String Linkedin() throws InterruptedException
   {
	   String Linkedin_Msg_text ="";
	   Thread.sleep(6000);
	   Linkedin_link.click();
	   try {
		
	
	   String parent = windowhandling(0);
	   windowhandling(1);
	   
	   implicity_wait(10);
	   crosstab.click();
	   
	   String Msg = driver.getCurrentUrl();
	   if(Msg.contains("linkedin"))
	   {
		   System.out.println("Linkedin link is working fine");
	   }
	   else {
		
		   System.out.println("Linkedin link is not working");
	}
	    Linkedin_Msg_text = Linkedin_msg.getText();
	   System.out.println(Linkedin_Msg_text);
	   
	   } catch (Exception e) {
			System.out.println();
		}

	   return Linkedin_Msg_text;
   }
   
   public String twitter() throws InterruptedException
   {
	   
	   Thread.sleep(6000);
	   Twitter_link.click();
	   String parent = windowhandling(0);
	   windowhandling(1);
	   
	   String Msg = driver.getCurrentUrl();
	   if(Msg.contains("twitter"))
	   {
		   System.out.println("Twitter link is working fine");
	   }
	   else {
		
		   System.out.println("Twitter link is not working");
	}
	   String Twitter_Msg_text = twitter_msg.getText();
	   System.out.println(Twitter_Msg_text);

	   return Twitter_Msg_text;
   }
   
   public String Instagram() throws InterruptedException
   {
	   Thread.sleep(6000);
	   instagram_link.click();
	   String parent = windowhandling(0);
	   windowhandling(1);
	   
	   String Msg = driver.getCurrentUrl();
	   if(Msg.contains("instagram"))
	   {
		   System.out.println("Instagram link is working fine");
	   }
	   else {
		
		   System.out.println("Instagram link is not working");
	}
	   Thread.sleep(8000);
	   String Instagram_Msg_text = instagram_msg.getText();
	   System.out.println(Instagram_Msg_text);

	   return Instagram_Msg_text;
   }
   
   public String Pinterest() throws InterruptedException
   {
	   Thread.sleep(6000);
	   pinterest_link.click();
	   String parent = windowhandling(0);
	   windowhandling(1);
	   
	   String Msg = driver.getCurrentUrl();
	   if(Msg.contains("pinterest"))
	   {
		   System.out.println("Pinterest link is working fine");
	   }
	   else {
		
		   System.out.println("Pinterest link is not working");
	}
	   String pinterest_Msg_text = Pinterest_msg.getText();
	   System.out.println(pinterest_Msg_text);

	   return pinterest_Msg_text;
   }
   
   public String youtube() throws InterruptedException
   {
	   Thread.sleep(6000);
	   youtube_link.click();
	   String parent = windowhandling(0);
	   windowhandling(1);
	   
	   String Msg = driver.getCurrentUrl();
	   if(Msg.contains("youtube"))
	   {
		   System.out.println("Youtube link is working fine");
	   }
	   else {
		
		   System.out.println("Youtube link is not working");
	}
	   String youtube_Msg_text = youtube_msg.getText();
	   System.out.println(youtube_Msg_text);

	   return youtube_Msg_text;
   }
   
   public void close()
   {
	   String parent = windowhandling(0);
	   windowhandling(1);
	   driver.close();
	   driver.switchTo().window(parent);
   }
}


