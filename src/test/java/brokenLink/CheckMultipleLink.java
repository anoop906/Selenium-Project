package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckMultipleLink {

	

	public static void main(String[] args) throws MalformedURLException, IOException   {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hyrtutorials.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link:links) {
			String url = link.getAttribute("href");
			System.out.println("-----------------------------");
			System.out.println(url);
			if(url==null || url.isEmpty()) {
				System.out.println(url+" is Empty");
				continue;
			}
			HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
			huc.connect();
			int responseCode = huc.getResponseCode();
			if (responseCode>=400) {
				System.out.println(url +" Link is Broken");
			}
			else {
				System.out.println(url+ " Link is fine");
			}
		}
		driver.quit();

	}

}
