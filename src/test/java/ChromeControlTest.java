import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeControlTest {

	@Test
	public void chromeControlTest() throws InterruptedException {
		ChromeOptions option=new ChromeOptions();
//		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
//		option.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
//		option.setExperimentalOption("excludeSwitches", Collections.singleton("enable-automation"));
//		option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));	
//		
//		List<String> eSwitches=new ArrayList<>();
//	    eSwitches.add("enable-automation");
//	    option.setExperimentalOption("excludeSwitches",eSwitches);
//		option.addArguments("start-maximized");
		
		option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://mictests.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Test my mic']")).click();		
		Thread.sleep(4000);
		driver.close();
	}
}
