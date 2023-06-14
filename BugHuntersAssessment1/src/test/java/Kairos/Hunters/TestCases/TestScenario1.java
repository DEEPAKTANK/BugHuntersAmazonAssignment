package Kairos.Hunters.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Kairos.Hunters.BaseClass.BaseClass;
import Kairos.Hunters.POMclasses.HomePagePOM;
import Kairos.Hunters.POMclasses.LoginPOM;

public class TestScenario1 extends BaseClass{
	@Test
	public void login() {
		log.info("Login Start.");
	    HomePagePOM home=new HomePagePOM(driver);
	    LoginPOM login=new LoginPOM(driver);
	    String currentTitle1=browser.presentTitle();
		String expectedTitle1="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		AssertJUnit.assertEquals(currentTitle1, expectedTitle1);
		Reporter.log("Title validation Successful",true);
	    login.signIN(data.fetchProperty("username"), data.fetchProperty("password"));
		log.info("Login Successful.");	
		home.clickHamburgerSign();
		Reporter.log("Login Validation Displayed message:- "+home.getUsername(), true);
		log.info("Message displayed- "+home.getUsername());
		home.clickCrossSign();
		

	}

}
