package E_Commerce.opencart;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTestCases {

WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void openWebsite() {
		driver.navigate().to("http://opencart.abstracta.us/");	
	}
	
	@Test
	public void getTitle() {
		String title = driver.getTitle();
		assertEquals("Your Store", title);
	}
	
	@Test
	public void checkHomePageOpened() {
		WebElement logo =  driver.findElement(By.id("logo"));
		logo.isDisplayed();
	}
	
	@Test
	public void happyCaseCheckSearch() throws InterruptedException {
		
		WebElement searchInput = driver.findElement(By.name("search"));
		searchInput.sendKeys("MacBook");
		
		WebElement searchButton = driver.findElement(By.className("btn-lg"));
		searchButton.click();
		
		Thread.sleep(5000);
		
		WebElement searchPageButton = driver.findElement(By.className("btn-primary"));
		searchPageButton.getText();
		
		if (searchPageButton.getText() == "Search") {
			System.out.println("You opened the search page.");
		}
		
		WebElement numberOfSearchResults = driver.findElement(By.className("text-right"));
		numberOfSearchResults.getText();
		
		String str = numberOfSearchResults.getText();
		String numbers = str.replaceAll("[^0-9]", "");
		
		int searchResultsNumber = Integer.parseInt(numbers);
		if (searchResultsNumber > 0) {
			System.out.println("We found one product and maybe more.");
		}
		
		searchInput.clear();
		searchInput.sendKeys("book");
		searchButton.click();
		
	}
	
}
