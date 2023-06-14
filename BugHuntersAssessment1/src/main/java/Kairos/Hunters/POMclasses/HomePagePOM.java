package Kairos.Hunters.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Kairos.Hunters.Library.HuntersBrowser;

public class HomePagePOM {

	WebDriver d;
	HuntersBrowser browser=new HuntersBrowser(d);
	public HomePagePOM(WebDriver driver) {
		d = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	private WebElement helloSignIN;
	@FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
	private WebElement hamburgerSign;
	@FindBy(xpath = "//div[@id='hmenu-customer-name']/b")
	private WebElement username;
	@FindBy(xpath = "//div[@class='nav-sprite hmenu-close-icon']")
	private WebElement cross;
	@FindBy(css = "input[name='field-keywords']")
	private WebElement searchBox;
	@FindBy(css = "input[type='submit']")
	private WebElement searchButton;
	@FindBy(linkText =  "Sign Out")
	private WebElement signOut;
	@FindBy(xpath = "//span[@class='nav-cart-count nav-cart-1 nav-progressive-attribute nav-progressive-content']")
	private WebElement cart;
	
	public void moveToHelloSignIN() {
		   browser.mouseHoverOn(d, helloSignIN);
		   
		}

	public void clickCart() {
		cart.click();
	}

	public void clickHamburgerSign() {
		this.hamburgerSign.click();
	}

	public String getUsername() {
		return username.getText();

	}

	public void enterTextToSearch(String text) {
		searchBox.sendKeys(text);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void searchProduct(String product) {
		enterTextToSearch(product);
		clickSearchButton();
	}

	public void signOut() {
		clickHamburgerSign();
		signOutButton().click();
	}

	public WebElement signOutButton() {
		return signOut;
	}
	public void clickCrossSign() {
		cross.click();
	}

}
