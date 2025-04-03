package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AddCategoryPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AddCategoryPageTest extends Base {
	
	HomePage homepage;
	CategoryPage categorypage;
	AddCategoryPage addcategorypage;
	FakerUtility fakerutility=new FakerUtility();
	
	@Test
	public void verifyNewButton() throws IOException
	{
	 LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  categorypage=homepage.moreInfoCategoryClick();
	  addcategorypage=categorypage.newCategoryClick();
	  boolean categorydisplayed=addcategorypage.isCategoryDisplayed();
	  Assert.assertTrue(categorydisplayed,Constants.ERRORNEWCATEGORYPAGE);
	}
	
  @Test
  public void verifyUserCanAddaNewCategory() throws AWTException, IOException 
  {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  //String categoryname=ExcelUtility.getStringData(1, 0, "AddCategory");
	  String categoryname=fakerutility.getFakeCategoryName();
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  categorypage=homepage.moreInfoCategoryClick();
	  addcategorypage=categorypage.newCategoryClick();
	  addcategorypage.enterCategoryName(categoryname).selectGroupClick().chooseFileToUpload().showLeftRadioClick().showTopMenuRadioClick().saveClick();

	  boolean AlertDisplayed= addcategorypage.isAlertDisplayed();
      Assert.assertTrue(AlertDisplayed,Constants.ERRORCATEGORYPAGE);
 }
}
