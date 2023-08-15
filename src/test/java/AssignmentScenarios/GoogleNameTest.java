package AssignmentScenarios;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleNameTest {

	@Test
	public void googleSuggestionTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Priyanka");
		System.out.println("Text send");
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='OBMEnb']/descendant::div[@class='wM6W7d']"));
	     	int no=list.size();
	     	TreeSet<String> set=new TreeSet<String>();
		for(WebElement ele:list) {
			set.add(ele.getText());
		}
		System.out.println(set);
		Object[] obj=set.toArray();
		System.out.println("the third index is "+obj[2].toString());
		
		Thread.sleep(7000);
		driver.close();
	}
}
