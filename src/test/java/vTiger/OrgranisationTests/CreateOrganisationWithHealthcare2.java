package vTiger.OrgranisationTests;

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

public class CreateOrganisationWithHealthcare2 {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
		WebDriver driver;
		
		/**1. Create object for all utilities **/
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		/**2. Read all the necessary data from file **/
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=eUtil.readDataFromExcel("Organisation", 2, 1);
		String INDUSTRYDROPDOWN=eUtil.readDataFromExcel("Organisation", 2, 3);
		
		/**3. launch the browser **/
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Chrome browser is launched");
		} else if(BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("Firefox browser is launched");
			}  else {
				System.out.println("Invalid browser");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				System.out.println("Chrome browser is launched");
			}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementToLoadInDOM(driver);
		driver.get(URL);
		
		/**4. login to the app **/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/**5. navigate to organisation**/
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		
		/**6. click on create new organisation**/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		/**7. create new organisation with HealthCare in industry drop down**/
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME+jUtil.getRandomNumber());
		
		//industry dropdown- Healthcare
	    WebElement element1=driver.findElement(By.xpath("//select[@name='industry']"));
		wUtil.handleDropDown(element1, INDUSTRYDROPDOWN);
	   
	   /**8. save**/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/**9. logout**/
		Thread.sleep(5000);
        WebElement element2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverOn(driver, element2);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}

}
