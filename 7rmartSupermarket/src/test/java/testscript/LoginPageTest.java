package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base 
{
	HomePage homepage;
  @Test(dataProvider = "credentials") 
  public void verifyUserLogin(String uname, String pwd) 
  {
	  LoginPage loginpage=new LoginPage(driver);
	  homepage=loginpage.verifySignIn(uname, pwd).signIn();
	  String expected="Dashboard | 7rmart supermarket";
	  String actual=driver.getTitle();
	  System.out.println(actual);
	  Assert.assertEquals(expected, actual,Constants.ERRORMSGLOGINPAGE);
  }
  
  @Test
  @Parameters({"username","password"})
 public void verifyUsercanLoginwithCorrectUsernameandIncorrectpwd(String username,String password)
 {
	 LoginPage loginpage=new LoginPage(driver);
	 loginpage.verifySignIn(username,password);
	 loginpage.signIn();
	  String expected="Dashboard | 7rmart supermarket";
	  String actual=driver.getTitle();
	  //System.out.println(actual);
	  Assert.assertEquals(expected, actual,Constants.ERRORMSGLOGINPAGE);
	 
 }
 
  @Test(retryAnalyzer = retry.Retry.class,groups = {"Smoke"})
  public void verifyUsercanLoginwithWrongUsernameandCorrectpwd() throws IOException
  {
 	 LoginPage loginpage=new LoginPage(driver);
	 String username=ExcelUtility.getStringData(1, 0, "LoginPage");
	 String password=ExcelUtility.getStringData(1, 1, "LoginPage");
 	 loginpage.verifySignIn(username, password);
 	 loginpage.signIn();
 	 //System.out.println("Title:" + driver.getTitle());
 	 String expected="Dashboard | 7rmart supermarket";
 	 String actual=driver.getTitle();
	 //System.out.println(actual);
	 Assert.assertEquals(expected, actual,Constants.ERRORMSGLOGINPAGE);
  }
  
  @Test(groups = {"Smoke"})
  public void verifyUsercanLoginwithWrongUsernameandWrongpwd() throws IOException
  {
 	 LoginPage loginpage=new LoginPage(driver);
	 String username=ExcelUtility.getStringData(2, 0, "LoginPage");
	 String password=ExcelUtility.getStringData(2, 1, "LoginPage");
 	  loginpage.verifySignIn(username, password);
 	  loginpage.signIn();
 	  String expected="Dashboard | 7rmart supermarket";
	  String actual=driver.getTitle();
	 // System.out.println(actual);
	  Assert.assertEquals(expected, actual,Constants.ERRORMSGLOGINPAGE);
  }
 
  @DataProvider(name="credentials")
  public Object testdata()
  {
	  Object data[][]= {{"admin","admin"},{"admin","wrongPwd"},{"wrongUname","admin"},{"wronguname","wrongpwd"}};
	  return data;
  }
}
