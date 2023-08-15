import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleCreateAccount {

	@Test
	public void googleTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/account/about/");
		driver.findElement(By.xpath("//a[.='Create an account']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", " ");
		driver.findElement(By.xpath("//span[@class='vRMGwf oJeWuf' and .='‪English (United Kingdom)‬']")).click();
		
		
		driver.findElement(By.xpath("//div[@class='u7land']/descendant::span[.='‪‪Filipino‬']")).click();
		
	}
}
