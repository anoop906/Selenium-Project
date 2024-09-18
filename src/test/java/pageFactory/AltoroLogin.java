package pageFactory;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AltoroLogin {
	WebDriver driver;
	
	@FindBy(id = "uid")
	WebElement username;
	
	@FindBy(id = "passw")
	WebElement password;
	
	@FindBy(name = "btnSubmit")
	WebElement login;

	@BeforeMethod
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://testfire.net/login.jsp");
		PageFactory.initElements(driver, this);
	}

	@Test
	public void Login() {

		username.sendKeys("jsmith");
		password.sendKeys("Demo1234");
		login.click();
		
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
