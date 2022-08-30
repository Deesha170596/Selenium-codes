package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDD3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		driver.findElement(By.id("Form_getForm_FullName")).sendKeys("Vidya");
		driver.findElement(By.id("Form_getForm_Email")).sendKeys("Vidya.shekar@sakshath-technologies.com");
		WebElement Country= driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
		selectByVT(Country,"Australia");
		driver.findElement(By.name("Contact")).sendKeys("9945320958");
	}

	private static void selectByVT(WebElement country, String string) {
		Select sel=new Select(country);
		sel.selectByVisibleText(string);
		
	}
	
}
