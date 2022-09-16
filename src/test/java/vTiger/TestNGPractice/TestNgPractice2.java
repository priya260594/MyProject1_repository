package vTiger.TestNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice2 {

	@Test
	public void CreateCustormerTest() {
		
		System.out.println("tc-01.. create customer data");
	}
	
	@Test (dependsOnMethods="CreateCustormerTest")
	public void ModifyCustomerTest() {
		
		System.out.println("tc-02.. modify custormer data");
		Assert.fail();
	}
	
	@Test (dependsOnMethods={"CreateCustormerTest","ModifyCustomerTest"})
	public void DeleteCustomerTest() {
		System.out.println("tc-03.. delete customer data");
	}

//@Test (invocationCount=4,priority=2)
//public void Test1() {
//	
//}

}

