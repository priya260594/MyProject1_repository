import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MicTest2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
//		option.addArguments("disable-notifications"); //to diaable the notifications
//		option.addArguments("disable-geolocation"); // disable location
//		option.addArguments("disable-media-stream"); //disabling microphone and camera
		
		HashMap<String, Integer> contentsetting=new HashMap<String, Integer>();
		HashMap<String, Object> profile=new HashMap<String, Object>();
		HashMap<String, Object> pref=new HashMap<String, Object>();
		
		contentsetting.put("media_stream", 1);
		profile.put("managed_default_content_settings", contentsetting);
		pref.put("profile", profile);
		
		option.setExperimentalOption("prefs", pref);
		
		
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://mictests.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Test my mic']")).click();
		

	}

}
