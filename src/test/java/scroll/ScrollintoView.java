package scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollintoView {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");
		JavascriptExecutor jse =(JavascriptExecutor) driver;
		jse.executeScript("window.scroll(0, 700)");
		Thread.sleep(2000);	
		
		WebElement yadaGiriReddy = driver.findElement(By.xpath("//a[text()='Yada Giri Reddy '] "));
		jse.executeScript("arguments[0].scrollIntoView()", yadaGiriReddy);
		yadaGiriReddy.click();
		Thread.sleep(2000);
		driver.close();

	}

}
