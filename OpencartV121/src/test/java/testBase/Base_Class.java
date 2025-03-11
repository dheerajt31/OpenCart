package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class Base_Class {

	public static WebDriver driver;
	public Logger logger;// log4j
	public Properties p;

	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException {
		FileReader file = new FileReader(
				"C:\\Users\\dheeraj\\eclipse-workspace\\OpencartV121\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);

		logger = LogManager.getLogger(this.getClass());// logger syntax log4j2
		// remote property
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capability = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				capability.setPlatform(Platform.WIN10);

			} else if (os.equalsIgnoreCase("mac")) {
				capability.setPlatform(Platform.WIN10);
			} else {
				System.out.println("failed operating system");
				return;
			}
			switch (br.toLowerCase()) {
			case "chrome":
				capability.setBrowserName("chrome");
				break;
			case "firefox":
				capability.setBrowserName("firefox");
				break;
			case "edge":
				capability.setBrowserName("edge");
				break;
			default:
				System.out.println("Invalid Btowser");
				return;

			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

		}
		// local property
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("invalid browser...");
				return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL")); // reading url from properties file
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void teardown() {

		// driver.close();
		driver.quit();
	}

	// -----------------Most imp part(random generated the email, number gmail
	// )------------------------------------------

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return (generatedString + "@" + generatedNumber);
	}

	public String captureScreen(String tname) {
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File SourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String path = "C:\\Users\\dheeraj\\eclipse-workspace\\OpencartV121\\screenshots\\" + tname + " " + timeStamp
					+ ".png";
			File targetfile = new File(path);

			SourceFile.renameTo(targetfile);
			return path;

		}
	
	}
}
