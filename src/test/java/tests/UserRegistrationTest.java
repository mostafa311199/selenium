package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase
{
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 

	@Test(priority=1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegistration("ahmed", "kamal", "testdy875@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority = 2)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	
	@Test(priority = 3)
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin("test126@gmail.com", "12345678");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
