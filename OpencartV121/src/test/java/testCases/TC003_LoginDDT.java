package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.Base_Class;
import utilities.DataProviders;

public class TC003_LoginDDT extends Base_Class {

	/*Data is invalid - login success - test fail - logout
	Data
	is invalid -- login failed - test pass
	 */

	@Test(dataProvider = "name", dataProviderClass = DataProviders.class, groups="Datadriven") // getting data provider from difference class
	public void verify_LoginDDT(String email, String pwd, String exp) {
		{

			logger.info("*****Starting TC003_LoginDDT  ******* ");
			try {
				//HomePage
				HomePage hp = new HomePage(driver);
				hp.clickMyAccount();
				hp.clicklogin();

				//Login
				LoginPage lp = new LoginPage(driver);
				lp.setEmail(email);
				lp.setEmailPassword(pwd);
				lp.clickLogin();
				//MyAccount
				MyAccountPage macc = new MyAccountPage(driver);
				boolean targetPage = macc.isAccountPageExists();

				if (exp.equalsIgnoreCase("valid")) {
					if (targetPage == true) {
						macc.clickLogout();
						Assert.assertTrue(true);

					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				if (exp.equalsIgnoreCase("Invalid")) {
					if (targetPage == true) {

						macc.clickLogout();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
			}
			catch(Exception e)
			{
				Assert.fail();
			}
		}
		logger.info("*****Finished TC003_LoginDDT  ******* ");

	}
}
