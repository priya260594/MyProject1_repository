package AssignmentScenarios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusDemo2 {
	@Test
	public void redBusSearch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.redbus.in/bus-tickets");
		driver.findElement(By.xpath("//input[@id='txtSource']")).sendKeys("Bangalore");
//		WebElement fromCity=driver.findElement(By.xpath("//ul[@id='C120_suggestion-wrap']/child::li[@class='C120_suggestions_list C120_suggestion-active']"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtDestination']")).sendKeys("Chennai");
//		driver.findElement(By.xpath("//ul[@id='C120_suggestion-wrap']/descendant::div[.='Chennai']"));
		Thread.sleep(2000);
		driver.findElement(By.id("txtOnwardCalendar")).sendKeys("26-Nov-2022");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='D120_search_btn searchBuses']")).click();
		Thread.sleep(7000);
		//closing add
		driver.findElement(By.className("close-primo")).click();
		Thread.sleep(4000);
		//getting the no of bus
		WebElement noOfbuses=driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		String buscountWithString=noOfbuses.getText();
		String[] buscountsplit=buscountWithString.split(" ");
		int buscount=Integer.parseInt(buscountsplit[0]);
        System.out.println("The toal buses are "+buscount);
        Thread.sleep(1000);

//        for(;;) { 
//        	try {
//        		Thread.sleep(3000);
//        		driver.findElement(By.xpath("//section[@class='D162_main']"));
//        		break;
//        	}catch(Exception e) {
//        	
//        JavascriptExecutor jse=(JavascriptExecutor)driver;
//        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)"); }
//        	 }
        
        for(int i=0;i<20;i++) {
        	JavascriptExecutor jse=(JavascriptExecutor)driver;
        	jse.executeScript("window.scrollInto(0,document.body.scrollHeight)");
        }
        Thread.sleep(10000);
		List<WebElement> listbus=driver.findElements(By.xpath("//div[@id='result-section']/descendant::div[@class='clearfix bus-item-details']/descendant::div[@class='travels lh-24 f-bold d-color']"));
		int count=listbus.size();
		System.out.println(count); 
		
		
		
		for(int i=0;i<count;i++) {
			System.out.println("The buses are " +listbus.get(i).getText());
			}
		
		
		Assert.assertEquals(buscount, count);
		Thread.sleep(7000);
		driver.close();
	}

}
