package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFromDataSet {
	@Test(timeOut = 10000, dataProvider = "Credential", dataProviderClass = Dataset.class)
	public void Login(String userName, String password) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SoftAssert softAssert = new SoftAssert();
		 driver.get("http://testfire.net/login.jsp");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.findElement(By.id("uid")).sendKeys(userName);
		 driver.findElement(By.id("passw")).sendKeys(password);
		 driver.findElement(By.name("btnSubmit")).click();
		 boolean b = driver.findElement(By.xpath("//h1[normalize-space(text()='Hello John Smith')]")).isDisplayed();
		 softAssert.assertEquals(b, true, "Hello John Smith not displayed");
		 softAssert.assertAll();
		 driver.close();
		 }
}


