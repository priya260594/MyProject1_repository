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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripBusFilter2 {
	@Test
	public void busFilter() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	String from="Bengaluru, India";
	String to="Chennai, India";
	String depart="Fri Dec 09 2022";   	
	String returnDate="Sun Dec 11 2022";
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	Thread.sleep(4000);
	Actions act=new Actions(driver);
	act.moveByOffset(20, 20).click().perform();
	driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(from);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[text()='"+from+"']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(to);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[text()='"+to+"']")).click();
	Thread.sleep(2000);
	
	act.moveByOffset(20, 20).click().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@aria-label='"+depart+"']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@data-cy='returnArea']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@aria-label='"+returnDate+"']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(.,'Search')]")).click();
	Thread.sleep(4000);
	
	act.moveByOffset(20, 20).click().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='linkText pointer']")).click();
	Thread.sleep(2000);
	int count=0;
	String names;
	List<WebElement> filterText=driver.findElements(By.xpath("//span[.='Show less']/preceding::span[@class='filterName']"));
//	List<WebElement> listCheck=driver.findElements(By.xpath("//span[.='Show less']/preceding::span[@class='customCheckbox']"));
	for(WebElement flightlst:filterText) {
		String filterTxt=flightlst.getText();
		String num=filterTxt.replaceAll("[^0-9]", "");
		int n=Integer.parseInt(num);
		
		if(n<=10) {
			flightlst.click();
			count++;
			names=flightlst.getText();
			System.out.println(names);
		}
}
	Thread.sleep(12000);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)", " ");
	Thread.sleep(4000);
	
	
	List<WebElement> flightName= driver.findElements(By.xpath("//span[@class='boldFont blackText']"));
	List<WebElement> departureTime=driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']/p[@class='appendBottom2 flightTimeInfo']"));
	List<WebElement> departurePlace=driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']/p[@class='blackText']"));
	List<WebElement> travelTime=driver.findElements(By.xpath("//div[@class='relative fliStopsSep']/../preceding-sibling::p"));
	List<WebElement> arriveTime=driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']//p[@class='appendBottom2 flightTimeInfo']/span"));
	List<WebElement> arrivePlace=driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']//p[@class='blackText']/font"));
	List<WebElement> flightCost=driver.findElements(By.xpath("//p[@class='blackText fontSize16 blackFont']"));
	

	FileInputStream fis=new FileInputStream("./src/test/resources/ScenarioExecutions.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("MakeMyTrip");
	for(int i=1;i<flightName.size();i++) {
		Row r=sh.createRow(i);
		r.createCell(0).setCellValue(flightName.get(i-1).getText());
		r.createCell(1).setCellValue(departureTime.get(i-1).getText());
		r.createCell(2).setCellValue(departurePlace.get(i-1).getText());
		r.createCell(3).setCellValue(travelTime.get(i-1).getText());
		r.createCell(4).setCellValue(arriveTime.get(i-1).getText());
		r.createCell(5).setCellValue(arrivePlace.get(i-1).getText());
		r.createCell(6).setCellValue(flightCost.get(i-1).getText());
	}
    FileOutputStream fos=new FileOutputStream("./src/test/resources/ScenarioExecutions.xlsx");
    wb.write(fos);
    wb.close();
	System.out.println("Return in excel sheet");
}
}