package factory;

import com.microsoft.playwright.*;

public class BrowserFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;

	public Page initBrowser(String browserName) {

		playwright = Playwright.create();

		switch (browserName.toLowerCase()) {

		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;

		case "webkit":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		}

		context = browser.newContext();
		page = context.newPage();

		return page;
	}

	public void closeBrowser() {

		if (browser != null) {
			browser.close();
		}

		if (playwright != null) {
			playwright.close();
		}
	}
}