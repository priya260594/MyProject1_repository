package AssignmentScenarios;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCRankDropDownTest {

	@Test
	public void rankDropDownTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.t20worldcup.com/");
		driver.findElement(By.partialLinkText("ICC RANKINGS")).click();
		Set<String> winIds=driver.getWindowHandles();
		Iterator<String> it=winIds.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		WebElement rank=driver.findElement(By.xpath("//button[contains(text(),'Rankings')]"));
		Actions act=new Actions(driver);
		act.moveToElement(rank).perform();
		
		Thread.sleep(6000);
		driver.close();
		
	}
}
