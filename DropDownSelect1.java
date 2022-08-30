package Selenium;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSelect1 {
public static void main(String args[]) throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Deesha"); 
	driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Shetty"); 
	driver.findElement(By.id("sex-1")).click();
	driver.findElement(By.xpath("//input[@id=\"exp-2\"]")).click();
	driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("02-08-2022");
	driver.findElement(By.xpath("//input[@id=\"profession-1\"]")).click();	
	driver.findElement(By.id("tool-2")).click();
	WebElement Continent= driver.findElement(By.xpath("//select[@id='continents']"));
	selectByVT(Continent,"South America");
	WebElement Selcmds= driver.findElement(By.xpath("//select[@id='selenium_commands']"));
	selectByIndex(Selcmds,4);			
}

private static void selectByVT(WebElement we, String val) {
	Select sel=new Select(we);
	sel.selectByVisibleText(val);
	
}
private static void selectByIndex(WebElement we1, int val1) {
	Select sel=new Select(we1);
	sel.selectByIndex(val1);	
}
} 