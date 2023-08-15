package RedBus;

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

public class RedBusBusSearch {

	@Test
	public void redBusSearch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.redbus.in/bus-tickets");
		driver.findElement(By.xpath("//input[@id='txtSource']")).sendKeys("Bangalore");
		WebElement fromCity=driver.findElement(By.xpath("//ul[@id='C120_suggestion-wrap']/child::li[@class='C120_suggestions_list C120_suggestion-active']"));
		Actions act=new Actions(driver);
		act.click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtDestination']")).sendKeys("Chennai");
		WebElement toCity=driver.findElement(By.xpath("//ul[@id='C120_suggestion-wrap']/descendant::div[.='Chennai']"));
		toCity.click();
		Thread.sleep(3000);
		driver.findElement(By.id("txtOnwardCalendar")).sendKeys("26-Nov-2022");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='D120_search_btn searchBuses']")).click();
		//closing add
		driver.findElement(By.className("close-primo")).click();
		Thread.sleep(4000);
		//getting the no of bus
		WebElement noOfbuses=driver.findElement(By.xpath("//span[@class='f-bold busFound']"));
		String buscount=noOfbuses.getText();}
		
	JavascriptExecutor jse=(JavascriptExecutor)driver;
    int y1=scroll1.getLocation().getY();
	jse.executeScript("window.scrollBy(0,"+y1+")", scroll1);
	listbus.addAll(listbus);
	int count=listbus.size();
	System.out.println(count);
		
		
		
		
		for(int i=0;i<listbus.size();i++) {
			System.out.println("The buses are " +listbus.get(i).getText());
		}
		
		Assert.assertEquals(buscount, count);
		Thread.sleep(7000);
		driver.close(); }
		
		
		public WebElement addingBuses(WebDriver driver,WebElement element,String buscount,We) {
			for(int i=0;i<=Integer.valueOf(buscount);i++) {
			List<WebElement> listbus=driver.findElements(By.xpath("//div[@id='result-section']/descendant::div[@class='clearfix bus-item-details']/descendant::div[@class='travels lh-24 f-bold d-color']"));
			WebElement scroll1=driver.findElement(By.xpath("//div[@class='clearfix bus-item']"));
			}
			
			public WebElement
	
}
		
		
		
		
		
		
		
		
