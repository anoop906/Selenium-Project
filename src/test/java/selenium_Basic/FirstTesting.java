package selenium_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTesting {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Anoop\\eclipse-workspace\\Demo\\chromeBrowser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.get("https://www.gtccabs.com/sign-in");
		driver.findElement(By.id("Email")).sendKeys("anoop7379@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("Password")).sendKeys("9876");
		Thread.sleep(1000);
		driver.findElement(By.className("signin-btn")).click();
		Thread.sleep(1000);

		// new Tab
		driver.switchTo().newWindow(WindowType.TAB);
		String newurl = "https://demo.testfire.net/login.jsp";
		driver.get(newurl);
		WebElement username = driver.findElement(By.id("uid"));
		WebElement password = driver.findElement(By.id("passw"));
		WebElement login = driver.findElement(By.name("btnSubmit"));
		Thread.sleep(1000);
		username.sendKeys("jsmith");
		Thread.sleep(1000);
		password.sendKeys("demo1234");
		Thread.sleep(1000);
		login.click();
		Thread.sleep(1000);
		driver.close();

	}
}
