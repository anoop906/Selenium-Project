package testNG_Code;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTesting {
	public static WebDriver driver;
	 public static JavascriptExecutor jse;
	 SoftAssert softAssert = new SoftAssert();
	 

	@BeforeTest
	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	jse = (JavascriptExecutor) driver;
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	}
	
  @Test
  public void UserDetails() {
	  jse.executeScript("document.getElementById('name').value='SuryaPratap'");
	  jse.executeScript("document.getElementById('email').value='abcd@gmail.com'");
	  jse.executeScript("document.getElementById('phone').value='123456789'");
	  jse.executeScript("document.getElementById('textarea').value='Hyderabad'");
	  System.out.println("Details entered successfully");
	  
  }
  @Test
  public void Gender() {
	  //click on male radio button
	  jse.executeScript("document.getElementsByName('gender')[0].checked=true;");
  }
  @Test
  public void Days() {
	  //click on Checkbox
	  jse.executeScript("document.getElementsByTagName('input')[5].checked=true;");
	  jse.executeScript("document.getElementById('monday').checked=true;");
	  jse.executeScript("document.getElementById('friday').checked=true;");
	  jse.executeScript("document.getElementById('saturday').checked=true;");
  }
  
  @Test
  public void Country() {
	  WebElement country= driver.findElement(By.xpath("//select[@id='country']")); 
	  Select select = new Select(country);
	  select.selectByVisibleText("India");
	 	  
//	  Actions action = new Actions(driver);
//	 action.moveToElement(country).click().build().perform();
//	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='country']")));
//	 WebElement india = driver.findElement(By.xpath("//option[text()='India']"));
//	  action.moveToElement(india).click().build().perform();
  }
  
  @Test
  public void colors() {
	  jse.executeScript("document.getElementById('colors')[3].click();");
  }
//  @AfterTest
//  public void teardown() {
//	  driver.close();
//  }
  
}
