package vTiger.OrgranisationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.ObjectRepository.CreateNewOrganisationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganisationInfoPage;
import vTiger.ObjectRepository.OrganisationPage;

@Listeners(vTiger.GenericUtility.ListenerImplementation.class)
public class CreateOrgWithHealthcare4Test extends BaseClass {

		
	@Test(groups="SmokeSuite")
	public void orgWithHealthcareTest() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		
		JavaUtility jUtil= new JavaUtility();
		ExcelFileUtility eUtil= new ExcelFileUtility();
		
		String ORGNAME=eUtil.readDataFromExcel("Organisation", 2, 1)+jUtil.getRandomNumber();
	    String INDUSTRYDROPDOWN=eUtil.readDataFromExcel("Organisation", 2, 3);
	
//		navigating to homepage
	        HomePage homepage=new HomePage(driver);
	        homepage.clickOnOrgLnk();
//	        navigate to organisation page
	        OrganisationPage orgPage=new OrganisationPage(driver);
	        orgPage.clickOnCreateNewOrgImg();
//	        navigate to new organisation page
	        CreateNewOrganisationPage newOrg=new CreateNewOrganisationPage(driver);
	        newOrg.createNewOrg(ORGNAME, INDUSTRYDROPDOWN);
//	        navigate to organisation info page
	        OrganisationInfoPage orgInfo=new OrganisationInfoPage(driver);
		    String orgHeader = orgInfo.getOrgheader();
		    Assert.assertTrue(orgHeader.contains(ORGNAME));
//		    if(orgHeader.contains(ORGNAME)){
//		    	System.out.println("Organisation created");
//		    } else {
//		    	System.out.println("Organisation not created");
//		    }
		    
	}
}
