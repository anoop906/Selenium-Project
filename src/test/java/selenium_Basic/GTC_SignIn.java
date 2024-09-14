package selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GTC_SignIn {

	public static void main(String[] args) throws InterruptedException {
		String path= System.getProperty("user.dir");
		//System.out.println(path);
		System.setProperty("webdriver.chrome.driver",path+"\\chromeBrowser\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		//Open the GTC website
//		
//		driver.get("https://www.gtccabs.com/");
//		WebElement SignUp= driver.findElement(By.partialLinkText("Sign"));
//		SignUp.click();
//		WebElement UserType = driver.findElement(By.id("UserType"));
//		UserType.click();
//		WebElement dropdown= driver.findElement(By.name("usertype"));
//		Select select = new Select(dropdown);
//		select.selectByValue("Passenger");
//		WebElement firstname = driver.findElement(By.id("FirstName"));
//		firstname.sendKeys("Ankit");
//		WebElement lastname = driver.findElement(By.id("LastName"));
//		lastname.sendKeys("Patel");
//		driver.findElement(By.name("email")).sendKeys("anoop7379@gmail.com");
//		driver.findElement(By.name("mobile")).sendKeys("9876543210");
//		driver.findElement(By.id("DateOfBirth")).sendKeys("01-01-2000");
//		driver.findElement(By.id("Male")).click();
//		driver.findElement(By.id("Female")).click();
//		
//		//counting the radio buttons in the page through findElements with common attributes
//		System.out.println(driver.findElements(By.xpath("//input[@type='radio']")).size());
//		driver.findElement(By.name("password")).sendKeys("2024");
//		Thread.sleep(500);
//		driver.findElement(By.name("confirm-password")).sendKeys("2024");
//		driver.findElement(By.name("book_terms")).click();
//		WebElement submit = driver.findElement(By.className("signup-btn"));
//		submit.click();
//		Thread.sleep(500);
		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://auth.usertesting.com/");
//		driver.findElement(By.name("username")).sendKeys("ratnakar15799@gmail.com");
//		driver.findElement(By.cssSelector("label[for=input33]")).click();
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		driver.get("https://auth.usertesting.com/signin");
//		driver.findElement(By.id("okta-signin-password")).sendKeys("86015@Ra");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.findElement(By.className("form-control text-muted")).sendKeys("132371312");
		
		
//		driver.findElement(By.linkText("Log In")).click();
//		Thread.sleep(500);
//		WebElement Email = driver.findElement(By.id("Email"));
//		WebElement password = driver.findElement(By.id("Password"));
//		WebElement login = driver.findElement(By.className("signin-btn"));
//		Email.sendKeys("anoop7379@gmail.com");
//		Thread.sleep(1000);
//		password.sendKeys("9876");
//		Thread.sleep(1000);
//		WebElement checkbox= driver.findElement(By.cssSelector("label[for=styled-checkbox-2]"));
//		checkbox.click();
//		Thread.sleep(500);
//		login.click();
//		Thread.sleep(500);
//		
//		//Logout from thw website
//		
//		WebElement logout= driver.findElement(By.linkText("LogOut"));
//		logout.click();
//		
//		//open new tab
//		Thread.sleep(1000);
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.gtccabs.com/sign-in");
//		Thread.sleep(1000);
//		WebElement forgotpassword= driver.findElement(By.linkText("Forgot Password?"));
//		 forgotpassword.click();
//		 Thread.sleep(500);
//		 driver.findElement(By.id("Email")).sendKeys("anoop7379@gmail.com");
//		 driver.findElement(By.id("SendOTP")).click();
//		 Thread.sleep(500);
//		 driver.findElement(By.id("EmailOTP"));
//		 
//		 //enter otp mannually
//		 Thread.sleep(2500);
//		 driver.findElement(By.id("VerifyEmail")).click();
		 
	
		 
		
		
	}

}
