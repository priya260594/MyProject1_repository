import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {
@Test
public void bookingShow() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	String movieName="Kantara";
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://in.bookmyshow.com/");
	driver.findElement(By.xpath("//span[contains(.,'Bengaluru')]")).click();
	driver.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).click();
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(movieName);
	driver.findElement(By.xpath("//li[@class='sc-gJqsIT jMjMYb']")).click();
	driver.findElement(By.xpath("//div[@class='styles__CtaWrapper-sc-qswwm9-8 JInhj']/descendant::div[@class='styles__CtaText-sc-1vmod7e-2 bBLrVT']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
	driver.findElement(By.xpath("//a[@class='date-href']/child::div[@class='date-numeric' and contains(.,'03')]")).click();
	Thread.sleep(4000);
	List<WebElement> ThreatreName=driver.findElements(By.xpath("//div[@class='__title']"));
	List<WebElement> movieTime=driver.findElements(By.xpath("//div[@class='body showtimes-details-container ']/descendant::div[@class='__text']"));
	//List<WebElement> movieTime=driver.findElements(By.xpath("//div[@class='__title']/ancestor::li[@class='list']/descendant::a[@class='showtime-pill']"));	
	FileInputStream fis=new FileInputStream("./src/test/resources/ScenarioExecutions.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("BookMyShow");
	for(int i=1;i<ThreatreName.size();i++) {
	Row r=sh.createRow(i);
	
	r.createCell(0).setCellValue(ThreatreName.get(i-1).getText()); 
	r.createCell(1).setCellValue(movieTime.get(i-1).getText());
	}
	FileOutputStream fos=new FileOutputStream("./src/test/resources/ScenarioExecutions.xlsx");
	wb.write(fos);
	wb.close();
	
	System.out.println("excel sheet printed");
	
}
}
