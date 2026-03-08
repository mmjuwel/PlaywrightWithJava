package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;

public class LoginTest extends BaseTest {

	@DataProvider(name = "loginValidData")
	public Object[][] loginValidData() {
		return new Object[][] { { "mansurworkplace@gmail.com", "123456" }, { "mansurworkplace@gmail.com", "123456" } };
	}

	@Test(dataProvider = "loginValidData")
	public void loginTestWithValidCradentials(String username, String password) {

		LoginPage loginpage = new LoginPage(page);
		HomePage homepage = new HomePage(page);

		homepage.clickOnSignupOrLoginMenu();
		loginpage.enterEmail(username).enterPassword(password).clickLogin();
		String actualUsername = homepage.getLoggedInUserName();

		Assert.assertEquals(actualUsername, "mansur", "Logged-in username does not match!");
	}

	@DataProvider(name = "loginInvalidData")
	public Object[][] loginInvalidData() {
		return new Object[][] { { "mansurworkplace@gmail.com", "121212" }, { "mansurworkplace@yahoo.com", "123456" } };
	}

	@Test(dataProvider = "loginInvalidData")
	public void loginTestWithInvalidCradentials(String username, String password) {

		LoginPage loginpage = new LoginPage(page);
		HomePage homepage = new HomePage(page);

		homepage.clickOnSignupOrLoginMenu();
		loginpage.enterEmail(username).enterPassword(password).clickLogin();
		String failedMessage = loginpage.getLoginFailedMessage();

		Assert.assertEquals(failedMessage, "Your email or password is incorrect!",
				"Login failed message does not match!");
	}

}
