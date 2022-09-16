package vTiger.practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class A2_ElectronicsLogout {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	    driver.findElement(By.xpath("//a[.='Organizations']")).click();
	    driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    
	    driver.findElement(By.name("accountname")).sendKeys("Organisation with electronics");
	    WebElement ele1=driver.findElement(By.name("industry"));
	    Select sel1=new Select(ele1);
	    sel1.selectByVisibleText("Electronics");
	    
	    WebElement ele2=driver.findElement(By.name("accounttype"));
	    Select sel2=new Select(ele2);
	    sel2.selectByVisibleText("Investor");
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        WebElement ele3=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    action.moveToElement(ele3).perform();
	    
	    driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	    
	    Thread.sleep(5000);
	    driver.close();
	    
	    
	}

}
