package Selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDD2 {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.orangehrm.com/contact-sales/");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Thread.sleep(3000);
	driver.findElement(By.id("Form_getForm_FullName")).sendKeys("Deesha");
	driver.findElement(By.name("Contact")).sendKeys("8904304262");
	driver.findElement(By.id("Form_getForm_Email")).sendKeys("deesha.shetty@sakshath-technologies.com");
	WebElement Country= driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
	selectByVT(Country,"India");
	WebElement NoOfEmp= driver.findElement(By.xpath("//select[@id='Form_getForm_NoOfEmployees']"));
	selectByIndex(NoOfEmp,4);
	driver.findElement(By.xpath("//input[@name='JobTitle']")).sendKeys("Test Engineer");
	driver.findElement(By.cssSelector("textarea")).sendKeys("This is an HRMS Portal, where we are contacting Sales");
}

private static void selectByIndex(WebElement selcmds, int i) {
	Select sel=new Select(selcmds);
	sel.selectByIndex(i);
	
}

private static void selectByVT(WebElement we, String val) {
	Select sel=new Select(we);
	sel.selectByVisibleText(val);
	
}
}