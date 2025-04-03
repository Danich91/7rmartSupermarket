package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtility;

public class AddSubCategoryPage {
	
	public WebDriver driver;
	PageUtilities pageutilities = new PageUtilities();
	FileUploadUtility fileuploadutility= new FileUploadUtility();
	WaitUtility waitutility=new WaitUtility();
	
	public AddSubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@class='form-control selectpicker']") WebElement catselect;
	@FindBy(xpath="//input[@id='subcategory']") WebElement subcat;
	@FindBy(xpath="//input[@id='main_img']") WebElement choosefile;
	@FindBy(xpath="//button[@type='submit']") WebElement submit;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	
	public AddSubCategoryPage categorySelection(String category)
	{
		pageutilities.selectByVisibleText(catselect, category);
		return this;
	}
	
	public AddSubCategoryPage enterSubCategory(String subcategory)
	{
		subcat.sendKeys(subcategory);
		return this;
	}
	
	public AddSubCategoryPage chooseImage()
	{
		waitutility.waitForElementtobeClicked(driver,choosefile);
		fileuploadutility.fileUploadForSendKey(choosefile,Constants.PATH1);
		return this;
	}
	
	public AddSubCategoryPage saveClick()
	{
		submit.click();
		return this;
	}
	public boolean isAlertDisplayed() 
	{
		return alert.isDisplayed();
	}
}
