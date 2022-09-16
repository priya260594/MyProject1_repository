package vTiger.ContactTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
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
import vTiger.ObjectRepository.CreateNewOrganisationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganisationInfoPage;
import vTiger.ObjectRepository.OrganisationPage;

public class CreateContactWithOrganisation3 {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
	WebDriver driver;
		//create objects for classes
		JavaUtility jUtil= new JavaUtility();
		ExcelFileUtility eUtil= new ExcelFileUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		WebDriverUtility wUtil= new WebDriverUtility();

//		read data from file
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
	    String ORGNAME=eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
	    String LASTNAME=eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber();
	//launch the browser
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
//        login to app
        LoginPage login=new LoginPage(driver);
        login.loginToApp(USERNAME, PASSWORD);
//        navigating to homepage
        HomePage homepage=new HomePage(driver);
        homepage.clickOnOrgLnk();
//        navigate to organisation page
        OrganisationPage orgPage=new OrganisationPage(driver);
        orgPage.clickOnCreateNewOrgImg();
//        navigate to new organisation page
        CreateNewOrganisationPage newOrg=new CreateNewOrganisationPage(driver);
        newOrg.createNewOrg(ORGNAME);
//        navigate to organisation info page
        OrganisationInfoPage orgInfo=new OrganisationInfoPage(driver);
	    String orgHeader = orgInfo.getOrgheader();
	    if(orgHeader.contains(ORGNAME)){
	    	System.out.println("Organisation created");
	    } else {
	    	System.out.println("Organisation not created");
	    }
//	    clicking contacts
	    homepage.clickOnContactsLnk();
//	    navigate to contacts page
	    ContactsPage contact=new ContactsPage(driver);
	    contact.clickOnCreateNewCntImg();
//	    navigate to new contacts page
	    CreateNewContactPage newContact=new CreateNewContactPage(driver);
	    newContact.createNewContact(LASTNAME, ORGNAME, driver);
//	    navigate to contact info page
	    ContactsInfoPage contactInfo=new ContactsInfoPage(driver);
	    String contactHeader = contactInfo.getContactHeader();
	    if(contactHeader.contains(LASTNAME)) {
	    	System.out.println("new contact created");
	    } else {
	    	System.out.println("new contact not created");
	    }
//	    logout
	    homepage.signOutOfApp(driver);
	
	}

}
