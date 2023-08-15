package AssignmentScenarios;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartScenarios {

	@Test
	public void addWinterHeaterToCart() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[.='✕']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("Winter Heater");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		WebElement product=driver.findElement(By.xpath("//div[@data-id='ROHG9BFDGBWGXVX5']"));
		String productText=product.getText();
//		String[] sa=productText.split(" ");
//		String partialText=sa[0];
		product.click();
		
		Set<String> winIds= driver.getWindowHandles();
		Iterator<String> it=winIds.iterator();
		String parentId=it.next();
	    String childId=it.next();
	    driver.switchTo().window(childId);
		
		WebElement ele2=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']"));
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		int y=ele2.getLocation().getY();
//		js.executeScript("window.scrollBy(0,"+y+")", ele2);
//		
		ele2.click();
		WebElement ele3=driver.findElement(By.xpath("//a[@class='_2Kn22P gBNbID']"));
		String cartText=ele3.getText();
		if(cartText.contains(productText)) {
			System.out.println("Same product is added to the cart");
		}
		
		Thread.sleep(6000);
		driver.close();
		
		
	}
}
