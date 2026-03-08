package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import utils.LoggerUtil;

import pages.HomePage;
import pages.LoginPage;
import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Automation Excercise - E-Commerce")
@Feature("Login Feature")
public class LoginTest extends BaseTest {

	final Logger log = LoggerUtil.getLogger(LoginTest.class);

	@DataProvider(name = "loginValidData")
	public Object[][] loginValidData() {
		return new Object[][] { { "mansurworkplace@gmail.com", "123456", "mansur" }, 
			{ "mansurworkplace@gmail.com", "1111", "mansur" }, 
			{ "mahamud@gmail.com", "123456" , "mansur"} };
	}

	@Test(dataProvider = "loginValidData")
	@Description("Test login functionality with valid credentials")
	@Severity(SeverityLevel.CRITICAL)
	public void loginTestWithValidCradentials(String username, String password, String userName) {

		LoginPage loginpage = new LoginPage(page);
		HomePage homepage = new HomePage(page);

		homepage.clickOnSignupOrLoginMenu();
		log.info("Click on Signup/Login menu");

		loginpage.enterEmail(username).enterPassword(password).clickLogin();
		String actualUsername = homepage.getLoggedInUserName();

		Assert.assertEquals(actualUsername, userName, "Logged-in username does not match!");
		log.info("Login successful, logged-in username: " + actualUsername);
	}

	@DataProvider(name = "loginInvalidData")
	@Description("Test login functionality with valid credentials")
	@Severity(SeverityLevel.NORMAL)
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
