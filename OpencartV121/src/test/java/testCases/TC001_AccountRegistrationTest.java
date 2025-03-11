package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.Base_Class;

public class TC001_AccountRegistrationTest extends Base_Class {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		logger.info("****Starting TC001_AccountRegistrationTest update*****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount");

			hp.clickMyRegister();
			logger.info("Clicked on MyRegister");


			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			logger.info("Providing customer details");


			/*
			 * regpage.setFirstname("jiddi"); 
			 * regpage.setLastname("ladka");
			 * regpage.setEmail("jiddiladka@gmail.com");
			 * regpage.setEmail(randomString()+"@gmail.com");
			 * random generated the email
			 * regpage.setTelephone("0123456789"); 
			 * regpage.setPassword("abc@123");
			 * regpage.setConfirmPassword("abc@123"); 
			 * regpage.setNewsLetter();
			 * regpage.setPolicy(); 
			 * regpage.clickContinue();
			 */
			//-----------------Most imp part(random generated the email, number gmail )------------------------------------------

			regpage.setFirstname(randomString().toUpperCase());
			regpage.setLastname(randomString().toUpperCase());
			//regpage.setEmail("jiddiladka@gmail.com"); 
			regpage.setEmail(randomString()+"@gmail.com");// random generated the email
			regpage.setTelephone(randomNumber());

			//String Password = randomAlphaNumeric();

			String Password = randomAlphaNumeric();

			regpage.setPassword(Password);
			regpage.setConfirmPassword(Password);
			regpage.setNewsLetter(); regpage.setPolicy(); 

			logger.info("Validation expected message...");

			regpage.clickContinue();

			logger.info("......We are the First test cases......");

			String confirmMsg = regpage.getConfirmationMsg();
			Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
			
		}
		catch(Exception e) 
		{

			logger.error("Test failed..");
			logger.debug("Debug logs....");
			Assert.fail();
		}
		logger.info(".......finish TC001_AccountRegistrationTest.....");
		//driver.close();
	}


}


