package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleSelectableItem {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/selectable/");
		WebElement iFrame= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iFrame);
		Actions action = new Actions(driver);
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
	// select single element by click
		//action.click(item5).build().perform();
		
	// select single element by doubleClick
		action.doubleClick(item5).build().perform();
		
	
		Thread.sleep(3000);
		driver.quit();

	}

}
