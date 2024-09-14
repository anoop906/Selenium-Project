package calander;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PastDate {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']")); 
		driver.switchTo().frame(iFrame);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']")));
		
		String Month= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
		while(!(Month.equals("October") && Year.equals("2023"))) {
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			Month= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}
		driver.findElement(By.xpath("//a[@data-date='2']")).click();

	}

}
