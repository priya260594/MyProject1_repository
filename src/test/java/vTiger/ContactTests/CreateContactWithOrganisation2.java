
package vTiger.ContactTests;

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
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertyFileUtility;
import vTiger.GenericUtility.WebDriverUtility;

/**
 * 
 * @author HP
 *
 */
public class CreateContactWithOrganisation2 {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		WebDriver driver;
		
		//1. Create object of generic utility
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
        
		//2. Read all required data
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		String ORGNAME=eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		
		//3. launch browser
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("chrome browser launched");
			} else if(BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				System.out.println("firefox browser launched");
			} else {
				System.out.println("browser invalid,, so chrome browser launched");
			    driver=new ChromeDriver();
			    System.out.println("chrome browser launched");
			}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementToLoadInDOM(driver);
		driver.get(URL);
		
		//4. login to the app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//5. navigate and create organisation with mandatory details
		//navigate
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		//click create organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	    //mandatory details
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		//6. save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ORGHEADER=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    System.out.println(ORGHEADER);
		if(ORGHEADER.contains(ORGNAME)) {
	    	System.out.println("PASS");
	    	System.out.println("Organisation created");
	    } else {
	    	System.out.println("Fail");
	    	System.out.println("Organisation not created");
	    }
		
		//6. navigate contact
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		//7. create contact with mandatory details and existing organisation
 		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		//click button to launch child window
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		//switch control to child window
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//switch control back to parent
		wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String CONTACTHEADER=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(CONTACTHEADER);
		if(CONTACTHEADER.contains(LASTNAME)) {
			System.out.println("PASS");
			System.out.println("contact created");
		} else {
			System.out.println("Fail");
			System.out.println("---contact not saved");
		}
		 //logout
		
		wUtil.mouseHoverOn(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
