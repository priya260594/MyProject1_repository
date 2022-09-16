package vTiger.OrgranisationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CreateOrganisationWithHealthcare {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
WebDriver driver;
		
		//generate random number inorder to avoid duplicate data
		Random random=new Random();
		int RANDOM = random.nextInt(1000);
		
		// 1. Read the necessary data
		// ----------Property file--> common data--------------
 FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\login_propertyfiles");
 Properties pObj=new Properties();
 pObj.load(fis);
 String BROWSER=pObj.getProperty("browser");
 String URL=pObj.getProperty("url");
 String USERNAME=pObj.getProperty("username");
 String PASSWORD=pObj.getProperty("password");
 
 
 //-----------------Excel sheet --> Test data------------
 FileInputStream fis2 = new FileInputStream("./src/test/resources/TestData.xlsx");
Workbook wh = WorkbookFactory.create(fis2);
Sheet sh =wh.getSheet("Organisation"); 
Row row=sh.getRow(3);
Cell cell=row.getCell(1);
String ORGNAME=cell.getStringCellValue();

 // 2. launch the browser`
if(BROWSER.equalsIgnoreCase("chrome")) {
	driver=new ChromeDriver();
	System.out.println("Chromw browser launched....");
}
else if(BROWSER.equalsIgnoreCase("firefox")) {
	driver=new FirefoxDriver();
    System.out.println("Firefox driver launched....");
} else {
	System.out.println("browser invalid");
	driver=new ChromeDriver();
	System.out.println("Chrome browser launched succesfully");
}
	
// 3. login to the app
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
driver.get("http://localhost:8888/");

driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();

		// 4. navigate to organisations
driver.findElement(By.xpath("//a[.='Organizations']")).click();

		// 5. create organisations with healthcare in industry dropdown
driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);

WebElement ele1=driver.findElement(By.name("industry"));
Select sel=new Select(ele1);
sel.selectByVisibleText("Healthcare");

		// 6. save
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// 7. logout
Thread.sleep(5000);
Actions act=new Actions(driver);
WebElement ele2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
act.moveToElement(ele2).perform();
driver.findElement(By.xpath("//a[.='Sign Out']")).click();


Thread.sleep(10000);
driver.close();
	}

}
