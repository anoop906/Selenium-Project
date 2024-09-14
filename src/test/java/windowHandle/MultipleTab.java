package windowHandle;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String mwindow= driver.getWindowHandle();
		driver.findElement(By.id("newTabsBtn")).click();
		Thread.sleep(3000);
		driver.switchTo().window(mwindow);
		WebElement output= driver.findElement(By.id("name"));
		output.sendKeys("Return to Main Window");
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		System.out.println(output.getAttribute("value"));
		driver.quit();

	}

}
