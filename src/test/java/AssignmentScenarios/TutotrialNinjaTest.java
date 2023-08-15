package AssignmentScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TutotrialNinjaTest {

	@Test
	public void testCase01Test() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://tutorialsninja.com/demo/");
		
		String pageTitle=driver.getTitle();
		System.out.println("The page title is "+pageTitle);
		if(pageTitle.equalsIgnoreCase("your store")) {
			System.out.println("same title name");
		}else {
			System.out.println("different title name");
		}
		
		WebElement ele1=driver.findElement(By.linkText("Components"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1).perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Monitors')]")).click();
		
		WebElement price=driver.findElement(By.xpath("//div[@class='product-thumb']/descendant::span[@class='price-new']"));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int y=price.getLocation().getY();
		jse.executeScript("window.scrollBy(0,'+y+')", price);
		
		String monitorPrice1=price.getText();
		System.out.println(monitorPrice1);
		
		driver.findElement(By.xpath("//a[contains(text(),'Apple Cinema')]")).click();
		
		String monitorPrice2=driver.findElement(By.xpath("//h1[contains(text(),'Apple Cinema')]/following::h2[1]")).getText();
		if(monitorPrice1.equals(monitorPrice2)) {
			System.out.println("Same Price is there");
		}else {
			System.out.println("same price not there");
		}
		
		jse.executeScript("window.scrollBy(0,1000)", " ");
		WebElement price1=driver.findElement(By.xpath("//h3[.='Available Options']"));
		int x=price1.getLocation().getX();
		int z=price1.getLocation().getY();
		jse.executeScript("window.scrollBy('+x+','+z+')", price1);
		
		driver.findElement(By.xpath("//input[@name='option[218]']")).click();
		driver.findElement(By.xpath("//input[@name='option[223][]' and @value='10']")).click();
		
		driver.findElement(By.xpath("//input[@name='option[208]']")).sendKeys("Selenium4");
		WebElement selection=driver.findElement(By.xpath("//select[@class='form-control']"));
		Select sel=new Select(selection);
	    sel.selectByIndex(1);
	    
	    WebElement addCart=driver.findElement(By.xpath("//button[.='Add to Cart']"));
	    int a=addCart.getLocation().getY();
	    jse.executeScript("window.scrollBy(0,'+a+')", a);
	    addCart.click();
	    
	    String text=driver.findElement(By.xpath("//div[@class='text-danger']")).getText();
	    if(text.equalsIgnoreCase("file required")) {
	    	System.out.println("error message is displayed");
	    }else {
	    	System.out.println("error message is not displayed");
	    }
	    
	    Thread.sleep(7000);
	    driver.close();
	    
		
	}
}
