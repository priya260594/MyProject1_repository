package practice3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartScenarios {
@Test
public void flipkar() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("phones");
	driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	List<WebElement> ele=driver.findElements(By.xpath("//div[@class='_4rR01b']"));
	for(WebElement e:ele) {
		System.out.println(e);
	}
}
}
