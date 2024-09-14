package screenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotFile {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		driver.navigate().to("https://www.hyrtutorials.com/");
	  File sourceFile	= screenshot.getScreenshotAs(OutputType.FILE);
	  String path = "C:\\Users\\Anoop\\eclipse-workspace\\GTC001\\src\\test\\java\\Screenshot images//image1.png";
	  File targetFile = new File (path);
	  
		  try {
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	  
		

	}

}
