package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import utilities.ExcelUtilities;

public class HomeTest extends Base{
	
	@Test(retryAnalyzer= retry.Retry.class,description = "Testcase used to Logout The HomePage")
	public void verifyTheUserIsAbleToLogoutTheHomePage() throws IOException
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		HomePage home = new HomePage(driver);
		home.adminClick();
		home.logoutClick();
		
		boolean value = home.isHomePageDisplayed();
		Assert.assertTrue(value,"Alert is not displayed");

	}
}
