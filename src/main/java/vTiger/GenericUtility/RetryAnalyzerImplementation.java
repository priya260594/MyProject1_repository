package vTiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will retry the failed test scripts due to synchronization
 * or network issues
 * @author HP
 *
 */
public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount=4; //manually try and specify the retry count
	
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		
		return false;
	}

}
