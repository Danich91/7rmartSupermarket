package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCategoryPage {
	
	
	public WebDriver driver;
	public SearchCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Category']") WebElement categoryadd;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") WebElement search;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']") WebElement table;
	@FindBy(xpath="//span[@id='res']") WebElement resultnotfound;
	public SearchCategoryPage enterCategory(String catname)
	{
		
		categoryadd.sendKeys(catname);
		return this;
		
	}
	public SearchCategoryPage searchCat()
	{
		search.click();
		return this;
	}
	
	public boolean isResultNotFoundDisplayed()
	{
		return resultnotfound.isDisplayed();
	}
}

