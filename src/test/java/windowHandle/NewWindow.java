package windowHandle;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
	 	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));
		String mWindow = driver.getWindowHandle();
		System.out.println(mWindow+" Main Window");
		driver.findElement(By.id("newWindowBtn")).click();
		//driver.navigate().back();
		driver.switchTo().window(mWindow);
		WebElement output = driver.findElement(By.id("name"));
		output.sendKeys("Return to Main Window");
		Thread.sleep(2000);
		System.out.println(output.getAttribute("value"));
		driver.quit();

	}

}
