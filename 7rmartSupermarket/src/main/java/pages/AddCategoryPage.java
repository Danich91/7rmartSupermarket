package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.WaitUtility;


public class AddCategoryPage 
{
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	WaitUtility waitutility=new WaitUtility();
	public WebDriver driver;
	public AddCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Enter the Category']") WebElement entercategory;
	@FindBy(xpath="//input[@type='file']") WebElement choosefile;
	@FindBy(xpath="//button[@type='submit']") WebElement savebutton;
	@FindBy(xpath="//li[@id='134-selectable']") WebElement groups;
	@FindBy(xpath="(//input[@name='top_menu'])[1]") WebElement showtop;
	@FindBy(xpath="(//input[@name='show_home'])[1]") WebElement showleft;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	@FindBy(xpath="//label[text()='Category']") WebElement catgegorydisplay;
	
	
	public AddCategoryPage enterCategoryName(String itemname)
	{
		entercategory.sendKeys(itemname);
		return this;
	}
	
	public AddCategoryPage selectGroupClick()
	{
		groups.click();
		return this;
		
	}
	public AddCategoryPage chooseFileToUpload() throws AWTException
	{
		waitutility.waitForElementtobeClicked(driver,choosefile);
		fileuploadutility.fileUploadForSendKey(choosefile,Constants.PATH);
		return this;
	}

	
	public AddCategoryPage showTopMenuRadioClick()
	{
		JavascriptExecutor javaexe=(JavascriptExecutor) driver;
		javaexe.executeScript("window.scrollBy(0,1000)");
		javaexe.executeScript("arguments[0].click();",showtop);
		return this;
	}
	
	public AddCategoryPage showLeftRadioClick()
	{
		JavascriptExecutor javaexe=(JavascriptExecutor) driver;
		javaexe.executeScript("window.scrollBy(0,1000)");
		javaexe.executeScript("arguments[0].click();",showleft);
		return this;
		
	}
	
	public AddCategoryPage saveClick()
	{
		JavascriptExecutor javaexe=(JavascriptExecutor) driver;
		javaexe.executeScript("window.scrollBy(0,1000)");
		//javaexe.executeScript("window.scrollBy(0,-500)");
		
		javaexe.executeScript("arguments[0].click();",savebutton);
		//savebutton.click();
		return this;
	}
	
	public boolean isAlertDisplayed() 
	{
		return alert.isDisplayed();
	}
	
	public boolean isCategoryDisplayed()
	{
		return catgegorydisplay.isDisplayed();
	}
}
