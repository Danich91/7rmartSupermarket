package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class HomePage {
	
	public WebDriver driver;
	WaitUtility waitutility=new WaitUtility();
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]") WebElement logout;
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]") WebElement moreinfo;
	@FindBy(xpath="(//a[@class='small-box-footer'])[3]") WebElement moreinfocat;
	@FindBy(xpath="(//a[@class='small-box-footer'])[4]") WebElement moreinfosubcat;
	
	
	
	public HomePage adminClick()
	{
		
		waitutility.waitForElementtobeClicked(driver, admin);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.elementToBeClickable(admin));
		admin.click();
		return this;
	}
	
	public HomePage logoutButtonClick()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
		return this;
	}
	
	public AdminUserPage moreInfoClick()
	{
		moreinfo.click();
		return new AdminUserPage(driver);
		
	}
	
	public CategoryPage moreInfoCategoryClick()
	{
		moreinfocat.click();
		return new CategoryPage(driver);
	}
	
	public SubCategoryPage moreInfoSubCategoryClick()
	{
		moreinfosubcat.click();
		return new SubCategoryPage(driver);
	}
}
