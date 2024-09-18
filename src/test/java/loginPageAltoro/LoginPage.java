package loginPageAltoro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		
	}

	private By userName = By.id("uid");
	private By password = By.id("passw");
	private By login = By.name ("btnSubmit");
	 
	

	public WebElement userName () {
		return driver.findElement(userName);
	}
	
	public WebElement password () {
		return driver.findElement(password);
	}
	
	public WebElement login () {
		return driver.findElement(login);
	}

}
