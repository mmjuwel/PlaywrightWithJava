package pages;

import com.microsoft.playwright.Page;

public class checkoutPage {

	private Page page;
	
	private String placeOrderButton = ".check_out";
	
	public checkoutPage(Page page) {
		// TODO Auto-generated constructor stub
		this.page = page;
	}

}
