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

public class NewUserPageTest extends Base {
	
	HomePage homepage;
	AdminUserPage adminuserpage;
	NewUserPage newuserpage;
  @Test
  public void verifycreateNewUserPage() throws IOException 
  {
	  
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  String uname=ExcelUtility.getStringData(2, 0, "NewUserPage");
	  String pwd=ExcelUtility.getStringData(2, 1, "NewUserPage");
	  String usertype=ExcelUtility.getStringData(2, 2, "NewUserPage");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  adminuserpage=homepage.moreInfoClick();
	  newuserpage= adminuserpage.newButtonClick();
	  newuserpage.enterUsernamePassword(uname, pwd).usertypeSelection(usertype).saveClick();
	  
	  boolean isAlertDisplayed= newuserpage.isAlertDisplayed();
	  System.out.println(isAlertDisplayed);
      Assert.assertTrue(isAlertDisplayed,Constants.ERRORNEWUSERPAGE);
      
	  
	  
	  
  }
}
