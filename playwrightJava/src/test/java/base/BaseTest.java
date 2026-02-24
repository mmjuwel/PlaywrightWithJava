package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

	protected Playwright playwright;
	protected Browser browser;
	protected Page page;
	
	@org.testng.annotations.BeforeMethod
	public void setup() {
		System.out.println("This is the setup method");
		
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		page = browser.newPage();
	}
	
	
	@org.testng.annotations.AfterMethod
	public void tearDown() {
		System.out.println("This is the tear down method");
		if (playwright != null) {playwright.close();}
		if (browser != null) {browser.close();}
	}
}
