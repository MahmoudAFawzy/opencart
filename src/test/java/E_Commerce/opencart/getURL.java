package E_Commerce.opencart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class getURL {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void openWebsite() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.selenium.dev/");
        //driver.get("https://www.selenium.dev/");
        driver.getTitle();
        driver.getPageSource();
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println(url + " " + title);
        System.out.println(driver.getPageSource());
        driver.quit(); // to close all the tabs and the browser itself

        // driver.close(); // to close the window only


    }

}
