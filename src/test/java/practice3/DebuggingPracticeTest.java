package practice3;

import org.testng.annotations.Test;

public class DebuggingPracticeTest {

	@Test
	public void ArithmeticTest() {
		System.out.println("Hi");
		DebuggingPracticeTest d=new DebuggingPracticeTest();
		int c=d.divide(20, 0);
		System.out.println(c);
	}
	
	public int divide(int a,int b) {
		int c=a/b;
		return c;
	}
}
