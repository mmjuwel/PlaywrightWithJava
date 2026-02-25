package pages;

import com.microsoft.playwright.Page;

public class ProductPage {

	private Page page;

	private final String searchBox = "#search_product";
	private final String searchButton = "#submit_search";
	private final String addToCartButton = ".single-products > div > div > .btn";
	private final String viewCartButton = "[href='/view_cart']>u";
	private final String continueShoppingButton = ".modal-footer>.btn-success";
	

	public ProductPage(Page page) {
		this.page = page;
	}
	
	public void searchForProduct(String productName) {
		page.fill(searchBox, productName);
		page.click(searchButton);
	}
	
	public void addFirstProductToCart() {
		page.click(addToCartButton);
	}
	
	public void viewCart() {
		page.click(viewCartButton);
	}
	
	public void continueShopping() {
		page.click(continueShoppingButton);
	}

}
