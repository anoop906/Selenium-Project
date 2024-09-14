package windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");
		String mwindow= driver.getWindowHandle();
		System.out.println(mwindow);
		driver.findElement(By.id("newWindowsBtn")).click();
		driver.switchTo().window(mwindow);
		WebElement output= driver.findElement(By.id("name"));
		output.sendKeys("Return to Main Window");
		System.out.println(output.getAttribute("value"));
		

	}

}
