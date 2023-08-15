package vTiger.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class acts like a implementation class to override al the methods 
 * present in ITestListener Interface 
 * @author HP
 *
 */
public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		/*Test is created which will initialise the individual test*/
		test=report.createTest(methodName);
		//Reporter.log(methodName+" test script execution started", true);
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"  -----> Passed");
		//Reporter.log(methodName+" is passed", true);
	}

	public void onTestFailure(ITestResult result) {
		WebDriverUtility wLib=new WebDriverUtility();
		JavaUtility jLib=new JavaUtility();
		
		//This will capture the exception occured
//		String msg = result.getThrowable().toString();
		
		//this wil capture the current test method name
		String methodName = result.getMethod().getMethodName();
		
		//Tis will append methodname with date for screenshot
		String screenShotName= methodName+"-"+jLib.getSystemdateInFormat();
		
		//thi swill log in report and console
		test.log(Status.FAIL, methodName+"  ----> failed");
		test.log(Status.FAIL, result.getThrowable());
		//Reporter.log(methodName+" test script execution failed because "+msg, true);
		
		//This will capture the screen shot and provide the screen shot name and save it in folder
		try {
			String path=wLib.takeScreenshot(BaseClass.sdriver, screenShotName);
			
			//navigate to screenshotpah and attach to the report
			test.addScreenCaptureFromPath(path);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		//String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"  --->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		//Reporter.log(methodName+" test script execution skipped because "+msg, true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Start of suite execution
	 */
	public void onStart(ITestContext context) {
	
		/*Configure the extend report*/                            
	ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Reports-"+new JavaUtility().getSystemdateInFormat()+".exe");	
	htmlReport.config().setDocumentTitle("WASM-5 VTiger execution report");
	htmlReport.config().setTheme(Theme.DARK); 
	htmlReport.config().setReportName("vTiger execution report");
	
	report=new ExtentReports();
	report.attachReporter(htmlReport);
	report.setSystemInfo("base-platform", "Window");
	report.setSystemInfo("base-browser", "Chrome");
	report.setSystemInfo("base-url", "http://localhost:8888");
	report.setSystemInfo("Reporter-name", "Priyanka");
	
}
	/**
	 * End of suite execution
	 */
	public void onFinish(ITestContext context) {
	
		//cosolidate all the test script execution and dump the status into report
		report.flush();
	}

}
