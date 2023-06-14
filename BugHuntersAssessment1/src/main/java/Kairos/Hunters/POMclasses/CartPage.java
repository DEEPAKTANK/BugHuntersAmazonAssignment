package Kairos.Hunters.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Kairos.Hunters.Library.HuntersBrowser;





public class CartPage {
	WebDriver d;
HuntersBrowser browser=new HuntersBrowser(d);
	public CartPage(WebDriver driver) {
		d = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#nav-cart")
	private WebElement cart;
	@FindBy(xpath = "//span[@class='a-truncate-cut']")
	private WebElement productName;
	@FindBy(xpath = "//span[@class='a-size-medium sc-number-of-items']")
	private WebElement currentQty;
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']")
	private WebElement cartAmount;
	@FindBy(xpath = "//select[@name='quantity']")
	private WebElement quantity;
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	private WebElement productPrice;
	@FindBy(css = ".a-button-text.a-declarative")
	private WebElement qtyButton;

	
	public void openCart() {
		cart.click();
	}

	public String getProductName() {
		return productName.getText();
	}

	public String getCurrentQuantity() {
		return currentQty.getText();
	}

	public String getProductPrice() {
		return productPrice.getText();
	}

	public String getCartAmount() {
		return cartAmount.getText();
	}

	public void updateQuantity(String quantity) {
		qtyButton.click();
//		Reporter.log(quantity, true);
		browser.handleDropDown(this.quantity, quantity);
		
	
	}

	
}
