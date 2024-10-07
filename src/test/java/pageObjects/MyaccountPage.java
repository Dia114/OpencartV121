package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BaseClass;

public class MyaccountPage extends BasePage {
	
	public MyaccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//locator
	@FindBy(xpath="//h2[normalize-space()='My Account']") // MyAccount Page Heading
	WebElement msgHeading;
	
	@FindBy(linkText="Logout") 
	WebElement linkLogout;
		
	//action
	public boolean isMyaccountPageExists() {
		
		try{
				return msgHeading.isDisplayed();
		   }
		
		catch(Exception e) 
		{
			return false;
		}
	    }
	
	public void ClickLogout() {
		
		linkLogout.click();
	}
}
