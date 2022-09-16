package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class CreateNewProductsPage extends WebDriverUtility{

	//declaration
	@FindBy(name="productname")
	private WebElement ProductNameEdt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement VendorLookUpImg;
	
	@FindBy(id="search_txt")
	private WebElement SearchEdt;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialisation
	public CreateNewProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilisation
	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}

	public WebElement getVendorLookUpImg() {
		return VendorLookUpImg;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
//business library
	public void createNewProduct(String productName, WebDriver driver) {
		ProductNameEdt.sendKeys(productName);
		SaveBtn.click();
	}
	
	public void createNewProduct(String productName,String vendorName,WebDriver driver) {
		ProductNameEdt.sendKeys(productName);
		VendorLookUpImg.click();
		switchToWindow(driver,"Vendors");
		SearchEdt.sendKeys(vendorName);
		SearchBtn.click();
		switchToWindow(driver,"Products");
		SaveBtn.click();
		}
	
	
	
}
