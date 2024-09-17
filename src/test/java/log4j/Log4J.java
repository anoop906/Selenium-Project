package log4j;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4J {

	public static void main(String[] args) {
		Logger log = LogManager.getLogger("Log4J");
		log.debug("Execution has been started");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver ();
		log.debug("Browser got launched");
		driver.manage().window().maximize();
		log.debug("Browser got maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.hyrtutorials.com/");
		log.debug("Navigated to hyrtutorials website");
		driver.findElement(By.xpath("//a[@class='linkedin']")).click();
		log.debug("Clicked on LinkedIn button & navigated to LinkedIn website");
		driver.navigate().back();
		log.debug("Navigated backward to hyrtutorials website");
		driver.navigate().forward();
		log.debug("Navigated forward to LinkedIn website");
		String url = "https://www.linkedin.com/company/hyrtutorials/";
		if(driver.getCurrentUrl().equals(url)) {
			log.info("Success: The correct url got");
		}
		else {
			log.error("Failure: Incorrect URL got");
		}
		
		driver.close();
		log.debug("Browser got closed and End of the Execution");
	}

}
