package Selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		driver.findElement(By.name("cusid")).sendKeys("53920");	
		Thread.sleep(3000);
        driver.findElement(By.name("submit")).submit();			      
        Alert alert = driver.switchTo().alert();	
        String alertMessage= driver.switchTo().alert().getText();				
        System.out.println(alertMessage);	
        Thread.sleep(5000);		
        alert.accept();
	}

}
