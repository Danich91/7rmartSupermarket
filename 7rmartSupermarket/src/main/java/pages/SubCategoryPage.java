package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage 
{
	
	WebDriver driver;
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
    @FindBy(xpath="(//a[@class='btn btn-sm btn btn-danger btncss'])[3]") WebElement delete;
    @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	public AddSubCategoryPage newSubcategoryClick()
	{
		newbutton.click();
		return new AddSubCategoryPage(driver);
	}
	
	public SubCategoryPage clickDelete()
	{
		delete.click();
		driver.switchTo().alert().accept();
		return this;
	}
	
	public boolean isAlertDisplayed() 
	{
		return alert.isDisplayed();
	}
}
