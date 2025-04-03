package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;

public class NewUserPage 
{
public WebDriver driver;
PageUtilities pageutilities = new PageUtilities();
	
	public NewUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//input[@id='username']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//select[@id='user_type']") WebElement dropdown;
	@FindBy(xpath="(//button[@type='submit'])[2]") WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	public NewUserPage enterUsernamePassword(String uname, String pwd)
	{
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		return this;
		
	}
	
	public NewUserPage usertypeSelection(String type)
	{
		//Select select=new Select(dropdown);
		//select.selectByVisibleText(type);
		pageutilities.selectByVisibleText(dropdown, type);
		return this;
	}
	
	public NewUserPage saveClick()
	{
		save.click();
		return this;
	}
	
	public boolean isAlertDisplayed() 
	{
		return alert.isDisplayed();
	}
	
}
