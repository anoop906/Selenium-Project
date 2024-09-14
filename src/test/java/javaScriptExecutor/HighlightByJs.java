package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightByJs {

	public static void main(String[] args) throws InterruptedException {
		// Locate the element by Selenium and Highlight by Javascript Executor
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		WebElement register = driver.findElement(By.xpath("(//button[@class='btn'])[1]")); 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,800)");
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;')", register);

		Thread.sleep(3000);
		
		driver.close();

	}

}
