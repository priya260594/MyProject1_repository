package practice3;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertPractice {

	@Test
	public void assertPracticeTest() {
		System.out.println("========Step1=========");
		System.out.println("========Step2=========");
//		Assert.assertEquals("B", "A"); //Hard assert-mandatory field
		System.out.println("========Step3=========");
		System.out.println("========Step4=========");
		Assert.assertEquals("A", "A"); //Hard assert mandatory field
		System.out.println("========Step5=========");

	}
	
	@Test
	public void assertPractice2Test() {
	
		SoftAssert sa=new SoftAssert();
		System.out.println("========Test 2 Step1========");
//		sa.assertTrue(false);
		Assert.assertTrue(false);//hard assert
		System.out.println("==========Test 2 step2===========");
	sa.assertEquals(0, 1); //fails
		System.out.println("Test2 Step3=");
		System.out.println("Test2 Step4=");
		sa.assertAll(); //should be used at the end
	}
}
