package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableBox {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/sortable/");
		WebElement iFrame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iFrame);
		WebElement Item1 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][1]"));
		WebElement Item2 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][2]"));
		WebElement Item5 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][5]"));
		WebElement Item6 = driver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][6]"));
		Actions action = new Actions(driver);
		
		action.dragAndDropBy(Item1, 0, 100).release().build().perform();
		action.dragAndDropBy(Item2, 0, 130).release().build().perform();
		action.dragAndDropBy(Item5, 10, -100).release().build().perform();
		action.dragAndDropBy(Item6, 15, -130).release().build().perform();
		Thread.sleep(4000);
		driver.close();
		
	}

}
