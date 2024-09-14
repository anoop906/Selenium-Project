package windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindow_MultiTab {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
	String mwindow=driver.getWindowHandle();
	System.out.println(mwindow);
	driver.findElement(By.id("newTabsWindowsBtn")).click();
	driver.switchTo().window(mwindow);
	WebElement output= driver.findElement(By.id("name"));
	output.sendKeys("Return to main window");
	Thread.sleep(2000);
	System.out.println(output.getAttribute("text"));
	driver.quit();

	}

}
