package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseLibrary.Base;

public class Furniture extends Base{
	
	public Furniture()
	{
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "(//a[text()=' FURNITURE '])[1]")
	private WebElement funiture;
	
	
	
}
