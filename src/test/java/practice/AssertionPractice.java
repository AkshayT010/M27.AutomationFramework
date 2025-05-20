package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplimentation.class)
	public void sampleHard()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	
//	if(1==0)//Fail - but shows passed
//	{
//		System.out.println("Pass");
//	}
//	else
//	{
//		System.out.println("Fail");
//	}
	
	Assert.assertEquals(0, 1);
	System.out.println("Step 4");
	System.out.println("Step 5");
	System.out.println("Step 6");
	}
	
	@Test
	
	public void sampleSoft()
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
		
		sa.assertAll();
	}
}
