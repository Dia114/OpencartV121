package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;

public class TC001_AccountRegisterationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	void verify_account_registeration() {
		
		try {
			
		logger.info("********* Starting  TC001_AccountRegisterationTest*********");
		
		HomePage hp = new HomePage(driver);
		hp.clikmyaccount();
		logger.info(" Click on MyAccount Link ");
		hp.clickregister();
		logger.info(" Click on Register Link  ");
		
		AccountRegisterationPage regpage = new AccountRegisterationPage(driver);
		logger.info(" Providing Costumer Info  ");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password =  randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
	
		regpage.setPrivacyPolicy();
		regpage.clickContinue();	
		logger.info(" Validating Expected Message ");
		String confMsg = regpage.getConfirmationMsg();
		
		if(confMsg.equals("Your Account Has Been Created!")){
			
			Assert.assertTrue(true);
		}
		else {
						
			logger.error( "Test failed.." );
			logger.debug("Debug Logg...");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confMsg, "Your Account Has Been Created!!!!");
		}
		catch(Exception e) {
			
					Assert.fail();
		}
		
		logger.info("****** Finished   TC001_AccountRegisterationTest****");
	}
	
	
	
	
}
