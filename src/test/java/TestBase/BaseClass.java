package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {

	public static WebDriver driver;
	public Logger logger ;//Log4j
	public Properties p;
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		
		FileReader file = new FileReader("./src//test//resources//config.Properties");
		p = new Properties();
		p.load(file);
		
		logger =  LogManager.getLogger(this.getClass());// Log4j
		
		if(p.getProperty("execuation_env").equals("remote")) {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			
			else if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching os");
				return;
			}
			
			//browser 
			switch(br.toLowerCase()) 
			{
				case "chrome": cap.setBrowserName("chrome");break;
				case "firefox": cap.setBrowserName("firefox"); break;			
				case "edge": cap.setBrowserName("MicrosoftEdge");break;
				default:System.out.println("No matching Browser"); 
				return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
			
		
		if(p.getProperty("execuation_env").equals("local")) {
			
				switch(br.toLowerCase())
				{
				
				case "chrome":driver = new ChromeDriver(); break;
				case "edge": driver = new EdgeDriver();break;
				case "firefox" :driver =new FirefoxDriver();break;
				default:System.out.println("invalid Browser Name"); return;
			  }
				
			}
				
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL2"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
		public void tearDown() {
		driver.quit();
	}
	
	
	
// random String
	public String randomString() {
		
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return  generateString;
	}
	
	public String randomNumber() {
		String generatNumber = RandomStringUtils.randomNumeric(10);
		return generatNumber;
	}
	
	public String randomAlphaNumeric() {
		
		String generateString = RandomStringUtils.randomAlphabetic(4);
		String generatNumber = RandomStringUtils.randomNumeric(3);
		return (generateString+"@"+generatNumber);
	}
	
	
	public String cuptureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		TakesScreenshot takesScreenshot =  (TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
}


