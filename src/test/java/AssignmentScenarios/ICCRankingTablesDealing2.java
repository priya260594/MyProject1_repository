package AssignmentScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCRankingTablesDealing2 {

	@Test
	public void table2test() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.icc-cricket.com/rankings/mens/overview");
//		List<WebElement> ele=driver.findElements(By.xpath("(//div[@class='col-4 col-12-desk uniform-grid__section touch-scroll-list__element'])[position()=4]/descendant::table/tbody/tr/td[2]"));
//		for(int i=0;i<ele.size();i++) {	
//		System.out.println(ele.get(i).getText());
//		}
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> ele2=driver.findElements(By.xpath("//table[@class='table']"));
		for(int i=0;i<ele2.size();i++) {
			System.out.println(ele2.get(i).getText()+" ");
		}
	}
}
