package Kairos.Hunters.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM extends HomePagePOM {
	WebDriver d;
	//HomePagePOM home=new HomePagePOM(d);
	public LoginPOM(WebDriver driver) {
		super(driver);
		d=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(linkText  = "Sign in securely")
	private WebElement signInSecurely;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement email_phone;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	@FindBy(xpath = "//span[text()='Sign in']")
	private WebElement signInButton;
	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signInSubmit;
	
	

	public void setEmail_phone(String email_phone) {
		this.email_phone.sendKeys(email_phone);
	}


	public void clickContinueButton() {
		this.continueButton.click();
	}


	public void setPassword(String password) {
		this.password.sendKeys(password);;
	}


	public void clickSignInSubmit() {
		this.signInSubmit.click();
	}


	public void signIN(String emailOrPhn,String password) {
		moveToHelloSignIN();
		
		signInButton.click();
		setEmail_phone(emailOrPhn);
		clickContinueButton();
		setPassword(password);
		clickSignInSubmit();	
	}
	
	

}
