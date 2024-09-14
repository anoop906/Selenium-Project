package dropDown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_printValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		WebElement dropDown= driver.findElement(By.id("course"));
		Select select = new Select(dropDown);
		List<WebElement>list= select.getOptions();
		for(WebElement output:list) {
			System.out.println(output.getText());
			
		}
		WebElement multioption= driver.findElement(By.id("ide"));
		Select select2 =new Select(multioption);
		List<WebElement>list2= select2.getOptions();
		for(WebElement multioutput: list2) {
			System.out.println(multioutput.getText());
			
		}
		driver.close();
	}

}
