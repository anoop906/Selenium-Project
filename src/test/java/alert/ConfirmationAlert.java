package alert;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfirmationAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
		driver.findElement(By.id("confirmBox")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement output= driver.findElement(By.xpath("//div[@id='output']"));
		System.out.println(output.getText());
		driver.close();
	}

}
