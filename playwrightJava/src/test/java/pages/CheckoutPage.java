package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {

	private Page page;
	
	private String placeOrderButton = ".check_out";
	
	public CheckoutPage(Page page) {
		// TODO Auto-generated constructor stub
		this.page = page;
	}

}
