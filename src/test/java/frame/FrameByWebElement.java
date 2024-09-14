package frame;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameByWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement we = driver.findElement(By.id("frm2"));
		driver.switchTo().frame(we);
		List<WebElement> menu= driver.findElements(By.xpath("//select[@id=\"selectnav2\"]"));
		
		
		for(WebElement lst: menu) {
			System.out.println(lst.getText());
		}
		WebElement basicControlOption=driver.findElement(By.id("selectnav1"));
        Select select = new Select(basicControlOption);
        List<WebElement> options =select.getOptions();
        for(WebElement list: options) {
        	System.out.println(list.getText());
        }
        driver.switchTo().defaultContent();
        WebElement mainFrame=driver.findElement(By.className("frmTextBox"));
        mainFrame.sendKeys("Cursor in main frame");
        System.out.println(mainFrame.getText());
	}

}
