package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserPageTest extends Base {
	
	HomePage homepage;
	AdminUserPage adminuserpage;
  @Test
  public void verifyAdminUserResetButtonClick() throws IOException 
  {
	  LoginPage loginpage= new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  String uname=ExcelUtility.getStringData(1, 0, "AdminUserPage");
	  String type=ExcelUtility.getStringData(1, 1, "AdminUserPage");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  adminuserpage=homepage.moreInfoClick().uname(uname).usertype(1).resetClick();
	  
	  String expected="Admin Users | 7rmart supermarket";
	  String actual=driver.getTitle();
	  System.out.println(actual);
	  Assert.assertEquals(expected, actual,Constants.ERRORADMINUSERPAGE);
  }
}
