package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromSameClass {
	@DataProvider(name="LoginCredential", parallel = true)
	// By default parallel = false, 
	// parallel = true: This parameter will launch a browser instance simultaneously
	// for each data entry, equal to the number of data entries.
	public Object[][] DataSourse() {
		Object [][] data = new Object [][] 
					{{"jsmith","demo1234"},
					{"jsmi", "demo1234"},
					{"jsmith","demo12"}};
	return data;
}
	
//@Test(timeOut = 20000,dataProvider = "LoginCredential")
	// It start the time from 0 milisec for each data
@Test(dataProvider = "LoginCredential")
public void Login(String userName, String password) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	 driver.get("http://testfire.net/login.jsp");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.findElement(By.id("uid")).sendKeys(userName);
	 driver.findElement(By.id("passw")).sendKeys(password);
	 driver.findElement(By.name("btnSubmit")).click();
	 driver.close();
	 }
}
