package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}



	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") 
	WebElement linkLogin;

	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	public void clickMyRegister() {
		lnkRegister.click();
	}
	public void clicklogin() {
		linkLogin.click();
	}
}
