package Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'round trip')]")).isDisplayed());  
        System.out.println("Web Element text has been displayed "); 
        Assert.assertEquals("Welcome aboard.",driver.findElement(By.xpath("//div[contains(text(),'Welcome aboard.')]")).getText());  
        System.out.println("Both Strings are equal");
        Assert.assertNotEquals("Hello", "How are you");  
        System.out.println("Both Strings are not equal");   
	}
}
