package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtilities {

	public WebDriver driver;
	
	public void selectByVisibleText(WebElement element, String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByIndexValue(WebElement element, int value)
	{
		Select select=new Select(element);
		select.selectByIndex(value);
	}
}
