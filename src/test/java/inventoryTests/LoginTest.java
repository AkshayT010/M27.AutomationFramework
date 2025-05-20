package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.Javautility;
import genericUtilities.SeleniumUtility;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplimentation.class)
public class LoginTest extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void tc_03_LoginTest() throws IOException, InterruptedException
	{
		/*
		//After import the base class-- we dont need to wright utilities, read data from property file,
		///Launch the browser, load the url , Login to application and Logout
		//create object of Utilities 
		FileUtility fUtil = new FileUtility();
		Javautility jUtil = new Javautility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the data from property file using generic utility
						
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
						
		//launch The Browser
		 WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
						
		//Load the URL
		driver.get(URL);
						
		//Login to the Application
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		*/		
		Thread.sleep(2000);
		
		/*			
		//Logout of application
		InventoryPage ip = new InventoryPage(driver);
		
		ip.LogoutOfApp();
		System.out.println("Logout successfully");
		*/

	}

}
