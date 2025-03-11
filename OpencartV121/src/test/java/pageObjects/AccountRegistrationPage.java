package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPasswrd;

	@FindBy(xpath = "//input[@value='0']")
	WebElement chkdNewsLetter;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkdPolicy;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnContinue;

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String telephone) 
	{
		txtTelephone.sendKeys(telephone);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String confirmpwd)
	{
		txtConfirmPasswrd.sendKeys(confirmpwd);
	}

	public void setNewsLetter() {
		chkdNewsLetter.click();
	}
	public void setPolicy() {
		chkdPolicy.click();
	}
	public void clickContinue()
	{
		//chkdNewsLetter.click();
		chkdNewsLetter.submit();
		/*
		 * Actions act= new Actions(driver);
		 * act.moveToElement(btnContinue).build().perform();
		 */

		/*
		 * JavascriptExecutor js = (JavascriptExecutor)driver;
		 * js.executeScript("argument[0].click();", btnContinue);
		 */

		//btnContinue.sendKeys(Keys.RETURN)

		/*
		 * WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
		 * mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		 */

	}
	public String getConfirmationMsg(){
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}

}
