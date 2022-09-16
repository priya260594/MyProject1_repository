package vTiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related to web driver actions
 * @author HP
 *
 */
public class WebDriverUtility {
/**
 * This method used to maximize the window
 */
	public void maximiseWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will wait for 20 seconds for the entire DOM structure to load
	 * @param driver
	 */
	public void waitForElementToLoadInDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 *  This method will wait for particular element to be visible
	 */
	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for particular element to be clickable
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will wait for particular element to perform click operation,
	 *   if the element is not interactive it will wait for 1 second
	 *  
	 * @param element
	 * @throws InterruptedException
	 */
	public void customWaitAndClickOnElement(WebElement element) throws InterruptedException {
		int count=0;
		while(count<10) {
			try{
				element.click();
		        break;   }
		catch(Exception e) {
			Thread.sleep(1000);
			count++;
		} } }
		/**
		 * This method will handle drop down by select class using index
		 */
		public void handleDropDown(WebElement element, int index) {
			Select s=new Select(element);
			s.selectByIndex(index);
		}
		/**
		 * This method will handle the drop down by elect class using visible text
		 */
	  public void handleDropDown(WebElement element,String visibleText) {
		  Select s=new Select(element);
		  s.selectByVisibleText(visibleText);
	  }
	  /**
	   * This method will handle the drop down by select class by using value
	   */
	public void handleDropDown(String value,WebElement element) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will perform double click on the web page
	 * @param driver
	 */
	
	public void doubleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click on the element in the web page
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This  method will perform mouse hover action on a particular element
	 */
	public void mouseHoverOn(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform mouse howber action over the offset
  	 * @param driver
	 * @param x
	 * @param y
	 */
	public void mouseHoverOn(WebDriver driver,int x,  int y) {
		Actions act= new Actions(driver);
		act.moveByOffset(x, y).perform();
	}
	/**
	 * This method will perform right click on the page
	 * @param driver
	 */
	public void rightClickOn(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**
	 * This method will perform right click on the particular element
	 * @param driver
	 * @param element
	 */
 	public void rightClickOn(WebDriver driver,WebElement element) {
 		Actions act=new Actions(driver);
 		act.contextClick(element).perform();
 	}
 	/**
 	 * This method will perform drag and drop action from src element to target element
 	 * @param driver
 	 * @param srcElement
 	 * @param targElement
 	 */
 	public void dragAndDrop(WebDriver driver,WebElement srcElement, WebElement targElement) {
 		Actions act=new Actions(driver);
 		act.dragAndDrop(srcElement, targElement);
 	}
 	/**
 	 * This method will accept the alert popup
 	 * @param driver
 	 */
 	public void acceptAlert(WebDriver driver) {
 		driver.switchTo().alert().accept();
 	}
 	/**
 	 * This method wil dismiss the alert
 	 * @param driver
 	 */
 	public void dismissAlert(WebDriver driver) {
 		driver.switchTo().alert().dismiss();
 	}
 	/**
 	 * This method will get the text from alert pop up and return it to a caller
 	 * @param driver
 	 * @return
 	 */
 	public String getTextAlert(WebDriver driver) {
 		String alertText=driver.switchTo().alert().getText();
 	    return alertText;
 	}
 	/**
 	 *  This method  will switch to the window with respect to the window title
 	 * @param driver
 	 * @param partialTitle
 	 */
 	public void switchToWindow(WebDriver driver,String partialTitle) {
 		// step1: get all window handles
 		Set<String> windowIds = driver.getWindowHandles();
 	    //step2: iterate through all the windowsIds 
 		Iterator<String> it=windowIds.iterator();
 		//step 3: navigate inside the windows
 		while(it.hasNext())  //loop until windowId exits
 		{
 			//capture all the window ids
 			String winId=it.next();
 			//switch to the window and capture the title
 			String currentTitle=driver.switchTo().window(winId).getTitle();
 			if(currentTitle.contains(partialTitle)) {
 				break;
 			}
 	}
 	}
 	/**
 	 * Switch to frame based on index
 	 * @param driver
 	 * @param index
 	 */
public void switchToFrame(WebDriver driver, int index) {
	driver.switchTo().frame(index);
}
/**
 * Switch to frame based on name or id
 */
public void switchToFrame(WebDriver driver,String idOrName) {
driver.switchTo().frame(idOrName);
}
/**
 * Switch to frame based on frame element
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * This method will take screen shot and return the destination path
 * @param driver
 * @param screenshotName
 * @return 
 * @throws IOException 
 */
public String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
     TakesScreenshot ts=(TakesScreenshot) driver;	
     File src=ts.getScreenshotAs(OutputType.FILE);
     String path="./Screenshots/"+screenshotName+".png";
     File dst=new File(path);
     FileUtils.copyFile(src, dst);
     
     return dst.getAbsolutePath(); //used for reporting in listeners
}
/**
 * This method will perform random scroll
 * @param driver
 */
public void scrollAction(WebDriver driver) {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)", " ");
	
}
/**
 * This method will scroll until the particular element
 * @param driver
 * @param element
 */
public void scrollActionByElement(WebDriver driver, WebElement element) {
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	//jse.executeScript("argument[0].scrollIntoView()",element);
    int y=element.getLocation().getY();
    jse.executeScript("window.scrollBy(0,"+y+")", element);
}
}