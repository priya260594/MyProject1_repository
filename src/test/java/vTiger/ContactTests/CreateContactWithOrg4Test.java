package vTiger.ContactTests;

import java.io.IOException;
import vTiger.GenericUtility.BaseClass;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.ObjectRepository.ContactsInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganisationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganisationInfoPage;
import vTiger.ObjectRepository.OrganisationPage;

@Listeners(vTiger.GenericUtility.ListenerImplementation.class)

public class CreateContactWithOrg4Test extends BaseClass{

	
	@Test(groups="SmokeSuite")
	public void contactWithOrgTest() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		
		
		JavaUtility jUtil=new JavaUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		
		String ORGNAME=eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber();
		
		
		//navigate to organisations link
		HomePage home=new HomePage(driver);
		home.clickOnOrgLnk();
		Reporter.log("Organisation look up image is clicked", true);
		
		OrganisationPage orgpage=new OrganisationPage(driver);
		orgpage.clickOnCreateNewOrgImg();
		Reporter.log("creation of new organisation page", true);
		
		//create new org 
		CreateNewOrganisationPage newOrg=new CreateNewOrganisationPage(driver);
		newOrg.createNewOrg(ORGNAME);
		Reporter.log("new organisation is created", true);
		
		//organisation info page
		OrganisationInfoPage orginfo=new OrganisationInfoPage(driver);
		String ORGHEADER=orginfo.getOrgheader();
		System.out.println(ORGHEADER);
		Assert.assertTrue(ORGHEADER.contains(ORGNAME));
//		if(ORGHEADER.contains(ORGNAME)) {
//			System.out.println("PASS");
//		} else {
//			System.out.println("fail");
//		}
		
		//navigate to contact link
		home.clickOnContactsLnk();
		Reporter.log("Contact look up image is clicked", true);
		
		
		ContactsPage conpage=new ContactsPage(driver);
		conpage.clickOnCreateNewCntImg();
		Reporter.log("creation of new contact page", true);
		
		//create new contact
		CreateNewContactPage newCon=new CreateNewContactPage(driver);
		newCon.createNewContact(LASTNAME, ORGNAME, driver);
		Reporter.log("contact page is created with organisation", true);
		
		//contact info page
		ContactsInfoPage coninfo=new ContactsInfoPage(driver);
		String CONHEADER = coninfo.getContactHeader();
		System.out.println(CONHEADER);
		Assert.assertTrue(CONHEADER.contains(LASTNAME));
//		if(CONHEADER.contains(LASTNAME)) {
//			System.out.println("PASS");
//		} else {
//			System.out.println("fail");
//		}
		
	}
	@Test(groups="SmokeSuite")
	public void demoRegression() {
		System.out.println("This is demo");
	}
}

