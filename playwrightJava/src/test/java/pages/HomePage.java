package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import io.qameta.allure.Step;

public class HomePage {

	private Page page;

	private final Locator homeMenu;
	private final Locator productMenu;
	private final Locator logoutMenu;
	private final Locator signupOrLoginMenu;
	private final Locator loggedinUserName;

	public HomePage(Page page) {
		this.page = page;
		this.homeMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home"));
		this.productMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Products"));
		this.logoutMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout"));
		this.signupOrLoginMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Signup / Login"));
		this.loggedinUserName = page.getByText("Logged in as ").first();
	}

	@Step("Click on Home menu")
	public HomePage clickOnHomeMenu() {
		homeMenu.click();
		return this;
	}

	@Step("Click on Product menu")
	public ProductPage clickOnProductMenu() {
		productMenu.click();
		return new ProductPage(page);
	}

	@Step("Click on Logout menu")
	public HomePage clickOnLogoutMenu() {
		logoutMenu.click();
		return this;
	}

	@Step("Click on Signup/Login menu")
	public LoginPage clickOnSignupOrLoginMenu() {
		signupOrLoginMenu.click();
		return new LoginPage(page);
	}

	@Step("Get logged-in username")
	public String getLoggedInUserName() {
		String UserName = loggedinUserName.textContent().trim().replace("Logged in as ", "").trim();
		return UserName;
	}

}
