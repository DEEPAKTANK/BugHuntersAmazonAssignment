package Kairos.Hunters.TestCases;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Kairos.Hunters.BaseClass.BaseClass;
import Kairos.Hunters.POMclasses.HomePagePOM;
import Kairos.Hunters.POMclasses.LoginPOM;
import Kairos.Hunters.POMclasses.ProductpagePOM;
import Kairos.Hunters.POMclasses.SearchResultPagePom;

public class TestScenario3 extends BaseClass{
	
	@Test
	public void addToCart() {
		 LoginPOM login=new LoginPOM(driver);
		 SearchResultPagePom result=new SearchResultPagePom(driver);
		 HomePagePOM home=new HomePagePOM(driver);
		 ProductpagePOM product=new ProductpagePOM(driver);
		 log.info("Third scenario started");
		 login.signIN(data.fetchProperty("username"), data.fetchProperty("password"));
		 String productName=data.fetchProperty("product");
		 home.searchProduct(productName);
		 log.info(productName+" is searched");

		 List<WebElement> products=result.getProducts();
		 for(WebElement i:products) {
			 String text=i.getText();
			 if(text.contains(productName)) {
				 
				 i.click();break;
				 
			 }
		 }
	     browser.switchToWindow();
		 log.info("Window switched");
		 Reporter.log("----------------------------",true);
	     Reporter.log("Product details:-",true);
	     List<WebElement> productDetails=product.getProductDetails();
	     for(WebElement ele:productDetails) {
	    	 String data=ele.getText();
	    	 Reporter.log(data,true);
	     }
	     product.clickAddToCart();
	     browser.waitForElementToBeDisplayed(product.addedtocart());
	     log.info(productName+" added to cart.");
	     if(product.addedtocart().isDisplayed()) {
	    	 Reporter.log("----------------------------",true);
	    	 Reporter.log(productName+" is successfully added to cart",true);
	     }
	     browser.closeWindow();
	     browser.switchtoDefaultWindow();     
	}

}
