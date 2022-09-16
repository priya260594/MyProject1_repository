package vTiger.practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class A1_HealthCareLogout {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		driver.findElement(By.className("detailedViewTextBox")).sendKeys("Organization with industry");
		WebElement ele1=driver.findElement(By.name("industry"));
		Select sel=new Select(ele1);
		sel.selectByValue("Healthcare");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	    Thread.sleep(6000);
	    Actions action=new Actions(driver);
		WebElement ele2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    action.moveToElement(ele2).perform();
		
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
		
	}

}
