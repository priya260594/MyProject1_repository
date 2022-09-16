package practice3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPracticeTest {

	@Test(retryAnalyzer=vTiger.GenericUtility.RetryAnalyzerImplementation.class)
	public void retryPracticeTest() {
		System.out.println("hi");
        Assert.fail();		
	}
}
