package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Trash {
	public static void main(String args[]) {

	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//span[normalize-space()=\"My Account\"]")).click();

	driver.findElement(By.linkText("Login")).click();
	
	}
		
		
		
	
	
	
}
