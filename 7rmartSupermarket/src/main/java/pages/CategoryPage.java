package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	public WebDriver driver;
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchcat;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newcat;
	@FindBy(xpath="(//span[text()='Active'])[1]") WebElement status;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	@FindBy(xpath="(//i[@class='fas fa-edit'])[2]") WebElement edit;
	
	public SearchCategoryPage searchCatClick()
	{
		searchcat.click();
		return new SearchCategoryPage(driver);
	}
	
	public AddCategoryPage newCategoryClick()
	{
		newcat.click();
		return new AddCategoryPage(driver);
	}
	
	public CategoryPage statusClick()
	{
		status.click();
		return this;
	}
	
	public EditCategoryPage editClick()
	{
		edit.click();
		return new EditCategoryPage(driver);
	}
	
	public boolean isAlertDisplayed() 
	{
		return alert.isDisplayed();
	}
	
}
