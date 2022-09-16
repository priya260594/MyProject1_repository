package vTiger.practice2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest3 {

	public static void main(String[] args) throws InterruptedException {
	    //1. launch browser
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("http://localhost:8888/");
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//2. Login to app
         driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("admin");
         driver.findElement(By.id("submitButton")).click();
		//3. Go to organization link
         driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
       //4. click on organization look up page
         driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//5. Enter the mandatory details
         driver.findElement(By.className("detailedViewTextBox")).sendKeys("QSP");
		//6. Save
         driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
         
         driver.close();
         System.out.println("organization created");

	}

}
