package testCases;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import utilities.DataProviders;

  public class TC003_LoginDDT extends BaseClass{
	
	 @Test(dataProvider ="LoginData",dataProviderClass=DataProviders.class ,groups="Datadriven")
	 public void Verify_loginDDT(String email,String pwd,String exp) {
		
	 logger.info("***** Start  TC002_LoginTest*****");
	 
	 try {
	 //Home Page
     HomePage hp = new HomePage(driver);
     hp.clikmyaccount();
	 hp.clicklogin();	
				
	 //LoginPage
	 LoginPage lp = new LoginPage(driver);
     lp.setEmail(email);
	 lp.setPassword(pwd);
	 lp.clicklogin();

	 //MyaccountPage
	 MyaccountPage macc = new MyaccountPage(driver);
	 boolean targetPage =macc.isMyaccountPageExists();
		
/* Data is valid - Login Success -test pass - logout 
  	               Login Failed  - test fail
Data is invalid - login success - test fail - logout
  					login failed - test pass
*/    
	if(exp.equalsIgnoreCase("valid")) // data is valid
	{		
		if(targetPage == true){			//Login is successful 
			
			macc.ClickLogout();
			Assert.assertTrue(true);		
		}
	}
	else 
	{
		Assert.assertTrue(false);
	}
	
	if(exp.equalsIgnoreCase("invalid")) {
		
		if(targetPage == true)
		{   
			macc.ClickLogout();
			Assert.assertTrue(false);
		}
		else 
		{
			Assert.assertTrue(true);
	    }
			}
	 } catch(Exception e) 
	 {
		 Assert.fail();
	 }

	logger.info("***** Finish  TC002_LoginTest*****");

	 }
}