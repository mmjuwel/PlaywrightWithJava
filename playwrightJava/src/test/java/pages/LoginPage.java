package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class LoginPage {

	private final Page page;
	private final Locator emailTextBox;
	private final Locator passwoardTextBox;
	private final Locator loginButton;
	private final Locator emailOrPaaIncorrectMsg;

	public LoginPage(Page page) {
		this.page = page;

		this.emailTextBox = page.locator("form").filter(new Locator.FilterOptions().setHasText("Login"))
				.getByPlaceholder("Email Address");
		this.passwoardTextBox = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("password"));
		this.loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
		this.emailOrPaaIncorrectMsg = page.getByText("Your email or password is").first();

	}

	@Step("Enter username: {0}")
	public LoginPage enterEmail(String email) {
		emailTextBox.fill(email);
		return this;
	}

	@Step("Enter password: {0}")
	public LoginPage enterPassword(String password) {
		passwoardTextBox.fill(password);
		return this;
	}

	@Step("Click login button")
	public HomePage clickLogin() {
		loginButton.click();
		return new HomePage(page);
	}

	@Step("Get login failed message")
	public String getLoginFailedMessage() {
		String message = emailOrPaaIncorrectMsg.textContent();
		return message != null ? message.trim() : "";
	}

}
