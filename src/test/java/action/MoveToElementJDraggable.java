package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementJDraggable {

	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");
		WebElement iFrame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iFrame);
		Actions action = new Actions(driver);
		WebElement draggable= driver.findElement(By.id("draggable"));
		action.clickAndHold(draggable).moveToElement(draggable, 80, 80).release().build().perform();
		Thread.sleep(2000);
		driver.close();
		

	}

}
