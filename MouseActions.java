package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	public static void main(String args[]) throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
    Thread.sleep(3000);
	Actions action= new Actions(driver);
	Thread.sleep(3000);
	driver.navigate().to("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
	action.moveToElement(driver.findElement(By.xpath("//ul/li[contains(text(),'C')]")));
	action.clickAndHold().perform();
	Thread.sleep(3000);
	driver.get("http://demo.guru99.com/test/drag_drop.html");
	Thread.sleep(3000);
	WebElement From=driver.findElement(By.xpath("// li[@id='fourth']"));		
	WebElement To=driver.findElement(By.xpath("//ol[@id='amt7']"));	
	Actions act=new Actions(driver);						
	act.dragAndDrop(From,To).build().perform();
	}
}