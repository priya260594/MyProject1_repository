package vTiger.practice2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContactTest4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//1. login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//2.navigate to contact
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		//3. create contactid and saving it
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		WebElement ele=driver.findElement(By.name("salutationtype"));
		Select sel=new Select(ele);

		sel.selectByVisibleText("Mrs.");
		driver.findElement(By.name("firstname")).sendKeys("Priyanka");
		driver.findElement(By.name("lastname")).sendKeys("M");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		
		System.out.println("contact created");
		driver.close();
		
		
		
		
		
		

	}

}
