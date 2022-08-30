package Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class SftAssrt {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.cssSelector("button#submit")).click();
		
		SoftAssert softAssert = new SoftAssert();

		String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
		String actualUrl = driver.getCurrentUrl();
		softAssert.assertEquals(actualUrl, expectedUrl, "Actual page url is  same as expected");

		WebElement successMessage = driver.findElement(By.tagName("strong"));
		String expectedMessage = "Congratulations Michael Scott. You successfully logged in!";
		String actualMessage = successMessage.getText();

		softAssert.assertTrue(actualMessage.contains(expectedMessage), "Actual message does not contain expected message.\nActual Message: " + actualMessage + "\nExpected Message: " + expectedMessage);
		WebElement logOutButton = driver.findElement(By.linkText("Log out"));
		softAssert.assertTrue(logOutButton.isDisplayed(), "Log Out button is not visible");

		softAssert.assertAll();		
	}		
	}
