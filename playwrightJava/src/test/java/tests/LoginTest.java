package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;

public class LoginTest extends BaseTest {

	
	@Test
	public void loginTestWithValidCradentials() {
		
		LoginPage loginpage = new LoginPage(page);
		HomePage homepage = new HomePage(page);
		
		page.navigate("https://automationexercise.com/");
		
		homepage.clickOnSignupOrLoginMenu();
		loginpage.enterEmail("mansurworkplace@gmail.com");
		loginpage.enterPassword("123456");
		loginpage.clickLoginButton();
		
		loginpage
        .enterEmail("admin")
        .enterPassword("password")
        .clickLoginButton();
		
		String loggedInUserName = homepage.getLoggedInUserName();
		System.out.println("Logged in user name: " + loggedInUserName);
		Assert.assertEquals(loggedInUserName, "Mansur");
		
		
	}
	
	

}
