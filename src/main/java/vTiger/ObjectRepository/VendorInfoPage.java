package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class VendorInfoPage extends WebDriverUtility{
//declaration
	@FindBy(className="lvtHeaderText")
	private WebElement VendorHeaderTxt;
	//initialisation
	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilisation
	public WebElement getVendorHeaderTxt(){
		return VendorHeaderTxt;
		}
	public String getVendorHeader() {
		String vendorHeader = VendorHeaderTxt.getText();
		return vendorHeader;
	}
}
