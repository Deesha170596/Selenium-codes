package Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample1naukri {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Register')]")).click();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String pid = it.next();
		String cid = it.next();
		driver.switchTo().window(cid);
		driver.findElement(By.id("name")).sendKeys("Vignesh C Poojary");
		driver.findElement(By.name("email")).sendKeys("Vigneshpoojary419@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Create a password for your account']")).sendKeys("pallavi@123");
		driver.findElement(By.id("mobile")).sendKeys("8088177379");
		driver.findElement(By.xpath("//h2[contains(text(),\"I'm a Fresher\")]")).click();
		driver.findElement(By.id("currentCity")).sendKeys("Mumbai");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Upload Resume')]")).click();
		Robot robot= new Robot();
		robot.delay(2000);
		StringSelection fu= new StringSelection("C:\\Users\\DeeshaDShetty\\Downloads\\RahulShettyAcademy_Q&A List (1).pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fu, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//button[contains(text(),'Register Now')]")).submit();
	}

}
