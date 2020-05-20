package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {
	WebDriver driver;
	
	public WebDriverUtils(WebDriver driver) {
		this.driver = driver;
	}
public void enterTextbyXpath(String locatorValue, String text) {
	driver.findElement(By.id(locatorValue)).sendKeys(text);
}
	public void enterText(String locator, String locatorValue, String text) {
		switch(locator) {
		case "id" :
			driver.findElement(By.id(locatorValue)).sendKeys(text);
		case "xpath" :
			driver.findElement(By.xpath(locatorValue)).sendKeys(text);
		case "name" :
			driver.findElement(By.name(locatorValue)).sendKeys(text);			
		}
	}
	
	public void clickElement(String locator, String locatorValue) {
		switch(locator) {
		case "id" :
			driver.findElement(By.id(locatorValue)).click();
		case "xpath" :
			driver.findElement(By.xpath(locatorValue)).click();
		case "name" :
			driver.findElement(By.name(locatorValue)).click();			
		}
	}
	
	public void waitForElement(String locatorValue) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue))).isDisplayed();
	}
	
}
