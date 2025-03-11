package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement MailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Mailpassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement login;

	public void setEmail(String email) {
		MailAddress.sendKeys(email);
	}

	public void setEmailPassword(String emailpwd) {
		Mailpassword.sendKeys(emailpwd);
	}

	public void clickLogin() {
		login.click();
	}

}
