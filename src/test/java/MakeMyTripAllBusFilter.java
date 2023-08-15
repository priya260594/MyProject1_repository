import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripAllBusFilter {
@Test
public void allBusWithFilter() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[contains(.,'Search')]")).click();
	Thread.sleep(4000);
	Actions act=new Actions(driver);
	act.moveByOffset(20, 20).click().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@class='linkText pointer']")).click();
	Thread.sleep(2000);
	List<WebElement> filterText=driver.findElements(By.xpath("//div[@class='filtersOuter'][1]/descendant::span[@class='filterName']"));
	List<WebElement> listCheck=driver.findElements(By.xpath("//div[@class='filtersOuter'][1]/descendant::span[@class='check']"));
	for(int i=0;i<filterText.size();i++) {
		
		if((filterText.get(i).getText().charAt(i))>='0' && filterText.get(i).getText().charAt(i)<='9') {
			 int num=filterText.get(i).getText().charAt(i)-48;
			if(num<=10) {
				for(int j=0;j<=listCheck.size();j++) {
				
				listCheck.get(i).click();
//				WebElement bus=driver.findElement(By.xpath("//div[@class='filtersOuter'][1]/descendant::span[@class='check']["+(i+1)+"]"));
//				bus.click();
				Thread.sleep(2000);
			
//				JavascriptExecutor js=(JavascriptExecutor)driver;
//				js.executeScript("window.scrollBy(0,500)", " ");
				num=0;
				}
			}
		}
	}
	System.out.println("hi");
}
}
