package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class VendorsPage extends WebDriverUtility{
	//declaration
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement createNewVendorLookUpImg;
	//initialization
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilisation
	public WebElement getCreateNewVendorLookUpImg() {
		return createNewVendorLookUpImg;
	}
	//business library
	public void clickOnCreateNewVendorImg() {
		createNewVendorLookUpImg.click();	
	}
	
	
}
