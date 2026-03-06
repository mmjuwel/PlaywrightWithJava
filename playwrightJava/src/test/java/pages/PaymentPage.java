package pages;

import com.microsoft.playwright.Page;

public class PaymentPage {
	
	private Page page;
	
	private final String nameOnCardTextBox = "[name='name_on_card']";
	private final String cardNumberTextBox = "[name='card_number']";
	private final String cvcTextBox = "[name='cvc']";
	private final String expiryMonthTextBox = "[name='expiry_month']";
	private final String expiryYearTextBox = "[name='expiry_year']";
	private final String payAndConfirmOrderButton = "#submit";
	private final String placedOrderText = ".title > b";
	
	
	

	public PaymentPage(Page page) {
		this.page = page;
	}
	
	public void enterNameOnCard(String nameOnCard) {
		page.fill(nameOnCardTextBox, nameOnCard);
	}
	
	public void enterCardNumber(String cardNumber) {
		page.fill(cardNumberTextBox, cardNumber);
	}
	
	public void enterCVC(String cvc) {
		page.fill(cvcTextBox, cvc);
	}
	
	public void enterExpiryMonth(String expiryMonth) {
		page.fill(expiryMonthTextBox, expiryMonth);
	}
	
	public void enterExpiryYear(String expiryYear) {
		page.fill(expiryYearTextBox, expiryYear);
	}
	
	public void clickPayAndConfirmOrderButton() {
		page.click(payAndConfirmOrderButton);
	}
	
	

}
