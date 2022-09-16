package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class CreateNewVendorPage extends WebDriverUtility{

	//declaration
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement VendorNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	//initialization
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilisation
	public WebElement getVendorNameEdt() {
		return VendorNameEdt;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	//bussiness library
	public void createVendorPage(WebDriver driver, String vendorName){
		VendorNameEdt.sendKeys(vendorName);
		SaveBtn.click();
	}
	
}
