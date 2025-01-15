package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManageContactPage;
import utilities.ExcelUtilities;

public class ManageContactText extends Base{
	
	@Test
	public void verifyTheUserIsAbleToUpdateTheContactInformation() throws IOException
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		String phonevalue = ExcelUtilities.readIntegerData(1, 0, "ManageContact");
		String emailvalue = ExcelUtilities.readStringData(1, 1, "ManageContact");
		String addressvalue = ExcelUtilities.readStringData(1, 2, "ManageContact");
		String deliverytimeclick = ExcelUtilities.readIntegerData(1, 3, "ManageContact");
		String deliverychargeclick = ExcelUtilities.readIntegerData(1, 4, "ManageContact");
	
	
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		ManageContactPage Managecontact = new ManageContactPage(driver);
		Managecontact.manageContactClick();
		Managecontact.actionClick();
		Managecontact.phoneClick(phonevalue);
		Managecontact.emailClick(emailvalue);
		Managecontact.adressClick(addressvalue);
		Managecontact.deliveryTimeClick(deliverytimeclick);
		Managecontact.deliveryChargeClick(deliverychargeclick);
		Managecontact.updateClick();

			
		Boolean value =	Managecontact.isAlertdisplayed();
		Assert.assertTrue(value,"Alert is not displayed");
		
	}
	@Test
	public void verifyTheUpdateButtonIsDisplyedSuccessfully() throws IOException
	{
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
	
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.submitClick();
		
		ManageContactPage Managecontact = new ManageContactPage(driver);
		Managecontact.manageContactClick();
		Managecontact.actionClick();
		
		boolean isupdatebuttondisplayed = Managecontact.isUpdateButtonDisplayed();
		Assert.assertTrue(isupdatebuttondisplayed,"Alert is not displayed");

	}
}