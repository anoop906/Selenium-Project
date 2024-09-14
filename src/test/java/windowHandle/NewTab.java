package windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTab {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String oldTab = driver.getWindowHandle();
		System.out.println(oldTab);
		WebElement newTab = driver.findElement(By.id("newTabBtn"));
		newTab.click();
		Thread.sleep(3000);
		//driver.close();
		driver.switchTo().window(oldTab);
		WebElement output= driver.findElement(By.id("name"));
		output.sendKeys("Came back to Previous Tab");
		System.out.println(output.getAttribute("value"));
		driver.close();
		
		
		

	}

}
