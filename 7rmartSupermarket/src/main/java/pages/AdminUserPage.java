package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtilities;

public class AdminUserPage {
	
	
	public WebDriver driver;
	PageUtilities pageutilities=new PageUtilities();
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement search1;
	@FindBy(xpath="(//a[@class=\"btn btn-default btn-fix\"])[1]") WebElement reset;
	@FindBy(xpath="//input[@id='un']") WebElement username;
	@FindBy(xpath="//select[@id='ut']") WebElement usertype;
	
	
	public NewUserPage newButtonClick()
	{
		newuser.click();
		return new NewUserPage(driver) ;
		
	}
	
	public SearchPage searchClick()
	{
		search1.click();
		return new SearchPage(driver);
	}
	
	public AdminUserPage uname(String uname)
	{
		search1.click();
		username.sendKeys(uname);
		return this;
	}
	
	public AdminUserPage usertype(int type)
	{
		pageutilities.selectByIndexValue(usertype, type);
		return this;
	}
	public AdminUserPage resetClick()
	{
		
		reset.click();
		return this;
	}
	
	
	
}
