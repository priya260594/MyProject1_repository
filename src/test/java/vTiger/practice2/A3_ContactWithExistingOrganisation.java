package vTiger.practice2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class A3_ContactWithExistingOrganisation {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	WebElement ele1=driver.findElement(By.name("salutationtype"));
	Select sel=new Select(ele1);
	sel.selectByVisibleText("Mrs.");
	driver.findElement(By.name("firstname")).sendKeys("Mahesh");
	driver.findElement(By.name("lastname")).sendKeys("N");
	String parentId=driver.getWindowHandle();
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	Set<String> bothParentChildId=driver.getWindowHandles();
	for(String wh:bothParentChildId) {
		if(wh!=parentId) {
			driver.switchTo().window(wh);
		}
	}
	
	driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
	
	driver.switchTo().window(parentId);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	Thread.sleep(6000);
	
	Actions act=new Actions(driver);
	WebElement ele2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    act.moveToElement(ele2).perform();
    driver.findElement(By.xpath("//a[.='Sign Out']")).click();
    
    Thread.sleep(6000);
    driver.close();
	
	}

}
