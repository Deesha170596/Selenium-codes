package Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEvents {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebElement fullName = driver.findElement(By.id("userName"));
	    fullName.sendKeys("Deesha Shetty");
	    WebElement email=driver.findElement(By.id("userEmail"));
	    email.sendKeys("DeeshaShetty@sakshath-technologies.com");
	    WebElement currentAddress=driver.findElement(By.id("currentAddress"));
	    WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
	    currentAddress.sendKeys("Bangalore");	    
	    Actions action =new Actions(driver);
	    action.keyDown(Keys.CONTROL);
	    action.sendKeys("A");
	    action.sendKeys("C");
	    Thread.sleep(3000);
	    action.keyUp(Keys.CONTROL);
	    action.build().perform();
	    Thread.sleep(3000);
	    permanentAddress.sendKeys(Keys.CONTROL + "v");	
	}
}
