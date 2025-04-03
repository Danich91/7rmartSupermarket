package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {
	
	HomePage homepage;
  @Test
  public void verifyLogout() throws IOException
  {
	  LoginPage loginpage= new LoginPage(driver);
	  String username=ExcelUtility.getStringData(3, 0, "LoginPage");
	  String password=ExcelUtility.getStringData(3, 1, "LoginPage");
	  homepage=loginpage.verifySignIn(username, password).signIn();
	  homepage.adminClick().logoutButtonClick();
	  
	  
	   System.out.println("title:"+ driver.getTitle());
	   String expected="Login | 7rmart supermarket";
	   String actual=driver.getTitle();
	   System.out.println(actual);
	   Assert.assertEquals(expected, actual,Constants.ERRORHOMEPAGE);
	  
	  
			  
  }
}
