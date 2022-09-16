package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class ProductInfoPage extends WebDriverUtility {

	//declaration
	@FindBy(className="lvtHeaderText")
	private WebElement productHeaderText;
	//initialization
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//utilizaation
	public WebElement getProductHeaderText()
	{
		return productHeaderText;
	}	
	//business library
	public String getProductHeader() {
		String productHeader = productHeaderText.getText();
		return productHeader;
	}
	
}
