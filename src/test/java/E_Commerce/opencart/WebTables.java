package E_Commerce.opencart;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class WebTables {

	WebDriver driver = new FirefoxDriver();

	// WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void openWebsite() {
		driver.manage().window().maximize();
		
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
	}
	
	@Test
	public void webTables() {
		
		WebElement tables = driver.findElement(By.id("table1"));
		List<WebElement> rows = tables.findElements(By.tagName("tr"));
		assertEquals(5, rows.size());
		for(WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col : cols) {
				System.out.println(col.getText() + "\t");
			}
			System.out.println();
		}
		
	}
	
}
