package applicationUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Action {

	public void actio( WebElement element, WebDriver driver);
	
	public void action_drag(WebElement element, WebDriver driver);
}
