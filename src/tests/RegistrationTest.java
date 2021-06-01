package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Home;

public class RegistrationTest {

	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "d:\\chromeDriver\\chromedriver.exe");
		 driver = new ChromeDriver();

	}

	@Test
	public void testRegistration() {

		File f = new File("data.xlsx");
		try {
			InputStream is = new FileInputStream(f);

			XSSFWorkbook wb;

			wb = new XSSFWorkbook(is);

			Sheet sheet = wb.getSheetAt(0);
			SoftAssert sa = new SoftAssert();
			for (int i = 0; i < 7; i++) {
				Row row = sheet.getRow(i);
				Cell c0 = row.getCell(0);
				Cell c1 = row.getCell(1);
				String username = c0.toString();
				String password = c1.toString();
				driver.navigate().to(Home.URL);
				Home.inputUsername(driver, username);
				Home.inputPassword(driver, password);
				Home.submit(driver);
				String currentUrl = driver.getCurrentUrl();
				String expectedUrl = "https://www.saucedemo.com/inventory.html";
				sa.assertEquals(currentUrl, expectedUrl, username + " " + i);
			}
			sa.assertAll();
			wb.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}