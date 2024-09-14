package dataProvider;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromDifferentClass {
	public static WebDriver driver;
	SoftAssert softAssert;
	
	@BeforeTest
	public void launchData() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider = "LoginCredential", dataProviderClass = ReadDataFromHere.class)
	public void Login(String userName, String password) throws IOException, InterruptedException {
	     
		 driver.get("http://testfire.net/login.jsp");
	     driver.findElement(By.id("uid")).sendKeys(userName);
		 driver.findElement(By.id("passw")).sendKeys(password);
		 driver.findElement(By.name("btnSubmit")).click();
		 boolean b = driver.findElement(By.xpath("//h1[normalize-space(text()='Hello John Smith')]")).isDisplayed();
		 softAssert.assertEquals(b, true, "Hello John Smith not displayed");
		 Thread.sleep(2000);
		 
		 //dynamic time
		 LocalDateTime localTime = LocalDateTime.now();
		 DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmm");
		 String time = localTime.format(format);
		 
		 // take screenshot
		 TakesScreenshot screenShot = (TakesScreenshot) driver;
		 File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
		 String path="C:\\Users\\Anoop\\eclipse-workspace\\SeleniumProject\\DataProviderScreenShot//"+time+".png";
		 File targetFile = new File (path);
		 FileUtils.copyFile(sourceFile, targetFile);
	}
		 
		 @AfterTest 
		 public void teardown() {
			 softAssert.assertAll();
			 driver.close(); 
		 }
		 
}

	

