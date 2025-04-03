package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AddSubCategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class AddSubCategoryPageTest extends Base{
	HomePage homepage;
	SubCategoryPage subcategorypage;
	AddSubCategoryPage addsubcategorypage;
  @Test
  public void verifyUsercanAddSubCategory() throws IOException 
  {
	  
	  LoginPage loginpage= new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  String category=ExcelUtility.getStringData(1, 0, "NewSubCategory");
	  String subcategory=ExcelUtility.getStringData(1, 1, "NewSubCategory");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  subcategorypage=homepage.moreInfoSubCategoryClick();
	  addsubcategorypage=subcategorypage.newSubcategoryClick();
	  addsubcategorypage.categorySelection(category).enterSubCategory(subcategory).chooseImage().saveClick();
	  
	  boolean isAlertDisplayed= addsubcategorypage.isAlertDisplayed();
	  System.out.println(isAlertDisplayed);
      Assert.assertTrue(isAlertDisplayed,Constants.ERRORADDSUBCATEGORYPAGE);
      
  }
}
