package base;

import javax.naming.Context;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

	protected Playwright playwright;
	protected Context context;
	protected Browser browser;
	protected Page page;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		System.out.println("This is the setup method");

		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		page = browser.newPage();

		page.navigate("https://automationexercise.com/");

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		System.out.println("This is the tear down method");

		if (page != null)
			page.close();
		if (browser != null)
			browser.close();
		if (playwright != null)
			playwright.close();
	}
}
