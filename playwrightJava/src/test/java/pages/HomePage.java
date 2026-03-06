package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

	private Page page;
	
	private final Locator homeMenu;
	private final Locator productMenu;
	private final Locator logoutMenu ;
	private final Locator signupOrLoginMenu ;
	private final Locator loggedinUserName ;
	
	 


	
	public HomePage(Page page) {
		this.page = page;
		this.homeMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home"));
		this.productMenu =  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Products"));
		this.logoutMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logout"));
		this.signupOrLoginMenu = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Signup / Login"));
		this.loggedinUserName = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Logged in as"));
	}

	
	public HomePage clickOnHomeMenu() {
		homeMenu.click();
		return this;
	}
	public ProductPage clickOnProductMenu() {
		productMenu.click();
		return new ProductPage(page);
	}
	public HomePage clickOnLogoutMenu() {
		logoutMenu.click();
		return this;
	}
	
	public LoginPage clickOnSignupOrLoginMenu() {
		signupOrLoginMenu.click();
		return new LoginPage(page);
	}
	
	public String getLoggedInUserName() {
		return loggedinUserName.textContent().replace("Logged in as ", "").trim();
	}
}
