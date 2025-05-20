package practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.Javautility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddProductTocartWithGu {

	public static void main(String[] args) throws IOException {
		
		//Create Object Of Utilities
		
		FileUtility fUtil = new FileUtility();
		Javautility jUtil = new Javautility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
				
		//Read the data from Excel File
			
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Product", 1, 2);
				
						
		//Launch The browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
				
		//Load the URL
		driver.get(URL);
				
		//Login to Application
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
		
		lp.LoginToApp(USERNAME, PASSWORD);
				
		//click on product - Sauce Labs Backpack
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']"));
		String productToBeAdded = ele.getText();
		ele.click();
				
		//capture Screenshot
		String screenshotName = "addProductTocart"+jUtil.getSystemDate();
		sUtil.captureScreenShot(driver, screenshotName);
				
		//Add to cart
		driver.findElement(By.id("add-to-cart")).click();
				
		//Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();
				
		//Validate the product
		 String productAdded = driver.findElement(By.className("inventory_item_name")).getText();
				
				if(productAdded.equals(productToBeAdded))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				
		System.out.println(productAdded);
		//Logout the application
		driver.findElement(By.className("bm-burger-button")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("LOGOUT SUCESSFULL");
				
			}

}


