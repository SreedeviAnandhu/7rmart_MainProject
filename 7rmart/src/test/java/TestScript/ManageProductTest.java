package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageProductPage;
import utilities.ExcelUtilities;

public class ManageProductTest extends Base{
	
	@Test
	public void verifyTheUserIsAbleToDeleteTheProduct() throws IOException
	{
	
	String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
	String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.submitClick();

	ManageProductPage manage = new ManageProductPage(driver);
	manage.manageProductClick();
	manage.deleteClick();
	
	Boolean isalertdisplayed = manage.isAlertDisplayed();
	Assert.assertTrue(isalertdisplayed,"Alert is not displayed");
	
	
	}
}
