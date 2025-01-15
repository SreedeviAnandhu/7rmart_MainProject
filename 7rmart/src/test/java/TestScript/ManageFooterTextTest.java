package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base{
	
	@Test
	public void verifyTheUserIsAbleToUpdateTheFooterText() throws IOException
	{
		String username =  ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password =  ExcelUtilities.readStringData(1, 1, "LoginPage");
		String addressvalue = ExcelUtilities.readStringData(1, 0, "FooterText");
		String emailvalue = ExcelUtilities.readStringData(1, 1, "FooterText");
		String phonevalue = ExcelUtilities.readIntegerData(1, 2, "FooterText");
		 
		
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		ManageFooterTextPage ManageFooter = new ManageFooterTextPage(driver);
		ManageFooter.manageFooterPageClick();
		ManageFooter.actionClick();
		ManageFooter.addressClick(addressvalue);
		ManageFooter.emailClick(emailvalue);
		ManageFooter.phoneClick(phonevalue);
		ManageFooter.updateClick();
		
		Boolean value = ManageFooter.isAlertDisplayed();
		Assert.assertTrue(value,"Alert is not displayed");
		
	}
	
	@Test
	public void verifyIfTheUpdateButtonisDisplayedOrNot() throws IOException {
		
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		 
		
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		ManageFooterTextPage ManageFooter = new ManageFooterTextPage(driver);
		ManageFooter.manageFooterPageClick();
		ManageFooter.actionClick();
		
		boolean value = ManageFooter.isUpdateButtonDisplayed();
		Assert.assertTrue(value, "Update button is not displayed");
		
	}
	
	
}


