package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class OrganisationPage extends WebDriverUtility{
//declation
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgLookupImg;
	
	//Initialization
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getCreateOrgLookUpImg() {
		return createNewOrgLookupImg;
	}	
	
	//business library
/**
 * This method will click on create new organization look up image
 */

public void clickOnCreateNewOrgImg() {
	createNewOrgLookupImg.click();
}

}
