package pages;

import com.microsoft.playwright.Page;

public class CartPage {

	private Page page;
	
	private final String cartItem = "[href='/product_details/4']";
	private final String cartTotalAmount = ".cart_total_price";
	private final String procedeToCheckoutButton = ".check_out";
	private final String singupOrLoginButton = "[href='/login']>u";
	
	public CartPage(Page page) {
		this.page = page;
	}
	
	public String getCartItem() {
		return page.textContent(cartItem);
	}
	
	public String getCartTotalAmount() {
		return page.textContent(cartTotalAmount);
	}
	
	public void clickOnProcedeToCheckoutButton() {
		page.click(procedeToCheckoutButton);
	}
	
	public void clickOnSingupOrLoginButton() {
		page.click(singupOrLoginButton);
	}

}
