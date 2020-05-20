package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
		WebDriver driver;
		Reusables reuse;
		
		public HomePage(WebDriver driver) {
			this.driver=driver;		
		}
		
		public void timeSheetCheck() throws Exception {
			reuse = new Reusables (driver);
			Thread.sleep(5000);
			driver.findElement(By.xpath(reuse.readProperties("timeSheetIcon"))).click();
			Thread.sleep(5000);
			driver.findElement(By.id(reuse.readProperties("empNameID"))).clear();
			driver.findElement(By.id(reuse.readProperties("empNameID"))).sendKeys("John Smith");
			driver.findElement(By.id(reuse.readProperties("viewButtonID"))).click();
	}
	

}
