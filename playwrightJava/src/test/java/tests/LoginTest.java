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

		// page.pause();
		homepage.clickOnSignupOrLoginMenu();
		loginpage.enterEmail("mansurworkplace@gmail.com").enterPassword("123456").clickLogin();
		String actualUsername = homepage.getLoggedInUserName();

		Assert.assertEquals(actualUsername, "mansur", "Logged-in username does not match!");

	}

}
