package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility{
//declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createNewCntLookUpImg;
	
//Initialisation	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	utilization
	public WebElement getCreateNewCntLookUpImg() {
		return createNewCntLookUpImg;
	}
	
//	business library
	public void clickOnCreateNewCntImg() {
	createNewCntLookUpImg.click();
	
	}
}
