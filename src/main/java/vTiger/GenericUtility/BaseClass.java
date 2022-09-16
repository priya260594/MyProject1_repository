package vTiger.GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class contains basic configuration annotation for common
 * functionalities like connection to database, launch the browser etc 
 * @author HP
 *
 */
public class BaseClass {

	public DatabaseUtility dUtil=new DatabaseUtility();
	public JavaUtility jUtil=new JavaUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups={"RegressionSuite","SmokeSuite"})
	public void bsConfig() {
//		dUtil.connectionToDB();
		Reporter.log("----Connection to database established---", true);
	}
// @Parameters("BROWSER") //only for cross browser platform
	@BeforeTest(groups= {"RegressionSuite","SmokeSuite"})
//   @BeforeClass(groups={"RegressionSuite","SmokeSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException {
	String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log(BROWSER+ " Browser is launched", true);
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			Reporter.log(BROWSER+ " Browser is launched", true);
		} else {
				
			System.out.println("invalid browser");		
}
		sdriver=driver;
wUtil.maximiseWindow(driver);
wUtil.waitForElementToLoadInDOM(driver);
driver.get(URL);
	}
	

	@BeforeMethod(groups= {"RegressionSuite","SmokeSuite"})
	public void bmConfig() throws IOException {
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
		Reporter.log("-----Login successfull-----", true);
	}
	@AfterMethod(groups= {"RegressionSuite","SmokeSuite"})
	public void amConfig() {
		HomePage home=new HomePage(driver);
		home.signOutOfApp(driver);
		Reporter.log("-----Logout successfull-----", true);
	
	
	}
	@AfterTest(groups= {"RegressionSuite","SmokeSuite"})
		//@AfterClass
	public void acConfig() {
		driver.close();
		Reporter.log("----browser closed successfull------", true);
	}
		
	@AfterSuite(groups= {"RegressionSuite","SmokeSuite"})
	public void asConfig()  {
	//	dUtil.closeDb();
		Reporter.log("========Connection to database is closed======", true);
	}


}
