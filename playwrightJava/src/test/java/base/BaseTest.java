package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.microsoft.playwright.Page;
import factory.BrowserFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ByteArrayInputStream;

import utils.ConfigReader;

public class BaseTest {

	protected Page page;
	protected BrowserFactory browserFactory;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	@Step("Open broswer and load the website")
	public void setup(String browser) {

		browserFactory = new BrowserFactory();

		page = browserFactory.initBrowser(browser);
		
		page.navigate(ConfigReader.getProperty("baseURL"));

	}

	@AfterMethod(alwaysRun = true)
	@Step("Close the browser and capture screenshot")
	public void tearDown() throws FileNotFoundException {

		
		byte[] screenshot = page.screenshot();

	    Allure.addAttachment(
	        "Screenshot at last state of the test",
	        new ByteArrayInputStream(screenshot)
	    );

	   

	    Allure.addAttachment(
	        "Execution Log",
	        new FileInputStream("logs/test-automation-Ecom.log")
	    );
		
		if (browserFactory != null) {
			browserFactory.closeBrowser();
		}

	}

}
