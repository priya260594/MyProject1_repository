package vTiger.ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertyFileUtility;
import vTiger.GenericUtility.WebDriverUtility;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class CreateContactWithMandatoryFields {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
	WebDriver driver;
//			creating objects for classes
		JavaUtility jUtil = new JavaUtility();
        ExcelFileUtility eUtil = new ExcelFileUtility();
        PropertyFileUtility pUtil = new PropertyFileUtility();
        WebDriverUtility wUtil = new WebDriverUtility();
        
//        read data from file
        String URL=pUtil.readDataFromPropertyFile("url");
        String BROWSER=pUtil.readDataFromPropertyFile("browser");
        String USERNAME=pUtil.readDataFromPropertyFile("username");
        String PASSWORD=pUtil.readDataFromPropertyFile("password");
        
        String	LASTNAME=eUtil.readDataFromExcel("Contact", 1, 1)+jUtil.getRandomNumber();
        
//        launch the browser
        if(BROWSER.equalsIgnoreCase("chrome")) {
        	WebDriverManager.chromedriver().setup();
        	driver=new ChromeDriver();
            System.out.println("chrome browser is launched");	
        } else if(BROWSER.equalsIgnoreCase("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
        	driver=new FirefoxDriver();
        } else {
        	System.out.println("browser invalid");
        	driver=new ChromeDriver();
        	System.out.println("Chrome browser is launched");
        }
        
        wUtil.maximiseWindow(driver);
        wUtil.waitForElementToLoadInDOM(driver);
        driver.get(URL);
//        	login to app
        LoginPage login=new LoginPage(driver);
        login.loginToApp(USERNAME,PASSWORD);
//        homepage
        HomePage homepage=new HomePage(driver);
        homepage.clickOnContactsLnk();
//   click contact linkText
        ContactsPage contact=new ContactsPage(driver);
        contact.clickOnCreateNewCntImg();
//        create new contact page
        CreateNewContactPage newContact=new CreateNewContactPage(driver);
        newContact.createNewContact(LASTNAME, driver);
//        contact info page
        ContactsInfoPage contactInfo=new ContactsInfoPage(driver);
        String contactHeader = contactInfo.getContactHeader();
        if(contactHeader.contains(LASTNAME)) {
        	System.out.println("contact created");
        } else {
        	System.out.println("contact not created");
        }
//        logout of the app
          homepage.signOutOfApp(driver);
	}

}
