package Kairos.Hunters.POMclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductpagePOM {
	
	WebDriver d;
	public ProductpagePOM(WebDriver driver) {
		d=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css = "input[name='submit.add-to-cart']")
	private WebElement addtoCart;
	@FindBy(xpath = "//div[@id='feature-bullets']/ul/li/span")
	private List<WebElement> productDetails;
	@FindBy(xpath =  "//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private WebElement addedToCart;
	
	
	public WebElement addedtocart() {
		return addedToCart;
	}
	
	public List<WebElement> getProductDetails() {
		
		return productDetails;
	}
	public void clickAddToCart() {
		addtoCart.click();
	}
	

}
