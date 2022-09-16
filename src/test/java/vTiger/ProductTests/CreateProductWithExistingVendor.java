package vTiger.ProductTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertyFileUtility;
import vTiger.GenericUtility.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewProductsPage;
import vTiger.ObjectRepository.CreateNewVendorPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.ProductInfoPage;
import vTiger.ObjectRepository.ProductPage;
import vTiger.ObjectRepository.VendorInfoPage;
import vTiger.ObjectRepository.VendorsPage;

public class CreateProductWithExistingVendor {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
		WebDriver driver;
		//creating objects for generic utilities
		JavaUtility jUtil=new JavaUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil= new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		//reading data from files
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String VENDORNAME=eUtil.readDataFromExcel("Product", 1, 2)+jUtil.getRandomNumber();
		String PRODUCTNAME=eUtil.readDataFromExcel("Product", 1, 3)+jUtil.getRandomNumber();
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("Chrome browser launched");
			} else if(BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				System.out.println("firefox browser launched");
				}else {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					System.out.println("invalid browser..Chrome browser launched");
				}
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementToLoadInDOM(driver);
		driver.get(URL);
		//login to app
		LoginPage login=new LoginPage(driver);
		login.loginToApp(USERNAME, PASSWORD);
		//go to homepage
		HomePage homePage=new HomePage(driver);
		homePage.clickOnVendorsLnk(driver);
		//navigate to vendor page
		VendorsPage vendorPage=new VendorsPage(driver);
		vendorPage.clickOnCreateNewVendorImg();
		//create vendor page with mandatory fields
		CreateNewVendorPage newVendor=new CreateNewVendorPage(driver);
		newVendor.createVendorPage(driver, VENDORNAME);
		//check the vendor info page
		VendorInfoPage vendorInfo=new VendorInfoPage(driver);
		String vendorHeader=vendorInfo.getVendorHeader();
		if(vendorHeader.contains(VENDORNAME)) {
			System.out.println("vendor page created");
		} else {
			System.out.println("vendor page not created");
		}

		
		//click on product
		homePage.clickOnProductsLnk();
		//creae new product
		ProductPage productPage= new ProductPage(driver);
		productPage.createNewProductsPage();
		//creating a product page with existing vendor
		CreateNewProductsPage newProduct=new CreateNewProductsPage(driver);
		newProduct.createNewProduct(PRODUCTNAME, VENDORNAME, driver);
		//Check the product info page
		ProductInfoPage productInfo=new ProductInfoPage(driver);
		String productHeader = productInfo.getProductHeader();
		if(productHeader.contains(PRODUCTNAME)) {
			System.out.println("product page created");
		} else {
			System.out.println("product page not created");
		}
		//logout
		homePage.signOutOfApp(driver);
		Thread.sleep(5000);
		driver.close();

		}
	

}
