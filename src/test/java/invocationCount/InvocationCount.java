package invocationCount;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvocationCount {
	public static WebDriver driver;
	Actions action; 
	DateTimeFormatter dateFormat;
	TakesScreenshot screenshot;
	
@BeforeTest
	public void launchUrl() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://randomuser.me/");
		action = new Actions(driver);
		dateFormat = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
     	screenshot = (TakesScreenshot) driver;
}
	@Test (invocationCount = 3)
	public void invocationCountPage() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//name
		WebElement nameIcon = driver.findElement(By.xpath("//li[@data-label='name']"));
		action.moveToElement(nameIcon).build().perform();
		String nameTitle = driver.findElement(By.id("user_title")).getText();
		Thread.sleep(2000);
		String name = driver.findElement(By.id("user_value")).getText();
		System.out.println(nameTitle+" : "+name);
		
		//mail
		WebElement mailIcon = driver.findElement(By.xpath("//li[@data-label='email']"));
		action.moveToElement(mailIcon).build().perform();
		String mailTitle = driver.findElement(By.id("user_title")).getText();
		Thread.sleep(2000);
		String mail = driver.findElement(By.id("user_value")).getText();
		System.out.println(mailTitle+" : "+mail);
		
		//birthday
		WebElement birthday = driver.findElement(By.xpath("//li[@data-label='birthday']"));
		action.moveToElement(birthday).build().perform();
		String birthdayTitle = driver.findElement(By.id("user_title")).getText();
		Thread.sleep(2000);
		String Birthday = driver.findElement(By.id("user_value")).getText();
		System.out.println(birthdayTitle+" : "+Birthday);
		System.out.println("--------------------------------------------------");
		
		//use dynamic time
		 LocalDateTime localtime = LocalDateTime.now();
		String time = localtime.format(dateFormat);
		byte[] bytearr = screenshot.getScreenshotAs(OutputType.BYTES);
		String path= "C:\\Users\\Anoop\\eclipse-workspace\\SeleniumProject\\InvocationScreenShot//"+time+".png";
		FileOutputStream fos = new FileOutputStream (path);
		fos.write(bytearr);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
@AfterTest
	public void teardown() {
	driver.close();
		}		
}

