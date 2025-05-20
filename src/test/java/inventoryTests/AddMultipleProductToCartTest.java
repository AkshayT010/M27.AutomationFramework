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
public class AddMultipleProductToCartTest extends BaseClass{
	
	
	@Test
	public void tc_04_AddMultipleProductToCartTest() throws IOException, InterruptedException {
		
		/*
		//Create object off utility
		
		FileUtility fUtil = new FileUtility();
		Javautility jUtil = new Javautility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the data from property file
		
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		*/
		//Read the data from excel file
		
		String PRODUCTNAME1 = fUtil.readDataFromExcelFile("Product", 10, 2);
		String PRODUCTNAME2 = fUtil.readDataFromExcelFile("Product", 11, 2);
		
		/*
		//Launch the browser
		
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
		
		//Load the URL
		driver.get(URL);
		
		
		//lOGIN TO APPLICATION
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		*/
		
		//Click on Product 1
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME1);
		
		//Add product 1 to cart
		InventoryItomPage iip = new InventoryItomPage(driver);
		iip.clickOnAddTocartBtn();
		
		//Back to product page
		iip.clickOnBackToProductLnk();
		
		//Click on Product 2
		ip.clickOnAProduct(driver, PRODUCTNAME2);
		
		//Add product 2 to cart
		iip.clickOnAddTocartBtn();
		
		//click on cart container
		ip.clickOnCartContainer();
		
		//Validate in cart
		CartPage cp = new CartPage(driver);
		String productInCart1 = cp.getItemnames(0);
		String productInCart2 = cp.getItemnames(1);

		Assert.assertEquals(productInCart1, PRODUCTNAME1);
		System.out.println(productInCart1);
		
		Assert.assertEquals(productInCart2, PRODUCTNAME2);
		System.out.println(productInCart2);
		
		
		//wait
		Thread.sleep(1000);
		
		/*
		//logout application
		ip.LogoutOfApp();
		*/
	}

}
