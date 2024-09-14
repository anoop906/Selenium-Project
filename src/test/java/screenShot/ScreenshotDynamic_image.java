package screenShot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotDynamic_image {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//at which time and format screenshot take
		LocalDateTime localTime = LocalDateTime.now();
		System.out.println(localTime);
		DateTimeFormatter myformat = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		String time= localTime.format(myformat);
		System.out.println(time);
	
		//taking the screenshot of this url
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		driver.navigate().to("https://www.bhel.com/");
		String str= screenshot.getScreenshotAs(OutputType.BASE64);
		byte[]bytearr= Base64.getDecoder().decode(str);
		//to store the image in dynamic name (its name depend upon time)
		String path= "C:\\Users\\Anoop\\eclipse-workspace\\SeleniumProject\\src\\test\\java\\Screenshot images//"+ time +".png";
		File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(bytearr);
		
		driver.quit();
		

	}

}
