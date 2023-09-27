package E_Commerce.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickWithActions {

	WebDriver driver = new FirefoxDriver();
	
	
	@BeforeTest
	public void openWebsite() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
	}
	
	@Test
	public void DoubleClickTest() {
		
		WebElement message = driver.findElement(By.id("message"));
		
		System.out.println(message.getCssValue("background-color"));
		
		Actions builder = new Actions(driver);
		
		builder.doubleClick(message).perform();
		
		System.out.println(message.getCssValue("background-color"));

		Assert.assertEquals("rgb(255, 255, 0)", "rgb(255, 255, 0)");
		
		
	}
	
}
