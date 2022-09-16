package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganisationPage extends WebDriverUtility {

	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industrydropdown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropdown;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public  CreateNewOrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}
	//Business library
	/**
	 * This method will create organisation wih Org name
	 * 
	 */
	public void createNewOrg(String Orgname) {
		OrgNameEdt.sendKeys(Orgname);
		saveBtn.click();
	}
	/**
	 * This method will craete organisation with industry drop down
	 * @param OrgName
	 */
	public void createNewOrg(String OrgName,String IndustryType) {
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryType, industrydropdown);
		saveBtn.click();
	}
	/**
	 * This metod will create organisation with type and industry drop down
	 */
public void createNewOrg(String OrgName,String industryType,String type) {
	OrgNameEdt.sendKeys(OrgName);
	handleDropDown(industryType, industrydropdown);
	handleDropDown(type,typeDropdown);
	saveBtn.click();
}

}
