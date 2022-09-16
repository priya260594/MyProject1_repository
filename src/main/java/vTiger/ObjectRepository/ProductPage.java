package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class ProductPage extends WebDriverUtility{
//declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement clickOnProductLookUpImg;
	//initialisation
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilisation
	public WebElement getclickOnProductLookUpImg() {
		return clickOnProductLookUpImg;
	}
	//business library
	public void createNewProductsPage(){
		clickOnProductLookUpImg.click();
	}
}
