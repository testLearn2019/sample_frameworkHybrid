package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusables {
	WebDriver driver;
	/*
	 * 1. Read Properties File 2. Read Excel File / (Write) 3. Take Screenshot
	 */
	static Properties prop;
	static String propValue;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String cell;
	
	public Reusables(WebDriver driver) {
		this.driver = driver;
	}

	public String readProperties(String KeyProperty) {
		prop = new Properties();

		try {
			FileReader fs = new FileReader("./ObjectRepository/objRepo.properties");
			prop.load(fs);
			propValue = prop.getProperty(KeyProperty);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propValue;
	}

	public String excelRead(int row, int col) {
		try {
			FileInputStream fis = new FileInputStream("./TestData/TestDataSample.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			cell = sheet.getRow(row).getCell(col).getStringCellValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cell;
	}
	
	public void getScreenShot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(img, new File("./Screenshots/" +filename +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// for(int i = 0; i<=3 ; i++) {  //create row
				//create the row
		// Row headerRow = sheet.createRow(i);
		/*	for(int j= 0; j<=3; j++) {
				//Cell 
			}*/
		
	}

}
