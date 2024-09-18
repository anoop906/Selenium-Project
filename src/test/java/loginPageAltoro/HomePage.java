package loginPageAltoro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	
	private By welcomeWord=By.xpath("//h1[contains(text(),'Hello John Smith')]");
	
	

	public WebElement welcomeWord() {
		return driver.findElement(welcomeWord);
	}
	
}
