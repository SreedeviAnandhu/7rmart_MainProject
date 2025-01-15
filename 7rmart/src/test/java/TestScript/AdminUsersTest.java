package TestScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;


public class AdminUsersTest extends Base{
	
	@Test
	public void verifyTheUserIsAbleToCreateAAdminUser() throws IOException {
		
		
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		
	//	String usernamevalue = ExcelUtilities.readStringData(1, 0, "AdminUser");
	//	String passwordvalue = ExcelUtilities.readStringData(1, 1, "AdminUser");
		
		
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuser.adminUserClick();
		adminuser.newClick();
		
		FakerUtility fakerutility = new FakerUtility();
		String admin = fakerutility.generateName();
		String adminpassword = fakerutility.generatePassword();
		
		adminuser.userNameClick(admin);
		adminuser.passWordClick(adminpassword);
		adminuser.selectClick();
		adminuser.saveClick();
		
		boolean isalertdisplayed =adminuser.isAlertDisplayed();
		Assert.assertTrue(isalertdisplayed,"execution failed");
		
	}
	
	@Test
    public void verifyTheUserIsAbleToDeleteTheAdminUserDetails() throws IOException {
		
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		AdminUsersPage adminuser = new AdminUsersPage(driver);
		adminuser.adminUserClick();
		adminuser.deleteClick();
		
		boolean alertdisplayed = adminuser.isAlertDisplayeed();
		Assert.assertTrue(alertdisplayed,"Alert is not displayed");
		
		
	}
	
	

}
