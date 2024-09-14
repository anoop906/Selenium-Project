package frame;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameById {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int size= driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Iframe in this page: "+size);
		driver.switchTo().frame("frm1");
		List<WebElement>dropdown_list = driver.findElements(By.xpath("//select[@id='selectnav1']/child::option"));
		int i = dropdown_list.size();
		System.out.println("Number of dropdown in Home: "+ i);
		for(WebElement list: dropdown_list) {
			System.out.println(list.getText());
		}
		driver.switchTo().parentFrame();
		WebElement text= driver.findElement(By.id("name"));
		text.sendKeys("Kindly switch to parent frame page");
		Thread.sleep(1000);
		//System.out.println(text.getText());
		System.out.println(text.getAttribute("value"));
		driver.close();
	}

}
