package Kairos.Hunters.BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import Kairos.Hunters.Library.DataUtility;
import Kairos.Hunters.Library.HuntersBrowser;
import Kairos.Hunters.Library.LoggerClass;
import Kairos.Hunters.POMclasses.HomePagePOM;

@Listeners(Kairos.Hunters.Library.ListenerUtility.class)
public class BaseClass {
	public static WebDriver driver;
	public HuntersBrowser browser = new HuntersBrowser(driver);
	protected LoggerClass log = new LoggerClass();
	protected DataUtility data = new DataUtility();
    protected HomePagePOM home=null;


    @Parameters("Browser")
	@BeforeClass
	public void openBrowser(String Browser) {
		driver = browser.openBrowser(Browser);
		log.info(Browser+" is opened.");
		home=new HomePagePOM(driver);

	}

	@BeforeMethod
	public void openAmazon() {
		browser.maximiseWindow(driver);	
		browser.navigateURL(data.fetchProperty("BaseURL"));
		browser.waitForElementsToLoadInDOM(driver);
		
	}


	@AfterMethod
	public void logOut() {
		log.info("Logout");
		home.signOut();
		String currentTitle2=browser.presentTitle();
		String expectedTitle2="Amazon Sign In";
		AssertJUnit.assertEquals(currentTitle2, expectedTitle2);
		Reporter.log("Title validation Successful",true);
		Reporter.log("LogOut Successful",true);
		log.info("Logout successful");

	}

	@AfterClass
	public void closeBrowser() {
		browser.terminate();
		log.info("Browser is Closed.");

	}
}
