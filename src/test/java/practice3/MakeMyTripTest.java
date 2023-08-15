package practice3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {

	@Test
	public void DateTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='close']")).click();
		WebElement ele1=driver.findElement(By.className("lbl_input latoBold  appendBottom5"));
		ele1.click();
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		driver.findElement(By.className("react-autosuggest__input react-autosuggest__input--open")).sendKeys("MAA");
		driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText' and .='Chennai, India']")).click();
		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Wed Sep 28 2022']")).click();
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10' and .='RETURN']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Sat Oct 01 2022']")).click();
		driver.findElement(By.className("primaryBtn font24 latoBold widgetSearchBtn ")).click();
	}
}
