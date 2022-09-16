package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class ContactsInfoPage extends WebDriverUtility{

	@FindBy(className="dvHeaderText")
	private WebElement contactHeaderText;
	
	public ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}

public String getContactHeader() {
	String contactHeader = contactHeaderText.getText();
	return contactHeader;
}
	
}
