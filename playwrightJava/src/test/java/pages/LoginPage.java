package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

	private final Page page;
	private final Locator emailTextBox;
	private final Locator passwoardTextBox;
	private final Locator loginButton;

	public LoginPage(Page page) {
		this.page = page;

		this.emailTextBox = page.locator("form").filter(new Locator.FilterOptions().setHasText("Login")).getByPlaceholder("Email Address");
		this.passwoardTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("password"));
		this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
	}

	public LoginPage enterEmail(String email) {
		emailTextBox.fill(email);
		return this;
	}

	public LoginPage enterPassword(String password) {
		passwoardTextBox.fill(password);
		return this;
	}

	public HomePage clickLogin() {
		loginButton.click();
		return new HomePage(page);
	}

}
