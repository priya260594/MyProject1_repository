package AssignmentScenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDragAndDrop {
@Test
	public void dragAndDrop() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.automationtesting.in/Static.html");
	WebElement symbol1=driver.findElement(By.xpath("//img[@src='logo.png']"));
	WebElement symbol3=driver.findElement(By.xpath("//img[@src='original.png']"));
	WebElement symbol2=driver.findElement(By.xpath("//div[@id='droparea']/p[@id='msg']"));
	Actions act=new Actions(driver);
	act.dragAndDrop(symbol3, symbol2).perform();
}
}
