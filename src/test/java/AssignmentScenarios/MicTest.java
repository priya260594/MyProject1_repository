package AssignmentScenarios;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MicTest {

	@Test
	public void micTest() {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("use-fake-ui-for-media-stream");

		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://mictests.com/");
		driver.findElement(By.xpath("//button[text()='Test my mic']")).click();
	    
		
	}
}
//HashMap<String, Integer> conentSettings=new HashMap<String, Integer>();
//HashMap<String, Object> profile=new HashMap<String, Object>();
//HashMap <String, Object> pref=new HashMap<>();
//
//conentSettings.put("disable_media_stream", 1);
//profile.put("managed_default_content_settings", conentSettings);
//pref.put("profile",profile);
//options.setExperimentalOption("pref", pref);

//options.addArguments("disable-notifications");
//options.addArguments("disable-geolocation");
//options.addArguments("disable-media_stream");
