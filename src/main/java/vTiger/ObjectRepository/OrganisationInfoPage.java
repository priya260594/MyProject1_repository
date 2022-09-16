package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import vTiger.GenericUtility.WebDriverUtility;

public class OrganisationInfoPage extends WebDriverUtility{

	//deeclaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderText; 
    
	//initialise
	public OrganisationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	public WebElement getOrgHeaderText() {
		return OrgHeaderText;
	}
	/**
	 * This method will get the header text for organization
	 * @return
	 */
 //business library
	public String getOrgheader() {
		String orgHeader=OrgHeaderText.getText();
	    return orgHeader;
	}
}
