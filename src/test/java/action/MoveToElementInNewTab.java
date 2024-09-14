package action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementInNewTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Locate the Electronic and click
		driver.findElement(By.xpath("(//*[contains(text(),'Electronics')])[2]")).click();
		// It should open in new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/goat-sale-july-electronics-store?"
				+ "fm=neo%2Fmerchandising&iid=M_a02a76d8-a832-4fbc-a598-31dc7ffd7fb4_1_"
				+ "KUZ8W60OFFMO_MC.KCBBC8GGWR9V&otracker=hp_rich_"
				+ "navigation_4_1.navigationCard.RICH_NAVIGATION_Electronics"
				+ "_KCBBC8GGWR9V&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_"
				+ "EXPANDABLE_navigationCard_cc_4_L0_view-all&cid=KCBBC8GGWR9V");
		Thread.sleep(3000);
		
		//Hover the mouse to the Electronics 
		Actions action = new Actions(driver);
		WebElement electronics =driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		action.moveToElement(electronics).build().perform();
		
		//Inside the electronics find Laptop dropdown list and click it for open
		WebElement laptop = driver.findElement(By.xpath("(//a[text()='Laptops'])[1]"));
		action.clickAndHold(electronics).moveToElement(laptop).click();
		
		//Laptop option should open in new tab
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/laptops-store?otracker=nmenu_sub_Electronics_0_Laptops");
		
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
