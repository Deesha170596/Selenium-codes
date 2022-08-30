package Selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindow5 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.linkedin.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Join now')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Get help')]")).click();
		Set<String> WindowIds = driver.getWindowHandles();
		Iterator<String> it = WindowIds.iterator();
		String PID=it.next();
		System.out.println(PID);
		String CID=it.next();
		driver.switchTo().window(CID);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='desktop-nav__me-menu ']//a")).click();
	}
}
