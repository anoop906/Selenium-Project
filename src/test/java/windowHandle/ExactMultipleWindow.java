package windowHandle;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExactMultipleWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple Windows')]")).click();
		//for new seprate window open
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> windowsIds = driver.getWindowHandles();
		for(String windowId:windowsIds) {
			// Printing the Id of each window
			//System.out.println(windowId);
			driver.switchTo().window(windowId);
			try {
			String Xpathtext = driver.findElement
					(By.xpath("//h1[contains(text(),'XPath Practice')]")).getText();
			System.out.println(Xpathtext);
			driver.quit();
			break;
			} catch(Exception e) {
				driver.close();
				
			}

		}

	}

}
