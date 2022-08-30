package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multipleselect4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.anhtester.com/basic-select-dropdown-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(3000);
		WebElement day= driver.findElement(By.xpath("//select[@class='form-control']"));
		selectByValue(day,"Wednesday");
		WebElement mulst = driver.findElement(By.xpath("//select[@name='States']"));
		Select s=new Select(mulst);
		List<WebElement> t = s.getOptions();
	      System.out.println("States are: ");
	      for (WebElement i: t)
	      {
	         System.out.println(i.getText());
	      }
	      Boolean b=s.isMultiple();
	      System.out.println("Boolen value for Multiple dropdown: "+ b);
	      s.selectByIndex(2);
	      Thread.sleep(1000);
	      s.selectByIndex(3);
	      Thread.sleep(1000);
	      s.selectByIndex(0);
	      Thread.sleep(1000);
	      s.selectByVisibleText("Pennsylvania");
	      Thread.sleep(1000);
	      WebElement f = s.getFirstSelectedOption();
	      System.out.println("First selected option is: "+ f.getText());
	}

	private static void selectByValue(WebElement day, String d1) {
		Select sel=new Select(day);
		sel.selectByVisibleText(d1);
		
	}

}
