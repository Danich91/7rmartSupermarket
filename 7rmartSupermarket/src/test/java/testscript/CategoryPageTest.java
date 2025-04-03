package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryPageTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	CategoryPage categorypage;
  @Test
  public void verifyChangeStatusInCategoryPage() throws IOException 
  { 
	  LoginPage loginpage= new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  categorypage=homepage.moreInfoCategoryClick().statusClick();
	  boolean isAlertDisplayed= categorypage.isAlertDisplayed();
	  System.out.println(isAlertDisplayed);
      Assert.assertTrue(isAlertDisplayed,Constants.ERRORSUBCATEGORYPAGE);
  }
}
