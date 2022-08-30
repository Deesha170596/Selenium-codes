package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NonSelectDropdown {
	public static void main(String args[]) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://35.172.253.220/login/login/signin");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[contains(text(),'As a Guardian ')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Proceed')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Select ')]")).click();
		Thread.sleep(3000);
		List<WebElement> title = driver.findElements(By.xpath("//ul[@role='listbox']/p-dropdownitem/li"));
		for(int i=0;i<title.size();i++)
		{
			System.out.println(title.get(i).getText());
			if(title.get(i).getText().equalsIgnoreCase("Mrs."))
			{
				title.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Soumya");
		driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys("D");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Shetty");
		driver.findElement(By.xpath("//span[contains(text(),'Select ')]")).click();
		Thread.sleep(3000);
		List<WebElement> phno = driver.findElements(By.xpath("//div[@class='country-item ng-star-inserted']"));
		for(int i=0;i<phno.size();i++)
		{
			System.out.println(phno.get(i).getText());
			if(phno.get(i).getText().equalsIgnoreCase("India - 91"))
			{
				phno.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@formcontrolname='phoneNumber']")).sendKeys("9972942989");
		driver.findElement(By.xpath("//input[@placeholder='Email ']")).sendKeys("Soumya.shetty@sakshath-technologies.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter ']")).sendKeys("sy1254");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Password@555");
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("Password@555");
		driver.findElement(By.id("mat-checkbox-1")).click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
	}		
}
