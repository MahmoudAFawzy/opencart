package E_Commerce.opencart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {

WebDriver driver = new FirefoxDriver();
	
	
	@BeforeTest
	public void openWebsite() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");
	}
	

	@Test
	public void dragAndDrop() {
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(source, target).perform();
		
		Assert.assertEquals("Dropped!", target.getText());
	}
}
