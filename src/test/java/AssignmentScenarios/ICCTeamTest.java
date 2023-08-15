package AssignmentScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCTeamTest {

	@Test
	public void teamTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.t20worldcup.com/");
		driver.findElement(By.xpath("//ul[@class='global-navigation__list']/descendant::a[contains(text(),'Teams')]")).click();	
		
		Thread.sleep(6000);
		driver.close();
	}
	
	
}
