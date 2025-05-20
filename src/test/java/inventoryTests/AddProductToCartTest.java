package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.Javautility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItomPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplimentation.class)
public class AddProductToCartTest extends BaseClass {
	
	@Test (groups  = "SmokeSuite")
	public void tc_01_AddProductToCartTest () throws IOException
	{
		
	/*
	//After import the base class-- we dont need to wright utilities, read data from property file,
	///Launch the browser, load the url , Login to application and Logout
	//Create Object Of Utilities
		
	FileUtility fUtil = new FileUtility();
	Javautility jUtil = new Javautility();
	SeleniumUtility sUtil = new SeleniumUtility();
				
	//Read the data from property file
	String URL = fUtil.readDataFromPropertyFile("url");
	String USERNAME = fUtil.readDataFromPropertyFile("username");
	String PASSWORD = fUtil.readDataFromPropertyFile("password");
	*/
	//Read the data from Excel File
					
	String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 1, 2);
						
	/*					
	//Launch The browser
	WebDriver driver = new EdgeDriver();
	sUtil.maximizeWindow(driver);
	sUtil.addImplicitelyWait(driver);
						
	//Load the URL
	driver.get(URL);
	
	//Login to Application
	LoginPage lp = new LoginPage(driver);
	lp.LoginToApp(USERNAME, PASSWORD);
	*/
		
	//click on product
	InventoryPage ip = new InventoryPage(driver);
	ip.clickOnAProduct(driver, PRODUCTNAME);
	
	//Add product  to cart
	InventoryItomPage iip = new InventoryItomPage(driver);
	iip.clickOnAddTocartBtn();
	
	//Click on cart container
	ip.clickOnCartContainer();
	
	//Validate in cart
	
	CartPage cp = new CartPage(driver);
	String productInCart = cp.getItemName();
	
	Assert.assertEquals(productInCart, PRODUCTNAME);
	
	Assert.assertTrue(productInCart.equals(PRODUCTNAME));
	
	System.out.println(productInCart);
	
//	if(productInCart.equals(PRODUCTNAME))
//	{
//		System.out.println("pass");
//		System.out.println(productInCart);
//	}
//	else
//	{
//		System.out.println("fail");
//	}
	/*
	//Logout of App
	ip.LogoutOfApp();
	*/
	}
	
	@Test
	public void samepleTest()
	{
		//Assert.fail();
		System.out.println("Sample");
	}
	

}
