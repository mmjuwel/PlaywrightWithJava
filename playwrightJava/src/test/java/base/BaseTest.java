package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.microsoft.playwright.Page;
import factory.BrowserFactory;
import utils.ConfigReader;

public class BaseTest {

	protected Page page;
	protected BrowserFactory browserFactory;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(String browser) {

		browserFactory = new BrowserFactory();

		page = browserFactory.initBrowser(browser);

		page.navigate(ConfigReader.getProperty("baseURL"));

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		if (browserFactory != null) {
			browserFactory.closeBrowser();
		}

	}

}
