package E_Commerce.opencart;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenCartTestCases {

	WebDriver driver = new FirefoxDriver();
	
	//WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void openWebsite() {
		driver.navigate().to("https://opencart.abstracta.us/");	
	}
	
	@Test
	public void getTitle() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		assertEquals("Your Store", title);
	}
	
	@Test (dependsOnMethods = "getTitle")
	public void checkHomePageOpened() {
		WebElement logo =  driver.findElement(By.id("logo"));
		logo.isDisplayed();
	}
	
	
	@Test (dependsOnMethods = "checkHomePageOpened")
	public void CheckWrongSearchResult() {
		WebElement searchInput = driver.findElement(By.name("search"));
		searchInput.sendKeys("car");
		
		WebElement searchButton = driver.findElement(By.className("btn-lg"));
		searchButton.click();
	}
	
	
	@Test (dependsOnMethods = "CheckWrongSearchResult")
	public void happyCaseCheckSearch() throws InterruptedException {
		
		WebElement searchInput = driver.findElement(By.name("search"));
		searchInput.clear();
		searchInput.sendKeys("MacBook");
		
		WebElement searchButton = driver.findElement(By.className("btn-lg"));
		searchButton.click();
		
		Thread.sleep(5000);
		
		WebElement searchPageButton = driver.findElement(By.className("btn-primary"));
		searchPageButton.getText();
		
		if (searchPageButton.getText() == "Search") {
			System.out.println("You opened the search page.");
		}
		
		Thread.sleep(5000);
		
		WebElement numberOfSearchResults = driver.findElement(By.className("text-right"));
		numberOfSearchResults.getText();
		
		String str = numberOfSearchResults.getText();
		String numbers = str.replaceAll("[^0-9]", "");
		
		int searchResultsNumber = Integer.parseInt(numbers);
		if (searchResultsNumber > 0) {
			System.out.println("We found one product and maybe more.");
		}
	}
	
	@Test (dependsOnMethods = "happyCaseCheckSearch")
	public void checkAddToCart() throws InterruptedException {
		WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[1]/div/div[2]/div[2]/button[1]"));
		addToCartButton.click();
		
		Thread.sleep(5000);
		
		WebElement cartIcon = driver.findElement(By.id("cart"));
		cartIcon.click();
		
		Thread.sleep(5000);
	}
	
	@Test (dependsOnMethods = "checkAddToCart")
	public void comparePrice() {
		
		WebElement itemPriceInProductCard = driver.findElement(By.className("price-tax"));
		itemPriceInProductCard.getText();
		System.out.println(itemPriceInProductCard.getText());
		
		String stringOfItemInCard = itemPriceInProductCard.getText();
		String numb = stringOfItemInCard.replaceAll("[^0-9]", "");
		
		WebElement itemPriceInCart = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/div/ul/li[2]/div/table/tbody/tr[1]/td[2]"));
		itemPriceInCart.getText();
		System.out.println(itemPriceInCart.getText());
		
		String stringOfItemInCart = itemPriceInCart.getText();
		String numbers = stringOfItemInCart.replaceAll("[^0-9]", "");
		
		if(numb == numbers) {
			System.out.println("The price of items in the cart is the same as the price of the item in the card. ElAs3ar wa7da ya 7omar.");
		}
	}
	
	@Test (dependsOnMethods = "comparePrice")
	public void checkoutPage() {
		WebElement checkoutPageButton = driver.findElement(By.className("fa-share"));
		checkoutPageButton.click();
		
		String title = driver.getTitle();
		assertEquals("Checkout", title);
	}
	
	@Test (dependsOnMethods = "checkoutPage") 
	public void signToCompleteCheckout() {
		WebElement email = driver.findElement(By.id("input-email"));
		email.sendKeys("ssgtester@yahoo.com");
		
		
	}
}
