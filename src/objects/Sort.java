package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sort {
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	public static final String SortBTN="//*[@id=\"header_container\"]/div[2]/div[2]/span/select";
	public static void sortByPrice(WebDriver driver) {
		driver.findElement(By.xpath(SortBTN)).click();;
		
	}
}
