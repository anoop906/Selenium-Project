package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropDroppable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		//WebElement iFrame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		WebElement dragBox= driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropBox= driver.findElement(By.xpath("//div[@id='droppable']"));
		action.dragAndDrop(dragBox, dropBox).build().perform();
		Thread.sleep(2000);
		driver.close();
	}

}
