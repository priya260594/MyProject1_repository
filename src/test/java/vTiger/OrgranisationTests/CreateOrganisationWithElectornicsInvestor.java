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


public class CreateOrganisationWithElectornicsInvestor {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
		WebDriver driver;
		Random r=new Random();
		int RANDOM=r.nextInt(1000);
		
		//1. Read the neccessary data
		
		//--------Property file---> common data-------
		FileInputStream fis = new FileInputStream("./src/test/resources/login_propertyfiles");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		//-------------Property File--> TestData-------
		FileInputStream fis2 = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wh = WorkbookFactory.create(fis2);
		Sheet sh=wh.getSheet("Organisation");
		Row row=sh.getRow(4);
		Cell cell=row.getCell(1);
		String ORGNAME=cell.getStringCellValue();
	
		//3.launch the browser
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			System.out.println("chrome browser launched");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox")) {
	    	driver=new FirefoxDriver();
	    	System.out.println("firefox launched");
	    }
		else {
			System.out.println("invalid browser");
			driver=new ChromeDriver();
			System.out.println("chrome browser launched");
		}
	//4. login to the app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//5. Create Organisation with electronics and investor in drop down
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+RANDOM);
		
		//electronics selection
		WebElement ele1=driver.findElement(By.name("industry"));
		Select sel= new Select(ele1);
		sel.selectByVisibleText("Electronics");
        
		//investor selection
		WebElement ele2=driver.findElement(By.name("accounttype"));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText("Investor");
		
		//6. Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// 7. logout
        Thread.sleep(5000);
        Actions act=new Actions(driver);
        WebElement ele3=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        act.moveToElement(ele3).perform();
        driver.findElement(By.xpath("//a[.='Sign Out']")).click();


        Thread.sleep(10000);
        driver.close();
	}
	
	

}
