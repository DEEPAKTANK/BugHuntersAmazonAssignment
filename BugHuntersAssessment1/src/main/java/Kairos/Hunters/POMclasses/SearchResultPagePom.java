package Kairos.Hunters.POMclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPagePom {
@FindBy(xpath = "//div[contains(@class,'a-section a-spacing-small')][1]")
private WebElement searchResult;
@FindBy(xpath = "//a[contains(@class,'a-link-normal s-underline-text')]//span")
private List<WebElement> products;
WebDriver d;
public SearchResultPagePom(WebDriver driver) {
	d=driver;
	PageFactory.initElements(driver,this);
}
public WebElement getResult() {
	return searchResult;
}
public List<WebElement> getProducts(){
	return products;
}

}
