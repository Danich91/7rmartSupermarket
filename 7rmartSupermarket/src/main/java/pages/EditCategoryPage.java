package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class EditCategoryPage {
	
	public WebDriver driver;
	FileUploadUtility fileuploadutility= new FileUploadUtility();
	WaitUtility waitutility=new WaitUtility();
	public EditCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//i[@class='fas fa-edit'])[4]") WebElement edit;
	@FindBy(xpath="//input[@id='category']") WebElement category;
	@FindBy(xpath="//input[@id='main_img']") WebElement choosefile;
	@FindBy(xpath="//span[@class='fas fa-trash-alt']") WebElement delete;
	@FindBy(xpath="//button[@type='submit']") WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	
	public EditCategoryPage categoryUpdate(String name)
	{
		category.clear();
		category.sendKeys(name);
		return this;
	}
	
	public EditCategoryPage deleteExistingImage()
	{
		JavascriptExecutor javaexe=(JavascriptExecutor) driver;
		javaexe.executeScript("window.scrollBy(0,1000)");
		javaexe.executeScript("arguments[0].click();",delete);
		driver.switchTo().alert().accept();
		return this;
	}
	
	public EditCategoryPage addImage()
	{
		waitutility.waitForElementtobeClicked(driver,choosefile);
		fileuploadutility.fileUploadForSendKey(choosefile,Constants.PATH);
		return this;
	}
	
	public EditCategoryPage updateClick()
	{
		JavascriptExecutor javaexe=(JavascriptExecutor) driver;
		javaexe.executeScript("window.scrollBy(0,1000)");
		javaexe.executeScript("arguments[0].click();",update);
		return this;
	}
	
	public boolean isAlertDisplayed() 
	{
		return alert.isDisplayed();
	}
	
}
