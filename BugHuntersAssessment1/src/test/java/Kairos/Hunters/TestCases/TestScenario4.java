package Kairos.Hunters.TestCases;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Kairos.Hunters.BaseClass.BaseClass;
import Kairos.Hunters.POMclasses.CartPage;
import Kairos.Hunters.POMclasses.LoginPOM;

public class TestScenario4 extends BaseClass {
	@Test
	public void viewAndEditCart() {
		log.info("Scenario 4 Started");
		CartPage cart = new CartPage(driver);
		LoginPOM login = new LoginPOM(driver);
		login.signIN(data.fetchProperty("username"), data.fetchProperty("password"));
		log.info("Signin");

		cart.openCart();
		log.info("Cart is opened");
		String actualProduct = cart.getProductName();
		String expectedProduct=data.fetchProperty("product");
		if(actualProduct.contains(expectedProduct)) {
			Reporter.log("Product name validation successfull.",true);
			log.info("Name validation successfull");
		}
		String actualPrice = cart.getProductPrice();
		String expectedPrice=data.fetchProperty("price");
		if(actualPrice.contains(expectedPrice)) {
			Reporter.log("Product Price- "+actualPrice,true);
			log.info("Price validation successfull");
		}
		
		Reporter.log("Original quantity- "+cart.getCurrentQuantity(),true);
		cart.updateQuantity(data.fetchProperty("setQuantity"));
		log.info("Quantity updated");
		
		Reporter.log("Updated quantity- "+cart.getCurrentQuantity(),true);
		log.info("Details are validated");
		Reporter.log("Cart Total - "+cart.getCartAmount(),true);
		log.info("Details are validated");


	}

}
