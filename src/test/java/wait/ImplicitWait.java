package wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.findElement(By.id("btn1")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement we=driver.findElement(By.xpath("//h3[text()='Show the textboxes here:']/child::input[@type='text']"));
		we.sendKeys("I am waiting");
		driver.findElement(By.id("btn2")).click();
		driver.findElement(By.id("txt2")).sendKeys("I will till 10 sec");
		driver.close();

	}

}
