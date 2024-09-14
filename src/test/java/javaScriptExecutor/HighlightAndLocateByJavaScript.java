package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighlightAndLocateByJavaScript {

	public static void main(String[] args) throws InterruptedException {
		//Locate and Highlight the element by Javascript Executor
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
		driver.findElement(By.xpath("//td[text()='Maria Anders']/preceding-sibling::td/child::input")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName('post-title entry-title')[0].style.backgroundColor='red'");
		//page scroll down 
		js.executeScript("window.scrollTo(0,300)");
		//highlight box
		js.executeScript("document.getElementsByTagName('label')[0].style.color='red'");
		js.executeScript("document.getElementsByName('name')[0].style.backgroundColor = 'yellow';");
		js.executeScript("document.getElementsByName('name')[0].style.border='2px solid red'");
		js.executeScript("document.getElementsByTagName('label')[2].style.color = 'red'");
		js.executeScript("document.getElementsByTagName('input')[2].style.background = 'green'");
		js.executeScript("document.getElementsByTagName('input')[2].style.border='2px solid red'");
		Thread.sleep(3000);
		driver.close();
	}

}
