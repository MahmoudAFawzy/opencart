package E_Commerce.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithConfirmAlert {

WebDriver driver = new FirefoxDriver();
	
	
	@BeforeTest
	public void openWebsite() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	
	
	@Test (priority = 0)
	public void acceptingAlert() throws InterruptedException {
		WebElement button = driver.findElement(By.id("confirm"));
		button.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
		WebElement text = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Accepted Alert!", text.getText());
	}
	
	@Test (priority = 1)
	public void rejectingAlert() throws InterruptedException {
		WebElement button = driver.findElement(By.id("confirm"));
		button.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5000);
		alert.dismiss();
	}
}
