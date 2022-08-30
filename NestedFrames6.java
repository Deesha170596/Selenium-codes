package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames6 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		 int cntframe = driver.findElements(By.tagName("iframe")).size();
		 System.out.println(cntframe);
		 WebElement frame1=driver.findElement(By.id("frame1"));    
         driver.switchTo().frame(frame1);
         WebElement frame1Element= driver.findElement(By.tagName("body"));
         String frame1Text=frame1Element.getText();
         System.out.println("Frame1 is :"+frame1Text);
         int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
         System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);
	}
}
