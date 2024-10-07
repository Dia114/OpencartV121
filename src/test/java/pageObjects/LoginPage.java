package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{
	
//Contractor
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//locator
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']") 
	WebElement btnlogin;
	
	
	//action
	public void setEmail(String email) {
		
		txtEmailAddress.sendKeys(email);
		}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clicklogin() {
		btnlogin.click();
	}
	
	
}
