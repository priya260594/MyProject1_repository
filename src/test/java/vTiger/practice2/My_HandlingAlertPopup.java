package vTiger.practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class My_HandlingAlertPopup {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	    driver.findElement(By.xpath("//a[.='Organizations']")).click();
	    driver.findElement(By.xpath("//a[.='del']")).click();
	    
	    Alert aler = driver.switchTo().alert();
	    aler.accept();
	    
	    
	}

}
