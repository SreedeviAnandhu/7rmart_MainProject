package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import Pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base{
//	@DataProvider(name = "credentials")
	public Object[][] testData(){
		Object data[][] = {{"admin","admin"},{"admin","hello"},{"srree","admin"}};
		return data;
	}
	
	@Test //(dataProvider = "credentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
	
  /*   String username= "admin";
     String password= "admin";
*/		
	String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
	String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		
	
	LoginPage loginpage =new LoginPage(driver); 
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.submitClick();
	
	boolean isHomePageLoded = loginpage.isDashBoardDisplayed();
	Assert.assertTrue(isHomePageLoded);

    }
	
	@Test
	@Parameters({"username","password"})
	public void verifyTheUserIsAbleToLoginWithIncorrectPassword(String username,String password) 
	{
	//	String username = "admin";
	//	String password = "hello";
		
	//	String username = ExcelUtilities.readStringData(2, 0, "LoginPage");
	//	String password = ExcelUtilities.readStringData(2, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		
		boolean isalertdisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed);
		
	}
	@Test
	public void verifyTheUserIsAbleToLoginIncorrectUsername() throws IOException 
	{
	//	String username = "anupama";
	//	String password ="admin";
		
		String username = ExcelUtilities.readStringData(3, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(3, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		boolean isalertdisplayedd = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayedd);
		
	}
	@Test
	public void verifyTheUserIsAbleToLoginWithIncorrectUsernameAndPassword() throws IOException
	{
	//	String username ="anusree";
	//	String password ="anupama";
		
		String username = ExcelUtilities.readStringData(4, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(4, 1, "LoginPage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		boolean isalertdisplayeded = loginpage.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayeded);
	}
}
