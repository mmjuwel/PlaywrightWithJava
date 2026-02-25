package pages;

import com.microsoft.playwright.Page;

public class LogInPage {

	private Page page;

	private final String emailTextBox = "[data-qa='login-email']";
	private final String passwoardTextBox = "[name='password']";
	private final String loginButton = "[data-qa='login-button']";
	
	
	public LogInPage(Page page) {
		// TODO Auto-generated constructor stub
		this.page = page;
	}
	
	public void enterEmail(String email) {
		page.fill(emailTextBox, email);
	}
	
	public void enterPassword(String password) {
		page.fill(passwoardTextBox, password);
	}
	
	public void clickLoginButton() {
		page.click(loginButton);
	}
	
	
	

}
