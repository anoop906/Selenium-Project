package testNG_Code;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AltoroMutual {
	 public static WebDriver driver;
	 SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("http://testfire.net/login.jsp");
}

  @Test (priority = 1)
  public void Login() {
	  driver.findElement(By.id("uid")).sendKeys("jsmith");
	  driver.findElement(By.id("passw")).sendKeys("demo1234");
	  driver.findElement(By.name("btnSubmit")).click();
	  System.out.println("Login successfully");
	
	  }
  
  @Test (priority = 2)
  public void VerifyUrl() throws InterruptedException {
	  String actualUrl = driver.getCurrentUrl();
	  String expectedUrl = "http://testfire.net/bank/main.jsp";
	  softAssert.assertEquals(actualUrl, expectedUrl, "Url not matched");
	  Thread.sleep(2000);
	  softAssert.assertAll();
  }
  
  @Test (priority = 3)
  public void SignOut() throws InterruptedException {
  driver.findElement(By.xpath("//font[text()='Sign Off']")).click();
  System.out.println("Sign Out Successfully");
  
  }
  
  @Test (priority = 4)
  public void LoginAgain1() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.findElement(By.id("uid")).sendKeys("jsmith");
	  driver.findElement(By.id("passw")).sendKeys("demo1234");
	  driver.findElement(By.name("btnSubmit")).click();
	  System.out.println("Login again1 successfully");
	
	  }
	 
  @Test (priority = 5)
	  public void WelcomeMessage1() throws InterruptedException {
	  //Word Match: Hello John Smith
	  String actual=driver.findElement(By.xpath("//h1[normalize-space(text()='Hello John Smith')]")).getText();
	  String expected ="Hello John Smith";
	  softAssert.assertEquals(actual, expected, "Words not matched");
	  Thread.sleep(2000);
	  softAssert.assertAll();
	  
	  }
	  
	  @Test (priority = 6)
	  public void FeedbackText() throws InterruptedException {
	  //Word Match: E-mail 
	  driver.findElement(By.id("LinkHeader2")).click();
	  driver.findElement(By.xpath("(//a[text()='Deposit Products'])[2]")).click();
	  driver.findElement(By.xpath("//a[text()='contact Altoro Mutual']")).click();
	  driver.findElement(By.xpath("//h2[text()='E-mail']")).getText();
	  driver.findElement(By.xpath("//a[@href ='feedback.jsp']")).click();
	  String feedbackActual = driver.findElement(By.xpath("//h1[text()='Feedback']")).getText();
	  String expect = "Feedback";
	  softAssert.assertEquals(feedbackActual, expect,"Feedback word not matched");
	  Thread.sleep(2000);
	  softAssert.assertAll();
	  }
	  
	  @Test (priority = 7)
	  public void SignOff() throws InterruptedException {
	  driver.findElement(By.xpath("//font[text()='Sign Off']")).click();
	  System.out.println("Sign Out");
	  Thread.sleep(2000);
	  }
	  
	  @Test (priority = 8)
	  public void LoginAgain2() throws InterruptedException {
	  //Login again
	  driver.findElement(By.xpath("//font[text()='Sign In']")).click();
	  driver.findElement(By.id("uid")).sendKeys("jsmith");
	  driver.findElement(By.id("passw")).sendKeys("demo1234");
	  driver.findElement(By.name("btnSubmit")).click();
	  System.out.println("Login again2 successfully");
	  Thread.sleep(2000);
	  }
	  
	  @Test (priority = 9)
	  public void WordInsuranceMatch() throws InterruptedException {
	  driver.findElement(By.xpath("//a[@id='LinkHeader3']")).click();
	  driver.findElement(By.xpath("(//a[text()='Insurance'])[2]")).click();
	  String actualText = driver.findElement(By.xpath("//h1[text()='Insurance']")).getText();
	  String expectedText= "Insurance";
	  softAssert.assertEquals(actualText, expectedText, "Text not matched");
	  Thread.sleep(1000);
	  softAssert.assertAll();
  }
  

 @Test (priority = 10)
  public void MatchSignOffWord() {
	  boolean SignOff=driver.findElement(By.xpath("//font[text()='Sign Off']")).isDisplayed();
	  softAssert.assertEquals(SignOff,true,"Sign Off is not shown");
	  softAssert.assertAll();
 }
  
  @AfterTest
  public void CloseBrowser() throws InterruptedException {
	  driver.close();
  }
  
}
