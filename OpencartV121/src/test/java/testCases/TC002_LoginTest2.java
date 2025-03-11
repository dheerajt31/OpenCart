package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Base_Class;

public class TC002_LoginTest2 extends Base_Class {//grouping

	@Test(groups={"Sanity","Master"})
	public void check_Login() {
		logger.info("****Starting TC002_LoginTest ***");

		try {
//HomePAge
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clicklogin();
			Thread.sleep(3000);
//LoginPAge
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setEmailPassword(p.getProperty("password"));
			lp.clickLogin();
			Thread.sleep(3000);

//MyAccount

			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isAccountPageExists();

			
			Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true,"Login Failed");

			logger.info("*** Finished TC002_LoginTest ***** ");
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
