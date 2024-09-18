package loginTestAltoro;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import loginPageAltoro.HomePage;
import loginPageAltoro.LoginCredential;
import loginPageAltoro.LoginPage;

public class LoginTest {
	WebDriver driver;
	LoginCredential loginCredential;
	
	
	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	
	@Test
	public void login() throws IOException {
		loginCredential = new LoginCredential();
		String url=loginCredential.takeData("url");
		String userName = loginCredential.takeData("userName");
		String password = loginCredential.takeData("password");
		
		
		driver.navigate().to(url);
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.userName().sendKeys(userName);
		loginPage.password().sendKeys(password);
		loginPage.login().click();
		
		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.welcomeWord().isDisplayed());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	

}
