package action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizableBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement iFrame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iFrame);
		
		//rightVerticalLine by moveToElement
		WebElement rightVerticalLine = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
		Actions action = new Actions(driver);
		action.clickAndHold(rightVerticalLine).moveByOffset(400, 0).release().build().perform();
		
		//downHorizontal line by dragAndDrop
		WebElement downHorizontalLine =driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-s']"));
		action.dragAndDropBy(downHorizontalLine, 0, 50).release().build().perform();
	   Thread.sleep(3000);
	   driver.close();
	}

}
