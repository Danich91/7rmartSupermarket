package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signin;
	
	
	public LoginPage verifySignIn(String uname, String pwd)
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		return this;
		
	}
	
	public HomePage signIn()
	{
		signin.click();
		return new HomePage(driver);
	}
	
}
