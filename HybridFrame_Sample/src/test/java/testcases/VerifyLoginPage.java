package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.Reusables;

public class VerifyLoginPage {
	WebDriver driver;
	Reusables reuse;
	LoginPage login;
	HomePage home;
	
	@BeforeTest
	public void browserSetup() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void verifyLoginPage() throws Exception {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		reuse = new Reusables(driver);
		login.login(1, 0, 1);
		reuse.getScreenShot("Valid Credentials - LoginPage");
		home.timeSheetCheck();
		reuse.getScreenShot("Timesheet Validation");
	}
}
