package javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightCheckbox_RadioButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//RadioButton locate by selenium
		WebElement radioMale = driver.findElement(By.xpath("//input[@id='male']"));
		radioMale.click();
		//Operation perform by JavascriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,500)");
		jse.executeScript("arguments[0].style.border = '2px solid red';", radioMale);
		
		//locate and click by Javascript
		//jse.executeScript("document.getElementsByClassName('form-check-input')['sunday'].style.background='red'");
		
		jse.executeScript("document.getElementsByClassName('form-check-input')['saturday'].click()");
		jse.executeScript("document.getElementsByClassName('form-check-input')['sunday'].click()");
		Thread.sleep(3000);
		
		driver.close();

	}

}
