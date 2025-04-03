package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	HomePage homepage;
	SubCategoryPage subcategorypage;
  @Test
  public void verifySubCategoryPageisLoading() throws IOException 
  {
	  
	  LoginPage loginpage= new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  subcategorypage=homepage.moreInfoSubCategoryClick();
	  System.out.println("title" + driver.getTitle());
	  
	  String expected="List Sub Categories | 7rmart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(expected, actual,Constants.ERRORSUBCATEGORYPAGE);
  }
  
  @Test
  public void verifySubCategoryitemCanbeDeleted() throws IOException
  {
	  LoginPage loginpage= new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  subcategorypage=homepage.moreInfoSubCategoryClick().clickDelete();
	  
	  boolean isAlertDisplayed= subcategorypage.isAlertDisplayed();
	  System.out.println(isAlertDisplayed);
      Assert.assertTrue(isAlertDisplayed,Constants.ERRORSUBCATEGORYPAGE);
  }
  
}
