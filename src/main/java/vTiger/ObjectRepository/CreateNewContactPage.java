	package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

//	declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement giveExistOrg;
	
	@FindBy(xpath="//input[@type='button' and @name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@id='1' and @href='javascript:window.close();']")
	private WebElement SelectLnk; 
	
	@FindBy(name="leadsource")
	private WebElement leadsourceDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
//	initializing the constructor
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//	utilisation 
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getGiveExistOrg() {
		return giveExistOrg;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSelectLnk() {
		return SelectLnk;
	}
	
//	business library
	
	public void createNewContact(String lastName, WebDriver driver) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
		
	}
	
	public void createNewContact(String lastName,String orgName,WebDriver driver) {
		lastNameEdt.sendKeys(lastName);
		OrgLookUpImg.click();
		switchToWindow(driver,"Accounts");
		giveExistOrg.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click(); //DYNAMIC XPATH
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}
	public void createNewContact(WebDriver driver,String lastName,String leadSourceType) {
		lastNameEdt.sendKeys(lastName);
		handleDropDown(leadSourceType,leadsourceDropDown);
		saveBtn.click();
	}
	
}
