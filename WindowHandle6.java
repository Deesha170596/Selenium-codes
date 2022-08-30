package Selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.linkedin.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Join now')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Get help')]")).click();
		Thread.sleep(3000);
			String parentWindowHandle = driver.getWindowHandle();
			System.out.println("Parent window's handle -> " + parentWindowHandle);
			Thread.sleep(3000);
			Set<String> allWindowHandles = driver.getWindowHandles();
			for(String handle : allWindowHandles)
			{
			System.out.println("Switching to window - > " + handle);
			Thread.sleep(2000);
			System.out.println("Navigating to google.com");
			driver.switchTo().window(handle);
			driver.navigate().to("https://www.google.com/");
			Thread.sleep(4000);
			}
			driver.switchTo().window(parentWindowHandle);
			Thread.sleep(3000);
			driver.close();
			}
			}