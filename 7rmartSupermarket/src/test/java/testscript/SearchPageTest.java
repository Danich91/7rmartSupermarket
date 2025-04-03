package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NewUserPage;
import pages.SearchPage;
import utilities.ExcelUtility;

public class SearchPageTest extends Base {
	
	HomePage homepage;
	SearchPage searchpage;
	NewUserPage newuserpage;
	AdminUserPage adminuserpage;
  @Test
  public void verifyAdminUserPageSearch() throws IOException 
  {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  String name=ExcelUtility.getStringData(1, 0, "SearchAdmin");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  adminuserpage=homepage.moreInfoClick();
	  searchpage=adminuserpage.searchClick();
	  searchpage.enterusername(name).search2Click();
	
	  
	  boolean resultnotfound=searchpage.isResultNotFoundDisplayed();
	  System.out.println(resultnotfound);
	  Assert.assertTrue(resultnotfound,Constants.ERRORSEARCHADMINPAGE);
	  
  }
}
