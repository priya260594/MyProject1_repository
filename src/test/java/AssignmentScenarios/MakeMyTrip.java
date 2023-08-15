package AssignmentScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	@Test
	public void makeMyTripDate() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='landingSprite swipIcon']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
//	    JavascriptExecutor jse=JavascriptExecutor(driver); 
//	    jse.executeScript("window.scrollBy(0,500)", "");
//			
			
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@aria-label='Sun Nov 27 2022']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10' and contains(text(),'RETURN')]")).click();
//		jse.executeScript("window.scrollBy(0,500)", " ");
		Thread.sleep(2000);
		for(;;) {
			try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@aria-label='Tue Mar 21 2023']")).click();
			break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		
	}

	private JavascriptExecutor JavascriptExecutor(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
}
