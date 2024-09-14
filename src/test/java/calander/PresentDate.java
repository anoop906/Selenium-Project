package calander;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PresentDate {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("first_date_picker")).click();
		
		//Explicit Wait for particular WebElement
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		
		String pMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
		String pYear= driver.findElement(By.className("ui-datepicker-year")).getText();
		
		if(pMonth.equals("July") && pYear.equals("2024")) {
			driver.findElement(By.xpath("//a[text()='25']")).click();
			}
		Thread.sleep(3000);
		driver.close();
		
	}

}
