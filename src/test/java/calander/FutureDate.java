package calander;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FutureDate {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		//Implicit Wait to load the overall page
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("second_date_picker")).click();
		
		//Explicit Wait for particular WebElement
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
		
		String pMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
		String pYear= driver.findElement(By.className("ui-datepicker-year")).getText();
		
		// When the whole condition will false. It will exit from while loop
		// January equals(January)will give "true" && 2025 equals (2025) will give "true"
		// the overall will give "true"
		//!(true) means not of true will five false = It will terminate while loop
		
		String expecMonth = "January";
		String expecYear = "2025";
		while(!(pMonth.equals(expecMonth) && pYear.equals(expecYear))) {
			
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			pMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
			pYear= driver.findElement(By.className("ui-datepicker-year")).getText();
			
			}
		driver.findElement(By.xpath("//a[text()='26']")).click();
		Thread.sleep(3000);
		driver.close();
		
	}

	}


