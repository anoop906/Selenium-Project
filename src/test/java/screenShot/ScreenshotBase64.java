package screenShot;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotBase64 {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		//screenshot of this url
		driver.get("https://mycollegebag.in/");
		String str= screenshot.getScreenshotAs(OutputType.BASE64);
		byte[] bytearr= Base64.getDecoder().decode(str);
		//storing the screenshot
		String path= "C:\\Users\\Anoop\\eclipse-workspace\\GTC001\\src\\test\\java\\Screenshot images//image3.png";
		FileOutputStream fos = new FileOutputStream(path);
		fos.write(bytearr);
		driver.close();
		}
	    

}
