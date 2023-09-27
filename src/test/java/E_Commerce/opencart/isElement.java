package E_Commerce.opencart;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class isElement {

	WebDriver driver = new FirefoxDriver();

	// WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void openWebsite() {
		driver.manage().window().maximize();

		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	}

	@Test
	
	public void testIsElementPresent() {
		if (!isElementPresent(By.xpath("/html/body/div[2]/div/div/form/input[1]")));
		{
			WebElement check1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]"));
			if (!check1.isSelected()) {
				check1.click();
			} else {
				Assert.fail("Checkbox 1 doesn't exist.");
			}
		} 
	}

	private boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
