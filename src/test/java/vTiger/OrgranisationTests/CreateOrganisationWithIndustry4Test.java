package vTiger.OrgranisationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
public class CreateOrganisationWithIndustry4Test extends BaseClass {

	
	//Create objects for class
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	
	
	@Test(dataProvider="Orgdata")
	public void createMultipleOrgTest(String Orgname,String IndustryType) throws IOException {
	
	String ORG=Orgname+jUtil.getRandomNumber();

	HomePage hp=new HomePage(driver);
	hp.clickOnOrgLnk();
	
	OrganisationPage op=new OrganisationPage(driver);
	op.clickOnCreateNewOrgImg();
	
	CreateNewOrganisationPage newop=new CreateNewOrganisationPage(driver);
	newop.createNewOrg(ORG, IndustryType);
	
	OrganisationInfoPage orginfo =new OrganisationInfoPage(driver);
	String ORGHEADER = orginfo.getOrgheader();
	System.out.println(ORGHEADER);
	
	Assert.assertTrue(ORGHEADER.contains(ORG));
	
//	if(ORGHEADER.contains(ORG)) {
//		System.out.println("organisation created");
//	} else {
//		System.out.println("organisation not created");
//	}
	}
	
	@DataProvider(name="Orgdata")
	public Object[][] getdata() throws EncryptedDocumentException, InvalidFormatException, IOException {
		return eUtil.readMultipleDataFromExcel("MultipleOrg");
	}

}
