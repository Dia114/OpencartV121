package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
		public void Verify_login() {
		
		try {
			
		logger.info("***** Start  TC002_LoginTest*****");
		
		//Home Page
		HomePage hp = new HomePage(driver);
		hp.clikmyaccount();
		hp.clicklogin();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clicklogin();

		//MyaccountPage
		
		MyaccountPage macc = new MyaccountPage(driver);
		boolean targetPage =macc.isMyaccountPageExists();
		
		Assert.assertTrue(targetPage);//Assert.assertEquals(targetPage, true,"Login fail");
		
		}
		catch(Exception e) {
			
			Assert.fail();
			
		}
		
		 logger.info("****** Finish TC002_LoginTest******");
		}
	  }

