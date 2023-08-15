package vTiger.practice;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Screenshots {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		String systemDate=new Date().toString().replace(':', '_').replace(' ', '_');
        TakesScreenshot shot=(TakesScreenshot)driver;
        File src=shot.getScreenshotAs(OutputType.FILE);
        File dest=new File("./Screenshot/"+systemDate+".png");
        FileUtils.copyFile(src, dest);
        Thread.sleep(7000);
        driver.close();
		
	}

}
