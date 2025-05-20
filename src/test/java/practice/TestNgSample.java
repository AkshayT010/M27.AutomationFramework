package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgSample {
	/*
	 // Flag --> priority, invocationCount
	 
	@Test( invocationCount = 2 ,priority = 1)
	public void createSample()
	{
		System.out.println("Create");
	}
	

	@Test(priority = 2)
	public void modifySample()
	{
		System.out.println("Modify");
	}
	

	@Test(priority = 3)
	public void deleteSample()
	{
		System.out.println("Delete");
	}
	*/
	/*
	
	// Flag --> dependsOnMethod, enabled
	
	@Test
	public void createSample()
	{
		//Assert.fail();// it is used to forcefully fail the method execution
		System.out.println("Create");
	}
	

	@Test(dependsOnMethods = "createSample")
	public void modifySample()
	{
		System.out.println("Modify");
	}
	

	@Test (enabled = false)
	public void deleteSample()
	{
		System.out.println("Delete");
	}
	*/
	//Flag --> data provider 
	
	@Test(dataProvider = "getData")
	public void createEmpData(String name, int id)
	{
		System.out.println("Name is "+ name);
		System.out.println("Id is "+ id);
	}
	
	@DataProvider
	public Object [][] getData()
	{
		// 3 row and 2 column
		Object [][] data = new Object [3][2];//3x2 - Three data sets and each consist 2 info
		
		//1s data set
		data[0][0]="Akshay";
		data[0][1]=10;
		
		//2nd Data set
		data[1][0]="Rohan";
		data[1][1]= 13;
		
		//3rd data set
		
		data[2][0]= "Rehan";
		data[2][1]= 9;
		
		return data;
	}
}
