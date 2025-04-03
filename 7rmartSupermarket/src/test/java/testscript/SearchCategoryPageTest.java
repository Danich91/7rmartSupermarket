package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchCategoryPage;
import utilities.ExcelUtility;

public class SearchCategoryPageTest extends Base {
	
	HomePage homepage;
	CategoryPage category;
	SearchCategoryPage searchcategorypage;
  @Test
  public void verifysearchForaCategory() throws IOException 
  {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  String categoryname=ExcelUtility.getStringData(1, 0, "SearchCategory");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  category=homepage.moreInfoCategoryClick();
	  searchcategorypage=category.searchCatClick();
	  searchcategorypage.enterCategory(categoryname).searchCat();
	  
	  boolean resultnotfound=searchcategorypage.isResultNotFoundDisplayed();
	  System.out.println(resultnotfound);
	  Assert.assertTrue(resultnotfound,Constants.ERRORSEARCHCATEGORYPAGE);
	  
  }
}
