package pages;

import com.microsoft.playwright.Page;

public class HomePgae {

	private Page page;
	
	private final String homeMenu = ".navbar-nav [href='/']";
	private final String productMenu = "[href='/products']";
	private final String logoutMenu = "[href='/logout']";
	private final String signupOrLoginMenu = "[href='/login']";

	
	public HomePgae(Page page) {
		this.page = page;
	}

	
	public void clickOnHomeMenu() {
		page.click(homeMenu);
	}
	public void clickOnProductMenu() {
		page.click(productMenu);
	}
	public void clickOnLogoutMenu() {
		page.click(logoutMenu);
	}
	public void clickOnSignupOrLoginMenu() {
		page.click(signupOrLoginMenu);
	}
}
