package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

	protected Playwright playwright;
	protected Browser browser;
	protected Page page;
	
	public void setup() {
		System.out.println("This is the setup method");
	}
	
	
	public void tearDown() {
		System.out.println("This is the tear down method");
	}
}
