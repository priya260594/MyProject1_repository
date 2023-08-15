package AssignmentScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICCRankingTableDealing {
	@Test
	public void dragAndDrop() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	List<WebElement> country=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
	List<WebElement> points=driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
	
//	List<WebElement> country=driver.findElements(By.xpath("(//table/tbody/tr/td[2])[position()>=5]"));
//	List<WebElement> country=driver.findElements(By.xpath("(//table/tbody/tr/td[2])[position()=5]"));
//	List<WebElement> country=driver.findElements(By.xpath("(//table/tbody/tr/td[2])[last()-1]"));
	for(int i=0;i<country.size();i++) {
		System.out.println(country.get(i).getText() +"      "+points.get(i).getText());
	}
//	for(int i=0;i<country.size();i++) {
//		if(country.get(i).getText().equalsIgnoreCase("Afghanistan")) {
//			System.out.println("points: " +points.get(i).getText());
//		}
	}
	
}

