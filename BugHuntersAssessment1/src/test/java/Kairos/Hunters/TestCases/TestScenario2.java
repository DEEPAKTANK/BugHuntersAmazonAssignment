package Kairos.Hunters.TestCases;

import org.testng.annotations.Test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Kairos.Hunters.BaseClass.BaseClass;
import Kairos.Hunters.POMclasses.LoginPOM;
import Kairos.Hunters.POMclasses.SearchResultPagePom;

public class TestScenario2 extends BaseClass{
	
	@Test
	public void searchProduct() {
		 LoginPOM login=new LoginPOM(driver);
		 SearchResultPagePom result=new SearchResultPagePom(driver);
		 login.signIN(data.fetchProperty("username"), data.fetchProperty("password"));
		 home.searchProduct(data.fetchProperty("product"));
		if( result.getResult().isDisplayed())
		{
			Reporter.log("Result page is displayed ",true);
			Reporter.log("Result message-"+result.getResult().getText(),true);	
		}
		
	}

}
