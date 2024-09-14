package action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		WebElement draggableSource = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement doppableTarget = driver.findElement(By.xpath("//div[@id='droppable']"));
		action.dragAndDrop(draggableSource, doppableTarget).build().perform();
		Thread.sleep(2000);
		driver.close();
		
	}

}
