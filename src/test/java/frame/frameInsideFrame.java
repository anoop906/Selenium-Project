package frame;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frameInsideFrame {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//scroll down main page
		js.executeScript("window.scroll(0,2200)");
		
		// Goto the frame by name
		driver.switchTo().frame("frm3");
		
		//Inside frame 3: there is 3 more frame
		//In Frame 3 : scroll down cursor so that enter the text
		js.executeScript("window.scroll(0,350)");
		
		// Locate by Selenium
		WebElement text = driver.findElement(By.id("name"));
		//value given by JavaScript
		js.executeScript("arguments[0].value='You are in third frame'", text);
		Thread.sleep(2000);
		
		//Go to the frame1 by indexing
		driver.switchTo().frame(0);
		
		WebElement IDEName = driver.findElement(By.xpath("//*[@id=\"ide\"]")); 
		Select sl = new Select(IDEName);
		sl.selectByIndex(0);
		sl.selectByIndex(1);
		sl.selectByIndex(2);
		sl.selectByIndex(3);
		Thread.sleep(2000);
		
		//switch back to parent frame for scrolling down
		// use scrollBY
		driver.switchTo().parentFrame();
		js.executeScript("window.scrollBy(0,400)");
				Thread.sleep(2000);
				
		//Inside Frame3: now change the focus from frame 1 to Frame 2
		//goto the frame2 by WebElement 
		WebElement frame2= driver.findElement(By.id("frm2"));
		driver.switchTo().frame(frame2);
		
		
		driver.findElement(By.id("femalerb")).click();
		driver.findElement(By.id("englishchbx")).click();
		driver.findElement(By.id("hindichbx")).click();
		Thread.sleep(2000);
		
		//switch back to parent frame for scrolling down
		driver.switchTo().parentFrame();
		js.executeScript("window.scrollBy(0,300)");
		
		// switch the frame3 by id
		driver.switchTo().frame("frm3");
		Thread.sleep(1000);
		
		//switch to parent frame
		//Highlight the text by JavaScript
		driver.switchTo().parentFrame();
		WebElement frameName = driver.findElement(By.linkText("Frame3:"));
		js.executeScript("arguments[0].setAttribute('style','color:read;');", frameName);
		
		driver.close();
		
	}

}
