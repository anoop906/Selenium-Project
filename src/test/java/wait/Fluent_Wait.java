package wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluent_Wait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		Wait<WebDriver>wait = new FluentWait<WebDriver>(driver)
				             .withTimeout(Duration.ofSeconds(10))
				             .pollingEvery(Duration.ofMillis(500))
				             .ignoring(Exception.class);
		driver.navigate().to("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.findElement(By.id("btn1")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt1"))).sendKeys("Hello Explicit Wait");
		driver.findElement(By.id("btn2")).click();
		WebElement we= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));
		we.sendKeys("Waiting from 10 seconds");
		driver.close();
				             

	}

}
