package dropDown;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultioptionDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		WebElement dropDown= driver.findElement(By.id("course"));
		Select select = new Select(dropDown);
		select.selectByIndex(2);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		select.selectByValue("java");
		
		select.selectByVisibleText("Python");
		
		driver.close();

	}

}
