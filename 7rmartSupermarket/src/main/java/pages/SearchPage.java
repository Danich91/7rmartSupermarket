package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	@FindBy(xpath="//input[@id='un']") WebElement username;
	@FindBy(xpath="//button[@name='Search']") WebElement search2;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']") WebElement table;
	@FindBy(xpath="//span[@id='res']") WebElement resultnotfound;

	
	
	public SearchPage enterusername(String Uname)
	{
		username.sendKeys(Uname);
		return this;
	}
	
	public SearchPage search2Click()
	{
		search2.click();
		return this;
	}
	
	public boolean isTableDisplayed() 
	{
		return table.isDisplayed();
	}
	
	public boolean isResultNotFoundDisplayed()
	{
		return resultnotfound.isDisplayed();
	}
	
}

