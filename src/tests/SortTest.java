package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Home;
import objects.Sort;

public class SortTest {
	
	private static WebDriver driver;

	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "d:\\chromeDriver\\chromedriver.exe");
		 driver = new ChromeDriver();

	}

	@Test
	public void testSort() {
		driver.get("https://www.saucedemo.com");
		Home.inputUsername(driver,"standard_user");
		Home.inputPassword(driver, "secret_sauce");
		Home.submit(driver);
		Sort.sortByPrice(driver);
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(currentUrl, expectedUrl);

	}
}
