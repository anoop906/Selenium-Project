package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendTextToWebPage {

	public static void main(String[] args) throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementsByName('name')[0].value='Anoop'");
		jse.executeScript("document.getElementsByName('name')[1].value='Kumar'");
		jse.executeScript("document.getElementsByTagName('input')[2].value='anoop7379@gmail.com'                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  ");
		Thread.sleep(3000);
		jse.executeScript("document.getElementsByTagName('button')[1].click()");
		driver.close();
	}

}
