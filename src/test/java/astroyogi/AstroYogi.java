package astroyogi;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AstroYogi {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.astroyogi.com/kundli");
		// Name
		driver.findElement(By.xpath(" //form[@id='kundliRegistrationFrm']//input[@id='Kund_Name']")).sendKeys("Ankit");
		// Gender
		WebElement Gender = driver.findElement(By.xpath("//select[contains(@id,'UserGender')]"));
		Select slGender = new Select(Gender);
		slGender.selectByValue("Male");
		// Date of Birth
		// Day:
		WebElement date = driver.findElement(By.xpath("//select[contains(@id,'Date')]"));
		Select slDate = new Select(date);
		slDate.selectByVisibleText("22");
		// Month:
		WebElement month = driver.findElement(By.xpath("//select[contains(@id,'Month')]"));
		Select slMonth = new Select(month);
		slMonth.selectByIndex(3);
		// Year:
		WebElement year = driver.findElement(By.xpath("//select[contains(@id,'Year')]"));
		Select slYear = new Select(year);
		slYear.selectByVisibleText("1994");

		// Birth Time:
		// Hour:
		WebElement birthHour = driver.findElement(By.xpath("//select[contains(@id,'Kund_F_BirthPlace_Hour')]"));
		Select slHour = new Select(birthHour);
		slHour.selectByVisibleText("5");
		// Minute:
		WebElement birthMinute = driver.findElement(By.xpath("//select[contains(@id,'Kund_F_BirthPlace_Minute')]"));
		Select slMinute = new Select(birthMinute);
		slMinute.selectByVisibleText("00");
		// AM/PM:
		WebElement birthAM = driver.findElement(By.xpath("//select[contains(@id,'Kund_F_BirthPlace_AM')]"));
		Select slAM = new Select(birthAM);
		slAM.selectByVisibleText("AM");

		// BirthPlace:
		WebElement birthPlace = driver
				.findElement(By.xpath("//label[text()='Birth Place']//following::input[@id='Kund_BirthPlace']"));
		birthPlace.sendKeys("Hardoi, Uttar Pradesh, IN");
		Thread.sleep(2000);
		birthPlace.sendKeys(Keys.BACK_SPACE);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement currentDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//li[contains(@class,'ui-menu-item')]//div[contains(@id,'ui-id')]")));
		Actions act = new Actions(driver);
		act.moveToElement(currentDropdown).click().build().perform();
		
		// Click Get Your Kundli:
		driver.findElement(By.xpath("//button[contains(text(),'Get Your Kundli')]")).click();
		Thread.sleep(3000);
		driver.close();

	}

}
