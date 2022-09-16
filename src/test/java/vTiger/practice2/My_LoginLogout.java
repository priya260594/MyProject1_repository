package vTiger.practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class My_LoginLogout {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		WebElement ele1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
      
        act.moveToElement(ele1).perform();
        
        driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
