package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/");
		
		//locate the element(in this element there is anchor tag which is having url)
		WebElement link = driver.findElement(By.xpath("//a[text()='Link1']"));
		
		// Get the value of href attribute that is "url".
		String url = link.getAttribute("href");
		 
		 if (url==null || url.isEmpty()) {
			 System.out.println(url+" is Empty");
			 
		 }
		//  convert the String into URL by using URL class
		// because url in 'http' form so make the connection between http and particular url 
	HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
	    
	// connect the url to the server or
	// send the request from client to the server
		huc.connect();
		
	// get the response-code from the server
	      int responseCode = huc.getResponseCode();
	      if (responseCode>=400) {
	    	  System.out.println(url+" is broken");
	    	  
	      }
	      
	      driver.close();

	}

}
