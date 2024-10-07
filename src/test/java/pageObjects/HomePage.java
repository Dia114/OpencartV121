package pageObjects;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//Contractor
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locator
	@FindBy(xpath="//span[normalize-space()=\"My Account\"]")
	WebElement linkmyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") 
	WebElement linkregester;
	
	@FindBy(linkText="Login") 
	WebElement linklogin;

	//Action methods

	public void clikmyaccount() {
		
		linkmyaccount.click();
	}
	
	public void clickregister() {
		linkregester.click();
	}
	public void clicklogin() {
		linklogin.click();
	}
}

