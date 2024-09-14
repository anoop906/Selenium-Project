package alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_Pop_Up{
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//open the HYR tutorial website - alert page
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.findElement(By.id("alertBox")).click();
		//implicit waits
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement output= driver.findElement(By.id("output"));
		System.out.println(output.getText());
		//System.out.println(output.getAttribute("value"));
		driver.close();
		
	}
	
}