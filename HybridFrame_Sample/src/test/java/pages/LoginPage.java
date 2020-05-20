package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	Reusables reuse;
	WebDriverUtils webUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void login(int row, int col_user, int col_pass) {
		reuse = new Reusables (driver);
		driver.findElement(By.id(reuse.readProperties("userNameLocator"))).sendKeys(reuse.excelRead(row, col_user));
		
		driver.findElement(By.id(reuse.readProperties("passwordLocator"))).sendKeys(reuse.excelRead(row, col_pass));
		
		driver.findElement(By.id(reuse.readProperties("loginButton"))).click();
	}
	
/*	public void forgotPassword(int row, int col_user) throws Exception {
		driver.findElement(By.xpath(reuse.readProperties("forgotPassword"))).click();
		Thread.sleep(3000);
		driver.findElement(By.id(reuse.readProperties("forgotPassUserName"))).sendKeys(reuse.excelRead(row, col_user));

		driver.findElement(By.id(reuse.readProperties("resetButtonCancel"))).click();
		
	}*/

}
