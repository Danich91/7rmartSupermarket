package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.EditCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class EditCategoryPageTest extends Base{
	
	HomePage homepage;
	EditCategoryPage editcategorypage;
  @Test
  public void verifyEditisWorkingInCategoryPage() throws IOException 
  {
	  
	  LoginPage loginpage= new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  String catname=ExcelUtility.getStringData(1, 0, "AddCategory");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  editcategorypage=homepage.moreInfoCategoryClick().editClick().deleteExistingImage().addImage().categoryUpdate(catname).updateClick();
	  
	  boolean isAlertDisplayed= editcategorypage.isAlertDisplayed();
	  System.out.println(isAlertDisplayed);
      Assert.assertTrue(isAlertDisplayed,Constants.ERROREDITCATEGORYPAGE);
	 
  }
  
}
