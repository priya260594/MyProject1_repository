package practice3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.LoginPage;

public class POMPracticce {

	public static void main(String[] args) {
    // LAUNCH THE BROWSER
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://localhost:8888");
	
	//login to app
	LoginPage lp=new LoginPage(driver);
	WebElement username=lp.getUserNameEdt();
	username.sendKeys("admin");
	
	lp.getPasswordEdt().sendKeys("admin");
	lp.getLoginBtn().click();
	
	lp.loginToApp("admin","admin");
	
	}

}
