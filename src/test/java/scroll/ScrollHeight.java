package scroll;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollHeight {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//In Javascript it will tell the whole page height
		//document.body.scrollHeight
		//jse.executeScript("window.scrollTo(X-axis, Y-axis)
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.close();
	}

}
