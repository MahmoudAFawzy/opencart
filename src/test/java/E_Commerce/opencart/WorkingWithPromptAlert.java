package E_Commerce.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class WorkingWithPromptAlert {
	
	
WebDriver driver = new FirefoxDriver();
	
	
	@BeforeTest
	public void openWebsite() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");
	}
	
	@Test
	
	public void acceptingAlert() {
		
		WebElement button = driver.findElement(By.id("prompt"));
		button.click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Mahmoud Abbas");
		
		alert.accept();
		
		
		
	}

}
