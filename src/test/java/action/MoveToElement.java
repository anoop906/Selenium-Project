package action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		
		WebElement tutorials = driver.findElement(By.xpath("(//a[text()='Tutorials'])[1]"));
		action.moveToElement(tutorials).build().perform();
		WebElement testing = driver.findElement(By.xpath("(//a[contains(text(),'Testing')])[1]"));
		action.moveToElement(testing).build().perform();
		WebElement selenium = driver.findElement(By.xpath("(//a[contains(text(),'Selenium')])[1]"));
		action.moveToElement(selenium).click().build().perform();
		Thread.sleep(3000);
		driver.close();
	}

}
