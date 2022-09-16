package vTiger.ContactTests;
import vTiger.GenericUtility.JavaUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.PropertyFileUtility;
import vTiger.GenericUtility.WebDriverUtility;

/**
 * This class contains test script to create contact
 * @author HP
 *
 */
public class CreateContactTest2 {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
	WebDriver driver;  
	
		/*Step1: create object of all utilities*/
		
	JavaUtility jUtil=new JavaUtility();
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	WebDriverUtility wUtil=new WebDriverUtility();
	
	/*Step2: read all the necessary data*/
	String BROWSER=pUtil.readDataFromPropertyFile("browser");
	String URL=pUtil.readDataFromPropertyFile("url");
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD=pUtil.readDataFromPropertyFile("password");
	
	String LASTNAME=eUtil.readDataFromExcel("Contact", 1, 4);
	
	 /*Step3: launch the browser*/
	if(BROWSER.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("Chrome browser is launched");
		
	} else if(BROWSER.equalsIgnoreCase("Firefox")) {
	  
     WebDriverManager.firefoxdriver().setup();
	 driver=new FirefoxDriver();
	 System.out.println("Firefox browser is launched");
	 
	}else {
		System.out.println("Invalid browser");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("Chrome is launched");
	}
	wUtil.maximiseWindow(driver);
	wUtil.waitForElementToLoadInDOM(driver);
	driver.get(URL);
	
	  /*Step4: login to app*/
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	/*Step5: navigate to contacts*/
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	
	 /*Step6: click on create contact*/
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	/*Step7: create contact with mandatory info*/
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME+jUtil.getRandomNumber());
	
	 /*Step8: save*/
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 /*Step9: logout*/
	WebElement ele1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wUtil.mouseHoverOn(driver, ele1);
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
