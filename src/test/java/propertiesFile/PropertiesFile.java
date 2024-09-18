package propertiesFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesFile {
		WebDriver driver;
	@Test
	public void HYRForm() throws IOException, InterruptedException {
		Properties prop= new Properties();
		File file = new File("hyrRegistrationForm.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//taking the url value from hyrRegistrationForm.properties
		driver.navigate().to(prop.getProperty("url"));
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		//sending the value from hyrRegistrationForm.properties file
		firstName.sendKeys(prop.getProperty("firstName"));
		
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys(prop.getProperty("lastName"));
		//checkBox
		driver.findElement(By.id("englishchbx")).click();
		//mail
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("email"));
		//password
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		 Thread.sleep(3000);
		}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
