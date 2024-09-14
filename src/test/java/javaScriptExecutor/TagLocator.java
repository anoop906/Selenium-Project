package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagLocator {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Scroll down page
		jse.executeScript("window.scrollTo(0,600)");
		//locate the password field
		jse.executeScript("document.getElementsByTagName('input')[3]");
		// highlight the Refresh Button
		jse.executeScript("document.getElementsByName(\"refreshbtn\")[0].style.border = '2px solid red'");
		jse.executeScript("document.getElementsByName(\"refreshbtn\")[0].style.background='blue'");
		Thread.sleep(3000);
		driver.close();
	}

}
