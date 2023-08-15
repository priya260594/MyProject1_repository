package AssignmentScenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTest {

	@Test
	public void makeMyTripTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\makeMyTripTest.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String sh=wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		System.out.println(sh);
						
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Thread.sleep(7000);
		
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform();
		
		
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(sh);
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//ul[@role='listbox']/child::li[@data-suggestion-index='0']")).click();
		driver.findElement(By.xpath("//p[text()='"+sh+", India']")).click();
		
		
		driver.close();
		
		
	}
}
